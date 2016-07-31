package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage {
	
	@FindBy(id = "aba_agenda")
	private WebElement agenda;
	
	public void clickAgenda() {
		agenda.click();
	}

}
