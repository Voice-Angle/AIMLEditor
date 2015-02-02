package com.gaver.domain;

public class MyPattern {
	public static final String START_CAT = "<pattern>";
	public static final String END_CAT = "</pattern>";
	public String mContent;

	public MyPattern(String src) {
		super();
		this.mContent = src.replaceAll("</{0,1}pattern>", "");
	}

	@Override
	public String toString() {
		return START_CAT + mContent + END_CAT;
	}

}
