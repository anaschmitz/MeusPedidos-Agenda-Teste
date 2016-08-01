package popups;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import entity.Appointment;
import utils.AppointmentType;

public class UpdateAppointmentPopUp {

	@FindBy(id = "id_tipo_atividade_0")
	private WebElement visitType;

	@FindBy(id = "id_tipo_atividade_1")
	private WebElement callType;

	@FindBy(id = "id_tipo_atividade_2")
	private WebElement activityType;

	@FindBy(id = "id_cliente_atividade")
	private WebElement client;

	@FindBy(xpath = "//*[@id='selecionado_autocomplete_id_cliente_atividade']/div[1]/a")
	private WebElement changeClient;

	@FindBy(id = "id_data_acao")
	private WebElement date;

	@FindBy(id = "id_hora_acao")
	private WebElement hour;

	@FindBy(id = "id_colaborador")
	private WebElement user;

	@FindBy(id = "id_observacao")
	private WebElement note;

	@FindBy(id = "id_realizada")
	private WebElement done;

	@FindBy(id = "id_descricao")
	private WebElement description;

	@FindBy(xpath = "//*[@id='form-cadastro']/div[9]/a[1]")
	private WebElement btnSave;

	@FindBy(xpath = "//*[@id='form-cadastro']/div[9]/a[2]")
	private WebElement btnCancel;

	@FindBy(xpath = "//*[@id='form-cadastro']/div[9]/a[3]")
	private WebElement btnDelete;

	private void waitLoad(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(btnSave));
	}

	public void fillFields(Appointment appoint, WebDriver driver) {
		waitLoad(driver);
		fillType(appoint.getType());
		fillClient(appoint.getClient(), driver);
		fillDate(appoint.getDateFormatted());
		fillHour(appoint.getHourFormmatted());
		fillUser(appoint.getUser());
		fillNote(appoint.getNote());
		fillDone(appoint.isDone());
		fillDescription(appoint.getDescription());
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
		changeClient();
		this.client.clear();
		this.client.sendKeys(client);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id='div_campo_id_cliente_atividade']/ul/li[1]/a/div/h5")));
		this.client.sendKeys(Keys.ENTER);
	}

	public void changeClient() {
		changeClient.click();
	}

	private void fillDate(String date) {
		this.date.clear();
		this.date.sendKeys(date);
		this.date.click();
	}

	private void fillHour(String hour) {
		this.hour.clear();
		this.hour.sendKeys(hour);
	}

	private void fillUser(String user) {
		Select userSelect = new Select(this.user);
		userSelect.selectByVisibleText(user);
	}

	private void fillNote(String note) {
		this.note.clear();
		this.note.sendKeys(note);
	}

	private void fillDone(boolean done) {
		if (done && !this.done.isSelected() || !done && this.done.isSelected()) {
			this.done.click();
		}
	}

	private void fillDescription(String description) {
		if (!description.isEmpty()) {
			this.description.clear();
			this.description.sendKeys(description);
		}
	}

	public void btnSaveClick() {
		btnSave.click();
	}

	public void btnCancelClick() {
		btnCancel.click();
	}

	public void btnDeleteClick(WebDriver driver) {
		waitLoad(driver);
		btnDelete.click();
	}

}
