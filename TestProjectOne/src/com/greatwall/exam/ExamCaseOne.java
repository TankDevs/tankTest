package com.greatwall.exam;

/**
 * 注意：<br>
 * 1、不能修改参数类型和返回值类型<br>
 * 2、请使用junit做测试
 */
public class ExamCaseOne {

    /**
     * 1、程序实现目标： 输入一个字符串0-9,A-Z,a-z，将其各个字符对应的ASCII值加5后， 输出结果;<br/>
     * 程序要求：<br/>
     * a.每个字符加5后输出;<br/>
     * b.0-9内的数字加5如果超过9的情况(不包括9),重新从0开始计数，如8+5=13,转换为3,7+5=12,转换为2依次类推; <br/>
     * c.A-Z字母加5后大于Z的，重新从A开始(不包括Z),例如，Y+5=A; <br/>
     * d.a-z字母加5后大于z的，重新从a开始(不包括z)，例如，y+5=a;
     * 用例1：入参：23ab4uUX9u8WVyzZdY,返回：78fg9zZA4z3AAaaAiA <br/>
     * 用例2：入参：GL83d54safWk7H4dAwDsfU，返回：LQ38i09xfkAp2M9iFaIxkZ 用例3：自编
     */
    public String stringAdd5ByASCII(String source) {
        StringBuilder result = new StringBuilder();
        char[] charArraySource = source.toCharArray();
        for (int i = 0; i < charArraySource.length; i++) {
            char tempResult;
            if (charArraySource[i] > 'u' && charArraySource[i] <= 'z') {
                tempResult = 'a';
            } else if (charArraySource[i] > 'U' && charArraySource[i] <= 'Z') {
                tempResult = 'A';
            } else if (charArraySource[i] >= '0' && charArraySource[i] <= '9') {
                int number = (Integer
                        .parseInt(String.valueOf(charArraySource[i])) + 5) % 10;
                tempResult = Integer.toString(number).charAt(0);
            } else {
                tempResult = (char) (((int) charArraySource[i]) + 5);
            }
            result.append(tempResult);
        }
        return result.toString();
    }

    /**
     * 2、编写一个函数，判断某数字是否是回文(Palindrome)字符串。<br>
     * 回文(Palindrome)字符串：有这样一类字符串，他们顺着看和倒着看是相同的字符串 <br>
     * 用例1：入参：23ab4uUX9u8WVyzZdY,返回：78fg9zZA4z3AAaaAiA <br/>
     * 用例2：入参：GL83d54safWk7H4dAwDsfU，返回：LQ38i09xfkAp2M9iFaIxkZ
     * 用例3：自编
     */
    public static boolean isPalindrome(String source) {
        try {
            StringBuilder builder = new StringBuilder();
            for (int i = source.length(); i > 0; i--) {
                builder.append(source.charAt(i - 1));
            }
            return builder.toString().compareTo(source) == 0 ? true : false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 3、功能描述：对十进制整型数字，将其二进制的每位进行0和1反转，求翻转后的二进制所对应的十进制数值<br>
     * 用例1： 入参：10 返回：5 <br>
     * 用例2： 入参：117 返回：10 <br>
     * 用例3：自编
     **/
    public static int revertNumberByBinary(int source) {
        char[] sourceCharArr = Integer.toBinaryString(source).toCharArray();
        StringBuilder strResult = new StringBuilder();
        for (int i = 0; i < sourceCharArr.length; i++) {
            if (sourceCharArr[i] == '0') {
                strResult.append('1');
            } else {
                strResult.append('0');
            }
        }
        // System.out.println(sourceCharArr);
        // System.out.println(strResult.toString()+"\n");
        return Integer.parseInt(strResult.toString(), 2);
    }
}
