package com.manage.gb.constants;

public enum Constants {
    //问题反馈状态已提交
    PROBLM_STATUS_COMMITED("已提交",1),
    PROBLM_STATUS_NO_COLLECTED("未收集",0),
    PROBLM_STATUS_COLLECTED("已收集",1),
    PROBLM_STATUS_PUBLIC("已下发",1),
    PROBLM_STATUS_NO_PUBLIC("未下发",0),
    OPTION_STATUS_COMMITED("已提交",1),
    OPTION_STATUS_COLLECTED("已采纳",2),
    OPTION_STATUS_PUBLIC("已办结",3),
    PROBLM_SELECT("被选登",1),
    PROBLM_NO_SELECT("未被选登",0),
    PROBLM_PUBLIC_SHOW("允许公开",1),
    PROBLM_NO_PUBLIC_SHOW("不允许公开",0);

    private String key;
    private Integer value;

    Constants(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
