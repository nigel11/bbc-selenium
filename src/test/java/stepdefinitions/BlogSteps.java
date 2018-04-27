package stepdefinitions;

import classes.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageobjects.BlogPage;
import pageobjects.SignInPage;

public class BlogSteps
{
    private BaseUtil base;

    public BlogSteps(BaseUtil base)
    {
        this.base = base;
    }

    @Given("^a signed in user is on the bbc blog page$")
    public void aUserIsOnTheBbcBlogPage()
    {
        base.loadUrl("http://www.bbc.co.uk/blogs/test/entries/f5f3031a-1a29-44ee-b2f8-86e78bfd57b0");
        new BlogPage(base).signIn();
        new SignInPage(base).signIn();
    }
    @When("^the user adds a unique comment$")
    public void theUserAddsAUniqueComment()
    {
        base.blogComment = base.createUniqueText();
        new BlogPage(base).addComment(base.blogComment);
    }

    @When("^the user adds (?:a valid|an invalid) comment \"([^\"]*)\"$")
    public void theUserLeavesAComment(String comment)
    {
        base.blogComment = comment;
        new BlogPage(base).addComment(base.blogComment);
    }

    @Then("^the comment is displayed$")
    public void theCommentIsDisplayed()
    {
        Assert.assertTrue("Comment not displayed on blog page: " + base.blogComment, new BlogPage(base).isCommentDisplayed(base.blogComment));
    }

    @Then("^the comment message is displayed \"([^\"]*)\"$")
    public void theCommentMessageIsDisplayed(String expectedMessage)
    {
        String message = new BlogPage(base).getCommentMessage();
        Assert.assertEquals("Comment message not displayed: " + expectedMessage, expectedMessage, message );
    }
}
