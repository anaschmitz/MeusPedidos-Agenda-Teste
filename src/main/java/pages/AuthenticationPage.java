package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage {

	@FindBy(id = "id_usuario")
	private WebElement user;

	@FindBy(id = "id_senha")
	private WebElement password;

	@FindBy(xpath = "/html/body/div[4]/form/button")
	private WebElement btnEnter;

	public void doLogin(String user, String password) {
		fillUser(user);
		fillPassword(password);

		btnEnter.submit();
	}

	private void fillUser(String user) {
		this.user.clear();
		this.user.sendKeys(user);
	}

	private void fillPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

}
