package com.weekendesk.waitfor200;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public final class WaitFor200 {

    private final ParseArguments parseArguments;

    private WaitFor200(ParseArguments parseArguments) {

        this.parseArguments = parseArguments;
    }

    public static void main(String... args) throws Exception {

        WaitFor200 waitFor200 = new WaitFor200(new ParseArguments());
        waitFor200.execute(args);
    }

    private void execute(String... args) throws Exception {

        if (!parseArguments.parse(args)) {
            printHelp();
            return;
        }

        String url = parseArguments.getUrl();
        int timeout = parseArguments.getTimeout();

        if (waitForUrl(url, timeout)) {
            System.out.println(url + " is alive");
        } else {
            System.out.println(url + " is not alive");
        }
    }

    private boolean waitForUrl(String url, int timeout) {

        System.out.println("Wait for " + url + " at most " + timeout + "s");
        final CheckHttpUrl checkHttpUrl = new CheckHttpUrl(url);
        try {
            await().atMost(timeout, TimeUnit.SECONDS).until(checkHttpUrl::check);
        } catch (Exception e) {
        }
        return checkHttpUrl.isAlive();
    }

    private void printHelp() {
        System.out.println("example usage:");
        System.out.println("waitfor200 http://weekendesk.com --timeout=10");
        System.out.println("will wait http://weekendesk.com for 10 seconds");
    }
}
