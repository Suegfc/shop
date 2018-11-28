package com.seventh.shop.dao;

import com.seventh.shop.domain.Proimage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProimageDao extends JpaRepository<Proimage, Integer> {

    //批量添加商品图片
    @Override
    List<Proimage> saveAll(Iterable iterable);

    //根据pid删除商品图片
    int deleteByPid(Integer pid);
}
