package classes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseUtil extends State
{
    public void loadUrl(String url)
    {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public WebElement waitFor(By locator)
    {
        WebElement element = new WebDriverWait(driver, 10, 200).until(ExpectedConditions.presenceOfElementLocated(locator));
        scrollToElement(element);

        return element;
    }

    private void scrollToElement(WebElement element)
    {
        javascript().executeScript("arguments[0].scrollIntoView(true);", element);
        sleep(0.2, "Wait for screen to scroll");
        javascript().executeScript("window.scrollBy(0, " + -200 + ")", "");
    }

    private JavascriptExecutor javascript()
    {
        return (JavascriptExecutor) driver;
    }

    private void sleep(double seconds, String message)
    {
        try
        {
            System.out.println(message);
            Thread.sleep((int) (seconds * 1000));
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void switchToFrame(By locator)
    {
        WebElement element = waitFor(locator);
        driver.switchTo().frame(element);
    }

    public void insertText(By locator, String text)
    {
        WebElement day = waitFor(locator);
        day.click();
        day.sendKeys(text);
    }

    public String createUniqueText()
    {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        return df.format(new Date());
    }
}


