package com.liyc.redis;

import java.io.IOException;
import java.util.List;

import org.redisson.Redisson;
import org.redisson.config.Config;

public class RedissonClient {
  public static void main(String[] args) throws IOException {
    Config config = new Config();
    config.useSingleServer().setAddress("123.56.216.146:6379").setPassword("root").setConnectionPoolSize(10);
    org.redisson.api.RedissonClient redisson = Redisson.create(config);

    // 测试 list
    List<String> strList = redisson.getList("strList");
//    strList.clear(); // 清除所有数据
//    strList.add("测试中文1");
//    strList.add("test2");
    strList.forEach(str->System.out.println(str));
    System.out.println("hyperlogIpCount = "+redisson.getHyperLogLog("hyperlogIp").count());
    redisson.shutdown();
  }
}
