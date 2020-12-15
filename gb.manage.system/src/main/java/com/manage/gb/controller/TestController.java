package com.manage.gb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manage.gb.common.CommonException;

@RestController
public class TestController {

	@GetMapping("test1")
	public String test1() throws Exception{
		{
			throw new CommonException("203","出错了");
		}
	}
}



