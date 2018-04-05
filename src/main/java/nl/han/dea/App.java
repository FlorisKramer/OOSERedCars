package nl.han.dea;

import nl.han.dea.controller.ReservationController;
import nl.han.dea.utils.CarType;
import nl.han.dea.utils.PaymentType;
import nl.han.dea.utils.SubscriptionType;

import java.util.Scanner;

public class App {

    private ReservationController reservationController = new ReservationController();

    public static void main(String[] args) {
        App app = new App();
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


        app.getReservationController().createReservation(subscriptionType,carType,paymentType,amountUsed,kmsDriven);

        int paymentAmount = app.getReservationController().getReservation().calculatePaymentAmount();
        System.out.println("Total price : "+((double) paymentAmount)/100);


    }

    public ReservationController getReservationController() {
        return reservationController;
    }
}
