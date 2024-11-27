package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.CounterRequest;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.service.CounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * event 控制器
 */
@RestController

public class EventController {

  final Logger logger;

  public EventController() {
    this.logger = LoggerFactory.getLogger(EventController.class);
  }

  @PostMapping(value = "/index")
  ApiResponse index(@RequestBody Object object) {
    logger.info("/index/count post request, action: {}", object.toString());

    return ApiResponse.ok(0);
  }

}
