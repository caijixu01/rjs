//package com.cjx.rjs.controller.animal;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.cjx.rjs.model.Animal;
//import com.cjx.rjs.service.animal.AnimalService;
//
//@Controller
//@RequestMapping(value = "/animal")
//public class AnimalController {
//    @Autowired
//    protected AnimalService service;
//
//    @RequestMapping(value = "/query", method = RequestMethod.GET)
//    public @ResponseBody Animal query(HttpServletRequest request) {
//        String id = request.getParameter("id");
//        Animal animal = this.service.get(id);
//        return animal;
//    }
//}
