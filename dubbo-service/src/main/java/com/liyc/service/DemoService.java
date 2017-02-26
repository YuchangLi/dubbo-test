package com.liyc.service;

import javax.validation.constraints.NotNull;

/**
 * DemoService
 * @author liyc
 */
public interface DemoService {
	/**
	 * sayHello
	 * @param name
	 * @return
	 */
	String sayHello(@NotNull(message = "name can't be null") String name);
}
