package com.gaver.domain;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.gaver.util.ReglarExpression;

public class MyCatorage {

	public static final String START_CAT = "<category>";
	public static final String END_CAT = "</category>";
	public MyPattern pattern;
	public MyTemplate template;

	public static MyCatorage parseCatorage(String content) {
		if (content == null || "".equals(content)) {
			return null;
		}
		MyCatorage catorage = new MyCatorage();
		catorage.pattern = new MyPattern(ReglarExpression.Reglar(
				"<pattern>.*?</pattern>", content));
		catorage.template = new MyTemplate(ReglarExpression.Reglar(
				"<template>.*?</template>", content));
		return catorage;
	}

	@Override
	public String toString() {
		return START_CAT + "\r\n" + pattern + "\r\n" + template + "\r\n"
				+ END_CAT;
	}

	public boolean writeFile(String dir, String fileName) {
		File fileDir = new File(dir);
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}
		File file = new File(dir, fileName);
		RandomAccessFile randomFile = null;
		String head = "";
		try {
			if (!file.exists()) {
				head = MyAIML.START_HEAD + "\r\n" + MyAIML.END_HEAD;
			}
			randomFile = new RandomAccessFile(file, "rwd");
			randomFile.write(head.getBytes("GBK"));
			randomFile.seek(randomFile.length() - MyAIML.END_HEAD.length());
			randomFile.write((this.toString() + "\r\n" + MyAIML.END_HEAD)
					.getBytes("GBK"));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (randomFile != null) {
				try {
					randomFile.close();
				} catch (IOException e) {
				}
			}
		}
		return false;
	}
}
