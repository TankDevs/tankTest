package com.greatwall.exam;

// ע�⣺
// 1�������޸Ĳ������ͺͷ���ֵ����
// 2����ʹ��junit�����ԣ����Ը����ʽ���Ϊ�Ʒ���

public class ExamCaseOne {

    // 1������ʵ��Ŀ�꣺ ����һ���ַ���0-9,A-Z,a-z����������ַ���Ӧ��ASCIIֵ��5�� ������
    // ����Ҫ��
    // a.ÿ���ַ���5�����
    // b.0-9�ڵ����ּ�5�������9�����(������9),���´�0��ʼ��������8+5=13,ת��Ϊ3,7+5=12,ת��Ϊ2��������
    // c.A-Z��ĸ��5�����Z�ģ����´�A��ʼ(������Z),���磬Y+5=A
    // d.a-z��ĸ��5�����z�ģ����´�a��ʼ(������z)�����磬y+5=a
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
                return "�Ƿ��ַ���";
            }
            result.append(tempResult);
        }
        return result.toString();
    }

    // 1������һ���ַ�����ֻ���������ֺ�Ӣ����ĸ������������ַ���Ӧ��ASCIIֵ��n���������������
    // ��1�����ּ�n���������9����������´�0��ʼ����������n=5����8+5=13��ת��Ϊ3����������
    // ��2��A-Z��ĸ��n�������ַ�����Z�����´�A��ʼ,����n=5��Y+5=D���Դ�����
    // ��3��a-z��ĸ��n�������ַ�����z�����´�a��ʼ,����n=5��a+5=d���Դ�����
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
                return "���벻�Ϸ�";
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

    // 2����дһ���������ж�ĳ�����Ƿ��ǻ���(Palindrome)�ַ�����
    // ����(Palindrome)�ַ�����������һ���ַ���������˳�ſ��͵��ſ�����ͬ���ַ���

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

    // 3��������������ʮ�����������֣���������Ƶ�ÿλ����0��1��ת����ת��Ķ���������Ӧ��ʮ������ֵ
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
