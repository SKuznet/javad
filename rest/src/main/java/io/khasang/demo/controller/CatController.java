package io.khasang.demo.controller;

import io.khasang.demo.entity.Cat;
import io.khasang.demo.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
// localhost:8080/cat
@RequestMapping("/cat")
public class CatController {
    @Autowired
    private CatService catService;

    @RequestMapping(value = "/all")
    @ResponseBody
    public List<Cat> allCats(){
        return catService.getAllCats();
    }

    @RequestMapping(value = "/menu")
    public String getCatMenu(){
        return "cat";
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Cat getCatById(@PathVariable(value = "id") String id) {
        return catService.getCatById(Long.parseLong(id));
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Cat addCat(@RequestBody Cat cat) {
        return catService.addCat(cat);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Cat deleteCat(@RequestParam(value = "id") String id) {
        return catService.deleteCat(Long.parseLong(id));
    }
}
