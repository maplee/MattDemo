package com.matt.mattdemo.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author:Created by jiaguofeng on 2019/7/18.
 * Email:jiaguofeng@inno72.com
 */
public class StringDemo {

    public static void main(String...args){
        String s1 = "ab";
        String s4 = new String("ab");
        String s3 = "a"+"b";

        s3.intern();
        String s2 = new String("a")+new String("b");
        System.out.println("result:s1==s2:"+(s1==s2));
        System.out.println("result:s1==s3:"+(s1==s3));
        System.out.println("result:s1==s4:"+(s1==s4));

        String str = "{\"username\":\"zs\",\"password\":\"123123\",\"phone\":\"13612345678\"}";
        Matcher m = Pattern.compile("\"(.*?)\":\"(.*?)\"").matcher(str);
        while(m.find()){
            System.out.println(m.group(1)+"="+m.group(2));
        }
        String a = "a";
        int aInt = a.charAt(0);
        System.out.println(aInt);
    }
}
