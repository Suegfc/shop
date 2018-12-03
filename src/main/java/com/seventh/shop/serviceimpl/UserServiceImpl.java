package com.seventh.shop.serviceimpl;

import com.seventh.shop.dao.UserDao;
import com.seventh.shop.domain.User;
import com.seventh.shop.service.UserService;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * @author gfc
 * 2018年11月23日 上午 10:26
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired

    private UserDao dao;

    //查询指定用户
    @Override
    public User selectUser(User user) {
        return dao.findUser(user.getUsername(), user.getPassword());
    }

    //修改用户信息
    @Override
    @Transactional
    public Result<User> updateUser(User user) {

        return dao.updateUser(user.getUsername(), user.getPassword()) == 0 ? Result.error(CodeMsg.newError(1, "修改失败")) : Result.success(user);

    }

    @Override
    public Result<List<Map<String, Object>>> myConllection(String id) {
        
        return Result.success(dao.myConllection(id));
    }
}
