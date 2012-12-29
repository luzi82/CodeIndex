#!/bin/bash

. gensrcsrc/config.sh

OUTPUT=gensrc/com/luzi82/codeindex/gen/Config.java
mkdir -p `dirname ${OUTPUT}`
rm -f ${OUTPUT}

echo "package com.luzi82.codeindex.gen;" >> ${OUTPUT}
echo "public class Config{" >> ${OUTPUT}

echo "public static final int REPEAT_COUNT=${REPEAT_COUNT};" >> ${OUTPUT}

echo "}" >> ${OUTPUT}
