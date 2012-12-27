#include <jni.h>
#include <stdlib.h>
#include "version.h"

JNIEXPORT void JNICALL Java_com_luzi82_codeindex_android_Jni_getVersion(JNIEnv* env,
		jclass cls, jbyteArray out) {
	jbyte*buf=((*env)->GetByteArrayElements(env,out,NULL));
	if(buf){
		memcpy(buf,__AUTO_VERSION__,sizeof(__AUTO_VERSION__));
		(*env)->ReleaseByteArrayElements(env,out,buf,0);
	}
}

/////////////////

JNIEXPORT void JNICALL Java_com_luzi82_codeindex_android_Jni_memcpyGetReleaseByteArrayElementsJNIABORT(JNIEnv* env,
		jclass cls, jbyteArray dest, jbyteArray src) {
	jbyte*destBuf,*srcBuf;
	jsize len;
	destBuf=((*env)->GetByteArrayElements(env,dest,NULL));
	if(destBuf){
		srcBuf=((*env)->GetByteArrayElements(env,src,NULL));
		if(srcBuf){
			len=(*env)->GetArrayLength(env,dest);
			memcpy(destBuf,srcBuf,len);
			(*env)->ReleaseByteArrayElements(env,src,srcBuf,JNI_ABORT);
		}
		(*env)->ReleaseByteArrayElements(env,dest,destBuf,0);
	}
}

JNIEXPORT void JNICALL Java_com_luzi82_codeindex_android_Jni_memcpyGetReleaseByteArrayElements0(JNIEnv* env,
		jclass cls, jbyteArray dest, jbyteArray src) {
	jbyte*destBuf,*srcBuf;
	jsize len;
	destBuf=((*env)->GetByteArrayElements(env,dest,NULL));
	if(destBuf){
		srcBuf=((*env)->GetByteArrayElements(env,src,NULL));
		if(srcBuf){
			len=(*env)->GetArrayLength(env,dest);
			memcpy(destBuf,srcBuf,len);
			(*env)->ReleaseByteArrayElements(env,src,srcBuf,0);
		}
		(*env)->ReleaseByteArrayElements(env,dest,destBuf,0);
	}
}

JNIEXPORT void JNICALL Java_com_luzi82_codeindex_android_Jni_memcpyGetReleasePrimitiveArrayCritical(JNIEnv* env,
		jclass cls, jbyteArray dest, jbyteArray src) {
	jbyte*destBuf,*srcBuf;
	jsize len=(*env)->GetArrayLength(env,dest);
	destBuf=((*env)->GetPrimitiveArrayCritical(env,dest,NULL));
	if(destBuf){
		srcBuf=((*env)->GetPrimitiveArrayCritical(env,src,NULL));
		if(srcBuf){
			memcpy(destBuf,srcBuf,len);
			(*env)->ReleasePrimitiveArrayCritical(env,src,srcBuf,0);
		}
		(*env)->ReleasePrimitiveArrayCritical(env,dest,destBuf,0);
	}
}

/////////////////

JNIEXPORT void JNICALL Java_com_luzi82_codeindex_android_Jni_memsetGetReleaseByteArrayElements(JNIEnv* env,
		jclass cls, jbyteArray dest, jbyte value) {
	jbyte*destBuf;
	jsize len=(*env)->GetArrayLength(env,dest);
	destBuf=((*env)->GetByteArrayElements(env,dest,NULL));
	if(destBuf){
		memset(destBuf,value,len);
		(*env)->ReleaseByteArrayElements(env,dest,destBuf,0);
	}
}

JNIEXPORT void JNICALL Java_com_luzi82_codeindex_android_Jni_memsetGetReleasePrimitiveArrayCritical(JNIEnv* env,
		jclass cls, jbyteArray dest, jbyte value) {
	jbyte*destBuf;
	jsize len=(*env)->GetArrayLength(env,dest);
	destBuf=((*env)->GetPrimitiveArrayCritical(env,dest,NULL));
	if(destBuf){
		memset(destBuf,value,len);
		(*env)->ReleasePrimitiveArrayCritical(env,dest,destBuf,0);
	}
}

/////////////////

JNIEXPORT void JNICALL Java_com_luzi82_codeindex_android_Jni_loopGetReleaseByteArrayElementsJNIABORT(JNIEnv* env,
		jclass cls, jbyteArray dest, jint loop) {
	jbyte*destBuf;
	jint i;
	for(i=loop;i!=0;--i){
		destBuf=((*env)->GetByteArrayElements(env,dest,NULL));
		if(destBuf){
			(*env)->ReleaseByteArrayElements(env,dest,destBuf,JNI_ABORT);
		}
	}
}

JNIEXPORT void JNICALL Java_com_luzi82_codeindex_android_Jni_loopGetReleaseByteArrayElements0(JNIEnv* env,
		jclass cls, jbyteArray dest, jint loop) {
	jbyte*destBuf;
	jint i;
	for(i=loop;i!=0;--i){
		destBuf=((*env)->GetByteArrayElements(env,dest,NULL));
		if(destBuf){
			(*env)->ReleaseByteArrayElements(env,dest,destBuf,0);
		}
	}
}

JNIEXPORT void JNICALL Java_com_luzi82_codeindex_android_Jni_loopGetReleasePrimitiveArrayCritical(JNIEnv* env,
		jclass cls, jbyteArray dest, jint loop) {
	jbyte*destBuf;
	jint i;
	for(i=loop;i!=0;--i){
		destBuf=((*env)->GetPrimitiveArrayCritical(env,dest,NULL));
		if(destBuf){
			(*env)->ReleasePrimitiveArrayCritical(env,dest,destBuf,0);
		}
	}
}
