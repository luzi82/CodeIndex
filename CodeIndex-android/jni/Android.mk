LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := codeindexjni
LOCAL_SRC_FILES := codeindexjni.c

include $(BUILD_SHARED_LIBRARY)
