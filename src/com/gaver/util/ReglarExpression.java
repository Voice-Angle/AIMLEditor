package com.gaver.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReglarExpression {

    public static String Reglar(String regex, String source) {
        String content = "";
        final List<String> list = new ArrayList<String>();
        final Pattern pa = Pattern.compile(regex);
        final Matcher ma = pa.matcher(source);
        while (ma.find()) {
            list.add(ma.group());
        }
        for (int i = 0; i < list.size(); i++) {
            content = content + list.get(i);
        }
        return content;
    }

    

    public static ArrayList<String> ReglarArray(String regex, String source) {
        final ArrayList<String> list = new ArrayList<String>();
        final Pattern pa = Pattern.compile(regex);
        final Matcher ma = pa.matcher(source);
        while (ma.find()) {
            list.add(ma.group());
        }
        return list;
    }
}
