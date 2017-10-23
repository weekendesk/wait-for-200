package com.weekendesk.waitfor200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseArguments {

    private static final Pattern TIMEOUT_ARG = Pattern.compile("--timeout=(\\d+)");

    private String url;
    private int timeout;

    public boolean parse(String... args) {
        if (!argsValid(args)) {
            return false;
        }

        this.url = args[0];

        final Matcher timeoutMatcher = TIMEOUT_ARG.matcher(args[1]);
        timeoutMatcher.find();
        final String parsedTimeout = timeoutMatcher.group(1);
        this.timeout = Integer.parseInt(parsedTimeout);

        return true;
    }

    public String getUrl() {
        return url;
    }

    public int getTimeout() {
        return timeout;
    }

    private static boolean argsValid(String... args) {
        return args.length == 2
                && TIMEOUT_ARG.matcher(args[1]).matches();
    }
}
