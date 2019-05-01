package com.imooc.controller;

import com.imooc.service.GirlService;
import com.imooc.domain.Girl;
import com.imooc.repostories.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> getGirlList(){
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Girl addGirl(@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl= new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

//    @GetMapping(value = "/girls/{id}")
//    public Girl findGirl(@PathVariable("id") Integer id){
//        return girlRepository.getOne(id);
//    }

    @GetMapping(value = "girls/{id}")
    public Girl findGirl(@PathVariable("id") Integer id){
        Girl girl = girlRepository.findById(id).get();
        System.out.println("id:"+id);
        return girl;
    }

    @PutMapping(value = "/girls/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    @GetMapping(value = "girls/age/{age}")
    public List<Girl> girlfindAllByAge(@PathVariable("age") Integer age){
        return girlRepository.findAllByAge(age);
    }

    @GetMapping(value = "girls/cupSize/{cupSize}")
    public List<Girl> girlfindAllByCupSize(@PathVariable("cupSize") String cupSize){
        return girlRepository.findAllByCupSize(cupSize);
    }

    @PostMapping(value = "/girls/two")
    public void insertTwo(){
        girlService.insertTwo();
    }
}
