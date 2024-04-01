package Money;

import java.util.Vector;

public class MoneyBag implements IMoney {
    private Vector<Money> fMonies = new Vector<>();

    public MoneyBag(Money m1, Money m2) {
        appendMoney(m1);
        appendMoney(m2);
    }

    public MoneyBag(Money bag[]) {
        for (int i = 0; i < bag.length; i++)
            appendMoney(bag[i]);
    }

    private void appendMoney(Money m) {
        boolean found = false;
        for (Money money : fMonies) {
            if (money.currency().equals(m.currency())) {
                money = new Money(money.amount() + m.amount(), money.currency());
                found = true;
                break;
            }
        }
        if (!found) {
            fMonies.add(m);
        }
    }

    public Money total() {
        Money total = new Money(0, fMonies.get(0).currency());
        for (Money m : fMonies) {
            total = new Money(total.amount() + m.amount(), m.currency());
        }
        return total;
    }

    public IMoney add(IMoney aMoney) {
        if (aMoney instanceof Money) {
            appendMoney((Money) aMoney);
        } else if (aMoney instanceof MoneyBag) {
            MoneyBag mb = (MoneyBag) aMoney;
            for (Money m : mb.fMonies) {
                appendMoney(m);
            }
        }
        return this;
    }
    
    public IMoney addMoney(Money m) {
        appendMoney(m);
        return this;
    }
    
    public IMoney simplifyIfNeeded() {
        if (fMonies.size() == 1) {
            return fMonies.get(0);
        } else {
            return this;
        }
    }

}
