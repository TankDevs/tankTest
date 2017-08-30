package com.gw.exam;

/**
 * ע�⣺<br>
 * 1�������޸��κ��������߷��������Լ���Ӧ�Ĳ�������ֵ �����޸ģ���0�ּ���<br>
 * 2����ʹ��junit������
 */
public class ExamCaseOne {

    /**
     * 1.����ʵ��Ŀ�꣺ ����һ���ַ���0-9,A-Z,a-z����������ַ���Ӧ��ASCIIֵ��5�� ������;<br/>
     * ����Ҫ��<br/>
     * a.ÿ���ַ���5�����;<br/>
     * b.0-9�ڵ����ּ�5�������9�����(������9),���´�0��ʼ��������8+5=13,ת��Ϊ3,7+5=12,ת��Ϊ2��������; <br/>
     * c.A-Z��ĸ��5�����Z�ģ����´�A��ʼ(������Z),���磬Y+5=A; <br/>
     * d.a-z��ĸ��5�����z�ģ����´�a��ʼ(������z)�����磬y+5=a;
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
     * 2�������ַ����жϡ� ��Ŀ������ ������һ���ַ���������˳�ſ��͵��ſ�����ͬ���ַ�����<br>
     * ���磺abc121cba,cds656sdc�ȣ��������ַ����ͳ�Ϊ���������ַ����� <br>
     * ��дһ���������ж�ĳ�����Ƿ��ǻ����ַ�����
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
