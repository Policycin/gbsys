package com.manage.gb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.manage.gb.model.ProblemsClues;
import com.manage.gb.model.ProblemsCluesQuery;
import com.manage.gb.model.ProblemsCluesVO;

/**
 * <p>
 * 线索征集表 服务类
 * </p>
 *
 * @author zxd
 * @since 2020-12-16
 */
public interface ProblemsCluesService extends IService<ProblemsClues> {

    Integer add(ProblemsCluesVO problemsCluesVO);

    ProblemsClues queryDetail(ProblemsCluesQuery query);

    Integer update(ProblemsClues dto);
}
