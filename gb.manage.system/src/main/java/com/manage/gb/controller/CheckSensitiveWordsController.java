package com.manage.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manage.gb.common.CommonRespInfoJson;
import com.manage.gb.service.impl.SensitiveWordsCheckServiceImpl;

@RestController
public class CheckSensitiveWordsController {

	@Autowired
	private SensitiveWordsCheckServiceImpl sensitiveWordsCheckService;
	
	@PostMapping("/vailKeyWords")
	public CommonRespInfoJson vailKeyWords(@RequestBody String input){
		
		return sensitiveWordsCheckService.checkWords(input);
	}
}
