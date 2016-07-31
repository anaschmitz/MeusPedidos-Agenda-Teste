package pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.CommonTest;
import utils.SeleniumUtils;

public class AgendaTest extends CommonTest {

	@BeforeClass
	@Parameters({ "user", "password" })
	public void init(String user, String password) throws Exception {
		AuthenticationPage authPage = PageFactory.initElements(driver, AuthenticationPage.class);
		SeleniumUtils.waitForDocumentReady(driver);
		authPage.doLogin(user, password);

		MenuPage menuPage = PageFactory.initElements(driver, MenuPage.class);
		SeleniumUtils.waitForDocumentReady(driver);
		menuPage.clickAgenda();
	}

	@Test
	public void NovoAgendamentoTestCreate() {
		System.out.println("NovoAgendamentoTestCreate");
	}

	@Test
	public void NovoAgendamentoTestRead() {
		System.out.println("NovoAgendamentoTestRead");
	}

	@Test
	public void NovoAgendamentoTestDontSubmitWithOldDate() {
		System.out.println("NovoAgendamentoTestDontSubmitWithOldDate");
	}

	@Test
	public void RegistarAtividadeTestCreate() {
		System.out.println("RegistarAtividadeTestCreate");
	}

	@Test
	public void RegistarAtividadeTestRead() {
		System.out.println("RegistarAtividadeTestRead");
	}

	@Test
	public void RegistarAtividadeTestDontSubmitWithFutureDate() {
		System.out.println("RegistarTestDontSubmitWithFutureDate");
	}

	@Test
	public void TestUpdate() {
		System.out.println("TestUpdate");
	}

	@Test
	public void TestDelete() {
		System.out.println("TestDelete");
	}

	@AfterClass
	public void end() throws Exception {
		System.out.println("The End.");
	}
}
