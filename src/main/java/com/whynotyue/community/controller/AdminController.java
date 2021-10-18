package com.whynotyue.community.controller;

import com.whynotyue.community.strategy.ExportContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// 自己做的
@Controller
public class AdminController {

    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public String getAdminPage() {
        return "/site/admin";
    }

    @RequestMapping(path = "/admin/user", method = RequestMethod.GET)
    public String getAdminUserPage() {
        return "/site/admin-user";
    }

    @RequestMapping(path = "/admin/discuss", method = RequestMethod.GET)
    public String getAdminDiscussPage() {
        return "/site/admin-discuss";
    }

    @RequestMapping(path = "/admin/review", method = RequestMethod.GET)
    public String getAdminReviewPage() {
        return "/site/admin-review";
    }

    @RequestMapping(path = "/admin/export", method = RequestMethod.POST)
    @ResponseBody
    public String export(String type) throws ClassNotFoundException {
        // 这里采用「策略模式」，避免 if...else...
        return new ExportContext(type).export();
    }
}
