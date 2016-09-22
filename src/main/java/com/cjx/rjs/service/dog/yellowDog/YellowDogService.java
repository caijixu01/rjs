//package com.cjx.rjs.service.dog.yellowDog;
//
//import java.util.ArrayList;
//import java.util.Date;
//
//import com.cjx.rjs.util.page.Page;
//import com.cjx.rjs.vo.dog.DogVO;
//
//public class YellowDogService {
//    public Page<DogVO> queryPage(DogVO vo) {
//        ArrayList<DogVO> list = new ArrayList<DogVO>();
//        
//        for (int i = 0; i < 10; i++) {
//        	DogVO dogVO = new DogVO();
//            dogVO.setName("yellowdog" + i);
//            dogVO.setAge(10 + i);
//            dogVO.setCreateDate(new Date());
//            list.add(dogVO);
//		}
//        
//        
//        Page<DogVO> page = new Page<DogVO>();
//        page.setList(list);
//        page.setStartRow(1);
//        page.setTotalRowCounts(188L);
//        page.setPageSize(10);
//        page.setTotalPageCounts(1L);
//        page.setPageNum(1);
//        
//        return page;
//    }
//    
//    public DogVO query(DogVO vo) {
//        DogVO dogVO = new DogVO();
//        dogVO.setName("yellowdog");
//        dogVO.setAge(10);
//        dogVO.setCreateDate(new Date());
//
//        return dogVO;
//    }
//}
