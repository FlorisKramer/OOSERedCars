package nl.han.dea.subscriptions;

import nl.han.dea.utils.CarType;
import nl.han.dea.utils.SubscriptionType;

public class FreeSubscription extends Subscription{

    public FreeSubscription(CarType type) {
        switch (type) {
            case PERSONEN:
                perHour = 600;
                perDay = 5000;
                perWeekend = 7000;
                week = 15000;
                perKM = 30;
                freeKMS = 0;
                break;
            case STATION:
                perHour = 750;
                perDay = 6000;
                perWeekend = 9000;
                week = 18000;
                perKM = 35;
                freeKMS = 0;
                break;
        }
    }
}
