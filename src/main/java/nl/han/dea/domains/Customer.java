package nl.han.dea.domains;

import nl.han.dea.utils.SubscriptionType;

public class Customer {
    SubscriptionType subscriptionType;

    public SubscriptionType getSubscription() {
        return subscriptionType;
    }

    public void setSubscription(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }
}
