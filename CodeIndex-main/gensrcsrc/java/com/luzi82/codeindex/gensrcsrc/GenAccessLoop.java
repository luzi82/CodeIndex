package com.luzi82.codeindex.gensrcsrc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.luzi82.codeindex.AccessLoopFunc;
import com.luzi82.codeindex.ByteArrayCopy;

public class GenAccessLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File outputFile = new File("gensrc/com/luzi82/codeindex/gen/AccessLoop.java");
			outputFile.getParentFile().mkdirs();

			Class<?> accessLoopFuncClass = AccessLoopFunc.class;
			Method[] methodAry = accessLoopFuncClass.getMethods();

			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

			bw.write("package com.luzi82.codeindex.gen;");
			bw.newLine();
			bw.write("import com.luzi82.codeindex.Case;");
			bw.newLine();
			bw.write("import com.luzi82.codeindex.AccessLoopFunc;");
			bw.newLine();
			bw.write("public class AccessLoop extends Case {");
			bw.newLine();
			bw.write("public void test_0(Object arg){AccessLoopFunc.testcase_hardcode(1);System.currentTimeMillis();}");
			bw.newLine();

			for (Method method : methodAry) {
				String methodName = method.getName();
				if (!methodName.startsWith("testcase_"))
					continue;
				methodName = methodName.substring(9);
				bw.write("public void test_" + methodName + "(Object arg) {");
				bw.newLine();
				if ((method.getModifiers() & Modifier.STATIC) == 0) {
					bw.write("AccessLoopFunc obj = new AccessLoopFunc();");
					bw.newLine();
				}
				bw.write("long now = System.currentTimeMillis();");
				bw.newLine();
				bw.write("long startTime = now;");
				bw.newLine();
				bw.write("long endTime = startTime + TIME_LIMIT;");
				bw.newLine();
				bw.write("int done = 0;");
				bw.newLine();
				bw.write("while (now < endTime) {");
				bw.newLine();
				if ((method.getModifiers() & Modifier.STATIC) == 0) {
					bw.write("obj.testcase_" + methodName + "(1);");
				}else{
					bw.write("AccessLoopFunc.testcase_" + methodName + "(1);");
				}
				bw.newLine();
				bw.write("++done;");
				bw.newLine();
				bw.write("now = System.currentTimeMillis();");
				bw.newLine();
				bw.write("}");
				bw.newLine();
				bw.write("long timeDone = now - startTime;");
				bw.newLine();
				bw.write("float donePerSec = (((float) done) / timeDone) * 1000 * Config.REPEAT_COUNT;");
				bw.newLine();
				bw.write("msgTimeScore(donePerSec, \"line\");");
				bw.newLine();
				bw.write("}");
				bw.newLine();
			}

			bw.write("public static void main(String[] args) {main(AccessLoop.class);}");

			bw.write("}");
			bw.newLine();

			bw.flush();
			bw.close();
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}

}
