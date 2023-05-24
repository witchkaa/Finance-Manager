package userinterface;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class ConsoleTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testShowInfo() {
        Console console = new Console();
        console.showInfo("This is an info message");

        Assert.assertEquals("This is an info message\n", testOut.toString());
    }

    @Test
    public void testAskInfoForInt() {
        Console console = new Console();
        provideInput("42");

        Object result = console.askInfo("int");

        Assert.assertTrue(result instanceof Integer);
        Assert.assertEquals(42, result);
    }

    @Test
    public void testAskInfoForString() {
        Console console = new Console();
        provideInput("Hello, World!");

        Object result = console.askInfo("string");

        Assert.assertTrue(result instanceof String);
        Assert.assertEquals("Hello, World!", result);
    }

    @Test
    public void testAskInfoForWord() {
        Console console = new Console();
        provideInput("Hello");

        Object result = console.askInfo("word");

        Assert.assertTrue(result instanceof String);
        Assert.assertEquals("Hello", result);
    }

    @Test
    public void testAskInfoWithInvalidInput() {
        Console console = new Console();
        provideInput("Invalid Input");

        Object result = console.askInfo("int");

        Assert.assertNull(result);
        Assert.assertEquals("Wrong input! Try again. Expected an integer value there.\n", testOut.toString());
    }

    @Test
    public void testShowSuggestions() {
        Console console = new Console();
        provideInput("5");

        int choice = console.showSuggestions();

        Assert.assertEquals(5, choice);
        Assert.assertEquals("Choose what would you like to do:\n" +
                "\tview current budget - press '0'\n" +
                "\tchange budget - press '1'\n" +
                "\tview planned expenses - press '2'\n" +
                "\tview planned incomes - press '3'\n" +
                "\tadd expense - press '4'\n" +
                "\tadd income - press '5'\n" +
                "\tmark expense as done - press '6'\n" +
                "\tmark income as done - press '7'\n" +
                "\tremove expense without completing - press '8'\n" +
                "\tremove income without completing - press '9'\n" +
                "\tcompare financial plans(incomes and expends) - press '10'\n" +
                "\tcompare all finance(incomes, expends and current budget) - press '11'\n" +
                "\tshow history stats - press '12'\n", testOut.toString());
    }

}