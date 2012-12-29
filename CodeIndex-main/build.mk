.PHONY : all clean

ALL_OUTPUT = \
	gensrc/com/luzi82/codeindex/gen/FunctionLengthFunc.java

all : ${ALL_OUTPUT}

gensrc/com/luzi82/codeindex/gen/FunctionLengthFunc.java : gensrcsrc/gen_functionlength_func.sh
	gensrcsrc/gen_functionlength_func.sh

clean :
	rm -rf ${ALL_OUTPUT}
