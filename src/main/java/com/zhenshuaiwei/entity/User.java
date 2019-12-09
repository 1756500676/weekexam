/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: User.java 
 * @Prject: zhenshuaiwei-week2exam
 * @Package: com.zhenshuaiwei.entity 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年12月9日 上午8:40:00 
 * @version: V1.0  
 */
package com.zhenshuaiwei.entity;

import java.io.Serializable;
import java.util.Date;

/** 
 * @ClassName: User 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年12月9日 上午8:40:00  
 */
public class User implements Serializable {

/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -6576310339381141125L;
//	共有ID，姓名，性别，手机，邮箱，生日，共
	private Integer id;
	private String name;
	private String sex;
	private String phone;
	private String email;
	private Date birthday;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public User(Integer id, String name, String sex, String phone, String email, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", phone=" + phone + ", email=" + email
				+ ", birthday=" + birthday + "]";
	}
	
	
}
