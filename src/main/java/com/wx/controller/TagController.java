package com.wx.controller;

import com.wx.entity.WeiXinUser;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
@RestController
public class TagController {
    /**
     * 创建标签
     * @param name 标签名字
     * @param ACCESS_TOKEN 公众号的全局唯一接口调用凭据
     * @return
     */
    @PostMapping("/tag")
    public String addTag(@PathVariable String name,String ACCESS_TOKEN){
        String url = "https://api.weixin.qq.com/cgi-bin/tags/create?access_token" + ACCESS_TOKEN ;
        try {
            JSONObject j = new JSONObject();
            JSONObject group = new JSONObject();
            j.put("name", name);
            group.put("tag", j);
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.postForObject(url, group.toString(), String.class);
            System.out.println(result);
        }catch (JSONException e){
            System.out.println("json转换出错");
        }
        return "";
    }

    /**
     *  获取公众号已创建的标签
     * @param ACCESS_TOKEN 公众号的全局唯一接口调用凭据
     * @return
     */
    @GetMapping("/tag")
    public String getAllTag(String ACCESS_TOKEN){
        String url  = " https://api.weixin.qq.com/cgi-bin/tags/get?access_token=" + ACCESS_TOKEN;
        try{
            RestTemplate restTemplate = new RestTemplate();
            String result =   restTemplate.getForObject(url,String.class);
            System.out.println(result);
        }catch (HttpClientErrorException e){
            System.out.println("http请求出错");
        }
        return "";
    }

    /**
     * 编辑标签
     * @param ACCESS_TOKEN 公众号的全局唯一接口调用凭据
     * @param id 标签id
     * @param name 更改的标签名字
     * @return
     */
    @PutMapping("/tag")
    public String updateTag(String ACCESS_TOKEN,int id,String name){
        String url = "https://api.weixin.qq.com/cgi-bin/tags/update?access_token=" + ACCESS_TOKEN;
        try{
            JSONObject j = new JSONObject();
            JSONObject group = new JSONObject();
            j.put("id", id);
            j.put("name", name);
            group.put("tag", j);
            RestTemplate restTemplate = new RestTemplate();
            String res =  restTemplate.postForObject(url, group.toString(), String.class);
            System.out.println(res);
        }catch (JSONException e){
            System.out.println("json转换出错");
        }catch (HttpClientErrorException e){
            System.out.println("http请求出错");
        }
        return "";
    }

    /**
     *
     * @param ACCESS_TOKEN 公众号的全局唯一接口调用凭据
     * @param id 标签的id
     * @return
     */
    @DeleteMapping("/tag")
    public String delTag(String ACCESS_TOKEN,int id){
        String url = "https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=" + ACCESS_TOKEN;
        try {
            JSONObject j = new JSONObject();
            JSONObject group =  new JSONObject();
            j.put("id", id);
            group.put("tag", j);
            RestTemplate restTemplate = new RestTemplate();
            String res = restTemplate.postForObject(url, group.toString(), String.class);
            System.out.println(res);
        }catch (JSONException e){
            System.out.println("json转换e出错");
        }catch (HttpClientErrorException e ){
            System.out.println("http请求出错");
        }
        return "";
    }

    /**
     * 获取标签下粉丝列表
     * @param tagid 标签id
     * @param ACCESS_TOKEN 公众号的全局唯一接口调用凭据
     * @return
     */
    @GetMapping("/taglist")
    public String getTagList(String tagid,String ACCESS_TOKEN ){
        String url  = "https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=" + ACCESS_TOKEN;
        try{
            JSONObject j = new JSONObject();
            j.put("tagid", tagid);
            RestTemplate restTemplate = new RestTemplate();
            String res = restTemplate.postForObject(url, j.toString(), String.class);
        }catch (JSONException e){
            System.out.println("json转换出错");
        }catch (HttpClientErrorException e){
            System.out.println("http请求出错");
        }
        return "";
    }

    /**
     * 获取用户身上的标签列表
     * @param openid 用户唯一的id
     * @param ACCESS_TOKEN 公众号的全局唯一接口调用凭据
     * @return
     */
    @GetMapping("/user/tag")
    public String getTagByOpenId(String openid,String ACCESS_TOKEN){
        String url = " https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=" + ACCESS_TOKEN;
        try {
            JSONObject j = new JSONObject();
            j.put("openid", openid);
            RestTemplate restTemplate = new RestTemplate();
            String res = restTemplate.postForObject(url, j.toString(), String.class);
            System.out.println(res);
        }catch (JSONException e){
            System.out.println("json转换出错");
        }catch (HttpClientErrorException e){
            System.out.println("http请求出错");
        }
        return "";
    }

    /**
     *
     * @param openid 用户唯一的id
     * @param ACCESS_TOKEN 公众号的全局唯一接口调用凭据
     * @return
     */
    @GetMapping("/user/message")
    public String getUserMessageByOpenId(String openid,String ACCESS_TOKEN){
        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + ACCESS_TOKEN + "&openid=" + openid + "&lang=zh_CN";
        try{
            RestTemplate restTemplate = new RestTemplate();
            WeiXinUser user = restTemplate.getForObject(url, WeiXinUser.class);
            System.out.println(user);
        }catch (HttpClientErrorException e ){
            System.out.println("http请求出错");
        }
        return "";
    }
}
