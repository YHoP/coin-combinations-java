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
  Integer aQuarter = 5;
  Integer aDime = 10;
  Integer aNickel = 3;

  // while loop for counting coins
  while (coinCount > 0){
    if (coinCount >= 25 && aQuarter > 0){
      coinCount -= 25;
      quarterCount++;
      aQuarter--;
    }
    else if(coinCount >= 10 && aDime > 0){
      coinCount -= 10;
      dimeCount++;
      aDime--;
    }else if(coinCount >= 5 && aNickel >0){
      coinCount -= 5;
      nickelCount++;
      aNickel--;
    }else if(coinCount >= 1){
      coinCount--;
      pennyCount++;
    }else
    coinCount = 0;
  }

  String answer = String.format("Your change is %d quarters, %d dimes, %d nickels and %d pennies.<br>", quarterCount, dimeCount, nickelCount, pennyCount);
  answer += outCoins(aQuarter, aDime, aNickel);
  return answer;
    }

public static String outCoins(Integer aQuarter, Integer aDime, Integer aNickel){
  String outPut ="";
  if (aQuarter == 0) outPut += "We are out of quarters.<br>";
  if (aDime == 0) outPut += "We are out of dimes.<br>";
  if (aNickel == 0) outPut += "We are out of nickels.<br>";
  return outPut;
}

}
