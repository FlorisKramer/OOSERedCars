package nl.han.dea.subscriptions;

import nl.han.dea.utils.CarType;

public abstract class Subscription {
    int perHour;
    int perDay;
    int week;
    int perWeekend;
    int perKM;
    int freeKMS;

    public int getPerHour(){
        return perHour;
    }

    public int getPerDay(){
        return perDay;
    }

    public int getPerWeek(){
        return week;
    }

    public int getPerWeekend(){
        return perWeekend;
    }

    public int getPerKMS(){
        return perKM;
    }

}
