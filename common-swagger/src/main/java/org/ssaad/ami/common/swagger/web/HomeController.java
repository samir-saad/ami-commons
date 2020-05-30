package org.ssaad.ami.common.swagger.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;


@Controller
@ApiIgnore
public class HomeController {

    @RequestMapping({"/", "/swagger"})
    public String home() {
        return "redirect:/swagger-ui.html";
    }
}