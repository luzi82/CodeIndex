package com.luzi82.codeindex;

import com.luzi82.codeindex.gen.Config;
import com.luzi82.codeindex.gen.ForLoopFunc;

public class ForLoop extends Case {

	public static final String DESCRIPTION = "Performace effect on for loop";

	public void test_forloop_ppi_lt(Object arg) {
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			ForLoopFunc2.forloop_ppi_lt(1);
			++done;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * Config.REPEAT_COUNT;
		msg(String.format("%s: %s line/s, %ss/line", getFunctionName(), metricPrefix(donePerSec), metricPrefix(1 / donePerSec)));
	}

	public void test_forloop_ppi_ne(Object arg) {
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			ForLoopFunc2.forloop_ppi_ne(1);
			++done;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * Config.REPEAT_COUNT;
		msg(String.format("%s: %s line/s, %ss/line", getFunctionName(), metricPrefix(donePerSec), metricPrefix(1 / donePerSec)));
	}

	public void test_forloop_ipp_lt(Object arg) {
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			ForLoopFunc2.forloop_ppi_lt(1);
			++done;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * Config.REPEAT_COUNT;
		msg(String.format("%s: %s line/s, %ss/line", getFunctionName(), metricPrefix(donePerSec), metricPrefix(1 / donePerSec)));
	}

	public void test_forloop_ipp_ne(Object arg) {
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			ForLoopFunc2.forloop_ipp_ne(1);
			++done;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * Config.REPEAT_COUNT;
		msg(String.format("%s: %s line/s, %ss/line", getFunctionName(), metricPrefix(donePerSec), metricPrefix(1 / donePerSec)));
	}

	public void test_forloop_mmi_gt(Object arg) {
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			ForLoopFunc2.forloop_mmi_gt(1);
			++done;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * Config.REPEAT_COUNT;
		msg(String.format("%s: %s line/s, %ss/line", getFunctionName(), metricPrefix(donePerSec), metricPrefix(1 / donePerSec)));
	}

	public void test_forloop_mmi_ne(Object arg) {
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			ForLoopFunc2.forloop_mmi_ne(1);
			++done;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * Config.REPEAT_COUNT;
		msg(String.format("%s: %s line/s, %ss/line", getFunctionName(), metricPrefix(donePerSec), metricPrefix(1 / donePerSec)));
	}

	public void test_forloop_imm_gt(Object arg) {
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			ForLoopFunc2.forloop_mmi_gt(1);
			++done;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * Config.REPEAT_COUNT;
		msg(String.format("%s: %s line/s, %ss/line", getFunctionName(), metricPrefix(donePerSec), metricPrefix(1 / donePerSec)));
	}

	public void test_forloop_imm_ne(Object arg) {
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			ForLoopFunc2.forloop_imm_ne(1);
			++done;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * Config.REPEAT_COUNT;
		msg(String.format("%s: %s line/s, %ss/line", getFunctionName(), metricPrefix(donePerSec), metricPrefix(1 / donePerSec)));
	}

	public void test_repeat(Object arg) {
		long now = System.currentTimeMillis();
		long startTime = now;
		long endTime = startTime + TIME_LIMIT;
		int done = 0;
		while (now < endTime) {
			ForLoopFunc.repeat(1);
			++done;
			now = System.currentTimeMillis();
		}
		long timeDone = now - startTime;
		float donePerSec = (((float) done) / timeDone) * 1000 * Config.REPEAT_COUNT;
		msg(String.format("%s: %s line/s, %ss/line", getFunctionName(), metricPrefix(donePerSec), metricPrefix(1 / donePerSec)));
	}

	public static void main(String[] args) {
		main(ForLoop.class);
	}
}
