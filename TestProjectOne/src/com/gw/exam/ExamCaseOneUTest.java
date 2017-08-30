package com.gw.exam;

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
    public void testStringParseASCII() {
        ExamCaseOne examCaseOne = new ExamCaseOne();
        String source = "234983abcduvwxyzsdABCEZYXWVU";
        String expected = "789438fghizaaaaaxiFGHJAAAAAZ";
        String actual = examCaseOne.stringParseASCII(source);
        assertEquals(expected, actual);

        source = "837454sadflskdfjiADUHGLH";
        expected = "382909xfikqxpikonFIZMLQM";
        actual = examCaseOne.stringParseASCII(source);
        assertEquals(expected, actual);

    }

    @Test
    public void testIsPalindrome() {
        String source = "12345567asdfaerr";
        boolean expected = false;
        boolean actual = ExamCaseOne.isPalindrome(source);
        assertEquals(expected, actual);

        source = "asdfe但是9889是但efdsa";
        expected = true;
        actual = ExamCaseOne.isPalindrome(source);
        assertEquals(expected, actual);

        source = null;
        expected = false;
        actual = ExamCaseOne.isPalindrome(source);
        assertEquals(expected, actual);

    }

}
