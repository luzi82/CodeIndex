package com.luzi82.codeindex.android.testcase;

import com.luzi82.codeindex.ByteArrayFill;
import com.luzi82.codeindex.android.Jni;

public class ByteArrayFillAndroid extends ByteArrayFill {

	public static final String DESCRIPTION = "Arrays.fill vs for-loop{a[i]=0} vs System.arraycopy vs JNI";

	public Object[] test_jni_memset_GetReleaseByteArrayElements_data() {
		return test_System_arraycopy_data();
	}

	public void test_jni_memset_GetReleaseByteArrayElements(Object arg) {
		final int ARRAY_SIZE = (Integer) arg;
		final byte[] dest = new byte[ARRAY_SIZE];
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			for (int i = 0; i < LOOP_PER_TICK; ++i) {
				Jni.memsetGetReleaseByteArrayElements(dest, (byte) 0);
			}
			done += LOOP_PER_TICK;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * ARRAY_SIZE;
		msg(String.format("test_jni_memset_GetReleaseByteArrayElements: %d: %sB/s", ARRAY_SIZE, metricPrefix(donePerSec)));
	}

	public Object[] test_jni_memset_GetReleasePrimitiveArrayCritical_data() {
		return test_System_arraycopy_data();
	}

	public void test_jni_memset_GetReleasePrimitiveArrayCritical(Object arg) {
		final int ARRAY_SIZE = (Integer) arg;
		final byte[] dest = new byte[ARRAY_SIZE];
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			for (int i = 0; i < LOOP_PER_TICK; ++i) {
				Jni.memsetGetReleasePrimitiveArrayCritical(dest, (byte) 0);
			}
			done += LOOP_PER_TICK;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * ARRAY_SIZE;
		msg(String.format("test_jni_memset_GetReleasePrimitiveArrayCritical: %d: %sB/s", ARRAY_SIZE, metricPrefix(donePerSec)));
	}

}
