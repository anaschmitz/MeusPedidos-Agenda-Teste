package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.AppointmentType;
import utils.Period;

public class AgendaPage {

	@FindBy(id = "id_status_chzn")
	private WebElement status;

	@FindBy(id = "id_colaborador_chzn")
	private WebElement user;

	@FindBy(id = "id_cliente")
	private WebElement client;

	@FindBy(xpath = "//*[@id='selecionado_autocomplete_id_cliente']/div[1]/a")
	private WebElement chanceClient;

	@FindBy(id = "id_tipo_0")
	private WebElement activityType;

	@FindBy(id = "id_tipo_1")
	private WebElement visitType;

	@FindBy(id = "id_tipo_2")
	private WebElement callType;

	@FindBy(id = "btn_novo_agendamento")
	private WebElement btnNewAppointment;

	@FindBy(id = "btn_registrar_atividade")
	private WebElement btnNewActivity;

	@FindBy(xpath = "//*[@id='filtro_periodo']/li[1]/a")
	private WebElement currentMonth;

	@FindBy(xpath = "//*[@id='filtro_periodo']/li[2]/a")
	private WebElement lastMonth;

	@FindBy(xpath = "//*[@id='filtro_periodo']/li[3]/a")
	private WebElement fiveMonths;

	@FindBy(xpath = "//*[@id='filtro_periodo']/li[4]/a")
	private WebElement otherPeriod;

	private void waitLoad(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(btnNewAppointment));
	}

	public void waitLoadField(WebDriver driver, WebElement field) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(field));
	}

	public void doSearch(String status, String user, String client, AppointmentType type, Period period,
			WebDriver driver) {
		waitLoad(driver);
		fillStatus(status, driver);
		fillUser(user, driver);
		fillClient(client, driver);
		fillType(type);
		periodClick(period);
	}

	private void fillStatus(String status, WebDriver driver) {
		this.status.click();
		WebElement cdStatus = driver.findElement(By.xpath("//*[@id='id_status_chzn']/div/div/input"));
		cdStatus.sendKeys(status);
		cdStatus.sendKeys(Keys.ENTER);
	}

	private void fillUser(String user, WebDriver driver) {
		this.user.click();
		WebElement cdUser = driver.findElement(By.xpath("//*[@id='id_colaborador_chzn']/div/div/input"));
		cdUser.sendKeys(user);
		cdUser.sendKeys(Keys.ENTER);
	}

	private void fillClient(String client, WebDriver driver) {
		changeClient(driver);
		this.client.clear();
		this.client.sendKeys(client);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading_autocomplete_id_cliente")));
		this.client.sendKeys(Keys.ENTER);
	}

	private void fillType(AppointmentType type) {
		if (type == AppointmentType.ACTIVITY) {
			activityType.click();
		} else if (type == AppointmentType.VISIT) {
			visitType.click();
		} else if (type == AppointmentType.CALL) {
			callType.click();
		}
	}

	private void periodClick(Period period) {
		if (period == Period.CURRENTMONTH) {
			currentMonth.click();
		} else if (period == Period.LASTMONTH) {
			lastMonth.click();
		} else if (period == Period.FIVEMONTHS) {
			fiveMonths.click();
		} else if (period == Period.OTHERPERIOD) {
			otherPeriod.click();
		}
	}

	public void btnNovoAgendamentoClick(WebDriver driver) {
		waitLoad(driver);
		btnNewAppointment.click();
	}

	public void btnNewActivitylick(WebDriver driver) {
		waitLoad(driver);
		btnNewActivity.click();
	}

	public void changeClient(WebDriver driver) {
		if (chanceClient.isDisplayed()) {
			chanceClient.click();
			waitLoadField(driver, client);
		}
	}

	public void checkDone(int index, WebDriver driver) {
		By xpathBtnDone = By.xpath("//*[@id='atividades']/li[" + index + "]/div[1]/div");
		driver.findElement(xpathBtnDone).click();
	}

	public void describeAppointmentClick(int index, WebDriver driver) {
		By xpathBtnDecribe = By.xpath("//*[@id='atividades']/li[" + index + "]/div[2]/div/a[1]");
		driver.findElement(xpathBtnDecribe).click();
	}

	public void fillDescription(int index, WebDriver driver, String description) {
		By xpathDescription = By.xpath("//*[@id='atividades']/li[" + index + "]/div[2]/div/div[4]/textarea");
		WebElement elementDescription = driver.findElement(xpathDescription);
		elementDescription.clear();
		elementDescription.sendKeys(description);
	}

	public void saveDescriptionClick(int index, WebDriver driver) {
		By xpathBtnSave = By.xpath("//*[@id='atividades']/li[" + index + "]/div[2]/div/div[4]/a");
		driver.findElement(xpathBtnSave).click();
	}

	public void btnUpdateAppointmentClick(int index, WebDriver driver) {
		By xpathBtnUpdate = By.xpath("//*[@id='atividades']/li[" + index + "]/div[2]/div/div[1]/a");
		driver.findElement(xpathBtnUpdate).click();
	}

}
