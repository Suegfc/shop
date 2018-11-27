package com.seventh.shop.serviceimpl;

import com.seventh.shop.dao.CtypeDao;
import com.seventh.shop.domain.Ctype;
import com.seventh.shop.service.CtypeService;
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
public class CtypeServiceImpl implements CtypeService {
    @Autowired
    private CtypeDao ctypeDao;

    @Override
    public Result<List<Ctype>> findAllCtypeById(int id) {
        return ctypeDao.findAllByTid(id) != null ? Result.success(ctypeDao.findAllByTid(id)) : Result.error(CodeMsg.ERROR);
    }
}
