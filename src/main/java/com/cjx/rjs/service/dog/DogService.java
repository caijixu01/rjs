package com.cjx.rjs.service.dog;

import org.springframework.stereotype.Service;

import com.cjx.rjs.model.Dog;
import com.cjx.rjs.service.base.BaseService;
import com.cjx.rjs.vo.dog.DogVO;

@Service("dogService")
public class DogService extends BaseService<DogVO, Dog> {
}
