package popups;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import entity.Appointment;
import utils.AppointmentType;

public class NewActivityPopUp {

	@FindBy(id = "id_tipo_atividade_0")
	private WebElement visitType;

	@FindBy(id = "id_tipo_atividade_1")
	private WebElement callType;

	@FindBy(id = "id_tipo_atividade_2")
	private WebElement activityType;

	@FindBy(id = "id_cliente_atividade")
	private WebElement client;

	@FindBy(id = "id_descricao")
	private WebElement description;

	@FindBy(id = "id_data_acao")
	private WebElement date;

	@FindBy(xpath = "//*[@id='form-cadastro-popover-realizada']/div[5]/a[1]")
	private WebElement btnSave;

	@FindBy(xpath = "//*[@id='form-cadastro-popover-realizada']/div[5]/a[2]")
	private WebElement btnCancel;

	private void waitLoad(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(btnSave));
	}

	public void fillFields(Appointment activiy, WebDriver driver) {
		waitLoad(driver);
		fillType(activiy.getType());
		fillClient(activiy.getClient(), driver);
		fillDescription(activiy.getDescription());
		fillDate(activiy.getDateFormatted());
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

	private void fillClient(String client, WebDriver driver) {
		this.client.clear();
		this.client.sendKeys(client);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading_autocomplete_id_cliente_atividade")));
		this.client.sendKeys(Keys.ENTER);
	}

	private void fillDescription(String description) {
		this.description.clear();
		this.description.sendKeys(description);
	}

	private void fillDate(String date) {
		this.date.clear();
		this.date.sendKeys(date);
		this.date.click();
	}

	public void btnSaveClick() {
		btnSave.click();
	}

	public void btnCancelClick() {
		btnCancel.click();
	}

}
