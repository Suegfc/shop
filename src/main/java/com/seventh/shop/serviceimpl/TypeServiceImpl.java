package com.seventh.shop.serviceimpl;

import com.seventh.shop.dao.TypeDao;
import com.seventh.shop.domain.Type;
import com.seventh.shop.service.TypeService;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gfc
 * 2018年11月27日 上午 10:32
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeDao typeDao;

    @Override
    public Result<List<Type>> findAllType() {
        return typeDao.findAll() != null ? Result.success(typeDao.findAll()) : Result.error(CodeMsg.ERROR);
    }
}
