package nl.han.dea.domains;

import nl.han.dea.factory.SubscriptionFactory;
import nl.han.dea.subscriptions.Subscription;

public class Reservation {
    Car car;
    Customer customer;
    Usage usage;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int calculatePaymentAmount(){

        Subscription subscription = SubscriptionFactory.getSubscription(customer.getSubscription(),car.getCarType());

        switch (usage.getPaymentType()){
            case PER_DAY:
                return usage.getCarUsage() * subscription.getPerDay() + usage.getKms() * subscription.getPerKMS();
            case PER_HOUR:
                return usage.getCarUsage() * subscription.getPerHour() + usage.getKms() * subscription.getPerKMS();
            case PER_KM:
                return usage.getCarUsage() * subscription.getPerKMS() + usage.getKms() * subscription.getPerKMS();
            case PER_WEEK:
                return usage.getCarUsage() * subscription.getPerWeek() + usage.getKms() * subscription.getPerKMS();
            case PER_WEEKEND:
                return usage.getCarUsage() * subscription.getPerWeekend() + usage.getKms() * subscription.getPerKMS();
        }
        return 0;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }
}
