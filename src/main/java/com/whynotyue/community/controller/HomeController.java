package com.whynotyue.community.controller;

import com.whynotyue.community.aspect.ServiceLogAspect;
import com.whynotyue.community.entity.DiscussPost;
import com.whynotyue.community.entity.Page;
import com.whynotyue.community.entity.User;
import com.whynotyue.community.service.DiscussPostService;
import com.whynotyue.community.service.LikeService;
import com.whynotyue.community.service.UserService;
import com.whynotyue.community.util.CommunityConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController implements CommunityConstant {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @Autowired
    private LikeService likeService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page) {
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");
        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        // 讨论贴（外键userId）涉及用户，所以将两者拼成map，多条记录用List<Map>
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);

                long likeCount = likeService.findEntityLikeCount(ENTITY_TYPE_POST, post.getId());
                map.put("likeCount", likeCount);

                discussPosts.add(map);
            }
        }
        // 方法调用前，SpringMVC 会自动实例化方法参数 Model、Page，并将 Page 注入 Model
        // 所以，这里可以省去将 Page 注入 Model 的代码
        model.addAttribute("discussPosts", discussPosts);
        return "/index";
    }

    // 返回错误页面
    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public String getErrorPage() {
        return "/error/500";
    }

}
