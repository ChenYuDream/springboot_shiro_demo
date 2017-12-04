package org.jypj.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * @author ChenYu
 */
@Controller
@RequestMapping
public class IndexController {

    /**
     * 跳转到login页面
     *
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("index")
    public String toIndex() {
        return "index";
    }
}