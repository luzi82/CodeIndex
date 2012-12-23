package com.luzi82.codeindex;

public class ByteArrayCopy extends Case {

	public static int TIME_LIMIT = 10000;
	public static int LOOP_PER_TICK = 100;
	// public static long LOOP_COUNT = 10000000000L;
	public static int[] CASE_DATA = {//
	100000,//
			1000000,//
			10000000,//
	};

	public Object[] test_System_arraycopy_data() {
		Object[] ret = new Object[CASE_DATA.length];
		for (int i = 0; i < CASE_DATA.length; ++i) {
			ret[i] = CASE_DATA[i];
		}
		return ret;
	}

	public void test_System_arraycopy(Object arg) {
		final int ARRAY_SIZE = (Integer) arg;
		final byte[] src = new byte[ARRAY_SIZE];
		final byte[] dest = new byte[ARRAY_SIZE];
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			for (int i = 0; i < LOOP_PER_TICK; ++i) {
				System.arraycopy(src, 0, dest, 0, ARRAY_SIZE);
			}
			done += LOOP_PER_TICK;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000;
		msg(String.format("test_System_arraycopy: %d: %.1f/s", ARRAY_SIZE, donePerSec));
	}

	public Object[] test_manualcopy_data() {
		return test_System_arraycopy_data();
	}

	public void test_manualcopy(Object arg) {
		final int ARRAY_SIZE = (Integer) arg;
		final byte[] src = new byte[ARRAY_SIZE];
		final byte[] dest = new byte[ARRAY_SIZE];
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			for (int i = 0; i < LOOP_PER_TICK; ++i) {
				for (int j = 0; j < ARRAY_SIZE; ++j) {
					dest[j] = src[j];
				}
			}
			done += LOOP_PER_TICK;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000;
		msg(String.format("test_manualcopy: %d: %.1f/s", ARRAY_SIZE, donePerSec));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		main(ByteArrayCopy.class);
	}

}
