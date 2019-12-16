package com.atguigu.gmall.auth.service;

import com.atguigu.core.bean.Resp;
import com.atguigu.core.utils.CookieUtils;
import com.atguigu.core.utils.JwtUtils;
import com.atguigu.gmall.auth.config.JwtProperties;
import com.atguigu.gmall.auth.feign.GmallUmsClient;
import com.atguigu.gmall.ums.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@EnableConfigurationProperties(JwtProperties.class)
public class AuthService {

    @Autowired
    private GmallUmsClient gmallUmsClient;

    @Autowired
    private JwtProperties properties;

    public String accredit(String username, String password) {
        // 远程调用，校验用户名和密码
        Resp<MemberEntity> memberEntityResp = this.gmallUmsClient.queryUser(username, password);
        MemberEntity memberEntity = memberEntityResp.getData();

        // 判断用户是否为null
        if (memberEntity == null) {
            return null;
        }

        try {
            // 制作jwt
            Map<String, Object> map = new HashMap<>();
            map.put("id", memberEntity.getId());
            map.put("username", memberEntity.getUsername());
            return JwtUtils.generateToken(map, this.properties.getPrivateKey(), this.properties.getExpire());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
