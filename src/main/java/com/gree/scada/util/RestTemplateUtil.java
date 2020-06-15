package com.gree.scada.util;

import com.alibaba.fastjson.JSONObject;
import com.gree.scada.config.VerifyThread;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

public class RestTemplateUtil {

    /**
     * 发起GET请求
     *
     * @param url
     * @return
     */
    public static JSONObject doGet(String url){
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.getForObject(url, String.class);
        //System.out.println("doGet:"+s);
        JSONObject result = JSONObject.parseObject(s);
        System.out.println("doget请求结果："+result);
        if (result != null) {
            if (result.getInteger("errcode") == null) {
                return result;
            } else if (0 == result.getInteger("errcode")) {
                return result;
            } else {
                int errCode = result.getInteger("errcode");
                String errMsg = result.getString("errmsg");
                try {
                    throw new Exception("error code:" + errCode + ", error message:" + errMsg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 发起POST请求
     *
     * @param url
     * @param po
     * @param <T>
     * @return
     */
    public static <T> JSONObject doPost(String url,T po){
        HttpEntity requestEntity = new HttpEntity(JSONObject.toJSONString(po), RestTemplateUtil.getHeaders());
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.postForObject(url,requestEntity, String.class, VerifyThread.accessToken.getToken());
        System.out.println("dopost结果："+s);
        JSONObject result = JSONObject.parseObject(s);
        if (result != null) {
            if (result.getInteger("errcode") == null) {
                return result;
            } else if (0 == result.getInteger("errcode")) {
                return result;
            } else {
                int errCode = result.getInteger("errcode");
                String errMsg = result.getString("errmsg");
                try {
                    throw new Exception("error code:" + errCode + ", error message:" + errMsg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    /**
     * 创建指定字符集的RestTemplate
     *
     * @param charset
     * @return
     */
    public static RestTemplate getInstance(String charset) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName(charset)));
        return restTemplate;
    }


    /**
     * 解决请求数据乱码问题
     *
     * @return 正常的headers
     */
    public static HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        return headers;
    }

}