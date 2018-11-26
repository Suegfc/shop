package com.seventh.shop.serviceimpl;

import com.seventh.shop.dao.UserDao;
import com.seventh.shop.domain.User;
import com.seventh.shop.service.UserService;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Result<User> selectUser(User user) {

        return  dao.findByUsernameAndPassword(user.getUsername(),user.getPassword()) != null ? Result.success(dao.findByUsernameAndPassword(user.getUsername(),user.getPassword())):Result.error(CodeMsg.ERROR);
    }
    //修改用户信息
    @Override
    public Result<User> updateUser(User user) {
        if(dao.findByUsernameAndPassword(user.getUsername(),user.getPassword())!=null) {
            return dao.save(user) == null ? Result.error(CodeMsg.ERROR) : Result.success(user);
        } else
            return  Result.error(CodeMsg.newError(1,"请输入正确密码"));
    }
}
