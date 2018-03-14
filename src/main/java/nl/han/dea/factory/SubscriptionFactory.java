package nl.han.dea.factory;

import nl.han.dea.subscriptions.FreeSubscription;
import nl.han.dea.subscriptions.PaidSubscription;
import nl.han.dea.subscriptions.Subscription;
import nl.han.dea.utils.CarType;
import nl.han.dea.utils.SubscriptionType;

public class SubscriptionFactory {

    public static Subscription getSubscription(SubscriptionType type, CarType carType){
        if (type == null){
            return null;
        }

        if (type == SubscriptionType.FREE){
            return new FreeSubscription(carType);
        } else {
            return new PaidSubscription(carType);
        }
    }
}
