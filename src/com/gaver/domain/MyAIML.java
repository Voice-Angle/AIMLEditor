package com.gaver.domain;

import java.util.ArrayList;
import java.util.List;

import com.gaver.util.ReglarExpression;

public class MyAIML {

	public static final String START_HEAD = "<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n<aiml>";
	public static final String END_HEAD = "</aiml>";
	public List<MyCatorage> catorages = new ArrayList<MyCatorage>();

	public static MyAIML parseAIML(String content) {
		if (content == null || "".equals(content)) {
			return null;
		}
		MyAIML myAIML = new MyAIML();
		MyCatorage catorage = null;
		ArrayList<String> catorageStrings = ReglarExpression.ReglarArray(
				"<category>.*?</category>", content);
		for (String string : catorageStrings) {
			catorage = MyCatorage.parseCatorage(string);
			myAIML.catorages.add(catorage);
		}
		return myAIML;
	}

	public boolean writeFile(String dir, String fileName) {
		for (MyCatorage catorage : catorages) {
			if (!catorage.writeFile(dir, fileName)) {
				return false;
			}
		}
		return true;
	}
}
