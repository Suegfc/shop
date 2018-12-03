package com.seventh.shop.controller;

import com.seventh.shop.domain.Store;
import com.seventh.shop.domain.User;
import com.seventh.shop.service.StoreService;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author gfc
 * 2018年11月27日 下午 9:37
 */
@RestController
public class StoreController {
    @Autowired
    private StoreService service;

    @GetMapping("/api/v1/stores")
    public Result<List<Store>> findAllStore() {
        return service.findAllStore();
    }

    @GetMapping("/api/v1/one")
    public Result<Store> findStore(int shopId) {
        return service.findStoreById(shopId);
    }

    @GetMapping("/api/v1/store")
    public Result<List<Store>> findStores() {
        return service.findAllStoreRandom();
    }

    @PostMapping("/api/v1/shop")
    public Result addShop(Store store, HttpServletRequest request) {
        User user = (User) request.getServletContext().getAttribute("user");
        int sid = (int) request.getServletContext().getAttribute("sid");
        if (user != null) {
            store.setId(sid);
            store.setUid(user.getId());
            return service.addStore(store);
        }
        return Result.error(CodeMsg.ERROR);
    }
}
