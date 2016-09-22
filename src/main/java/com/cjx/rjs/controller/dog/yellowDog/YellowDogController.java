//package com.cjx.rjs.controller.dog.yellowDog;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.cjx.rjs.service.dog.yellowDog.YellowDogService;
//import com.cjx.rjs.util.page.Page;
//import com.cjx.rjs.vo.dog.DogVO;
//
//@Controller
//@RequestMapping(value = "/yellowDog")
//public class YellowDogController {
//    private YellowDogService yellowDogService = new YellowDogService();
//
//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public ModelAndView index(HttpServletRequest request, ModelAndView model) {
//        // model.addObject("secondCodeUrl", secondCodeUrl);
//        System.out.println(333);
//        model.setViewName("dog/yellowDog/index");
//        return model;
//    }
//
//    @RequestMapping(value = "/queryPage", method = RequestMethod.POST)
//    public @ResponseBody Page<DogVO> queryPage(HttpServletRequest request,
//            @RequestBody 
//            DogVO reqVO) {
//        Page<DogVO> page = this.yellowDogService.queryPage(reqVO);
//        return page;
//    }
//    
//    @RequestMapping(value = "/query", method = RequestMethod.POST)
//    public @ResponseBody DogVO query(HttpServletRequest request,
//            @RequestBody DogVO reqVO) {
//        return this.yellowDogService.query(reqVO);
//    }
//}
