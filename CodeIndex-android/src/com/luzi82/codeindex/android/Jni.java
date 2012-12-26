package com.luzi82.codeindex.android;

public class Jni {

	static {
		System.loadLibrary("codeindexjni");
	}

	public static native void getVersion(byte[] out);
	
	// memcpy
	
	public static native void memcpyGetReleaseByteArrayElementsJNIABORT(byte[] dest,byte[] src);

	public static native void memcpyGetReleaseByteArrayElements0(byte[] dest,byte[] src);

	public static native void memcpyGetReleasePrimitiveArrayCritical(byte[] dest,byte[] src);

	// memset
	
	public static native void memsetGetReleaseByteArrayElements(byte[] dest,byte value);

	public static native void memsetGetReleasePrimitiveArrayCritical(byte[] dest,byte value);

}
