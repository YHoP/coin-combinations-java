import org.junit.*;
import static org.junit.Assert.*;

public class CoinComboTest {



@Test
public void coinCounter_ReturnsNumberOfQuartersForCoinAmount_string() {
    CoinCombo testCoinCombo = new CoinCombo();
    String answer = "You have 1 quarters";
    assertEquals(answer, testCoinCombo.coinCounter(25));
}
 }
