package com.seventh.shop.dao;

import com.seventh.shop.domain.Ctype;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author gfc
 * 2018年11月27日 上午 10:29
 */
public interface CtypeDao extends JpaRepository<Ctype, Integer> {
    List<Ctype> findAllByTid(int tid);
}
