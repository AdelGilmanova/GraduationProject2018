package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.kpfu.itis.service.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Adel on 18.02.2018.
 */
@Controller
public class BaseController {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected UserService userService;

    public static String redirectToMain() {
        return "redirect:/";
    }

}
