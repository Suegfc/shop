package com.seventh.shop.serviceimpl;

import com.seventh.shop.dao.AddressDao;
import com.seventh.shop.domain.Address;
import com.seventh.shop.service.AddressService;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressServiceimpl  implements AddressService {
    @Autowired
    private AddressDao dao;
    //添加收货地址
    @Override
    @Transactional
    public Result sava(Address address) {

        if (address.getDetype()==1){
            dao.updataAddress();
        }
        return  dao.save(address)!= null?Result.success(dao.save(address)):Result.error(CodeMsg.ERROR);

    }

    @Override
        public Result selectAllById(int uid) {

        Result result = new Result();

        List<Address> list = dao.selectByUid(uid);
        if(list != null) {



            result.setData(list);
            result.setCode(0);
            result.setMsg("成功");
        }
            return result;

        }

    @Override
    public Result selectById(int id) {

        return Result.success(dao.findById(id));
    }
    //删除指定地址
    @Override
    public Result deleteById(int id) {
        dao.deleteById(id) ;
        return Result.success(new Address());
    }
}
