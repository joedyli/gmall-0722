package com.atguigu.gmall.cart.interceptors;

import com.atguigu.core.utils.CookieUtils;
import com.atguigu.core.utils.JwtUtils;
import com.atguigu.gmall.cart.config.JwtProperties;
import com.atguigu.core.bean.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;

@EnableConfigurationProperties(JwtProperties.class)
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtProperties properties;

    private static final ThreadLocal<UserInfo> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 统一获取登陆状态
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        UserInfo userInfo = new UserInfo();
        // 获取cookie中的token信息（jwt）及userKey信息
        String token = CookieUtils.getCookieValue(request, this.properties.getCookieName());
        String userKey = CookieUtils.getCookieValue(request, this.properties.getUserKey());

        // 判断有没有userKey，没有：制作一个放入cookie中
        if (StringUtils.isEmpty(userKey)) {
            userKey = UUID.randomUUID().toString();
            CookieUtils.setCookie(request, response, this.properties.getUserKey(), userKey, 6 * 30 * 24 * 3600);
        }
        userInfo.setUserKey(userKey);

        // 判断有没有token
        if (StringUtils.isNotBlank(token)) {
            // 解析token信息
            Map<String, Object> infoFromToken = JwtUtils.getInfoFromToken(token, this.properties.getPublicKey());
            userInfo.setId(new Long(infoFromToken.get("id").toString()));
        }

        THREAD_LOCAL.set(userInfo);

        return super.preHandle(request, response, handler);
    }

    public static UserInfo getUserInfo(){
        return THREAD_LOCAL.get();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 必须手动清除threadLocal中线程变量，因为使用的是tomcat线程池
        THREAD_LOCAL.remove();
    }
}
