package io.khasang.demo.controller;

import io.khasang.demo.model.Message;
import io.khasang.demo.service.TableCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
    @Autowired
    private Message message;
    @Autowired
    private TableCreationService tableCreationService;

    // localhost:8080/
    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("name", message.getInfo());
        return "hello";
    }

    @RequestMapping("/create")
    @ResponseBody
    public String createTable() {
        return tableCreationService.getStatus();
    }

    @RequestMapping("/user/abc")
    @ResponseBody
    public String checkSecurity(){
        return "You are in security area!";
    }

    @ResponseBody
    @RequestMapping(value = {"/password/{password}"}, method = RequestMethod.GET)
    public String getEncryptedPassword(@PathVariable("password") String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
