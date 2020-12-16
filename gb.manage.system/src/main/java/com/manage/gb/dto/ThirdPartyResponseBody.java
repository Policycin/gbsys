package com.manage.gb.dto;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;

@Data
public class ThirdPartyResponseBody {

	@JSONField(name = "PROBABILITY")
	private String probability;
	
	@JSONField(name = "KEYWORDS")
	private String keyWords;
	
	@JSONField(name = "TEXT_TYPE")
	private String textType;
}
