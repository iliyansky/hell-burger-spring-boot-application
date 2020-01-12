package hellburgers.hellburgerspringbootapplication.services.discount;

public class PayWithCardDiscount implements Discounter {

    @Override
    public double apply(double price) {
        return price - (price * payWithCardDiscount);
    }
}
