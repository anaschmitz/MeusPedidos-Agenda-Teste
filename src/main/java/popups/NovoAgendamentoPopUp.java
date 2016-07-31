package popups;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.AppointmentType;

public class NovoAgendamentoPopUp {
		
	@FindBy(xpath = "//*[@id='id_tipo_atividade']/li[1]/label")
	private WebElement visitType;
	
	@FindBy(xpath = "//*[@id='id_tipo_atividade']/li[2]/label")
	private WebElement callType;
	
	@FindBy(xpath = "//*[@id='id_tipo_atividade']/li[3]/label") 
	private WebElement activityType;
	
	@FindBy(id = "id_cliente_atividade")
	private WebElement client;
	
	@FindBy(id = "id_data_selecao")
	private WebElement cbDate;

	@FindBy(id = "id_data_acao")
	private WebElement date;
	
	@FindBy(id = "id_hora_acao")
	private WebElement hour;
	
	@FindBy(id = "id_colaborador")
	private WebElement user;

	@FindBy(id = "id_observacao")
	private WebElement note;
	
	@FindBy(xpath = "//*[@id='form-cadastro']/div[7]/a[1]") 
	private WebElement btnSave;
	
	@FindBy(xpath = "//*[@id='form-cadastro']/div[7]/a[2]") 
	private WebElement btnCancel;
	
	public void fillFields(AppointmentType type, String client, WebDriver driver, int cbDateIndex , String date, String hour, String user, String note) {
		fillType(type);
		fillClient(client);
		fillCbDate(driver, cbDateIndex);
		fillDate(date);
		fillHour(hour);
		fillUser(user);
		fillNote(note);
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
	
	private void fillCbDate(WebDriver driver, int index) {
		String xpath = "//*[@id='id_data_selecao']/option["+index+"]";
		driver.findElement(By.xpath(xpath)).click();
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
		this.user.clear();
		this.user.sendKeys(user);
		this.user.sendKeys(Keys.DOWN);
		this.user.sendKeys(Keys.ENTER);
	}
	
	private void fillNote(String note) {
		this.note.clear();
		this.note.sendKeys(note);
	}

	public void btnSaveClick() {
		btnSave.click();
	}
	
	public void btnCancelClick() {
		btnCancel.click();
	}
	
}
