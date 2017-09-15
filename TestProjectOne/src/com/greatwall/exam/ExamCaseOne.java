package com.greatwall.exam;

// 注意：
// 1、不能修改参数类型和返回值类型
// 2、请使用junit做测试，测试覆盖率将作为计分项

public class ExamCaseOne {

    // 1、程序实现目标： 输入一个字符串0-9,A-Z,a-z，将其各个字符对应的ASCII值加5后， 输出结果
    // 程序要求：
    // a.每个字符加5后输出
    // b.0-9内的数字加5如果超过9的情况(不包括9),重新从0开始计数，如8+5=13,转换为3,7+5=12,转换为2依次类推
    // c.A-Z字母加5后大于Z的，重新从A开始(不包括Z),例如，Y+5=A
    // d.a-z字母加5后大于z的，重新从a开始(不包括z)，例如，y+5=a
    public String stringAdd5ByASCII(String source) {
        StringBuilder result = new StringBuilder();
        char[] charArraySource = source.toCharArray();
        for (int i = 0; i < charArraySource.length; i++) {
            char tempResult;
            if (charArraySource[i] >= 'a' && charArraySource[i] <= 'z') {
                tempResult = charArraySource[i] > 'u' ? 'a'
                        : (char) (((int) charArraySource[i]) + 5);
            } else if (charArraySource[i] >= 'A' && charArraySource[i] <= 'Z') {
                tempResult = charArraySource[i] > 'U' ? 'A'
                        : (char) (((int) charArraySource[i]) + 5);
            } else if (charArraySource[i] >= '0' && charArraySource[i] <= '9') {
                int number = (Integer
                        .parseInt(String.valueOf(charArraySource[i])) + 5) % 10;
                tempResult = Integer.toString(number).charAt(0);
            } else {
                return "非法字符串";
            }
            result.append(tempResult);
        }
        return result.toString();
    }

    // 1、输入一段字符串（只允许含有数字和英文字母），将其各个字符对应的ASCII值加n后，输出结果，如果：
    // （1）数字加n后如果超过9的情况，重新从0开始计数，例如n=5，则8+5=13，转换为3，依次类推
    // （2）A-Z字母加n后所得字符大于Z，重新从A开始,例如n=5，Y+5=D，以此类推
    // （3）a-z字母加n后所得字符大于z，重新从a开始,例如n=5，a+5=d，以此类推
    public String stringAddByASCII(String source, int n) {
        StringBuilder result = new StringBuilder();
        char[] charArraySource = source.toCharArray();
        for (int i = 0; i < charArraySource.length; i++) {
            char tempResult;
            if (charArraySource[i] >= 'a' && charArraySource[i] <= 'z') {
                tempResult = lowLetterAddByASCII(charArraySource[i], n);
            } else if (charArraySource[i] >= 'A' && charArraySource[i] <= 'Z') {
                tempResult = upperLetterAddByASCII(charArraySource[i], n);
            } else if (charArraySource[i] >= '0' && charArraySource[i] <= '9') {
                tempResult = numberAddByASCII(charArraySource[i], n);
            } else {
                return "输入不合法";
            }
            result.append(tempResult);
        }
        return result.toString();
    }

    public char lowLetterAddByASCII(char c, int n) {
        int temp = n % 26;
        if ((c + temp <= 'z') && (c + temp >= 'a')) {
            return (char) (c + temp);
        }
        if (c + temp > 'z') {
            return (char) ((c + temp - 'z') + 'a' - 1);
        }
        return (char) (c + temp + ('z' - 'a' + 1));
    }

    public char upperLetterAddByASCII(char c, int n) {
        int temp = n % 26;
        if ((c + temp <= 'Z') && (c + temp >= 'A')) {
            return (char) (c + temp);
        }
        if (c + temp > 'Z') {
            return (char) ((c + temp - 'Z') + 'A' - 1);
        }
        return (char) (c + temp + ('Z' - 'A' + 1));
    }

    public char numberAddByASCII(char c, int n) {
        int number = Integer.parseInt(String.valueOf(c));
        number = (number + n) % 10;
        if (number < 0) {
            number = 10 + number;
        }
        return Integer.toString(number).charAt(0);
    }

    // 2、编写一个函数，判断某数字是否是回文(Palindrome)字符串。
    // 回文(Palindrome)字符串：有这样一类字符串，他们顺着看和倒着看是相同的字符串

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

    // 3、功能描述：对十进制整型数字，将其二进制的每位进行0和1反转，求翻转后的二进制所对应的十进制数值
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
        // System.out.println(sourceCharArr)
        // System.out.println(strResult.toString()+"\n")
        return Integer.parseInt(strResult.toString(), 2);
    }
}
