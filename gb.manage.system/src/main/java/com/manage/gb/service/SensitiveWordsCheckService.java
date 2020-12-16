package com.manage.gb.service;

import org.springframework.stereotype.Service;

import com.manage.gb.common.CommonRespInfoJson;

/**
 * 敏感词汇校验服务
 * 
 * @author zxd
 *
 */
@Service
public interface SensitiveWordsCheckService {



	public CommonRespInfoJson checkWords(String content);
}
