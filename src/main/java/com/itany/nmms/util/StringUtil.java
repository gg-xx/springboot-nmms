package com.itany.nmms.util;

public class StringUtil {

    public static boolean isNull(String s){
        if(s == null || "".equals(s)){
            return true;
        }
        return false;
    }
    public static String changeValue(String s){
        int i = Integer.parseInt(s)+1;
        s = "000000"+i;
        return s.substring(s.length()-6);
    }

    public static String escapeString(String s){
        if(!StringUtil.isNull(s)){
            char[] cs = s.toCharArray();
            StringBuffer str = new StringBuffer();
            for(char c : cs){
                str.append("/"+c);
            }
            return str.toString();
        }
        return null;
    }
}
