package com.luzi82.codeindex;

import com.luzi82.codeindex.gen.FunctionLengthFunc;

public class FunctionLength extends Case {

	public static final String DESCRIPTION = "Performace effect on function length";

	public void test_00001_speed(Object arg) {
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			FunctionLengthFunc.access_V_1(1);
			++done;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * 1;
		msgTimeScore(donePerSec,"line");
	}

	public void test_00010_speed(Object arg) {
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			FunctionLengthFunc.access_V_10(1);
			++done;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * 10;
		msgTimeScore(donePerSec,"line");
	}

	public void test_00100_speed(Object arg) {
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			FunctionLengthFunc.access_V_100(1);
			++done;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * 100;
		msgTimeScore(donePerSec,"line");
	}

	public void test_01000_speed(Object arg) {
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			FunctionLengthFunc.access_V_1000(1);
			++done;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * 1000;
		msgTimeScore(donePerSec,"line");
	}

	public void test_10000_speed(Object arg) {
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			FunctionLengthFunc.access_V_10000(1);
			++done;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * 10000;
		msgTimeScore(donePerSec,"line");
	}

	// public void test_20000_speed(Object arg) {
	// long now = System.currentTimeMillis();
	// long startTime = now;
	// long endTime = startTime + TIME_LIMIT;
	// int done = 0;
	// while (now < endTime) {
	// FunctionLengthFunc.access_V_20000();
	// ++done;
	// now = System.currentTimeMillis();
	// }
	// long timeDone = now - startTime;
	// float donePerSec = (((float) done) / timeDone) * 1000 * 20000;
	// msg(String.format("test_20000_speed: %s lines",
	// metricPrefix(donePerSec)));
	// }

	public static void main(String[] args) {
		main(FunctionLength.class);
	}
}
