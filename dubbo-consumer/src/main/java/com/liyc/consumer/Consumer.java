package com.liyc.consumer;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.alibaba.dubbo.rpc.RpcException;
import com.liyc.consumer.controller.BaseController;
@Configuration
@ComponentScan
@ImportResource({"classpath:consumer.xml"})
public class Consumer {
//	@Reference
//	private static DemoService demoService ;

	public static void main(String[] args) throws Exception {
		
		@SuppressWarnings("resource")
    ApplicationContext context =  new AnnotationConfigApplicationContext(Consumer.class);

    BaseController con = (BaseController)context.getBean("baseController"); // 获取远程服务代理
			try {
				for (int i = 0; i < 10; i++) {
          String hello = con.demoService.sayHello("world"); // 执行远程方法
          System.out.println(hello); // 显示调用结果
        }
			} catch (RpcException e) {
				e.printStackTrace();
				ConstraintViolationException ve = (ConstraintViolationException) e.getCause(); // 里面嵌了一个ConstraintViolationException
        Set<ConstraintViolation<?>> violations = ve.getConstraintViolations(); // 可以拿到一个验证错误详细信息的集合
        System.out.println(violations);
			}
    System.in.read(); // 按任意键退出
}
}
