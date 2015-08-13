import java.util.Map;
import java.util.HashMap;
import java.io.Console;

// import spark.ModelAndView;
// import spark.template.velocity.VelocityTemplateEngine;
// import static spark.Spark.*;



public class CoinCombo {
  public static void main(String[] args) {}


public static String coinCounter(Integer amount) {
  Integer coinCount = 85;
  Integer quarterCount = 0;
  Integer dimeCount = 0;
  Integer nickelCount = 0;
  Integer pennyCount = 0;

  String answer =String.format("You have %d quarters", quarterCount);
  //
  // String answer = System.out.println("Your change for %d cents is %d quarters, %d dimes, %d nickels and $d pennies.", coinCount, quarterCount, dimeCount, nickelCount, pennyCount);
  return answer;
    }
}
