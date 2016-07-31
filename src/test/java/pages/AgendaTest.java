package pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.CommonTest;
import utils.SeleniumUtils;

public class AgendaTest extends CommonTest {

	@BeforeClass
	public void init() throws Exception {
		driver.get("http://qa.meuspedidos.com.br/login/");
		driver.manage().window().maximize();

		AuthenticationPage authPage = PageFactory.initElements(driver, AuthenticationPage.class);
		SeleniumUtils.waitForDocumentReady(driver);
		authPage.doLogin("anaschmitz@gmail.com", "123456");
		
		// verificar se logou
		
		MenuPage menuPage = PageFactory.initElements(driver, MenuPage.class);
		SeleniumUtils.waitForDocumentReady(driver);
		menuPage.clickAgenda();
		
		// verificar se abriu a agenda
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
