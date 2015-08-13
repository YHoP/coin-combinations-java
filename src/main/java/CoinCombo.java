import java.util.Map;
import java.util.HashMap;
import java.io.Console;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;



public class CoinCombo {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/answers", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/answers.vtl");

      String amount = request.queryParams("amount");
      Integer intAmount = Integer.parseInt(amount);
      //String coinCounter = coinCounter(intAmount);

      // call the coinCounter method and assign the returned the String value put it back to answers page
      model.put("coinCounter", coinCounter(intAmount));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }


public static String coinCounter(Integer amount) {
  Integer coinCount = amount;
  Integer quarterCount = 0;
  Integer dimeCount = 0;
  Integer nickelCount = 0;
  Integer pennyCount = 0;

  // while loop for counting coins
  while (coinCount > 0){
    if (coinCount >= 25){
      coinCount -= 25;
      quarterCount += 1;
    }else if(coinCount >= 10){
      coinCount -= 10;
      dimeCount += 1;
    }else if(coinCount >= 5){
      coinCount -= 5;
      nickelCount += 1;
    }else if(coinCount >= 1){
      coinCount -= 1;
      pennyCount += 1;
    }else
    coinCount = 0;
  }
  String answer = String.format("Your change is %d quarters, %d dimes, %d nickels and %d pennies.", quarterCount, dimeCount, nickelCount, pennyCount);
  return answer;
    }
}
