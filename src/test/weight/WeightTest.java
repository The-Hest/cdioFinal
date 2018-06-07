package test.weight;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import boundary.weight.WeightTranslation;
import exceptions.DALException;

public class WeightTest {

	WeightTranslation weight;

	@Before
	public void startUp() {
		try {
			//weight = new WeightTranslation("169.254.2.3", 8000);
			 weight = new WeightTranslation("62.79.16.17", 8001);
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}

	@After
	public void wrapUp()
	{
		try {
			weight.closeAllLeaks();
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Shows a message that is possible to show.
	 */
	@Test
	public void showMsgTest()
	{
		try {
			weight.showMsg("Short");
			TimeUnit.SECONDS.sleep(1);
			weight.removeMsg();
		} catch (DALException | InterruptedException e) {
			fail("showMsgTest - Error: " + e.getMessage());
		}
	}

	/**
	 * Shows a message that is too long, and therefore shows
	 */
	@Test
	public void showMsgTooLongTest()
	{
		try {
			weight.showMsg("Msg too long");
			TimeUnit.SECONDS.sleep(1);
			weight.removeMsg();
		} catch (DALException | InterruptedException e) {
			fail("showMsgTooLongTest - Error: " + e.getMessage());
		}
	}

	/**
	 * Shows a long message
	 */
	@Test
	public void showLongMsgTest()
	{
		try {
			weight.showLongMsg("This msg can contain 30 chars");
			TimeUnit.SECONDS.sleep(1);
			weight.removeLongMsg();
		} catch (DALException | InterruptedException e) {
			fail("showLongMsgTest - Error: " + e.getMessage());
		}
	}

	/**
	 * Shows a long message, that is too long
	 */
	@Test
	public void showTooLongLongMsg()
	{
		try {
			weight.showLongMsg("This msg is too long to be shown");
			TimeUnit.SECONDS.sleep(1);
			weight.removeLongMsg();
		} catch (DALException | InterruptedException e) {
			fail("showTooLongLongM - Error: " + e.getMessage());
		}
	}
	
	@Test
	public void getWeightTest()
	{
		try {
			double value = weight.getWeight();
			TimeUnit.SECONDS.sleep(1);
			weight.removeLongMsg();
		} catch (DALException | InterruptedException e) {
			fail("showTooLongLongM - Error: " + e.getMessage());
		}
	}


}
