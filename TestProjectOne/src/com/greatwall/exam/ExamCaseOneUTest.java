package com.greatwall.exam;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExamCaseOneUTest {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test_stringParseASCII() {
        ExamCaseOne examCaseOne = new ExamCaseOne();

        assertEquals("78fg9zZA4z3AAaaAiA",
                examCaseOne.stringAdd5ByASCII("23ab4uUX9u8WVyzZdY"));

        assertEquals("LQ38i09xfkAp2M9iFaIxkZ",
                examCaseOne.stringAdd5ByASCII("GL83d54safWk7H4dAwDsfU"));

    }

    @Test
    public void test_isPalindrome() {

        assertEquals(false, ExamCaseOne.isPalindrome("123e67jk76e321"));

        assertEquals(true, ExamCaseOne.isPalindrome("123e67jkj76e321"));

        assertEquals(false, ExamCaseOne.isPalindrome(null));

        assertEquals(true, ExamCaseOne.isPalindrome(""));
    }
    
    @Test
    public void test_revertNumberByBinary() {
        assertEquals(1, ExamCaseOne.revertNumberByBinary(0));
        assertEquals(5, ExamCaseOne.revertNumberByBinary(10));
        assertEquals(7, ExamCaseOne.revertNumberByBinary(8));
        assertEquals(10, ExamCaseOne.revertNumberByBinary(117));
        assertEquals(2515, ExamCaseOne.revertNumberByBinary(5676));
    }

}
