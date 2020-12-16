package com.manage.gb.service;

import com.manage.gb.common.CommonRespInfoJson;

public interface VeriCodeService {

	CommonRespInfoJson getVerificatinCode(String var1);

    boolean checkVerificatinCode(String var1, String var2);
}
