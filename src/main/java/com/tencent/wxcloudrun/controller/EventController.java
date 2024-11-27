package com.tencent.wxcloudrun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * event 控制器
 */
@RestController
@RequestMapping("/event")
public class EventController {

  final Logger logger;

  public EventController() {
    this.logger = LoggerFactory.getLogger(EventController.class);
  }

  @PostMapping(value = "/callback")
  String handleEventCallback(@RequestBody Map<String, String> requestBody) {
    logger.info("/callback post request, params: {}", requestBody.toString());
    // 解析微信公众号的回调事件数据
    String toUserName = requestBody.get("ToUserName");
    String fromUserName = requestBody.get("FromUserName");
    String createTime = requestBody.get("CreateTime");
    String msgType = requestBody.get("MsgType");
    String event = requestBody.get("Event");

    // 打印回调内容
    System.out.println("Received WeChat Event Callback:");
    System.out.println("ToUserName: " + toUserName);
    System.out.println("FromUserName: " + fromUserName);
    System.out.println("CreateTime: " + createTime);
    System.out.println("MsgType: " + msgType);
    System.out.println("Event: " + event);
    // 根据需要处理事件逻辑
    if ("event".equals(msgType) && "subscribe".equals(event)) {
      System.out.println("New user subscribed!");
    } else if ("event".equals(msgType) && "unsubscribe".equals(event)) {
      System.out.println("User unsubscribed.");
    }
    return "";
  }

  /**
   * 用于微信公众号的验证回调接口
   * 微信首次验证服务器时会发送 GET 请求，需返回 echostr 的值
   */
  @GetMapping("/callback")
  public String verifyCallback(
          @RequestParam("signature") String signature,
          @RequestParam("timestamp") String timestamp,
          @RequestParam("nonce") String nonce,
          @RequestParam("echostr") String echostr) {
    System.out.println("Received WeChat Verification Callback");
    System.out.println("signature: " + signature);
    System.out.println("timestamp: " + timestamp);
    System.out.println("nonce: " + nonce);
    System.out.println("echostr: " + echostr);

    // 直接返回 echostr 以完成验证
    return echostr;
  }

}
