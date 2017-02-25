package com.liyc.provider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.liyc.service.DemoService;

@Configuration
@ComponentScan
@ImportResource({"classpath:provider.xml"})
public class Provider {
	public static void main(String[] args) throws Exception {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath:provider.xml" });
//		context.start();
		ApplicationContext context = 
        new AnnotationConfigApplicationContext(Provider.class);
//		System.out.println(context.getBean(DemoService.class).sayHello("proveder"));
		System.out.println("Provider started");
		System.in.read(); // 按任意键退出
	}
}
