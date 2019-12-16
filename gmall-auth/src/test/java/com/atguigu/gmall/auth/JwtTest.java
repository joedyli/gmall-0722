package com.atguigu.gmall.auth;

import com.atguigu.core.utils.JwtUtils;
import com.atguigu.core.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
	private static final String pubKeyPath = "D:\\project-0722\\rsa\\rsa.pub";

    private static final String priKeyPath = "D:\\project-0722\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "2432sdsdAD@#@#sfdsf23");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("id", "11");
        map.put("username", "liuyan");
        // 生成token
        String token = JwtUtils.generateToken(map, privateKey, 1);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6IjExIiwidXNlcm6hbWUiOiJsaXV5YW4iLCJleHAiOjE1NzY0ODI0MjF9.TXACLiiVV9eqfzgIKm2nsXCQMSSbQSZOiBORkntIyysUp6ldmjQpwyU-EgmfylfKXkbG0GljCDCGrDd8j2ONWIPl6IHlV9MP3JZuchQjGGkDM6CdUKIYaM6s1AZcn8Y4gmGjLCbbj30ojXQBYf8FVggj1ExQItC2h2vHawxCnwoOZCLicnI3R-FWDPHzgtCcnjbhHl-YtdcAl9Q36GKt-H8w5YtFg3jY-CP6Qg3GvoIhIXCeI82ZaF4f6xmQ_9X6BUAQpnsfI8OPo4ah6gXpRDHkU4XpyeTUH_ylp50YLJ6i7BPT7zilwlAnQYQ7m32WHPPboWBXTw1eJ-Cm_aydWA";

        // 解析token
        Map<String, Object> map = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + map.get("id"));
        System.out.println("userName: " + map.get("username"));
    }
}