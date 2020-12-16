package com.manage.gb.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.manage.gb.common.CommonRespInfoJson;
import com.manage.gb.dto.ThirdPartyResponse;
import com.manage.gb.dto.TxnBodyCom;
import com.manage.gb.dto.TxnCommCom;

import io.netty.util.internal.StringUtil;

/**
 * 敏感词汇校验服务
 * 
 * @author zxd
 *
 */
@Service
public class SensitiveWordsCheckServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(SensitiveWordsCheckServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${ThirdParty.Uri}")
	private String Uri;

	@Value("${ThirdParty.tStsTraceId}")
	private String tStsTraceId;

	@Value("${ThirdParty.txnIttChnlId}")
	private String txnIttChnlId;

	@Value("${ThirdParty.txnIttChnlCgyCode}")
	private String txnIttChnlCgyCode;

	public CommonRespInfoJson checkWords(String content) {
		if (StringUtil.isNullOrEmpty(content)) {
			return new CommonRespInfoJson("406", "输入参数为空!");
		}
		String url = Uri + "/dss/audit";
		HttpHeaders headers = new HttpHeaders();
		headers.set("C-tenancy-Id", "610000000000");
		headers.set("C-Business-Id", "2018");
		TxnCommCom txnCommCom = new TxnCommCom();
		txnCommCom.setTStsTraceId(tStsTraceId);
		txnCommCom.setTxnIttChnlId(txnIttChnlId);
		txnCommCom.setTxnIttChnlCgyCode(txnIttChnlCgyCode);
		TxnBodyCom txnBodyCom = new TxnBodyCom();
		txnBodyCom.setInput(content);
		Map<String, Object> param = new HashMap<>();
		param.put("txnCommCom", txnCommCom);
		param.put("txnBodyCom", txnBodyCom);
		JSONObject objMapper = new JSONObject();
		Object json = objMapper.toJSONString(param);

		logger.info("请求体参数--->"+json.toString());
		// 以表单的方式提交
		headers.setContentType(MediaType.APPLICATION_JSON);
		// 将请求头部和参数合成一个请求
		HttpEntity requestEntity = new HttpEntity<>(json, headers);
		// 执行HTTP请求，将返回的结构使用ResultVO类格式化
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestEntity, String.class);
		String body = responseEntity.getBody();
		ThirdPartyResponse parseObject = objMapper.parseObject(body,ThirdPartyResponse.class);
		logger.info("请响应body参数--->"+parseObject.toString());
		if(parseObject != null ) {
			return CommonRespInfoJson.data(parseObject.getThirdPartyResponseBody().getKeyWords());
		}
		return CommonRespInfoJson.ok();
	}

}
