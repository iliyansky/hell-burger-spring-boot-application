package hellburgers.hellburgerspringbootapplication.services.discount;

public class TwoMeatsDiscount implements Discounter {

    @Override
    public double apply(double price) {
        return price - (price * twoOrMoreMeats);
    }
}
