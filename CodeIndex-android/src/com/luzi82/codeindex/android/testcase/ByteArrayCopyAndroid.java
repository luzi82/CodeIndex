package com.luzi82.codeindex.android.testcase;

import com.luzi82.codeindex.ByteArrayCopy;
import com.luzi82.codeindex.android.Jni;

public class ByteArrayCopyAndroid extends ByteArrayCopy {

	public static final String DESCRIPTION = "System.arraycopy vs for-loop{a[i]=b[i]} vs JNI";

	public Object[] test_jni_memcpy_GetReleaseByteArrayElements_JNIABORT_data() {
		return test_System_arraycopy_data();
	}

	public void test_jni_memcpy_GetReleaseByteArrayElements_JNIABORT(Object arg) {
		final int ARRAY_SIZE = (Integer) arg;
		final byte[] src = new byte[ARRAY_SIZE];
		final byte[] dest = new byte[ARRAY_SIZE];
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			for (int i = 0; i < LOOP_PER_TICK; ++i) {
				Jni.memcpyGetByteArrayElementsJNIABORT(dest, src);
			}
			done += LOOP_PER_TICK;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * ARRAY_SIZE;
		msg(String.format("test_jni_memcpy_GetReleaseByteArrayElements_JNIABORT: %d: %sB/s", ARRAY_SIZE, metricPrefix(donePerSec)));
	}

	public Object[] test_jni_memcpy_GetReleaseByteArrayElements_0_data() {
		return test_System_arraycopy_data();
	}

	public void test_jni_memcpy_GetReleaseByteArrayElements_0(Object arg) {
		final int ARRAY_SIZE = (Integer) arg;
		final byte[] src = new byte[ARRAY_SIZE];
		final byte[] dest = new byte[ARRAY_SIZE];
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			for (int i = 0; i < LOOP_PER_TICK; ++i) {
				Jni.memcpyGetByteArrayElements0(dest, src);
			}
			done += LOOP_PER_TICK;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * ARRAY_SIZE;
		msg(String.format("test_jni_memcpy_GetReleaseByteArrayElements_0: %d: %sB/s", ARRAY_SIZE, metricPrefix(donePerSec)));
	}

	public Object[] test_jni_memcpy_GetReleasePrimitiveArrayCritical_data() {
		return test_System_arraycopy_data();
	}

	public void test_jni_memcpy_GetReleasePrimitiveArrayCritical(Object arg) {
		final int ARRAY_SIZE = (Integer) arg;
		final byte[] src = new byte[ARRAY_SIZE];
		final byte[] dest = new byte[ARRAY_SIZE];
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			for (int i = 0; i < LOOP_PER_TICK; ++i) {
				Jni.memcpyGetReleasePrimitiveArrayCritical(dest, src);
			}
			done += LOOP_PER_TICK;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * ARRAY_SIZE;
		msg(String.format("test_jni_memcpy_GetReleasePrimitiveArrayCritical: %d: %sB/s", ARRAY_SIZE, metricPrefix(donePerSec)));
	}

}
