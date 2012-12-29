package com.luzi82.codeindex;

import java.util.Arrays;
import java.util.LinkedList;

public class CaseList {

	private static final Class<?>[] CASE_ARRAY = {//
	ByteArrayCopy.class,//
			ByteArrayFill.class,//
			FunctionLength.class,//
			ForLoop.class,//
			findClass("com.luzi82.codeindex.gen.AccessLoop"),//
	};

	public static LinkedList<Class<?>> getList() {
		return new LinkedList<Class<?>>(Arrays.asList(CASE_ARRAY));
	}

	public static LinkedList<Class<?>> reduceList(LinkedList<Class<?>> aList) {
		LinkedList<Class<?>> ret = new LinkedList<Class<?>>();
		for (Class<?> c : aList) {
			boolean good = true;
			for (Class<?> cc : aList) {
				if (c == cc)
					continue;
				good = good & (!(c.isAssignableFrom(cc)));
			}
			if (good) {
				ret.addLast(c);
			}
		}
		return ret;
	}

	public static Class<?> findClass(String aName) {
		try {
			return Class.forName("com.luzi82.codeindex.gen.AccessLoop");
		} catch (ClassNotFoundException e) {
			throw new Error();
		}
	}

}
