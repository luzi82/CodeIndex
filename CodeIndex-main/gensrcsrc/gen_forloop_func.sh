#!/bin/bash

. gensrcsrc/config.sh

OUTPUT=gensrc/com/luzi82/codeindex/gen/ForLoopFunc.java
mkdir -p `dirname ${OUTPUT}`
rm -f ${OUTPUT}

echo "package com.luzi82.codeindex.gen;" >> ${OUTPUT}
echo "public class ForLoopFunc{" >> ${OUTPUT}

echo "public static int repeat(int x){" >> ${OUTPUT}
for i in `seq 1 ${REPEAT_COUNT}` ; do
	echo "x+=x;" >> ${OUTPUT}
done
echo "return x;" >> ${OUTPUT}
echo "}" >> ${OUTPUT}

echo "}" >> ${OUTPUT}
