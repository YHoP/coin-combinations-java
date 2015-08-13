import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest{
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver(){
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest(){
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Coin Counter Machine");
  }

  @Test
  public void doesRockBeatPaper(){
    goTo("http://localhost:4567/");
    fill("#amount").with("33");
    submit(".btn");
    assertThat(pageSource()).contains("Your change is 1 quarters, 0 dimes, 1 nickels and 3 pennies.");
  }

}
