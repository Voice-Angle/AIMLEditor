package com.gaver.control;

import java.awt.List;

public class AIMLFileAdapter {

	private java.awt.List mListAIMLFile;
	private String[] mFileName;

	public AIMLFileAdapter() {
		super();
	}

	public AIMLFileAdapter(List listAIMLFile, String... filenames) {
		super();
		listAIMLFile.removeAll();
		this.mListAIMLFile = listAIMLFile;
		this.mFileName = filenames;
		setUp();
	}

	protected void setUp() {
		for (String filename : mFileName) {
			mListAIMLFile.add(filename);
		}
	}
}
