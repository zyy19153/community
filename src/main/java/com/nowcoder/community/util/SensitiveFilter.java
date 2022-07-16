package com.nowcoder.community.util;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hide on bush
 * @since 2022/7/16 - 17:16
 */
@Component
public class SensitiveFilter {

    private static final Logger logger = LoggerFactory.getLogger(SensitiveFilter.class);

    // 替换值
    private static final String REPLACEMENT = "***";

    // 根节点
    private TrieNode root = new TrieNode();

    @PostConstruct // 当容器实例化该bean后，在调用该bean的实例化方法后，会自动调用该方法
    public void init() {
        try (
                InputStream is = this.getClass().getClassLoader().getResourceAsStream("sensitive-words.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        ) {
            String keyWord;
            while ((keyWord = reader.readLine()) != null) {
                // 添加到前缀树对象中
                this.addKeyWord(keyWord);
            }
        } catch (IOException e) {
            logger.error("加载敏感词文件失败");
        }
    }

    /**
     * 将一个敏感词添加到前缀树中去
     * @param keyWord
     */
    private void addKeyWord(String keyWord) {
        TrieNode tempNode = root;
        for (int i = 0; i < keyWord.length(); i++) {
            char c = keyWord.charAt(i);
            TrieNode subNode = tempNode.getSubNode(c);
            if (subNode == null) {
                // 初始化子节点
                subNode = new TrieNode();
                tempNode.addSubNode(c, subNode);
            }
            // 将当前节点指向子节点，准备进入下一轮循环
            tempNode = subNode;
        }
        tempNode.setKeyWordEnd(true);
    }

    /**
     * 过滤敏感词
     * @param text 待过滤的文本
     * @return 过滤后的文本
     */
    public String filter(String text) {
        if (StringUtils.isBlank(text)) {
            return null;
        }
        // 指针1
        TrieNode tempNode = root;
        // 指针2
        int begin = 0;
        // 指针3
        int position = 0;
        // 结果
        StringBuilder sb = new StringBuilder();
        while (position < text.length()) {
            char c = text.charAt(position);
            // 跳过符号
            if (isSymbol(c)) {
                // 若指针1属于根节点 将此符号计入结果，让指针2向下走一步
                if (tempNode == root) {
                    sb.append(c);
                    begin++;
                }
                // 无论符号在哪，指针3都会向下走一步
                position++;
                continue;
            }
            // 检查下级节点
            tempNode = tempNode.getSubNode(c);
            if (tempNode == null) {
                // 以beigin开头的字符串不是敏感词
                sb.append(text.charAt(begin));
                // 进入下一个位置
                position = ++begin;
                // 指针3重新指向根节点
                tempNode = root;
            } else if(tempNode.isKeyWordEnd()) {
                // 发现敏感词 将 begin - position 的字符串替换
                sb.append(REPLACEMENT);
                // 进入下一个位置
                begin = ++position;
                // 指针3重新指向新节点
                tempNode = root;
            } else {
                // 继续检查下一个字符
                position++;
            }
        }
        // 将最后一批字符计入结果
        sb.append(text.substring(begin));
        return sb.toString();
    }

    private boolean isSymbol(Character c) {
        // 0x2E80 - 0x9FFF 是东亚文字
        return !CharUtils.isAsciiAlphanumeric(c) && (c < 0x2E80 || c > 0x9FFF);
    }

    // 前缀树/字典树
    private class TrieNode {
        // 描述的是关键词结束的表示
        private boolean isKeyWordEnd = false;

        // 描述当前节点的子节点
        private Map<Character, TrieNode> subNodes = new HashMap<>();

        public boolean isKeyWordEnd() {
            return isKeyWordEnd;
        }

        public void setKeyWordEnd(boolean keyWordEnd) {
            isKeyWordEnd = keyWordEnd;
        }

        public void addSubNode(Character c, TrieNode n) {
            subNodes.put(c, n);
        }

        public TrieNode getSubNode(Character c) {
            return subNodes.get(c);
        }
    }
}
