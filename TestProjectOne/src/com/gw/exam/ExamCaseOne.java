package com.gw.exam;

/**
 * 注意：<br>
 * 1、不能修改任何类名或者方法名，以及对应的参数返回值 如若修改，做0分计算<br>
 * 2、请使用junit做测试
 */
public class ExamCaseOne {

    /**
     * 1.程序实现目标： 输入一个字符串0-9,A-Z,a-z，将其各个字符对应的ASCII值加5后， 输出结果;<br/>
     * 程序要求：<br/>
     * a.每个字符加5后输出;<br/>
     * b.0-9内的数字加5如果超过9的情况(不包括9),重新从0开始计数，如8+5=13,转换为3,7+5=12,转换为2依次类推; <br/>
     * c.A-Z字母加5后大于Z的，重新从A开始(不包括Z),例如，Y+5=A; <br/>
     * d.a-z字母加5后大于z的，重新从a开始(不包括z)，例如，y+5=a;
     */
    public String stringParseASCII(String source) {
        StringBuilder result = new StringBuilder();
        char[] charArraySource = source.toCharArray();
        for (int i = 0; i < charArraySource.length; i++) {
            char tempResult;
            if (charArraySource[i] > 'u' && charArraySource[i] <= 'z') {
                tempResult = 'a';
            } else if (charArraySource[i] > 'U' && charArraySource[i] <= 'Z') {
                tempResult = 'A';
            } else if (charArraySource[i] >= '0' && charArraySource[i] <= '9') {
                int number = (Integer.parseInt(String.valueOf(charArraySource[i])) + 5) % 10;
                tempResult = Integer.toString(number).charAt(0);
            } else {
                tempResult = (char) (((int) charArraySource[i]) + 5);
            }
            result.append(tempResult);
        }
        return result.toString();
    }

    /**
     * 2、回文字符串判断。 题目描述： 有这样一类字符串，他们顺着看和倒着看是相同的字符串，<br>
     * 例如：abc121cba,cds656sdc等，这样的字符串就称为：回文数字符串。 <br>
     * 编写一个函数，判断某数字是否是回文字符串。
     */
    public static boolean isPalindrome(String str) {
        try {
            StringBuilder builder = new StringBuilder();
            for (int i = str.length(); i > 0; i--) {
                builder.append(str.charAt(i - 1));
            }
            return builder.toString().compareTo(str) == 0 ? true : false;
        } catch (Exception e) {
            return false;
        }
    }
}
