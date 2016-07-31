package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.AppointmentType;
import utils.Period;

public class AgendaPage {
	
	@FindBy(id = "id_status_chzn")
	private WebElement status;
	
	@FindBy(id = "id_colaborador_chzn")
	private WebElement user;
	
	@FindBy(id = "id_cliente")
	private WebElement client;
	
	@FindBy(xpath = "//*[@id='id_tipo']/li[1]/label")
	private WebElement activityType;
	
	@FindBy(xpath = "//*[@id='id_tipo']/li[2]/label")
	private WebElement visitType;
	
	@FindBy(xpath = "//*[@id='id_tipo']/li[3]/label")
	private WebElement callType;
	
	@FindBy(id = "btn_novo_agendamento")
	private WebElement btnNewAppointment;
	
	@FindBy(id = "btn_registrar_atividade")
	private WebElement btnRegistrarAtividade;
	
	@FindBy(xpath = "//*[@id='filtro_periodo']/li[1]/a")
	private WebElement mesAtual;
	
	@FindBy(xpath = "//*[@id='filtro_periodo']/li[2]/a")
	private WebElement mesPassado;
	
	@FindBy(xpath = "//*[@id='filtro_periodo']/li[3]/a")
	private WebElement cincoMeses;
	
	@FindBy(xpath = "//*[@id='filtro_periodo']/li[4]/a")
	private WebElement outroPeriodo;
	
	public void doSearch(String status, String user, String client, AppointmentType type, Period period) {		
		fillStatus(status);
		fillUser(user);
		fillClient(client);
		fillType(type);
		fillPeriod(period);
	}

	private void fillStatus(String status) { 
		this.status.clear();
		this.status.sendKeys(status);
		this.status.sendKeys(Keys.DOWN);
		this.status.sendKeys(Keys.ENTER);
	}
	
	private void fillUser(String user) { 
		this.user.clear();
		this.user.sendKeys(user);
		this.user.sendKeys(Keys.DOWN);
		this.user.sendKeys(Keys.ENTER);
	}
	
	private void fillClient(String client) {
		this.client.clear();
		this.client.sendKeys(client);
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
	
	private void fillPeriod(Period period) {
		if (period == Period.MESATUAL) {
			mesAtual.click();
        } else if (period == Period.MESPASSADO) {
            mesPassado.click();
        } else if (period == Period.CINCOMESES) {
            cincoMeses.click();
        } else if (period == Period.OUTROPERIODO) {
            outroPeriodo.click();
            //informar preriodopopup
        }
	}	
	
	public void btnNovoAgendamentoClick() {
		btnNewAppointment.click();
	}
	
	public void btnRegistrarAtividadeClick() {
		btnRegistrarAtividade.click();
	}
	
	public void changeClient(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id='selecionado_autocomplete_id_cliente']/div[1]/a")).click();
	}
	
	public void checkDone(int index) {
		//click
	}
	
	public void describeAppointment(int index) {
		//click
		//campo
		//salvar
	}
	
	public void updateAppointment(int index) {
		//*[@id='L_93']/div[2]/div/div[1]/a
		//*[@id='V_92']/div[2]/div/div[1]/a
		//click
		//retorna popup
	}

}
