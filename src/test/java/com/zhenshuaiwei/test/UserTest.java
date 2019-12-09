/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: UserTest.java 
 * @Prject: zhenshuaiwei-week2exam
 * @Package: com.zhenshuaiwei.test 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年12月9日 上午8:43:37 
 * @version: V1.0  
 */
package com.zhenshuaiwei.test;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.zhenshuaiwei.dateutils.DateUtil;
import com.zhenshuaiwei.entity.User;
import com.zhenshuaiwei.utils.StringUtils;

/** 
 * @ClassName: UserTest 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年12月9日 上午8:43:37  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:redis.xml")
public class UserTest {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
//	JDK系列化方式
	@Test
	public void addUserTest() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			User user = getRandomUser();
			redisTemplate.opsForValue().set("user"+i, user);
//			保存完成后，输出系列化方式、保存数量、所耗时间三项数据，并将这三项数据复制到记事本中。（4
		}
		long endTime = System.currentTimeMillis();
		System.out.println("输出系列化方式"+":JDK");
		System.out.println("保存数量"+":5W");
		System.out.println("所耗时间三项数据"+(endTime - startTime)+"毫秒");
		
	}	
	
	@Test
	public void addUserTestJson() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			User user = getRandomUser();
			redisTemplate.opsForValue().set("user"+i, user);
//			保存完成后，输出系列化方式、保存数量、所耗时间三项数据，并将这三项数据复制到记事本中。（4
		}
		long endTime = System.currentTimeMillis();
		System.out.println("输出系列化方式"+":Json");
		System.out.println("保存数量"+":5W");
		System.out.println("所耗时间三项数据"+(endTime - startTime)+"毫秒");
		
	}	
	
	@Test
	public void addUserTestHash() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			User user = getRandomUser();
//			保存完成后，输出系列化方式、保存数量、所耗时间三项数据，并将这三项数据复制到记事本中。（4
			redisTemplate.opsForHash().put("users"+i, "user"+i, JSON.toJSONString(user));
		}
		long endTime = System.currentTimeMillis();
		System.out.println("输出系列化方式"+":Json");
		System.out.println("保存数量"+":5W");
		System.out.println("所耗时间三项数据"+(endTime - startTime)+"毫秒");
		
	}	
	
	
	private static User getRandomUser() {
		Random random = new Random();
		User user = new User();
		user.setId(10000+random.nextInt(40001));
		user.setName(StringUtils.generateChineseName());
		user.setSex(random.nextInt(2) == 0 ? "男" : "女" );
		user.setPhone("13" + StringUtils.getRandomNumber(9));
		user.setEmail(StringUtils.getMail(5, 10));
		user.setBirthday(DateUtil.randomHireday(1949, 2001));
		return user;
	}

}
