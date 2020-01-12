package hellburgers.hellburgerspringbootapplication.services.discount;

public interface Discounter {
    double payWithCardDiscount = 0.1;
    double twoOrMoreMeats = 0.2;
    double apply(double price);
}
