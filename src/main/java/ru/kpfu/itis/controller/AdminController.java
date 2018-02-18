package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.security.MyUserDetail;

/**
 * Created by Adel on 18.02.2018.
 */
@Controller
public class AdminController extends BaseController {
    private static final String ADMIN_PAGE_MAPPING = "/admin";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = ADMIN_PAGE_MAPPING, method = RequestMethod.GET)
    public String renderAdminPage() {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!object.equals("anonymousUser")) {
            MyUserDetail user = (MyUserDetail) object;
            String role = user.getUserInfo().getRole();
            if (role.equals("ROLE_ADMIN")) {
                return "admin";
            }
        }
        return "redirect:/";
    }

}
