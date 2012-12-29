package com.luzi82.codeindex;

import com.luzi82.codeindex.gen.Config;

public class ForLoopFunc2 {
	public static int forloop_ppi_lt(int x) {
		for (int i = 0; i < Config.REPEAT_COUNT; ++i) {
			x += x;
		}
		return x;
	}

	public static int forloop_ppi_ne(int x) {
		for (int i = 0; i != Config.REPEAT_COUNT; ++i) {
			x += x;
		}
		return x;
	}

	public static int forloop_ipp_lt(int x) {
		for (int i = 0; i < Config.REPEAT_COUNT; i++) {
			x += x;
		}
		return x;
	}

	public static int forloop_ipp_ne(int x) {
		for (int i = 0; i != Config.REPEAT_COUNT; i++) {
			x += x;
		}
		return x;
	}

	public static int forloop_mmi_gt(int x) {
		for (int i = Config.REPEAT_COUNT; i > 0; --i) {
			x += x;
		}
		return x;
	}

	public static int forloop_mmi_ne(int x) {
		for (int i = Config.REPEAT_COUNT; i != 0; --i) {
			x += x;
		}
		return x;
	}

	public static int forloop_imm_gt(int x) {
		for (int i = Config.REPEAT_COUNT; i > 0; i--) {
			x += x;
		}
		return x;
	}

	public static int forloop_imm_ne(int x) {
		for (int i = Config.REPEAT_COUNT; i != 0; i--) {
			x += x;
		}
		return x;
	}

}
