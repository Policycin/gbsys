package com.manage.gb.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class VfCodeDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String vfCode;  //验证码
	
	private String uuidVal;  //验证码Id
	
	private String imgCode; //验证码图片流
}
