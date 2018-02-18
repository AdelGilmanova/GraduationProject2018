package ru.kpfu.itis.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.security.MyUserDetail;

/**
 * Created by Adel on 18.02.2018.
 */
@Controller
public class MainController extends BaseController {
    private static final String MAIN_PAGE_MAPPING = "/";

    @RequestMapping(value = MAIN_PAGE_MAPPING, method = RequestMethod.GET)
    public String renderMainPage() {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.equals("anonymousUser")) {
            String role = ((MyUserDetail) user).getUserInfo().getRole();
            if (role.equals("ROLE_USER")) return "redirect:/patient";
            if (role.equals("ROLE_ADMIN")) return "redirect:/admin";
        }
        return "main";
    }

}
