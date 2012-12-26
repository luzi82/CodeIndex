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

JNIEXPORT void JNICALL Java_com_luzi82_codeindex_android_Jni_memcpyGetByteArrayElementsJNIABORT(JNIEnv* env,
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

JNIEXPORT void JNICALL Java_com_luzi82_codeindex_android_Jni_memcpyGetByteArrayElements0(JNIEnv* env,
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

//JNIEXPORT void JNICALL Java_com_luzi82_randomwallpaper_LiveWallpaper_setSeed(JNIEnv* env,
//		jclass cls, jlong _seed) {
//	seed = _seed;
//}
//
//JNIEXPORT void JNICALL Java_com_luzi82_randomwallpaper_LiveWallpaper_genFullColorRandom(JNIEnv* env,
//		jclass cls, jbyteArray out) {
//	static jint*ptr,*buf2,*bufEnd;
//	static jsize len;
//	buf2=(jint*)((*env)->GetByteArrayElements(env,out,NULL));
//	if(buf2) {
//		len=(*env)->GetArrayLength(env,out);
//		ptr=buf2;
//		bufEnd=buf2+(len>>2);
//		while(ptr!=bufEnd) {
//			seed=(seed*MULTIPLIER+0xbLL)&((1LL<<48)-1);
//			*ptr=((int)(seed>>(48-32)))|0xff000000;
//			++ptr;
//		}
//		(*env)->ReleaseByteArrayElements(env,out,(jbyte*)buf2,0);
//	}
//}
//
//JNIEXPORT void JNICALL Java_com_luzi82_randomwallpaper_LiveWallpaper_genGrayScaleRandom(JNIEnv* env,
//		jclass cls, jbyteArray out) {
//	static jint*ptr,*buf2,*bufEnd;
//	static jsize len;
//	static int remainOffset;
//	static int remain;
//	static int tmp;
//	remainOffset=0;
//	buf2=(jint*)((*env)->GetByteArrayElements(env,out,NULL));
//	if(buf2) {
//		len=(*env)->GetArrayLength(env,out);
//		ptr=buf2;
//		bufEnd=buf2+(len>>2);
//		while(ptr!=bufEnd) {
//			if(!remainOffset){
//				seed=(seed*MULTIPLIER+0xbLL)&((1LL<<48)-1);
//				remain=(int)(seed>>(48-32));
//				remainOffset=4;
//			}
//			tmp=remain&0xff;
//			*ptr=(tmp)|(tmp<<8)|(tmp<<16)|0xff000000;
//			++ptr;
//			remain>>=8;
//			--remainOffset;
//		}
//		(*env)->ReleaseByteArrayElements(env,out,(jbyte*)buf2,0);
//	}
//}
//
//JNIEXPORT void JNICALL Java_com_luzi82_randomwallpaper_LiveWallpaper_genBlackWhiteRandom(JNIEnv* env,
//		jclass cls, jbyteArray out) {
//	static jint*ptr,*buf2,*bufEnd;
//	static jsize len;
//	static int remainOffset;
//	static int remain;
//	remainOffset=0;
//	buf2=(jint*)((*env)->GetByteArrayElements(env,out,NULL));
//	if(buf2) {
//		len=(*env)->GetArrayLength(env,out);
//		ptr=buf2;
//		bufEnd=buf2+(len>>2);
//		while(ptr!=bufEnd) {
//			if(!remainOffset){
//				seed=(seed*MULTIPLIER+0xbLL)&((1LL<<48)-1);
//				remain=(int)(seed>>(48-32));
//				remainOffset=32;
//			}
//			*ptr=(remain&0x1)?0xffffffff:0xff000000;
//			++ptr;
//			remain>>=1;
//			--remainOffset;
//		}
//		(*env)->ReleaseByteArrayElements(env,out,(jbyte*)buf2,0);
//	}
//}
