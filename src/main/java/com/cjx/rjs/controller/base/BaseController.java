package com.cjx.rjs.controller.base;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cjx.rjs.common.page.Page;
import com.cjx.rjs.model.base.BasePO;
import com.cjx.rjs.service.base.BaseService;
import com.cjx.rjs.vo.base.BaseVO;
import com.cjx.rjs.vo.base.ResultVO;

public abstract class BaseController<V extends BaseVO> {
	
    @Autowired
    protected BaseService<V, ?> service;
    
    protected String getRequestMapping() {
        RequestMapping annotation = this.getClass().getAnnotation(RequestMapping.class);
        if (annotation == null) {
            return "";
        }
        
        return annotation.value()[0];
    }
    
	protected String getViewUrl(String viewName) {
	    return this.getRequestMapping() + "/" + viewName;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, ModelAndView model) {
		model.setViewName(this.getViewUrl("index"));
		return model;
	}
	
	@RequestMapping(value = "/indexSub", method = RequestMethod.POST)
	public ModelAndView indexSub(HttpServletRequest request, ModelAndView model,
			V vo) {
		ModelAndView retModel = this.index(request, model);
		
		model.addObject("vo", vo);
		retModel.setViewName(this.getViewUrl("indexSub"));
		return retModel;
	}
	
	@RequestMapping(value = "/queryPage", method = RequestMethod.POST)
	public @ResponseBody Page<V> queryPage(HttpServletRequest request,
			ModelAndView model, @RequestBody V vo) {
	    
		Page<V> page = this.service.queryPage(vo);

		return page;
	}
	
	@RequestMapping(value = "/queryPageByForeignKey", method = RequestMethod.POST)
	public @ResponseBody Page<V> queryPageByForeignKey(HttpServletRequest request,
	        ModelAndView model, @RequestBody V vo) {
	    Page<V> page = this.service.queryPageByForeignKey(vo);
	    
	    return page;
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public @ResponseBody ResultVO<V> get(HttpServletRequest request,
			@RequestBody V vo) {
	    V vo2 = this.service.query(vo.getId());
	    
		return ResultVO.newInstance(vo2);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ResultVO<Serializable> save(HttpServletRequest request,
			@RequestBody V vo) {
		BasePO po = this.service.save(vo);
		
		return ResultVO.newInstance(po.getId());
	}

	@RequestMapping(value = "/deleteList", method = RequestMethod.POST)
    public @ResponseBody ResultVO<?> deleteList(HttpServletRequest request,
            @RequestBody V vo) {
        this.service.deleteByIds(vo.getIds());
        
        return ResultVO.newInstance();
    }

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public ModelAndView query(HttpServletRequest request, ModelAndView model,
			@RequestBody V vo) {

		V vo2 = this.service.query(vo.getId());
		model.addObject("vo", vo2);

		model.setViewName(this.getViewUrl("editForm"));
		return model;
	}
	
	/**
	 * 提交流程 .
	 * 
	 * @param request
	 * @param vo
	 * @return
	 * 
	 * @author caijx
	 */
//	@RequestMapping(value = "/commitWorkflow", method = RequestMethod.POST)
//	public @ResponseBody ResultVO<Integer> commitWorkflow(
//			HttpServletRequest request, @RequestBody T vo) {
//		ResultVO<Integer> resultVO = this.service.commitWorkflow(vo);
//		return resultVO;
//	}
	
	/**
	 * 判断用户是否可进行保存操作
	 * .
	 * @param request
	 * @param vo
	 * @return 
	 * 
	 * @author caijx 
	 */
//	@RequestMapping(value = "/canSave", method = RequestMethod.POST)
//	public @ResponseBody ResultVO<Boolean> canSave(
//			HttpServletRequest request, @RequestBody T vo) {
//		ResultVO<Boolean> resultVO = this.service.canSave(vo.getId(), vo.getUserId());
//		return resultVO;
//	}
    
}
