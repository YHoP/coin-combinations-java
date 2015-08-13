import java.util.Map;
import java.util.HashMap;
import java.io.Console;

// import spark.ModelAndView;
// import spark.template.velocity.VelocityTemplateEngine;
// import static spark.Spark.*;



public class CoinCombo {
  public static void main(String[] args) {}


public static String coinCounter(Integer amount) {
  Integer coinCount = amount;
  Integer quarterCount = 0;
  Integer dimeCount = 0;
  Integer nickelCount = 0;
  Integer pennyCount = 0;

  while (coinCount > 0){
    if (coinCount >= 25){
      coinCount -= 25;
      quarterCount += 1;
    }else if(coinCount >= 10){
      coinCount -= 10;
      dimeCount += 1;
    }else
    coinCount = 0;
  }





  String answer = String.format("Your change is %d quarters, %d dimes, %d nickels and %d pennies.", quarterCount, dimeCount, nickelCount, pennyCount);
  return answer;
    }
}
