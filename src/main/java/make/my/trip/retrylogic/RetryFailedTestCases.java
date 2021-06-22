package make.my.trip.retrylogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer {

	private int retryCount = 0;

	private int maxRetryLimit = 3;

	public boolean retry(ITestResult result) {

		if (retryCount < maxRetryLimit) {
			retryCount++;
			return true;
		}
		return false;
	}
}
