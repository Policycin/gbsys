package com.manage.gb.service.impl;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manage.gb.common.CommonRespInfoJson;
import com.manage.gb.dto.VfCodeDTO;
import com.manage.gb.service.VeriCodeService;
import com.manage.gb.util.UUIDUtils;
import com.manage.gb.util.VerifyCodeUtil;


@Service
public class VeriCodeServiceImpl implements VeriCodeService {

	private static Logger logger = LoggerFactory.getLogger(VeriCodeServiceImpl.class);
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Value("${verify.code.outTime:10}")
	private String verifyCodeOutTime;
	
	private ObjectMapper mapper = new ObjectMapper();

	public VeriCodeServiceImpl() {
		this.mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		this.mapper.setSerializationInclusion(Include.NON_NULL);
	}

	public CommonRespInfoJson<String> getVerificatinCode(String uuidKey) {
		if (StringUtils.isNotBlank(uuidKey)) {
			this.stringRedisTemplate.delete(uuidKey);
		}

		String uuid = UUIDUtils.getUUID();
		String vfCode = VerifyCodeUtil.getVerifyCode((String) null);
		this.stringRedisTemplate.opsForValue().set(uuid, vfCode, Long.parseLong(this.verifyCodeOutTime),
				TimeUnit.MINUTES);
		String imgCode = null;

		try {
			imgCode = VerifyCodeUtil.getImgBase64(vfCode, (String) null, (String) null, (String) null);
		} catch (IOException var9) {
			logger.error(var9.getMessage());
			var9.printStackTrace();
		}

		VfCodeDTO param = new VfCodeDTO();
		param.setImgCode(imgCode);
		param.setUuidVal(uuid);
		String rep = null;

		try {
			rep = this.mapper.writeValueAsString(param);
		} catch (JsonProcessingException var8) {
			logger.error(var8.getMessage());
			var8.printStackTrace();
		}

		return CommonRespInfoJson.data(rep);
	}

	public boolean checkVerificatinCode(String uuidKey, String vfCode) {
		if (StringUtils.isNotBlank(uuidKey)) {
			String localCode = (String) this.stringRedisTemplate.opsForValue().get(uuidKey);
			if (StringUtils.isNotBlank(localCode) && localCode.equalsIgnoreCase(vfCode)) {
				return true;
			}
		}

		return false;
	}

}
