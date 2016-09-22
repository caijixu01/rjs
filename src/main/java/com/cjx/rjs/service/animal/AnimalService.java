package com.cjx.rjs.service.animal;

import org.springframework.stereotype.Service;

import com.cjx.rjs.model.Animal;
import com.cjx.rjs.service.base.BaseService;
import com.cjx.rjs.vo.animal.AnimalVO;

@Service("animalService")
public class AnimalService extends BaseService<AnimalVO, Animal> {
}
