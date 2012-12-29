.PHONY : all clean

OUTPUT_PATH = gensrc/com/luzi82/codeindex/gen

ALL_OUTPUT = \
	${OUTPUT_PATH}/FunctionLengthFunc.java \
	${OUTPUT_PATH}/Config.java \
	${OUTPUT_PATH}/ForLoopFunc.java \
	${OUTPUT_PATH}/AccessLoop.java

CONFIG_FILE = gensrcsrc/config.sh

all : ${ALL_OUTPUT}

${OUTPUT_PATH}/FunctionLengthFunc.java : gensrcsrc/gen_functionlength_func.sh ${CONFIG_FILE}
	gensrcsrc/gen_functionlength_func.sh

${OUTPUT_PATH}/Config.java : gensrcsrc/gen_config.sh ${CONFIG_FILE}
	gensrcsrc/gen_config.sh

${OUTPUT_PATH}/ForLoopFunc.java : gensrcsrc/gen_forloop_func.sh ${CONFIG_FILE}
	gensrcsrc/gen_forloop_func.sh

${OUTPUT_PATH}/AccessLoop.java : \
		gensrcsrc/java/com/luzi82/codeindex/gensrcsrc/GenAccessLoop.java \
		src/com/luzi82/codeindex/AccessLoopFunc.java \
		src/com/luzi82/codeindex/ByteArrayCopy.java \
		src/com/luzi82/codeindex/Case.java \
		${OUTPUT_PATH}/Config.java
	rm -rf tmp
	mkdir tmp
	javac -d tmp -sourcepath src:gensrcsrc:gensrc gensrcsrc/java/com/luzi82/codeindex/gensrcsrc/GenAccessLoop.java
	java -cp tmp com.luzi82.codeindex.gensrcsrc.GenAccessLoop
	rm -rf tmp

clean :
	rm -rf ${ALL_OUTPUT}
