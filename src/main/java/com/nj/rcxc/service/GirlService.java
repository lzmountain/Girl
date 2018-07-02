package com.nj.rcxc.service;

import com.nj.rcxc.domain.Girl;
import com.nj.rcxc.enums.ResultEnum;
import com.nj.rcxc.exception.GirlException;
import com.nj.rcxc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Fred on 2018/6/27.
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;
    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(16);
        girlRepository.save(girlA);
        System.out.println(1/0);
        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(17);
        girlRepository.save(girlB);

    }
    //通过抛出自定义的异常，来处理相关的业务
    public void getAge(int id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        int age = girl.getAge();
        if( age < 10){
            //返回还在上小学
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if( age > 10 && age < 16){
            //返回还在上初中
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 测试通过id查询对象信息
     */
    public Girl findOne(int id){
        return girlRepository.findOne(id);
    }
}
