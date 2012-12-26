package com.luzi82.codeindex;

public class ByteArrayCopy extends Case {

	public static final String DESCRIPTION = "System.arraycopy vs for-loop{a[i]=b[i]}";

	public static int TIME_LIMIT = 10000;
	public static int LOOP_PER_TICK = 100;
	// public static long LOOP_COUNT = 10000000000L;
	public static int[] CASE_DATA = {//
	100000,//
			1000000,//
			10000000,//
	};
	
	public static int CHECK_SIZE = 1024;

	public Object[] test_System_arraycopy_speed_data() {
		Object[] ret = new Object[CASE_DATA.length];
		for (int i = 0; i < CASE_DATA.length; ++i) {
			ret[i] = CASE_DATA[i];
		}
		return ret;
	}

	public void test_System_arraycopy_speed(Object arg) {
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
		float donePerSec = (((float) done) / timeDone) * 1000 * ARRAY_SIZE;
		msg(String.format("test_System_arraycopy_speed: %d: %sB/s", ARRAY_SIZE, metricPrefix(donePerSec)));
	}

	public Object[] test_manualcopy_speed_data() {
		return test_System_arraycopy_speed_data();
	}

	public void test_manualcopy_speed(Object arg) {
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
		float donePerSec = (((float) done) / timeDone) * 1000 * ARRAY_SIZE;
		msg(String.format("test_manualcopy_speed: %d: %sB/s", ARRAY_SIZE, metricPrefix(donePerSec)));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		main(ByteArrayCopy.class);
	}

}
