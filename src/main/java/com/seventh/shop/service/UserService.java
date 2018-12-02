package com.seventh.shop.service;

import com.seventh.shop.domain.Rules;
import com.seventh.shop.domain.User;
import com.seventh.shop.vo.Result;

import java.util.List;
import java.util.Map;

/**
 * @author gfc
 * 2018年11月23日 上午 10:26
 */
public interface UserService {

    Result<User> selectUser(User user);

    Result<User> updateUser(User user);

    Result<List<Map<String, Object>>> myConllection(String id);

}
