package classes;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks
{
    private BaseUtil base;

    public Hooks(BaseUtil baseUtil)
    {
        base = baseUtil;
    }

    @Before
    public void setup()
    {
        base.driver = new Driver().getChromeDriver();
    }

    @After
    public void tearDown()
    {
        base.driver.quit();
    }
}
