package pageobjects;

import classes.BaseUtil;
import org.openqa.selenium.By;

public class SignInPage
{
    private By email = By.id("user-identifier-input");
    private By password = By.id("password-input");
    private By signInButton = By.id("submit-button");
    private BaseUtil base;

    public SignInPage(BaseUtil base)
    {
        this.base = base;
    }

    public void signIn()
    {
        base.insertText(email, "nigel.millward+11@gmail.com");
        base.insertText(password, "w1234567");
        base.waitFor(signInButton).click();
    }
}
