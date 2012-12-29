.PHONY : all clean

OUTPUT_PATH = gensrc/com/luzi82/codeindex/gen

ALL_OUTPUT = \
	${OUTPUT_PATH}/FunctionLengthFunc.java \
	${OUTPUT_PATH}/Config.java \
	${OUTPUT_PATH}/ForLoopFunc.java

CONFIG_FILE = gensrcsrc/config.sh

all : ${ALL_OUTPUT}

${OUTPUT_PATH}/FunctionLengthFunc.java : gensrcsrc/gen_functionlength_func.sh ${CONFIG_FILE}
	gensrcsrc/gen_functionlength_func.sh

${OUTPUT_PATH}/Config.java : gensrcsrc/gen_config.sh ${CONFIG_FILE}
	gensrcsrc/gen_config.sh

${OUTPUT_PATH}/ForLoopFunc.java : gensrcsrc/gen_forloop_func.sh ${CONFIG_FILE}
	gensrcsrc/gen_forloop_func.sh

clean :
	rm -rf ${ALL_OUTPUT}
