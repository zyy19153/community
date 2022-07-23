package com.nowcoder.community.controller;

import com.nowcoder.community.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * @author Hide on bush
 * @since 2022/7/23 - 14:45
 */
@Controller
public class DataController {

    @Autowired
    private DataService dataService;

    // 打开统计页面
    @RequestMapping(path = "/data", method = {RequestMethod.POST, RequestMethod.GET})
    public String getDataPage() {
        return "/site/admin/data";
    }

    // 处理统计网站 uv 的请求
    @RequestMapping(path = "/data/uv", method = RequestMethod.POST)
    public String getUV(@DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") Date end, Model model) {
        long uv = dataService.calculateUV(start, end);
        model.addAttribute("uvResult", uv);
        model.addAttribute("uvStartDate", start);
        model.addAttribute("uvEndDate", end);
//        return "/site/admin/data";
        return "forward:/data"; // 上面是传给dispatcherServlet,让它去找模板。而本行的写法是继续去寻找（转发，注意转发是在同一个请求内完成的，所以转发过去的时候也是post请求）一个能处理请求的方法，而不是模板
    }

    // 处理统计网站活跃用户 DAU 的请求
    @RequestMapping(path = "/data/dau", method = RequestMethod.POST)
    public String getDAU(@DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") Date end, Model model) {
        long dau = dataService.calculateDAU(start, end);
        model.addAttribute("dauResult", dau);
        model.addAttribute("dauStartDate", start);
        model.addAttribute("dauEndDate", end);
//        return "/site/admin/data";
        return "forward:/data"; // 上面是传给dispatcherServlet,让它去找模板。而本行的写法是继续去寻找一个能处理请求的方法，而不是模板
    }
}
