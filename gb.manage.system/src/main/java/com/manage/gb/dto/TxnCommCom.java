package com.manage.gb.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TxnCommCom implements Serializable{

	private static final long serialVersionUID = 1L;
	private String tStsTraceId;
	private String txnIttChnlId;
	private String txnIttChnlCgyCode;
}
