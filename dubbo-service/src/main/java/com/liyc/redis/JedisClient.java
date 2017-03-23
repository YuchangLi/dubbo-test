package com.liyc.redis;

import java.io.IOException;

import redis.clients.jedis.Jedis;

public class JedisClient {
	public static void main(String[] args) throws IOException {
		 Jedis jedis = new Jedis("123.56.216.146"); 
     System.out.println("Connection to server sucessfully"); 
     //check whether server is running or not 
     jedis.auth("root");
     System.out.println("Server is running: "+jedis.ping()); 
     jedis.keys("*").forEach(key -> System.out.println(key));
     System.out.println(jedis.get("name"));
     jedis.lrange("list", 0, -1).forEach(key -> System.out.println(key));
     jedis.pfcount("hyperlogIp");
     System.in.read(); // 按任意键退出
	}
}
