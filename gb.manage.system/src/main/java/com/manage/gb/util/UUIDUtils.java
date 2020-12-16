package com.manage.gb.util;

import java.util.UUID;

public class UUIDUtils {
	public static String getUUID() {
		String id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		return id;
	}
}
