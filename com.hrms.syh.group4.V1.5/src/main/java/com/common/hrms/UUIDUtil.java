package com.common.hrms;

import java.util.UUID;

public class UUIDUtil {
	private UUIDUtil() {
	}
	static public String createUUID()
	{
		return UUID.randomUUID().toString().replace("-", "");
	}

}
