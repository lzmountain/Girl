package com.nj.rcxc.controller;

import com.nj.rcxc.aspect.HttpAspect;
import com.nj.rcxc.domain.Girl;
import com.nj.rcxc.domain.Result;
import com.nj.rcxc.repository.GirlRepository;
import com.nj.rcxc.service.GirlService;
import com.nj.rcxc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Fred on 2018/6/26.
 */
@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 查询列表信息
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        logger.info("girlList is running!");
        return girlRepository.findAll();
    }
    /**
     * 新增对象记录
     */
    @PostMapping(value = "/girls")
//    public Girl girlAdd(@RequestParam("cupSize")String cupSize,
//                          @RequestParam("age")int age){
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        Result result = new Result();
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());

        return ResultUtil.success(girlRepository.save(girl));

    }
    //查询对象
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") int id){
        return girlRepository.findOne(id);
    }
    //更新对象
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") int id,
                           @RequestParam("cupSize")String cupSize,
                           @RequestParam("age")int age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setId(id);
        return girlRepository.save(girl);
    }

    //删除对象
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") int id){
        girlRepository.delete(id);
    }

    //通过年龄查询女生列表
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") int age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }
    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id")int id) throws Exception {
        girlService.getAge(id);
    }
}
