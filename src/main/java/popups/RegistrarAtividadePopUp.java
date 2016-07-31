package popups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.AppointmentType;

public class RegistrarAtividadePopUp {

	@FindBy(xpath = "//*[@id='id_tipo_atividade']/li[1]/label")
	private WebElement visitType;
	
	@FindBy(xpath = "//*[@id='id_tipo_atividade']/li[2]/label")
	private WebElement callType;
	
	@FindBy(xpath = "//*[@id='id_tipo_atividade']/li[3]/label") 
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
	
	public void fillFields(AppointmentType type, String client, String description, String date){
			fillType(type);
			fillClient(client);
			fillDescription(description);
			fillDate(date);
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
	
	private void fillDescription(String description) {
		this.description.clear();
		this.description.sendKeys(description);
	}
	
	private void fillDate(String date) {
		this.date.clear();
		this.date.sendKeys(date);
	}
	
	public void btnSaveClick() {
		btnSave.click();
	}
	
	public void btnCancelClick() {
		btnCancel.click();
	}

}
