package com.luzi82.codeindex;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Case implements Runnable {

	public static int TIME_LIMIT = 2000;
	public static int LOOP_PER_TICK = 100;
	public static int[] TEST_ARRAY_SIZE = {//
	1,//
			1000,//
			1000000,//
			10000000,//
	};
	public static int CHECK_SIZE = 1024;

	public static interface Listener {
		public void msg(String aMsg);
	}

	Listener mListener;

	// protected int mTimeout;
	// protected long mStartTime;
	// protected long mSpeedTestResult;
	// protected int mSpeedTestLoop;

	public void setListener(Listener aListener) {
		mListener = aListener;
	}

	public void run() {
		msg(getClass().getName() + " START");
		runAllTest();
		msg(getClass().getName() + " END");
	}

	protected void msg(String aMsg) {
		if (mListener != null) {
			mListener.msg(aMsg);
		}
	}

	protected void runAllTest() {
		try {
			Method[] mv = getClass().getMethods();
			Arrays.sort(mv, new Comparator<Method>() {
				@Override
				public int compare(Method arg0, Method arg1) {
					int ret;
					ret = arg0.getName().compareTo(arg1.getName());
					if (ret != 0)
						return ret;
					return arg0.toString().compareTo(arg1.toString());
				}
			});
			for (Method m : mv) {
				String name = m.getName();
				if (!name.startsWith("test_"))
					continue;
				if (name.endsWith("_data"))
					continue;
				Method mm = null;
				try {
					mm = getClass().getMethod(name + "_data");
				} catch (NoSuchMethodException e) {
					// expected case
				}
				Object[] argAry = null;
				if (mm == null) {
					argAry = new Object[] { null };
				} else {
					argAry = (Object[]) (mm.invoke(this));
				}
				for (Object a : argAry) {
					// testSpeed(name, null);
					m.invoke(this, a);
				}
			}
		} catch (Throwable t) {
			throw new Error(t);
		}
	}

	// protected void testSpeed(String aFuncName, Object[] aObject) {
	// try {
	// Method m = getClass().getMethod(aFuncName, Object.class);
	// mTimeout = -1;
	// String txt="";
	// txt+=String.format("%s: ", m.getName());
	// if (aObject == null) {
	// m.invoke(this, null);
	// msg(String.format("%s: %d", m.getName(), ret));
	// } else {
	// m.invoke(this, aObject[1]);
	// msg(String.format("%s: %s: %d", m.getName(), aObject[0], ret));
	// }
	// } catch (Throwable t) {
	// throw new Error(t);
	// }
	// }
	//
	// protected void setTimeout(int aTimeout) {
	//
	// }
	//
	// protected void markStartTime() {
	// mStartTime = System.currentTimeMillis();
	// }
	//
	// protected void markEndTime() {
	// mSpeedTestResult = System.currentTimeMillis() - mStartTime;
	// }
	//
	public static void main(Class<?> c) {
		try {
			Object o = c.newInstance();
			Case oo = (Case) o;
			oo.setListener(new Listener() {
				@Override
				public void msg(String aMsg) {
					System.out.println(aMsg);
				}
			});
			oo.run();
		} catch (Throwable t) {
			throw new Error(t);
		}
	}

	public static String metricPrefix(float mValue) {
		if (mValue == 0) {
			return "0.00";
		}
		String signSuf = "";
		if (mValue < 0) {
			signSuf = "-";
			mValue *= -1;
		}
		String[] METRIC_PREFIX_UP = { "", "k", "M", "G", "T", "P", "E", "Z", "Y" };
		String[] METRIC_PREFIX_DOWN = { "", "m", "μ", "n", "p", "f", "a", "z", "y" };
		float factor = 0;
		String[] mp = null;
		int mpIdx = 0;
		if (mValue < 1) {
			mp = METRIC_PREFIX_DOWN;
			factor = 1000;
		} else {
			mp = METRIC_PREFIX_UP;
			factor = 0.001f;
		}
		while (true) {
			if ((mValue < 1000) && (mValue >= 1))
				break;
			if (mpIdx >= METRIC_PREFIX_UP.length - 1)
				break;
			mValue *= factor;
			++mpIdx;
		}
		String numString = String.format("%1.2f", mValue).substring(0, 4);
		if (numString.endsWith("."))
			numString = numString.substring(0, numString.length() - 1);
		return signSuf + numString + mp[mpIdx];
	}
	
	public static Object[] getTestArraySize(){
		Object[] ret = new Object[TEST_ARRAY_SIZE.length];
		for (int i = 0; i < TEST_ARRAY_SIZE.length; ++i) {
			ret[i] = TEST_ARRAY_SIZE[i];
		}
		return ret;
	}

}
