package nl.han.dea.controller;

import nl.han.dea.domains.Car;
import nl.han.dea.domains.Customer;
import nl.han.dea.domains.Reservation;
import nl.han.dea.domains.Usage;
import nl.han.dea.utils.CarType;
import nl.han.dea.utils.PaymentType;
import nl.han.dea.utils.SubscriptionType;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class ReservationController
{

    private Reservation reservation;

    public void createReservation(SubscriptionType subscriptionType,
                                  CarType carType,
                                  PaymentType paymentType,
                                  int amountUsed,
                                  int kmsDriven){

        //Deze informatie moet eigenlijk uit de database komen
        reservation = new Reservation();
        reservation.setCustomer(new Customer());
        reservation.setCar(new Car());
        reservation.setUsage(new Usage(paymentType));

        reservation.getCustomer().setSubscription(subscriptionType);
        reservation.getCar().setCarType(carType);



        reservation.getUsage().setCarUsage(amountUsed);
        reservation.getUsage().setKms(kmsDriven);
    }

    public Reservation getReservation() {
        return reservation;
    }
}
