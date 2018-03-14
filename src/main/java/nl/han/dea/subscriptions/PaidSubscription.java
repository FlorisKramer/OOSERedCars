package nl.han.dea.subscriptions;

import nl.han.dea.utils.CarType;
import nl.han.dea.utils.SubscriptionType;

public class PaidSubscription extends Subscription{

    public PaidSubscription(CarType type) {
        switch (type) {
            case PERSONEN:
                perHour = 400;
                perDay = 4000;
                perWeekend = 6000;
                week = 14000;
                perKM = 25;
                freeKMS = 10000;
                break;
            case STATION:
                perHour = 550;
                perDay = 5000;
                perWeekend = 8000;
                week = 17000;
                perKM = 30;
                freeKMS = 10000;
                break;
        }
    }
}
