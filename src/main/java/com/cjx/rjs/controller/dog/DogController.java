package com.cjx.rjs.controller.dog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjx.rjs.controller.base.BaseController;
import com.cjx.rjs.vo.dog.DogVO;

@Controller
@RequestMapping(value = "/dog")
public class DogController extends BaseController<DogVO> {

//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public ModelAndView index(HttpServletRequest request, ModelAndView model) {
//        RequestMapping annotation = this.getClass().getAnnotation(RequestMapping.class);
//        String[] value = annotation.value();
//        System.out.println(333);
//        DogVO dogVO = new DogVO();
//        dogVO.setId(33);
//        model.addObject("vo", dogVO);
//        model.setViewName("dog/index");
//        return model;
//    }

//    @RequestMapping(value = "/queryPage", method = RequestMethod.POST)
//    public @ResponseBody Page<DogVO> queryPage(HttpServletRequest request,
//            @RequestBody 
//            DogVO reqVO) {
//        Page<DogVO> page = this.dogService.queryPage(reqVO);
//        return page;
//    }
    
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public @ResponseBody Serializable save(HttpServletRequest request,
//            @RequestBody DogVO vo) {
//        System.out.println(vo);
//
//        if (vo.getId() == null) {
//            return new Random().nextInt(1000);
//        }
//        return vo.getId();
//    }
    
//    @RequestMapping(value = "/query", method = RequestMethod.POST)
//    public ModelAndView query(HttpServletRequest request, ModelAndView model,
//            @RequestBody DogVO reqVO) {
//        System.out.println("id: " + reqVO.getId());
//        DogVO vo = this.dogService.query(reqVO);
//        model.addObject("vo", vo);
//        model.setViewName("dog/editor");
//        return model;
//    }
}
