#!/bin/bash

OUTPUT=gensrc/com/luzi82/codeindex/gen/FunctionLengthFunc.java

mkdir -p `dirname ${OUTPUT}`

rm -f ${OUTPUT}

echo "package com.luzi82.codeindex.gen;" >> ${OUTPUT}
echo "public class FunctionLengthFunc {" >> ${OUTPUT}

for len in {1,10,100,1000,10000} ; do

	echo "public static int access_V_${len}(int x){" >> ${OUTPUT}
	for i in `seq 1 ${len}` ; do
		echo "x+=x;" >> ${OUTPUT}
	done
	echo "return x;" >> ${OUTPUT}
	echo "}" >> ${OUTPUT}

done

echo "}" >> ${OUTPUT}
