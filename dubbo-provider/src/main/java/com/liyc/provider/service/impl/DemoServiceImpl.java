package com.liyc.provider.service.impl;

import org.springframework.stereotype.Service;

import com.liyc.service.DemoService;

/**
 * DemoService
 * @author liyc
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {

	/**
	 * sayhello
	 */
	@Override
	public String sayHello(String name) {
		System.out.println("in DemoServiceImpl ");
		return "hello "+name+" : from provide";
	}
}
