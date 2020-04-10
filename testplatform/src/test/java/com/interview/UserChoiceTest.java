package com.interview;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class UserChoiceTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void userOption() throws Throwable {

        UserChoice obj =new UserChoice();
        //obj.userOption();

        String dataOptionFirst = "1";
        String dataOptionSecond = "2";
        System.setIn(new ByteArrayInputStream(dataOptionFirst.getBytes()));

        Scanner scanner = new Scanner(System.in);
        System.out.println("User has opted for option : " + scanner.nextLine() + " which is Add Questions and their Answers...");



        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        obj.userOption(dataOptionFirst);
        assertEquals(true, outContent.toString().contains("Starting process of adding Question in the System"));

        final ByteArrayOutputStream outContentDataOptionSecond = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentDataOptionSecond));
        obj.userOption(dataOptionSecond);
        assertEquals(true, outContentDataOptionSecond.toString().contains("Starting process of Asking Question"));


        final ByteArrayOutputStream outContentDataOptionthird = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentDataOptionthird));
        obj.userOption("45");
        assertEquals("Please enter Valid option..please try again!!!!", outContentDataOptionthird.toString());



    }
}