package com.wg.demo.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import me.chanjar.weixin.mp.api.WxMpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author wg
 * @date 2020/12/30
 */
public class WeixinUtil {

//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private static WxMpUserService wxMpUserService;


    private static String changeOpenId(String accessToken) {

        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(3000);
        httpRequestFactory.setConnectTimeout(3000);
        httpRequestFactory.setReadTimeout(3000);
        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
//        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());

        String format = "http://api.weixin.qq.com/cgi-bin/changeopenid?access_token=%s";
        String postParam = "{\n" +
                "    \"from_appid\": \"wx0b0290deafb091172\",\n" +
                "    \"openid_list\": [\n" +
                "        \"oYTBEwEjbvkwlRob156ZdKYqrh5w\",\n" +
                "        \"o9tCQ0reb4F-x03ir5F1hkWLOiJk\"\n" +
                "    ]\n" +
                "}";
        String url = String.format(format, accessToken);
        String s = restTemplate.postForObject(url, postParam, String.class);
        JSONObject object = JSON.parseObject(s);
        System.out.println(object);

        return null;

    }

    public static void main(String[] args) {


    }
}
