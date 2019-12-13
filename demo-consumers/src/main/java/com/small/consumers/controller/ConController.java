package com.small.consumers.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ConController {


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
}
