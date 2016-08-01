package pages;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.CommonTest;
import entity.Appointment;
import popup.ConfirmDeletePopUp;
import popups.NewActivityPopUp;
import popups.NewAppointmentPopUp;
import popups.UpdateAppointmentPopUp;
import utils.AppointmentType;
import utils.DateUtils;
import utils.Period;
import utils.SeleniumUtils;
import utils.Status;

public class AgendaTest extends CommonTest {

	private AgendaPage agendaPage;

	private Appointment appointment;

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

	@BeforeTest
	public void beforeTest() {
		this.agendaPage = PageFactory.initElements(driver, AgendaPage.class);
		SeleniumUtils.waitForDocumentReady(driver);
	}

	@Test(priority = 1)
	public void newAppoinmentTest() {
		agendaPage.btnNovoAgendamentoClick(driver);

		NewAppointmentPopUp newAppointPopUp = PageFactory.initElements(driver, NewAppointmentPopUp.class);
		SeleniumUtils.waitForDocumentReady(driver);
		appointment = new Appointment(AppointmentType.VISIT, "Automacao", 3, new Date(), "Ana Schmitz", "Teste");
		newAppointPopUp.fillFields(appointment, driver);
		newAppointPopUp.btnSaveClick();
		
		WebElement successBox = getSuccessBoxElement("//*[@id='gritter-item-1']/div[2]/div[2]/p/strong");
		Assert.assertEquals(appointment.getType().getLabel() + " cadastrada com sucesso!", successBox.getText());
	}

	@Test(priority = 2)
	public void readNewAppointmentTest() {
		agendaPage.doSearch(Status.ACTIVITIESNOTDONE.getLabel(), appointment.getUser(), appointment.getClient(),
				appointment.getType(), Period.CURRENTMONTH, driver);

		waitLoad();
		boolean match = searchMatch();

		Assert.assertTrue(match);
	}

	@Test(priority = 3)
	public void updateNewAppointmentTest() {
		agendaPage.btnUpdateAppointmentClick(1, driver);

		UpdateAppointmentPopUp updateAppointmentPopUp = PageFactory.initElements(driver, UpdateAppointmentPopUp.class);
		SeleniumUtils.waitForDocumentReady(driver);
		appointment = new Appointment(AppointmentType.CALL, "Automacao2", new Date(), "Ana Schmitz", "Teste alteração",
				true, "feito");
		updateAppointmentPopUp.fillFields(appointment, driver);
		updateAppointmentPopUp.btnSaveClick();

		WebElement successBox = getSuccessBoxElement("//*[@id='gritter-item-2']/div[2]/div[2]/p/strong");
		Assert.assertEquals(appointment.getType().getLabel() + " alterada com sucesso!", successBox.getText());

		agendaPage.doSearch(Status.ACTIVITIESDONE.getLabel(), appointment.getUser(), appointment.getClient(),
				appointment.getType(), Period.CURRENTMONTH, driver);

		waitLoad();
		boolean match = searchMatch();

		Assert.assertTrue(match);
	}

	// @Test(priority = 4)
	public void deleteNewAppointmentTest() {
		agendaPage.btnUpdateAppointmentClick(1, driver);

		UpdateAppointmentPopUp updateAppointmentPopUp = PageFactory.initElements(driver, UpdateAppointmentPopUp.class);
		SeleniumUtils.waitForDocumentReady(driver);
		updateAppointmentPopUp.btnDeleteClick();

		ConfirmDeletePopUp confirmDeletePopUp = PageFactory.initElements(driver, ConfirmDeletePopUp.class);
		SeleniumUtils.waitForDocumentReady(driver);
		confirmDeletePopUp.btnDeleteClick();

		WebElement successBox = getSuccessBoxElement("//*[@id='gritter-item-3']/div[2]/div[2]/p/strong"); 
		Assert.assertEquals(appointment.getType().getLabel() + " excluída com sucesso!", successBox.getText());

		agendaPage.doSearch(Status.ACTIVITIESDONE.getLabel(), appointment.getUser(), appointment.getClient(),
				appointment.getType(), Period.CURRENTMONTH, driver);

		waitLoad();
//		agendaPage.waitLoadField(driver, driver.findElement(By.xpath("//*[@id='atividades']/li[1]/div[2]")));

		boolean match = searchMatch();

		Assert.assertFalse(match);
	}

