package com.nj.rcxc.repository;

import com.nj.rcxc.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Fred on 2018/6/26.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //通过年龄来查询对象
    public List<Girl> findByAge(int age);
}
