package com.gaver.domain;

public class MyTemplate {
	public static final String START_CAT = "<template>";
	public static final String END_CAT = "</template>";
	public String mContent;

	public MyTemplate(String src) {
		super();
		this.mContent = src.replaceAll("</{0,1}template>", "");
		this.mContent = mContent.replaceAll("        ", "\n\r");
		this.mContent = mContent.replaceAll("    ", "\n\r");
	}

	@Override
	public String toString() {
		return START_CAT + mContent + END_CAT;
	}

}
