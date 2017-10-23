package com.weekendesk.waitfor200;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParseArgumentsTest {
    private ParseArguments parseArguments;

    @Before
    public void setUp() {
        parseArguments = new ParseArguments();
    }

    @Test
    public void should_fail_with_no_args() {
        boolean actual = parseArguments.parse();
        assertFalse(actual);
    }

    @Test
    public void should_fail_with_one_arg() {
        boolean actual = parseArguments.parse("coucou");
        assertFalse(actual);
    }

    @Test
    public void should_fail_with_second_arg_not_starting_by_timeout() {
        boolean actual = parseArguments.parse("coucou", "1234");
        assertFalse(actual);
    }

    @Test
    public void should_succeeds_with_second_arg_starting_by_timeout() {
        boolean actual = parseArguments.parse("coucou", "--timeout=1234");
        assertTrue(actual);
        assertEquals(parseArguments.getUrl(), "coucou");
        assertEquals(parseArguments.getTimeout(), 1234);
    }
}