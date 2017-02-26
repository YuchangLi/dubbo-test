package com.liyc.provider.service.impl;


import org.springframework.stereotype.Service;

import com.liyc.service.DemoService;

/**
 * DemoService
 * @author liyc
 */
@Service
@com.alibaba.dubbo.config.annotation.Service//(validation="true")
public class DemoServiceImpl implements DemoService {

	public DemoServiceImpl() {
		System.out.println("DemoServiceImpl inited!!!");
	}

	/**
	 * sayhello
	 */
	@Override
	public String sayHello(String name) {
		System.out.println("in DemoServiceImpl ");
		return "hello "+name+" : from provide";
	}
}
