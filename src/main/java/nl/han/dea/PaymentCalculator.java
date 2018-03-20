package nl.han.dea;

import nl.han.dea.factory.SubscriptionFactory;
import nl.han.dea.subscriptions.Subscription;
import nl.han.dea.usage.CarUsage;
import nl.han.dea.utils.CarType;
import nl.han.dea.utils.PaymentType;
import nl.han.dea.utils.SubscriptionType;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class PaymentCalculator
{
    public static void main( String[] args )
    {
        PaymentCalculator paymentCalculator = new PaymentCalculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Subscription type: FREE,PAID");
        SubscriptionType subscriptionType = SubscriptionType.valueOf(scanner.next().toUpperCase());
        System.out.println("Car type: STATION,PERSONEN");
        CarType carType = CarType.valueOf(scanner.next().toUpperCase());
        System.out.println("Payment type: PER_HOUR," +
                "PER_DAY," +
                "PER_WEEKEND," +
                "PER_WEEK");
        PaymentType paymentType = PaymentType.valueOf(scanner.next().toUpperCase());
        System.out.println("Amount of; days,hours,weekends,weeks: ");
        int amountUsed = scanner.nextInt();
        System.out.println("Amount of kms driven");
        int kmsDriven = scanner.nextInt();


        CarUsage usage = new CarUsage(paymentType,amountUsed);

        usage.setKms(kmsDriven);

        int paymentAmount = paymentCalculator.calculatePaymentAmount(carType, subscriptionType, paymentType, usage);
        System.out.println("Total price : "+((double) paymentAmount)/100);
    }

    private int calculatePaymentAmount(CarType carType,
                                       SubscriptionType subscriptionType,
                                       PaymentType subscriptionPaymentType,
                                       CarUsage usage){

        Subscription subscription = SubscriptionFactory.getSubscription(subscriptionType,carType);

        switch (subscriptionPaymentType){
            case PER_DAY:
                return usage.getCarUsage(subscriptionPaymentType) * subscription.getPerDay() + usage.getKms() * subscription.getPerKMS();
            case PER_HOUR:
                return usage.getCarUsage(subscriptionPaymentType) * subscription.getPerHour() + usage.getKms() * subscription.getPerKMS();
            case PER_KM:
                return usage.getCarUsage(subscriptionPaymentType) * subscription.getPerKMS() + usage.getKms() * subscription.getPerKMS();
            case PER_WEEK:
                return usage.getCarUsage(subscriptionPaymentType) * subscription.getPerWeek() + usage.getKms() * subscription.getPerKMS();
            case PER_WEEKEND:
                return usage.getCarUsage(subscriptionPaymentType) * subscription.getPerWeekend() + usage.getKms() * subscription.getPerKMS();
        }
        return 0;
    }



}
