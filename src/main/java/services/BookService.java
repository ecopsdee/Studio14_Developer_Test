package services;

import enums.PaymentType;
import models.Rocket;
import models.Station;
import models.User;
import models.Wallet;

public class BookService {

    //user loads wallet
    public static Wallet userLoadWallet(User user, Long amount){
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        wallet.setPaymentType(PaymentType.BITCOIN);
        wallet.setAmount(wallet.loadAmount(amount));
        return wallet;
    }
    //user pays for the trip
    public static void userTakesTrip(Wallet wallet, Rocket rocket, Station depart, Station arrive) {
        Long totalFare = baseFareAcrossOrbit(depart,arrive) + baseFareOnManMadeStation(arrive);
        if(rocket.getIsLuxury()){
            totalFare *= 2L;
        }
        try {
            wallet.setAmount(wallet.deductAmount(totalFare));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //user views balance
    public static void getUserBalance(Wallet wallet){
        System.out.println("The Balance of " + wallet.getUser().getName() + ": " + wallet.getAmount());
    }

    private static Long baseFareAcrossOrbit(Station depart, Station arrive){
        Long fare = 0L;
        if(depart.getOrbit() != arrive.getOrbit())
            fare += 250L;
        else fare += 50L;
        return fare;
    }

    private static Long baseFareOnManMadeStation(Station arrive){
        Long fare = 0L;
        if(arrive.getType().name().equalsIgnoreCase("manmade"))fare += 200L;
        return fare;
    }
}
