package com.liyc.consumer.controller;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liyc.service.DemoService;

@Component
public class BaseController {
	@Reference//(version="1.0.1",validation="false")
	public DemoService demoService;
}
