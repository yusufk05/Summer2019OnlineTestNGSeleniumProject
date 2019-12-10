package utils;

public class BrowserUtils {

    // it will be used to pause our test execution with provided number of seconds as a parameter
    public static void wait(int seconds) {
        try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
