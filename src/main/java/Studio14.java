import enums.StationType;
import models.Orbit;
import models.Rocket;
import models.Station;
import models.User;
import models.Wallet;
import services.BookService;

public class Studio14 {
    public static void main(String[] args) throws Exception {

        User user = new User();
        user.setName("Prince");
        Wallet wallet = BookService.userLoadWallet(user, 3000L);

        Rocket rocket = new Rocket();
        rocket.setName("Falcon 9");
        rocket.setIsLuxury(Boolean.TRUE);
        Orbit orbitEarth = new Orbit();
        orbitEarth.setName("Earth");
        Station depart = new Station();
        depart.setStation("Abuja");
        depart.setOrbit(orbitEarth);
        depart.setType(StationType.NATURAL);
        Station arrive = new Station();
        arrive.setStation("Moon");
        arrive.setOrbit(orbitEarth);
        arrive.setType(StationType.NATURAL);
        BookService.userTakesTrip(wallet,rocket,depart,arrive);
        BookService.getUserBalance(wallet);


        wallet = BookService.userLoadWallet(user, 3000L);
        Rocket rocket2 = new Rocket();
        rocket2.setName("Falcon 1");
        rocket2.setIsLuxury(Boolean.FALSE);
        Orbit orbitMars = new Orbit();
        orbitMars.setName("Mars");
        Station depart2 = new Station();
        depart2.setStation("Moon");
        depart2.setOrbit(orbitEarth);
        depart2.setType(StationType.NATURAL);
        Station arrive2 = new Station();
        arrive2.setStation("Spock");
        arrive2.setOrbit(orbitMars);
        arrive2.setType(StationType.NATURAL);
        BookService.userTakesTrip(wallet,rocket2,depart2,arrive2);
        BookService.getUserBalance(wallet);

        wallet = BookService.userLoadWallet(user, 3000L);
        Station arrive3 = new Station();
        arrive3.setStation("International Space Station");
        arrive3.setOrbit(orbitEarth);
        arrive3.setType(StationType.MANMADE);
        BookService.userTakesTrip(wallet,rocket,arrive2,arrive3);
        BookService.getUserBalance(wallet);


    }

}



