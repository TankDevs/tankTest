package com.greatwall.exam;

/**
 * ע�⣺<br>
 * 1�������޸Ĳ������ͺͷ���ֵ����<br>
 * 2����ʹ��junit������
 */
public class ExamCaseOne {

    /**
     * 1������ʵ��Ŀ�꣺ ����һ���ַ���0-9,A-Z,a-z����������ַ���Ӧ��ASCIIֵ��5�� ������;<br/>
     * ����Ҫ��<br/>
     * a.ÿ���ַ���5�����;<br/>
     * b.0-9�ڵ����ּ�5�������9�����(������9),���´�0��ʼ��������8+5=13,ת��Ϊ3,7+5=12,ת��Ϊ2��������; <br/>
     * c.A-Z��ĸ��5�����Z�ģ����´�A��ʼ(������Z),���磬Y+5=A; <br/>
     * d.a-z��ĸ��5�����z�ģ����´�a��ʼ(������z)�����磬y+5=a;
     * ����1����Σ�23ab4uUX9u8WVyzZdY,���أ�78fg9zZA4z3AAaaAiA <br/>
     * ����2����Σ�GL83d54safWk7H4dAwDsfU�����أ�LQ38i09xfkAp2M9iFaIxkZ ����3���Ա�
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
     * 2����дһ���������ж�ĳ�����Ƿ��ǻ���(Palindrome)�ַ�����<br>
     * ����(Palindrome)�ַ�����������һ���ַ���������˳�ſ��͵��ſ�����ͬ���ַ��� <br>
     * ����1����Σ�23ab4uUX9u8WVyzZdY,���أ�78fg9zZA4z3AAaaAiA <br/>
     * ����2����Σ�GL83d54safWk7H4dAwDsfU�����أ�LQ38i09xfkAp2M9iFaIxkZ
     * ����3���Ա�
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
     * 3��������������ʮ�����������֣���������Ƶ�ÿλ����0��1��ת����ת��Ķ���������Ӧ��ʮ������ֵ<br>
     * ����1�� ��Σ�10 ���أ�5 <br>
     * ����2�� ��Σ�117 ���أ�10 <br>
     * ����3���Ա�
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
