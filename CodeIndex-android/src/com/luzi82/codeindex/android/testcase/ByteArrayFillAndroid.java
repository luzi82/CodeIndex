package com.luzi82.codeindex.android.testcase;

import com.luzi82.codeindex.ByteArrayFill;
import com.luzi82.codeindex.android.Jni;

public class ByteArrayFillAndroid extends ByteArrayFill {

	public static final String DESCRIPTION = "Arrays.fill vs for-loop{a[i]=0} vs System.arraycopy vs JNI";

	/////////////////////

	// test_jni_memset_GetReleaseByteArrayElements
	public void test_jni_memset_check(Object arg) {
		final byte[] dest = new byte[CHECK_SIZE];
		for (int i = 0; i < CHECK_SIZE; ++i) {
			dest[i] = (byte) (i & 0xff);
		}
		Jni.memsetGetReleaseByteArrayElements(dest, (byte) 0x37);
		boolean good = true;
		for (int i = 0; i < CHECK_SIZE; ++i) {
			good = good & (dest[i] == (byte) (0x37));
		}
		msg(String.format("test_jni_memset_check: %s", good ? "PASS" : "FAIL"));
	}

	public Object[] test_jni_memset_speed_data() {
		return getTestArraySize();
	}

	public void test_jni_memset_speed(Object arg) {
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
		msgTimeScore(metricPrefix(ARRAY_SIZE) + "B", donePerSec, "B");
	}

//	/////////////////////
//
//	public void test_jni_memset_GetReleasePrimitiveArrayCritical_check(Object arg) {
//		final byte[] dest = new byte[CHECK_SIZE];
//		for (int i = 0; i < CHECK_SIZE; ++i) {
//			dest[i] = (byte) (i & 0xff);
//		}
//		Jni.memsetGetReleasePrimitiveArrayCritical(dest, (byte) 0x37);
//		boolean good = true;
//		for (int i = 0; i < CHECK_SIZE; ++i) {
//			good = good & (dest[i] == (byte) (0x37));
//		}
//		msg(String.format("test_jni_memset_GetReleasePrimitiveArrayCritical_check: %s", good ? "PASS" : "FAIL"));
//	}
//
//	public Object[] test_jni_memset_GetReleasePrimitiveArrayCritical_speed_data() {
//		return test_System_arraycopy_speed_data();
//	}
//
//	public void test_jni_memset_GetReleasePrimitiveArrayCritical_speed(Object arg) {
//		final int ARRAY_SIZE = (Integer) arg;
//		final byte[] dest = new byte[ARRAY_SIZE];
//		long now = System.currentTimeMillis();
//		long startTime = now;
//		long endTime = startTime + TIME_LIMIT;
//		int done = 0;
//		while (now < endTime) {
//			for (int i = 0; i < LOOP_PER_TICK; ++i) {
//				Jni.memsetGetReleasePrimitiveArrayCritical(dest, (byte) 0);
//			}
//			done += LOOP_PER_TICK;
//			now = System.currentTimeMillis();
//		}
//		long timeDone = now - startTime;
//		float donePerSec = (((float) done) / timeDone) * 1000 * ARRAY_SIZE;
//		msg(String.format("test_jni_memset_GetReleasePrimitiveArrayCritical_speed: %d: %sB/s", ARRAY_SIZE, metricPrefix(donePerSec)));
//	}

}
