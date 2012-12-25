package com.luzi82.codeindex;

import static org.junit.Assert.*;

import org.junit.Test;

public class CaseTest {

	@Test
	public void testMetricPrefix() {
		Object[][] SAMPLE = { //
		{ 0, "0.00" },//
				{ 1, "1.00" },//
				{ 12, "12.0" },//
				{ 123, "123" },//
				{ 1234, "1.23k" },//
				{ 12345, "12.3k" },//
				{ 123456, "123k" },//
				{ 1234567, "1.23M" },//
				{ 0.1f, "100m" },//
				{ 0.12f, "120m" },//
				{ 0.123f, "123m" },//
				{ 0.1234f, "123m" },//
				{ 0.01234f, "12.3m" },//
				{ 0.001234f, "1.23m" },//
				{ 0.0001234f, "123μ" },//
				{ 0.00001234f, "12.3μ" },//
				{ 0.000001234f, "1.23μ" },//
				{ 0.0000001234f, "123n" },//
		};
		for (Object[] S : SAMPLE) {
			float f = ((Number) S[0]).floatValue();
			String s = (String) S[1];
			assertEquals(s, s, Case.metricPrefix(f));
		}
	}

}
