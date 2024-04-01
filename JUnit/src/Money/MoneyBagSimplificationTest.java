package Money;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MoneyBagSimplificationTest {
    private Money m12CHF;
    private Money m7USD;
    private MoneyBag mb1;
    private MoneyBag mb2;

	@Before
	public void setUp() throws Exception {
        m12CHF = new Money(12, "CHF");
        m7USD = new Money(7, "USD");
        mb1 = new MoneyBag(m12CHF, m7USD);
        mb2 = new MoneyBag(m7USD, m12CHF);
	}

	@Test
    public void testSimplification() {
        IMoney result = mb1.add(mb2);
        assertTrue(result instanceof Money);
        Money moneyResult = (Money) result;
        assertEquals(19, moneyResult.amount());
        assertEquals("USD", moneyResult.currency());
    }
}