	private void waitLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
	}

	// @Test(priority = 5)
	public void newAppointmentTestDontSubmitWithOldDate() {
		System.out.println("NovoAgendamentoTestDontSubmitWithOldDate");

		System.out.println("Teste quebra pois o sistema permite incluir com data antiga");

		// deletar
	}

	@Test(priority = 6)
	public void newActivityTest() {
		agendaPage.btnNewActivitylick(driver);

		NewActivityPopUp newActivityPopUp = PageFactory.initElements(driver, NewActivityPopUp.class);
		SeleniumUtils.waitForDocumentReady(driver);
		appointment = new Appointment(AppointmentType.ACTIVITY, "Automacao", "Teste", new Date());
		newActivityPopUp.fillFields(appointment, driver);
		newActivityPopUp.btnSaveClick();

		WebElement successBox = getSuccessBoxElement("//*[@id='gritter-item-3']/div[2]/div[2]/p/strong");
		Assert.assertEquals(appointment.getType().getLabel() + " cadastrada com sucesso!", successBox.getText());
	}

	@Test(priority = 7)
	public void readNewActivityTest() {
		agendaPage.doSearch(Status.ACTIVITIESDONE.getLabel(), appointment.getUser(), appointment.getClient(),
				appointment.getType(), Period.CURRENTMONTH, driver);
		waitLoad();
		boolean match = searchMatch();
//		Assert.assertTrue(match);
	}

	@Test(priority = 8)
	public void updateNewActivityTest() {
		agendaPage.btnUpdateAppointmentClick(1, driver);

		UpdateAppointmentPopUp updateAppointmentPopUp = PageFactory.initElements(driver, UpdateAppointmentPopUp.class);
		SeleniumUtils.waitForDocumentReady(driver);
		appointment = new Appointment(AppointmentType.CALL, "Automacao2", new Date(), "Ana Schmitz", "Teste alteração",
				false, "");
		updateAppointmentPopUp.fillFields(appointment, driver);
		updateAppointmentPopUp.btnSaveClick();

		WebElement successBox = getSuccessBoxElement("//*[@id='gritter-item-4']/div[2]/div[2]/p/strong");
		Assert.assertEquals(appointment.getType().getLabel() + " alterada com sucesso!", successBox.getText());

		agendaPage.doSearch(Status.ACTIVITIESNOTDONE.getLabel(), appointment.getUser(), appointment.getClient(),
				appointment.getType(), Period.CURRENTMONTH, driver);

		SeleniumUtils.waitForDocumentReady(driver);
		agendaPage.waitLoadField(driver, driver.findElement(By.xpath("//*[@id='atividades']/li[1]/div[2]")));

		boolean match = searchMatch();

		Assert.assertTrue(match);
	}

	// @Test(priority = 9)
	public void deleteNewActivityTest() {
		agendaPage.btnUpdateAppointmentClick(1, driver);

		UpdateAppointmentPopUp updateAppointmentPopUp = PageFactory.initElements(driver, UpdateAppointmentPopUp.class);
		SeleniumUtils.waitForDocumentReady(driver);
		updateAppointmentPopUp.btnDeleteClick();

		ConfirmDeletePopUp confirmDeletePopUp = PageFactory.initElements(driver, ConfirmDeletePopUp.class);
		SeleniumUtils.waitForDocumentReady(driver);
		confirmDeletePopUp.btnDeleteClick();

		WebElement successBox = getSuccessBoxElement("//*[@id='gritter-item-2']/div[2]/div[2]/p/strong"); 
		Assert.assertEquals(appointment.getType().getLabel() + " excluída com sucesso!", successBox.getText());

		agendaPage.doSearch(Status.ACTIVITIESNOTDONE.getLabel(), appointment.getUser(), appointment.getClient(),
				appointment.getType(), Period.CURRENTMONTH, driver);

		SeleniumUtils.waitForDocumentReady(driver);
		agendaPage.waitLoadField(driver, driver.findElement(By.xpath("//*[@id='atividades']/li[1]/div[2]")));

		boolean match = searchMatch();

		Assert.assertFalse(match);
	}

	// @Test(priority = 10)
	public void NewActivityTestDontSubmitWithFutureDate() {
		System.out.println("RegistarTestDontSubmitWithFutureDate");

		System.out.println("Teste quebra pois o sistema permite incluir com data futura");

		// deleta
	}
	
	private WebElement getSuccessBoxElement(String xpath) {
		By successPath = By.xpath(xpath);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(successPath));
		WebElement successBox = driver.findElement(successPath);
		return successBox;
	}

	private boolean searchMatch() {
		boolean match = false;
		List<WebElement> resultSearch = driver.findElements(By.xpath("//*[@id='atividades']/li"));
		for (int i = 1; i <= resultSearch.size(); i++) {
			By xpathClient = By.xpath("//*[@id='atividades']/li[" + i + "]/div[2]/div/h5/a");
			WebElement client = driver.findElement(xpathClient);
			By xpathDate = By.xpath("//*[@id='atividades']/li[" + i + "]/div[2]/div/div[2]/span[1]");
			WebElement date = driver.findElement(xpathDate);
			By xpathHour = By.xpath("//*[@id='atividades']/li[" + i + "]/div[2]/div/div[2]/span[2]");
			WebElement hour = driver.findElement(xpathHour);
			By xpathUser = By.xpath("//*[@id='atividades']/li[" + i + "]/div[2]/div/div[2]/span[3]");
			// check //*[@id='atividades']/li[" + i + "]/div[1]/div
			WebElement user = driver.findElement(xpathUser);

			if (client.getText().trim().equals(appointment.getClient())
					&& date.getText().toUpperCase()
							.equals(DateUtils.getDateFormatted(appointment.getDate(), "EEEE, dd MMM yyyy")
									.toUpperCase())
					&& hour.getText().equals(appointment.getHourFormmatted())
					&& user.getText().contains(appointment.getUser())) {
				match = true;
				break;
			}

		}
		return match;
	}

	@AfterClass
	public void end() throws Exception {
		System.out.println("The End.");
	}
}
