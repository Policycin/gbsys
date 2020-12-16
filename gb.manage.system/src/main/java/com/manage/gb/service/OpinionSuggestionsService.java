package com.manage.gb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.manage.gb.model.OpinionSuggestions;
import com.manage.gb.model.OpinionSuggestionsQuery;
import com.manage.gb.model.OpinionSuggestionsVO;

/**
 * <p>
 * 意见建议表 服务类
 * </p>
 *
 * @author zxd
 * @since 2020-12-16
 */
public interface OpinionSuggestionsService extends IService<OpinionSuggestions> {

    Integer add(OpinionSuggestionsVO opinionSuggestionsVO);

    OpinionSuggestions queryDetail(OpinionSuggestionsQuery query);

    Integer update(OpinionSuggestions dto);
}
