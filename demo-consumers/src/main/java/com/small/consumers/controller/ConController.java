package com.small.consumers.controller;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("info")
@Api(value = "info控制器", tags = {"info控制器"})
public class ConController {
    volatile  int  account=0;
    @Value("${server.port}")
    int port ;


    @ApiOperation(value = "info", notes = "info")
    @GetMapping(value="/info/{value}")
    public   String    info(@PathVariable String  value)throws  Exception{
        WebSocket ws = new WebSocket();
        JSONObject jo = new JSONObject();
        jo.put("message", "这是后台返回的消息！");
        jo.put("To","0000001");
        try {
            ws.onMessage(jo.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;
    }


    @ApiOperation(value = "push", notes = "push")
    @RequestMapping("/push/{cid}/{message}")
    public Map pushToWeb(@PathVariable String cid,@PathVariable String message) {
        Map result = new HashMap();
        try {
            WebSocket.sendMessageTo(message, cid);
            result.put("code", 200);
            result.put("msg", "success");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value = "simple")
    public   int    testSimple(){
       // int  count=0;
        for(int i=0;i<10;i++){
            account++;
        }
        System.out.println("count:"+account);
        return   account;
    }
    @GetMapping(value = "account")
    public   int    acount(){

        return   port;
    }

    @GetMapping(value = "/sets/{name}")
    public   String     sets(HttpServletRequest  request,@PathVariable  String  name){
        request.getSession().setAttribute(name,name);
        return   "set:"+name;
    }

    @GetMapping(value = "/gets/{name}")
    public   String     gets(HttpServletRequest  request,@PathVariable  String  name){

        return   "get:"+request.getSession().getAttribute(name).toString();
    }





}
