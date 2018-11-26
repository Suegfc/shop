package com.seventh.shop.dao;

import com.seventh.shop.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gfc
 * 2018年11月23日 下午 7:57
 */
public interface ActivityDao extends JpaRepository<Activity,Integer> {
}
