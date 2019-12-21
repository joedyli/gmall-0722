package com.atguigu.gmall.order.pay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "alipay")
@Component
@Data
public class AlipayTemplate {

    //在支付宝创建的应用的id
    private   String app_id = "2016101200666477";

    // 商户私钥，您的PKCS8格式RSA2私钥
    private  String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCg6T9A2laDqThCKneE2skmHCkJhSTG0xHuP/K6rIjjw3BmYwf1xXO/v+xjQUuDSD0BtAerWSoyHtpLl0DcIG2g8gxeXYmpJxIS+iugDRgZPMcs9TrNOGKrLCkgk7TwRDAt63o1v9swB3rny0JhpMWGJc9K0hAUJIJb47xGBQSM+wJGPQZxETD+0SyskvHEbABthZ769ye7COvgw1cloHWkChy5JQA3T3bSl/JC+Xc1T+np7iTFQY861yiSjsRinJtSj/vA0h86zB+aaPSMyN08vy9IUA07idTfLabKOAN9/mV4Fq/eF5FMLrj6Dy1Uuk0VkfNlpbOOyAku/HckAfIvAgMBAAECggEAX2vyZrMTuuAOzK4CUnar8j2g2FRsiruAVpj1iF3oj6jGbvErN0PwcDWQKQv/i8q64tev9JzbuP0y1sDLZb6VRGxFiXBOwlC5Fyfj1vXs5Ip2UuLaC/j0Ci4V9YuiMRk+uPx7bIRppwHIkMyogN8Fg5fIZcZMYqWD6JoUfDFdkXwUnG5bMzY2LX+so6rSFzOGk/qzRfnozzKtxv3RH4xWZrctRIywqc+GtuNyv/9qbhcvVSZIMlcO+QemgH1p1/BCAN+2BsyeqeEepB4rmLOssAzoO3PMqO/6suQp+QClSOK8DNG0Wb7f4/j41ftPnugCTcgSIdLjjWpW76iQLaZbAQKBgQDwexCAU4emVD7FkBUf1t5P/4XULV5WTWRo6MzyCBBN9aG+gCPr3waQkE3I7EmrNcIgvZlpLtR2TLw14+mN7c8KFMG0aj1HC77tJOiGlovwYfEDrLqepkK/2lz6miM8CB8wWqCYbMuCAIPEu26JU3dqfLNjjMXsYL/WNNiKvAu2KQKBgQCrS6Du3ajjERS1FImxCC5Sr4uZ5W8yHoWmvROkDXRlvNzNH9rkjxaEn2PrWEDaxQzNM8bkG2/vMZ5gV8aN5bfKdmP/NNaS5c4Crm9blAQwLSjb+xiX0Dbu2PqjxmhDBhox9MtY0PkNRjv/AGsQYx8LIqfCDfWPG9AZ7t3WjH2AlwKBgQCogXMkmGM611lM0hMbRlJst92suUWbL4umP0osZh4WooF9nQiOpK5S6eq3WWqdf4PRsUkn/Np/MnHHSTZEb1hd9gFtS+w4NjDIts4AUMkp3VcmfggeVt361SXFq+/4hrBkD3zskX9gTsAGQFfJ/iR1B4Ajx2aApaKGlG0PeYizUQKBgHbt9XijEaVFsLjg35C4e2ERXL2nHIMRyf2wfTiD1vLkI/GPUm0qI5pFCBzYk37RHUhD0K2Dlz3dl3aQuty+R9McS+VfDDPFtjkKX2qX5CiG0j2ZosOU3u8KW0rmcHFIhVt1+NFble9veixcX/lquJ0EnLEQ/BM2XlADFqbluCVVAoGBAIuNTy1YzbNVejRGi1JK1qii81b3ODMpEQJxbJVUB4Ku+41QHRUrTQvV0SpKNgdXuqjb0p/pXJlRGDiP0Q/CqHGHTBl355xIwIqQ8jwyVwg+/2+KtYeTNsD4olwYwL+AxIYKM2JRfCANJl8LJXszhOnbO+LlGvbvpkiDQzCUSTQ9";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    private  String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAm0CbzDSMv9508/xEgXOciNrNyvR6pdJVDQ7iuXpJNXcniJB94G+wB3jn8EDygAwsdYHiQH8B6kp7clQ0tY3EEVy7w8/gleOT5zSG5eqLjtHy7VdWsWiQbDH6Tsl5ZMrr92Ki0QbWxepL642BG/8EeKsi3+/wdSWPV0Ujbw1+lpTID5wpiQbpCYOOs5bAuhJeqJNa4ovVPm238CEzmXCYmpH4fnsh6pjO/BiSLrdMx8Z2xy+cjQ3wcEF0R8vGgOz+q9yiuVkXaPU6emLJ/m8baRlkREszl80AghKNgBuV0771jsRykA81oR+9iJo/tdpvqisGW4TLirnrq1iDLDHZOQIDAQAB";
    // 服务器[异步通知]页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 支付宝会悄悄的给我们发送一个请求，告诉我们支付成功的信息
    private  String notify_url;

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //同步通知，支付成功，一般跳转到成功页
    private  String return_url;

    // 签名方式
    private  String sign_type = "RSA2";

    // 字符编码格式
    private  String charset = "utf-8";

    // 支付宝网关； https://openapi.alipaydev.com/gateway.do
    private  String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    public  String pay(PayVo vo) throws AlipayApiException {

        //AlipayClient alipayClient = new DefaultAlipayClient(AlipayTemplate.gatewayUrl, AlipayTemplate.app_id, AlipayTemplate.merchant_private_key, "json", AlipayTemplate.charset, AlipayTemplate.alipay_public_key, AlipayTemplate.sign_type);
        //1、根据支付宝的配置生成一个支付客户端
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl,
                app_id, merchant_private_key, "json",
                charset, alipay_public_key, sign_type);

        //2、创建一个支付请求 //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = vo.getOut_trade_no();
        //付款金额，必填
        String total_amount = vo.getTotal_amount();
        //订单名称，必填
        String subject = vo.getSubject();
        //商品描述，可空
        String body = vo.getBody();

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String result = alipayClient.pageExecute(alipayRequest).getBody();

        //会收到支付宝的响应，响应的是一个页面，只要浏览器显示这个页面，就会自动来到支付宝的收银台页面
        System.out.println("支付宝的响应："+result);

        return result;

    }
}
