package com.liyc.redis;

import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisClient {
  private Jedis jedis ; 
  
  @Before
  public void before(){
    jedis = new Jedis("123.56.216.146");
    jedis.auth("root");
  }
  
  //string
  @Test
  public void testStr(){
    //获取
    String strName = jedis.get("name");
    System.out.println("strName = "+strName);
    //更新
    String result = jedis.set("names", strName+"_");
    System.out.println("result = "+result);
    result = jedis.set("names", "newname", "xx", "EX", 10l);
    System.out.println("setNx result = "+result);
  }
  
  //list
  @Test
  public void testList(){
    //获取
    List<String> list = jedis.lrange("list", 0l, -1l);
    System.out.println("list.class = "+list.getClass());
    list.forEach(System.out::println);
    //添加 返回index
    Long index = jedis.rpush("list", "map");
    System.out.println("rpush index = "+index);
    list = jedis.lrange("list", 0l, -1l);
    list.forEach(System.out::println);
    //删除
    String delResult = jedis.rpop("list");
    System.out.println("delResult = "+delResult);
    list = jedis.lrange("list", 0l, -1l);
    list.forEach(System.out::println);
  }
  
  //set
  @Test
  public void testSet(){
    //获取
    Set<String> set = jedis.smembers("set");
    System.out.println("set.class = "+set.getClass()+" set.size = "+set.size());
    set.forEach(System.out::println);
    //添加 1成功 0失败
    Long result = jedis.sadd("set", "sss");
    System.out.println("sadd result = "+result);
    //删除
    result = jedis.srem("set", "sss");
    System.out.println("srem result = "+result);
  }
  
  //zset
  @Test
  public void testZSet(){
    //获取
    Set<String> zset = jedis.zrange("zset", 0, -1);
    System.out.println("zset.class = "+zset.getClass()+" zset.size = "+zset.size());
    zset.forEach(System.out::println);
//    jedis.zadd
    //带
    jedis.zrangeWithScores("zset", 0, -1);
  }
  
  
  @After
  public void after(){
    jedis.close();
  }
}
