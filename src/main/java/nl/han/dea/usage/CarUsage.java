package nl.han.dea.usage;

import nl.han.dea.utils.PaymentType;
import nl.han.dea.utils.SubscriptionType;

public class CarUsage {
    private int hours;
    private int days;
    private int weekends;
    private int weeks;
    private int kms;

    public CarUsage(PaymentType type,int amount) {
        switch (type){
            case PER_DAY:
                this.days = amount;
                break;
            case PER_HOUR:
                this.hours = amount;
                break;
            case PER_KM:
                this.kms = amount;
                break;
            case PER_WEEK:
                this.weeks = amount;
                break;
            case PER_WEEKEND:
                this.weekends = amount;
                break;
        }
    }

    public int getCarUsage(PaymentType type){
        switch (type){
            case PER_DAY:
                return days;
            case PER_HOUR:
                return hours;
            case PER_KM:
                return kms;
            case PER_WEEK:
                return weeks;
            case PER_WEEKEND:
                return weekends;
        }
        return 0;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    public int getKms() {
        return kms;
    }
}
