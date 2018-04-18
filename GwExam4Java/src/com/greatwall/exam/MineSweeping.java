package com.greatwall.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MineSweeping {
    /**
     * ������ʱ������9��ʾ
     */
    private static final int MINE_KEY_VALUE = 9;
    /**
     * ɨ�׾���������
     */
    private static final int MINE_ARRAY_MAX_LENGTH = 100;
    /**
     * ���׷���
     */
    private static final String MINE_SIGN = "*";

    public static void main(String[] args) {
        System.out.println(printMines(initMines(20, 143)));
    }

    /**
     * n * n �����С x �׵ĸ���
     * 
     * @param n
     * @param x
     * @throws Exception
     */
    private static int[][] initMines(int n, int x) {
        if (n > MINE_ARRAY_MAX_LENGTH || n <= 0 || x <= 0 || x > (n * n)) {
            return new int[0][0];
        }
        int[][] mines = new int[n][n];

        randomMines(n, x, mines);

        countMines(mines);

        return mines;

    }

    /**
     * ����������
     * 
     * @param n
     * @param x
     * @param mines
     */
    private static void randomMines(int n, int x, int[][] mines) {
        Map<Integer, Integer> map = new HashMap<>();
        Random random = new Random();
        while (map.size() < x) {
            int randomKey = random.nextInt(n * n);
            map.put(randomKey, 0);
        }
        for (int key : map.keySet()) {
            mines[key / n][key % n] = MINE_KEY_VALUE;
        }
    }

    /**
     * ���������Χ������
     * 
     * @param mines
     */
    private static void countMines(int[][] mines) {
        for (int rowIndex = 0; rowIndex < mines.length; rowIndex++) {
            int[] mineRow = mines[rowIndex];
            for (int columnIndex = 0; columnIndex < mineRow.length; columnIndex++) {
                int count = 0;
                if (mineRow[columnIndex] != MINE_KEY_VALUE) {
                    count += countCurrentRowMines(mineRow, columnIndex);
                    count += countUpRowMines(mines, rowIndex, columnIndex);
                    count += countDownRowMines(mines, rowIndex, columnIndex);
                    mineRow[columnIndex] = count;
                }
            }
        }
    }

    /**
     * ͳ�Ƶ�ǰ�еĵ�����
     * 
     * @param mineRow
     * @param columnIndex
     * @return
     */
    private static int countCurrentRowMines(int[] mineRow, int columnIndex) {
        int count = 0;
        if ((columnIndex + 1) < mineRow.length && mineRow[columnIndex + 1] == MINE_KEY_VALUE) {
            count++;
        }
        if ((columnIndex - 1) >= 0 && mineRow[columnIndex - 1] == MINE_KEY_VALUE) {
            count++;
        }
        if (mineRow[columnIndex] == MINE_KEY_VALUE) {
            count++;
        }
        return count;
    }

    /**
     * ͳ��������е�����
     * 
     * @param mines
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    private static int countUpRowMines(int[][] mines, int rowIndex, int columnIndex) {
        int count = 0;
        if (rowIndex - 1 >= 0) {
            int[] mineUpRow = mines[rowIndex - 1];
            count = countCurrentRowMines(mineUpRow, columnIndex);
        }
        return count;
    }

    /**
     * ͳ��������е�����
     * 
     * @param mines
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    private static int countDownRowMines(int[][] mines, int rowIndex, int columnIndex) {
        int count = 0;
        if (rowIndex + 1 < mines.length) {
            int[] mineDownRow = mines[rowIndex + 1];
            count = countCurrentRowMines(mineDownRow, columnIndex);
        }
        return count;
    }

    /**
     * ��ӡ����
     * 
     * @param mines
     */
    private static String printMines(int[][] mines) {
        if (mines.length == 0) {
            return "��������ȷ";
        }
        StringBuilder sb = new StringBuilder();
        for (int rowIndex = 0; rowIndex < mines.length; rowIndex++) {
            int[] mineRow = mines[rowIndex];
            for (int columnIndex = 0; columnIndex < mineRow.length; columnIndex++) {
                sb.append(mineRow[columnIndex] == MINE_KEY_VALUE ? MINE_SIGN : mineRow[columnIndex]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
