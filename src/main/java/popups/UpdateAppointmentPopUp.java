package popups;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.AppointmentType;

public class UpdateAppointmentPopUp {

	@FindBy(xpath = "//*[@id='id_tipo_atividade']/li[1]/label")
	private WebElement visitType;

	@FindBy(xpath = "//*[@id='id_tipo_atividade']/li[2]/label")
	private WebElement callType;

	@FindBy(xpath = "//*[@id='id_tipo_atividade']/li[3]/label")
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

	@FindBy(xpath = "//*[@id='form-cadastro']/div[9]/a[1]")
	private WebElement btnSave;

	@FindBy(xpath = "//*[@id='form-cadastro']/div[9]/a[2]")
	private WebElement btnCancel;

	@FindBy(xpath = "//*[@id='form-cadastro']/div[9]/a[3]")
	private WebElement btnDelete;

	public void fillFields(AppointmentType type, String client, String date, String hour, String user, String note,
			boolean done, String description) {
		fillType(type);
		fillClient(client);
		fillDate(date);
		fillHour(hour);
		fillUser(user);
		fillNote(note);
		fillDone(done);
		fillDescription(description);
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

	private void fillClient(String client) {
		this.client.clear();
		this.client.sendKeys(client);
	}

	public void changeClient() {
		changeClient.click();
	}

	private void fillDate(String date) {
		this.date.clear();
		this.date.sendKeys(date);
	}

	private void fillHour(String hour) {
		this.hour.clear();
		this.hour.sendKeys(hour);
	}

	private void fillUser(String user) {
		Select userSelect = new Select(this.user);
		userSelect.selectByValue(user);
	}

	private void fillNote(String note) {
		this.note.clear();
		this.note.sendKeys(note);
	}

	private void fillDone(boolean done) {
		this.done.clear();
		if (done) {
			this.done.click();
		}
	}

	private void fillDescription(String description) {

//		@FindBy(id = "id_descricao")
//		private WebElement description;
//		this.description.clear();
//		this.description.sendKeys(description);
	}

	public void btnSaveClick() {
		btnSave.click();
	}

	public void btnCancelClick() {
		btnCancel.click();
	}

	public void btnDeleteClick() {
		btnDelete.click();
	}

}
