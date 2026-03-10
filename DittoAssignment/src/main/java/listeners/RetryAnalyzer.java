package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int count = 0;
    int maxTry = 2;   // retry 2 times

    @Override
    public boolean retry(ITestResult result) {


        if (count < maxTry) {
            count++;
            System.out.println("Retrying test " + result.getName() + " again. Count = " + count);
            return true;
        }

        return false;

    }
}