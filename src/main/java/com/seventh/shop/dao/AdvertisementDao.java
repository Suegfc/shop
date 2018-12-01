package com.seventh.shop.dao;

import com.seventh.shop.domain.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gfc
 * 2018年12月01日 下午 2:03
 */
public interface AdvertisementDao extends JpaRepository<Advertisement,Integer> {
}
