package com.luzi82.codeindex;

import java.util.Arrays;
import java.util.LinkedList;

public class CaseList {

	public static final Class<?>[] CASE_ARRAY = {//
	ByteArrayCopy.class,//
	ByteArrayFill.class,//
	};

	public static LinkedList<Class<?>> getList() {
		return new LinkedList<Class<?>>(Arrays.asList(CASE_ARRAY));
	}

}
