package com.luzi82.codeindex;

import java.util.Arrays;

public class ByteArrayFill extends Case {

	public static int TIME_LIMIT = 10000;
	public static int LOOP_PER_TICK = 100;
	public static int SRC_SIZE = 10000;
	public static int[] CASE_DATA = {//
	100000,//
			1000000,//
			10000000,//
	};

	public static final String DESCRIPTION = "Arrays.fill vs for-loop{a[i]=0} vs System.arraycopy";

	public Object[] test_Arrays_fill_data() {
		Object[] ret = new Object[CASE_DATA.length];
		for (int i = 0; i < CASE_DATA.length; ++i) {
			ret[i] = CASE_DATA[i];
		}
		return ret;
	}

	public void test_Arrays_fill(Object arg) {
		final int ARRAY_SIZE = (Integer) arg;
		final byte[] ary = new byte[ARRAY_SIZE];
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			for (int i = 0; i < LOOP_PER_TICK; ++i) {
				Arrays.fill(ary, (byte) 0);
			}
			done += LOOP_PER_TICK;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * ARRAY_SIZE;
		msg(String.format("test_Arrays_fill: %d: %sB/s", ARRAY_SIZE, metricPrefix(donePerSec)));
	}

	public Object[] test_manualfill_data() {
		return test_Arrays_fill_data();
	}

	public void test_manualfill(Object arg) {
		final int ARRAY_SIZE = (Integer) arg;
		final byte[] ary = new byte[ARRAY_SIZE];
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			for (int i = 0; i < LOOP_PER_TICK; ++i) {
				for (int j = 0; j < ARRAY_SIZE; ++j) {
					ary[j] = 0;
				}
			}
			done += LOOP_PER_TICK;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * ARRAY_SIZE;
		msg(String.format("test_manualfill: %d: %sB/s", ARRAY_SIZE, metricPrefix(donePerSec)));
	}

	public Object[] test_System_arraycopy_data() {
		return test_Arrays_fill_data();
	}

	public void test_System_arraycopy(Object arg) {
		final int ARRAY_SIZE = (Integer) arg;
		final byte[] src = new byte[SRC_SIZE];
		final byte[] dest = new byte[ARRAY_SIZE];
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			for (int i = 0; i < LOOP_PER_TICK; ++i) {
				for (int j = 0; j < ARRAY_SIZE; j += SRC_SIZE) {
					System.arraycopy(src, 0, dest, j, SRC_SIZE);
				}
			}
			done += LOOP_PER_TICK;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * ARRAY_SIZE;
		msg(String.format("test_System_arraycopy: %d: %sB/s", ARRAY_SIZE, metricPrefix(donePerSec)));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		main(ByteArrayFill.class);
	}

}
