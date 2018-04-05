package nl.han.dea.domains;

import nl.han.dea.factory.SubscriptionFactory;
import nl.han.dea.subscriptions.Subscription;

public class Reservation {
    Car car;
    Customer customer;

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

        switch (car.getPaymentType()){
            case PER_DAY:
                return car.getCarUsage() * subscription.getPerDay() + car.getKms() * subscription.getPerKMS();
            case PER_HOUR:
                return car.getCarUsage() * subscription.getPerHour() + car.getKms() * subscription.getPerKMS();
            case PER_KM:
                return car.getCarUsage() * subscription.getPerKMS() + car.getKms() * subscription.getPerKMS();
            case PER_WEEK:
                return car.getCarUsage() * subscription.getPerWeek() + car.getKms() * subscription.getPerKMS();
            case PER_WEEKEND:
                return car.getCarUsage() * subscription.getPerWeekend() + car.getKms() * subscription.getPerKMS();
        }
        return 0;
    }
}
