package com.luzi82.codeindex.android;

public class Jni {

	static {
		System.loadLibrary("codeindexjni");
	}

	public static native void getVersion(byte[] out);
	
	public static native void memcpyGetByteArrayElementsJNIABORT(byte[] dest,byte[] src);

	public static native void memcpyGetByteArrayElements0(byte[] dest,byte[] src);

	public static native void memcpyGetReleasePrimitiveArrayCritical(byte[] dest,byte[] src);

}
