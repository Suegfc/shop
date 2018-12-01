package com.seventh.shop.utils;

import com.alibaba.fastjson.JSON;
import com.seventh.shop.domain.Token;

import java.util.Random;

public class TokenUtils {
    //穿件令牌
    public static String createToken(String content, int id) {
        Token token = new Token(content, System.currentTimeMillis(), id, new Random().nextLong());
        String json = JSON.toJSONString(token);
        return json;
    }

    //解析令牌
    public static Token parseToken(String token) {

        return JSON.parseObject(token, Token.class);
    }

    //更新令牌
    public static String updateToken(Token token) {
        token.setTime(System.currentTimeMillis());
        return JSON.toJSONString(token);
    }
}
