package com.imooc.service;

import com.imooc.domain.Girl;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.GirlException;
import com.imooc.repostories.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girl1 = new Girl();
        girl1.setCupSize("A");
        girl1.setAge(18);

        girlRepository.save(girl1);

        Girl girl2 = new Girl();
        girl2.setCupSize("B");
        girl2.setAge(28);
        girlRepository.save(girl2);
    }

    public  void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();

        if(age < 10){
            throw  new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if(age > 10 && age < 16){
            throw  new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
}
