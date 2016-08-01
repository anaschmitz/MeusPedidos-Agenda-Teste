package popups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmDeletePopUp {

	@FindBy(id = "btn_excluir_atividade_modal")
	private WebElement btnDelete;

	private void waitLoad(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(btnDelete));
	}

	public void btnDeleteClick(WebDriver driver) {
		waitLoad(driver);
		btnDelete.click();
	}

}
