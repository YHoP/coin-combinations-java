import org.junit.*;
import static org.junit.Assert.*;

public class CoinComboTest {



@Test
public void coinCounter_ReturnsNumberOfQuartersForCoinAmount_string() {
    CoinCombo testCoinCombo = new CoinCombo();
    String answer = "Your change is 1 quarters, 0 dimes, 0 nickels and 0 pennies.";
    assertEquals(answer, testCoinCombo.coinCounter(25));
}

@Test
public void coinCounter_ReturnsNumberOfDimesForCoinAmount_string() {
    CoinCombo testCoinCombo = new CoinCombo();
    String answer = "Your change is 0 quarters, 1 dimes, 0 nickels and 0 pennies.";
    assertEquals(answer, testCoinCombo.coinCounter(10));
  }
}
