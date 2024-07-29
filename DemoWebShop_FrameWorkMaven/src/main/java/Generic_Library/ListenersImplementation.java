package Generic_Library;

import java.io.File;

import java.io.IOException;

import  org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenersImplementation implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("-----Excution of || "+result.getName()+" ||Started--------");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("----Execution of || "+result.getName()+" || Success----");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("----Execution of || "+result.getName()+" || Failed----");

		TakesScreenshot ts=(TakesScreenshot)BaseTest.listenersDriver;
        File src = ts.getScreenshotAs(OutputType.FILE);
              File trg = new File("./ErrorShots/"+result.getName()+".png");
              try {
				FileHandler.copy(src, trg);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	

}
