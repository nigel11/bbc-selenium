package pageobjects;

import classes.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BlogPage
{
    private final By commentIframe = By.id("bbc-blogs-comments-iframe");
    private final By signInLink = By.cssSelector("#id4-cta-1 .id4-cta-signin");
    private final By commentField = By.cssSelector("form .cmts-post-box");
    private final By postCommentButton = By.cssSelector(".cmts-submit");
    private final By comments = By.cssSelector(".cmts-list>li");
    private final By commentMessage = By.cssSelector(".cmts-message");
    private BaseUtil base;

    public BlogPage(BaseUtil baseUtil)
    {
        base = baseUtil;
    }

    public void signIn()
    {
        base.switchToFrame(commentIframe);
        base.waitFor(signInLink).click();
        base.driver.switchTo().defaultContent();
    }

    public void addComment(String comment)
    {
        base.switchToFrame(commentIframe);
        base.insertText(commentField, comment);
        base.waitFor(postCommentButton).click();
        base.driver.switchTo().defaultContent();
    }

    public boolean isCommentDisplayed(String comment)
    {
        base.switchToFrame(commentIframe);

        WebDriverWait wait = new WebDriverWait(base.driver, 10, 200);
        List<WebElement> commentList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(comments));

        boolean isCommentFound = false;
        for(WebElement commenta : commentList)
        {
            String commentText = commenta.getText();
            if(commentText.contains(comment))
            {
                isCommentFound = true;
                break;
            }
        }

        base.driver.switchTo().defaultContent();
        return isCommentFound;
    }

    public String getCommentMessage()
    {
        base.switchToFrame(commentIframe);
        String message = base.waitFor(commentMessage).getText();
        base.driver.switchTo().defaultContent();

        return message;
    }
}
