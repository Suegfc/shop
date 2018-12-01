package com.seventh.shop.dao;

import com.seventh.shop.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author gfc
 * 2018年11月27日 上午 10:29
 */
public interface TypeDao extends JpaRepository<Type,Integer> {
    @Override
    List<Type> findAll();
}
