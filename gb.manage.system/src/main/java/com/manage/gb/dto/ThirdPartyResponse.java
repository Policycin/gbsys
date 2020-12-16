package com.manage.gb.dto;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;

@Data
public class ThirdPartyResponse {

	@JSONField(name = "C-Response-Desc")
	private String cResponseDesc;
	
	@JSONField(name = "C-API-Status")
	private String CAPIStatus;
	
	@JSONField(name = "C-Response-Code")
	private String CResponseCode;
	
	@JSONField(name = "C-Response-Body")
	private ThirdPartyResponseBody thirdPartyResponseBody;
}
