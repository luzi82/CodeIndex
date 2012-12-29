package com.luzi82.codeindex;

import com.luzi82.codeindex.gen.Config;

public class AccessLoopFunc {

	public static int testcase_hardcode(int x) {
		for (int i = 0; i < Config.REPEAT_COUNT; ++i) {
			x += 1;
		}
		return x;
	}

	static final int STATIC_FINAL = 1;

	public static int testcase_static_final(int x) {
		for (int i = 0; i < Config.REPEAT_COUNT; ++i) {
			x += STATIC_FINAL;
		}
		return x;
	}
	
	static int mStaticVar = 1;

	public static int testcase_static_var(int x) {
		for (int i = 0; i < Config.REPEAT_COUNT; ++i) {
			x += mStaticVar;
		}
		return x;
	}

	public static int testcase_plusplus(int x) {
		for (int i = 0; i < Config.REPEAT_COUNT; ++i) {
			x++;
		}
		return x;
	}

	public static int testcase_local_final(int x) {
		final int LOCAL_FINAL = 1;
		for (int i = 0; i < Config.REPEAT_COUNT; ++i) {
			x += LOCAL_FINAL;
		}
		return x;
	}

	public static int testcase_local_var(int x) {
		int localVar = 1;
		for (int i = 0; i < Config.REPEAT_COUNT; ++i) {
			x += localVar;
		}
		return x;
	}

	public final int member_final=1;
	
	public int testcase_member_final(int x){
		for (int i = 0; i < Config.REPEAT_COUNT; ++i) {
			x += member_final;
		}
		return x;
	}

	public int member_var=1;
	
	public int testcase_member_var(int x){
		for (int i = 0; i < Config.REPEAT_COUNT; ++i) {
			x += member_var;
		}
		return x;
	}

}
