NDK_PATH=/home/luzi82/project/android/software/android-ndk-r8d

JNILIB=codeindexjni
APP_PLATFORM=android-5

.PHONY : all clean

PROJECT_NAME = codeindex

DEPS_PATH = deps
TOOL_I18N_PATH = ${DEPS_PATH}/i18n
TOOL_JNIVERSION_PATH = ${DEPS_PATH}/jni_version

all : .i18n_timestamp libs/armeabi/lib${JNILIB}.so

.i18n_timestamp : src2/i18n/i18n.ods
	java \
		-jar ${TOOL_I18N_PATH}/CodeTemplate.jar \
		-g ${TOOL_I18N_PATH}/code_template_global_config.xml \
		-t ${TOOL_I18N_PATH}/ods2xml.xml \
		src2/i18n/i18n.ods ${PROJECT_NAME}_loc_strings
	touch .i18n_timestamp
	
libs/armeabi/lib${JNILIB}.so : jni/${JNILIB}.c jni/Android.mk
	java \
		-jar ${TOOL_JNIVERSION_PATH}/CodeTemplate.jar \
		-g ${TOOL_JNIVERSION_PATH}/code_template_global_config.xml \
		-t ${TOOL_JNIVERSION_PATH}/jni_version.xml
	${NDK_PATH}/ndk-build APP_PLATFORM=${APP_PLATFORM}

clean :
	rm -rf .i18n_timestamp
	rm -rf libs/armeabi
	rm -rf jni/version.h
