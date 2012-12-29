package com.luzi82.codeindex;

public class ByteArrayCopy extends Case {

	public static final String DESCRIPTION = "System.arraycopy vs for-loop{a[i]=b[i]}";

	public static int CHECK_SIZE = 1024;

	public Object[] test_System_arraycopy_speed_data() {
		return getTestArraySize();
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
		msgTimeScore(metricPrefix(ARRAY_SIZE) + "B", donePerSec, "B");
	}

	public Object[] test_manualcopy_speed_data() {
		return getTestArraySize();
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
		msgTimeScore(metricPrefix(ARRAY_SIZE) + "B", donePerSec, "B");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		main(ByteArrayCopy.class);
	}

}
