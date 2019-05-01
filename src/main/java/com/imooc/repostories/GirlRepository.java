package com.imooc.repostories;

import com.imooc.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> {
    public List<Girl> findAllByAge(Integer age);
    public List<Girl> findAllByCupSize(String cupSize);
}
