package Money;

public class Money implements IMoney {
    private int fAmount;
    private String fCurrency;

    public Money(int amount, String currency) {
        fAmount = amount;
        fCurrency = currency;
    }

    public int amount() {
        return fAmount;
    }

    public String currency() {
        return fCurrency;
    }
    
    public IMoney add(IMoney aMoney) {
        return aMoney.addMoney(this);
    }

    public IMoney addMoney(Money m) {
        if (m.currency().equals(currency())) {
            Money result = new Money(amount() + m.amount(), currency());
            return result.simplifyIfNeeded();
        } else {
            Money[] moneyArray = { this, m };
            MoneyBag result = new MoneyBag(moneyArray);
            return result.simplifyIfNeeded();
        }
    }
    
    public IMoney addMoneyBag(MoneyBag mb) {
        return mb.addMoney(this);
    }

    public IMoney simplifyIfNeeded() {
       return this;
    }
    
}
