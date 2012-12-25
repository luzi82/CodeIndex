package com.luzi82.codeindex.android;

public class Jni {

	static {
		System.loadLibrary("codeindexjni");
	}

	public static native void getVersion(byte[] out);

}
