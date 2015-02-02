package com.gaver.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AIMLFileReader {

	public static String readContent(String path){
		StringBuffer buffer = new StringBuffer();
		String temp = null;
		BufferedReader bReader = null;
		FileReader fReader = null;
		try {
			fReader = new FileReader(path);
			bReader = new BufferedReader(fReader);
			while ((temp=bReader.readLine())!=null) {
				buffer.append(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			releaseStream(bReader, fReader);
		}
		return buffer.toString();
	}

	public static void releaseStream(BufferedReader bReader,
			FileReader fReader) {
		if (fReader!=null) {
			try {
				fReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (bReader!=null) {
			try {
				bReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void releaseWriterStream(BufferedWriter bReader,
			FileWriter fReader) {
		if (fReader!=null) {
			try {
				fReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (bReader!=null) {
			try {
				bReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
