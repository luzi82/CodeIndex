package com.luzi82.codeindex.android.testcase;

import com.luzi82.codeindex.ByteArrayCopy;
import com.luzi82.codeindex.android.Jni;

public class ByteArrayCopyAndroid extends ByteArrayCopy {

	public static final String DESCRIPTION = "System.arraycopy vs for-loop{a[i]=b[i]} vs JNI";

	// /////////////

	// test_jni_memcpy_GetReleaseByteArrayElements_JNIABORT
	
	public void test_jni_memcpy_check(Object arg) {
		final byte[] src = new byte[CHECK_SIZE];
		final byte[] dest = new byte[CHECK_SIZE];
		for (int i = 0; i < CHECK_SIZE; ++i) {
			src[i] = (byte) (i & 0xff);
		}
		Jni.memcpyGetReleaseByteArrayElementsJNIABORT(dest, src);
		boolean good = true;
		for (int i = 0; i < CHECK_SIZE; ++i) {
			good = good & (dest[i] == (byte) (i & 0xff));
		}
		msg(String.format("test_jni_memcpy_check: %s", good ? "PASS" : "FAIL"));
	}

	public Object[] test_jni_memcpy_speed_data() {
		return getTestArraySize();
	}

	public void test_jni_memcpy_speed(Object arg) {
		final int ARRAY_SIZE = (Integer) arg;
		final byte[] src = new byte[ARRAY_SIZE];
		final byte[] dest = new byte[ARRAY_SIZE];
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			for (int i = 0; i < LOOP_PER_TICK; ++i) {
				Jni.memcpyGetReleaseByteArrayElementsJNIABORT(dest, src);
			}
			done += LOOP_PER_TICK;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * ARRAY_SIZE;
		msg(String.format("test_jni_memcpy_speed: %sB: %sB/s", metricPrefix(ARRAY_SIZE), metricPrefix(donePerSec)));
	}

//	// /////////////
//
//	public void test_jni_memcpy_GetReleaseByteArrayElements_0_check(Object arg) {
//		final byte[] src = new byte[CHECK_SIZE];
//		final byte[] dest = new byte[CHECK_SIZE];
//		for (int i = 0; i < CHECK_SIZE; ++i) {
//			src[i] = (byte) (i & 0xff);
//		}
//		Jni.memcpyGetReleaseByteArrayElements0(dest, src);
//		boolean good = true;
//		for (int i = 0; i < CHECK_SIZE; ++i) {
//			good = good & (dest[i] == (byte) (i & 0xff));
//		}
//		msg(String.format("test_jni_memcpy_GetReleaseByteArrayElements_0_check: %s", good ? "PASS" : "FAIL"));
//	}
//
//	public Object[] test_jni_memcpy_GetReleaseByteArrayElements_0_speed_data() {
//		return test_System_arraycopy_speed_data();
//	}
//
//	public void test_jni_memcpy_GetReleaseByteArrayElements_0_speed(Object arg) {
//		final int ARRAY_SIZE = (Integer) arg;
//		final byte[] src = new byte[ARRAY_SIZE];
//		final byte[] dest = new byte[ARRAY_SIZE];
//		long now = System.currentTimeMillis();
//		long startTime = now;
//		long endTime = startTime + TIME_LIMIT;
//		int done = 0;
//		while (now < endTime) {
//			for (int i = 0; i < LOOP_PER_TICK; ++i) {
//				Jni.memcpyGetReleaseByteArrayElements0(dest, src);
//			}
//			done += LOOP_PER_TICK;
//			now = System.currentTimeMillis();
//		}
//		long timeDone = now - startTime;
//		float donePerSec = (((float) done) / timeDone) * 1000 * ARRAY_SIZE;
//		msg(String.format("test_jni_memcpy_GetReleaseByteArrayElements_0_speed: %d: %sB/s", ARRAY_SIZE, metricPrefix(donePerSec)));
//	}
//
//	// /////////////
//
//	public void test_jni_memcpy_GetReleasePrimitiveArrayCritical_check(Object arg) {
//		final byte[] src = new byte[CHECK_SIZE];
//		final byte[] dest = new byte[CHECK_SIZE];
//		for (int i = 0; i < CHECK_SIZE; ++i) {
//			src[i] = (byte) (i & 0xff);
//		}
//		Jni.memcpyGetReleasePrimitiveArrayCritical(dest, src);
//		boolean good = true;
//		for (int i = 0; i < CHECK_SIZE; ++i) {
//			good = good & (dest[i] == (byte) (i & 0xff));
//		}
//		msg(String.format("test_jni_memcpy_GetReleasePrimitiveArrayCritical_check: %s", good ? "PASS" : "FAIL"));
//	}
//
//	public Object[] test_jni_memcpy_GetReleasePrimitiveArrayCritical_speed_data() {
//		return test_System_arraycopy_speed_data();
//	}
//
//	public void test_jni_memcpy_GetReleasePrimitiveArrayCritical_speed(Object arg) {
//		final int ARRAY_SIZE = (Integer) arg;
//		final byte[] src = new byte[ARRAY_SIZE];
//		final byte[] dest = new byte[ARRAY_SIZE];
//		long now = System.currentTimeMillis();
//		long startTime = now;
//		long endTime = startTime + TIME_LIMIT;
//		int done = 0;
//		while (now < endTime) {
//			for (int i = 0; i < LOOP_PER_TICK; ++i) {
//				Jni.memcpyGetReleasePrimitiveArrayCritical(dest, src);
//			}
//			done += LOOP_PER_TICK;
//			now = System.currentTimeMillis();
//		}
//		long timeDone = now - startTime;
//		float donePerSec = (((float) done) / timeDone) * 1000 * ARRAY_SIZE;
//		msg(String.format("test_jni_memcpy_GetReleasePrimitiveArrayCritical_speed: %d: %sB/s", ARRAY_SIZE, metricPrefix(donePerSec)));
//	}

}
