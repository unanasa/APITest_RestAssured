package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCategory_6327 extends BaseClass{

	/* Verifying first acceptance criteria */
	@Test(priority=0)
	public void verify_Name() {

		logger.info("------- AC1 : Verifying 'Name' value.. ----------");
		Assert.assertEquals(jsnPath.get("Name").toString(), "Carbon credits");

	}

	/* Verifying second acceptance criteria */
	@Test(priority = 1)
	public void verify_CanRelist() {

		logger.info("------- AC2 : Verifying 'CanRelist' value.. ----------");
		Assert.assertEquals(jsnPath.get("CanRelist"), true);
	}

	/* Verifying third acceptance criteria */
	@Test(priority = 2)
	public void verify_Gallery_Description() {

		logger.info("------- AC3 : Verifying 'Description' of Gallery.. ----------");
		Assert.assertEquals(jsnPath.get("Promotions.find {it.Name=='Gallery'}.Description").toString(), "Good position in category");

	}

}
