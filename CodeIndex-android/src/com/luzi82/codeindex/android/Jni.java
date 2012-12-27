package com.luzi82.codeindex.android;

public class Jni {

	static {
		System.loadLibrary("codeindexjni");
	}

	public static native void getVersion(byte[] out);

	// memcpy

	public static native void memcpyGetReleaseByteArrayElementsJNIABORT(byte[] dest, byte[] src);

	public static native void memcpyGetReleaseByteArrayElements0(byte[] dest, byte[] src);

	public static native void memcpyGetReleasePrimitiveArrayCritical(byte[] dest, byte[] src);

	// memset

	public static native void memsetGetReleaseByteArrayElements(byte[] dest, byte value);

	public static native void memsetGetReleasePrimitiveArrayCritical(byte[] dest, byte value);

	// array get release

	public static native void loopGetReleaseByteArrayElementsJNIABORT(byte[] dest, int loop);

	public static native void loopGetReleaseByteArrayElements0(byte[] dest, int loop);

	public static native void loopGetReleasePrimitiveArrayCritical(byte[] dest, int loop);

}
