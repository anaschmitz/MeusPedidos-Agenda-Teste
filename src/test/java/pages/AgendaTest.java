package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.CommonTest;
import entity.Appointment;
import popups.NewAppointmentPopUp;
import utils.AppointmentType;
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

	@Test(priority=1)
	public void newAppoinmentTest() {
		System.out.println("NovoAgendamentoTestCreate");
		AgendaPage agendaPage = getAgendaPage();
		agendaPage.btnNovoAgendamentoClick();
		
		NewAppointmentPopUp newAppointPopUp = PageFactory.initElements(driver, NewAppointmentPopUp.class);
		SeleniumUtils.waitForDocumentReady(driver);
		Appointment appoint = new Appointment(AppointmentType.VISIT, "Automacao", 3, "31/07/2016", "18:50", "Ana Schmitz", "Teste");
		newAppointPopUp.fillFields(appoint, driver);
		newAppointPopUp.btnSaveClick();
	
		WebElement successBox = getSuccessBoxElement();
		Assert.assertEquals("Visita cadastrada com sucesso!", successBox.getText());
	}

	private WebElement getSuccessBoxElement() {
		By successPath = By.xpath("//*[@id='gritter-item-1']/div[2]/div[2]/p/strong");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(successPath));
		WebElement successBox = driver.findElement(successPath);
		return successBox;
	}

	private AgendaPage getAgendaPage() {
		AgendaPage agendaPage = PageFactory.initElements(driver, AgendaPage.class);
		SeleniumUtils.waitForDocumentReady(driver);
		return agendaPage;
	}

	@Test
	public void readNewAppointmentTest() {
		System.out.println("NovoAgendamentoTestRead");
	}

	@Test
	public void newAppointmentTestDontSubmitWithOldDate() {
		System.out.println("NovoAgendamentoTestDontSubmitWithOldDate");
		
		
		System.out.println("Teste quebra pois o sistema permite incluir com data antiga");
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
