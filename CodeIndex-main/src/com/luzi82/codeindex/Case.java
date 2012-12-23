package com.luzi82.codeindex;

import java.lang.reflect.Method;

public class Case implements Runnable {

	public static interface Listener {
		public void msg(String aMsg);
	}

	Listener mListener;
	final String mDescription;

	// protected int mTimeout;
	// protected long mStartTime;
	// protected long mSpeedTestResult;
	// protected int mSpeedTestLoop;

	public Case(String aDescription) {
		mDescription = aDescription;
	}

	public String getDescription() {
		return mDescription;
	}

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

}
