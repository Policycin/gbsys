package com.manage.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manage.gb.common.CommonRespInfoJson;
import com.manage.gb.service.VeriCodeService;

@RestController
public class VerCodeController {

	@Autowired
	private  VeriCodeService veriCodeServiceImpl;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/gainvc")
	public CommonRespInfoJson<String> gainVerificationCode(@RequestParam(name ="uuidVal", required = false) String uuidVal){
		return veriCodeServiceImpl.getVerificatinCode(uuidVal);
	}
	
	@GetMapping("/checkvc")
	public boolean checkVerificationCode(@RequestParam(name ="uuidVal") String uuidVal,@RequestParam(name ="vfCode") String vfCode){
		return veriCodeServiceImpl.checkVerificatinCode(uuidVal, vfCode);
	}
}
