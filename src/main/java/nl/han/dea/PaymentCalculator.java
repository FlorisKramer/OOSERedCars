package nl.han.dea;

import nl.han.dea.factory.SubscriptionFactory;
import nl.han.dea.subscriptions.Subscription;
import nl.han.dea.usage.CarUsage;
import nl.han.dea.utils.CarType;
import nl.han.dea.utils.SubscriptionType;

/**
 * Hello world!
 *
 */
public class PaymentCalculator
{
    public static void main( String[] args )
    {
        PaymentCalculator paymentCalculator = new PaymentCalculator();
        CarUsage usage = new CarUsage(SubscriptionType.PER_DAY,10);
        int paymentAmount = paymentCalculator.calculatePaymentAmount(CarType.STATION, SubscriptionType.FREE, SubscriptionType.PER_DAY, usage);
        System.out.println(paymentAmount/100);
    }

    private int calculatePaymentAmount(CarType carType,
                                          SubscriptionType subscriptionType,
                                          SubscriptionType subscriptionPaymentType,
                                          CarUsage usage){
        Subscription subscription = SubscriptionFactory.getSubscription(subscriptionType,carType);
        switch (subscriptionPaymentType){
            case PER_DAY:
                return usage.getCarUsage(SubscriptionType.PER_DAY) * subscription.getPerDay();
            case PER_HOUR:
                return usage.getCarUsage(SubscriptionType.PER_HOUR) * subscription.getPerHour();
            case PER_KM:
                return usage.getCarUsage(SubscriptionType.PER_KM) * subscription.getPerKMS();
            case PER_WEEK:
                return usage.getCarUsage(SubscriptionType.PER_WEEK) * subscription.getPerWeek();
            case PER_WEEKEND:
                return usage.getCarUsage(SubscriptionType.PER_WEEKEND) * subscription.getPerWeekend();
        }
        return 0;
    }



}
