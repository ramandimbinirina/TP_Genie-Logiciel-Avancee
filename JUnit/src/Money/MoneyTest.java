package Money;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MoneyTest {
    private Money f12CHF;
    private Money f14CHF;
    private Money f7USD;
    private MoneyBag fMB1;
    private MoneyBag fMB2;

    @Before
    public void setUp() throws Exception {
        f12CHF = new Money(12, "CHF");
        f14CHF = new Money(14, "CHF");
        f7USD = new Money(7, "USD");
        fMB1 = new MoneyBag(f12CHF, f7USD);
        fMB2 = new MoneyBag(f14CHF, f7USD);
    }

    @Test
    public void testMixedSimpleAdd() {
        MoneyBag expected = new MoneyBag(new Money[] { f12CHF, f7USD });
        IMoney result = f12CHF.add(f7USD);
        assertEquals(expected, result);
    }
    
    @Test
    public void testBagSimpleAdd() {
        MoneyBag expected = new MoneyBag(new Money[] { f12CHF, f7USD });
        IMoney result = fMB1.add(f14CHF);
        assertEquals(expected, result);
    }

    @Test
    public void testSimpleBagAdd() {
        MoneyBag expected = new MoneyBag(new Money[] { f14CHF, f7USD });
        IMoney result = f14CHF.add(fMB1);
        assertEquals(expected, result);
    }

    @Test
    public void testBagBagAdd() {
        MoneyBag expected = new MoneyBag(new Money[] { f12CHF, f14CHF, f7USD });
        IMoney result = fMB1.add(fMB2);
        assertEquals(expected, result);
    }
}
