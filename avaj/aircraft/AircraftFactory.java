package dev.avaj.aircraft;

import dev.avaj.Coordinates;
import dev.avaj.Flyable;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (type.equals("JetPlane"))
        {
            return(new JetPlane(name, coordinates));
        }
        else if (type.equals("Helicopter"))
        {
            return(new Helicopter(name, coordinates));
        }
        else if (type.equals("Baloon"))
        {
            return(new Baloon(name, coordinates));
        }
        else
        {
            System.out.println("Invalid Flyable type: " + type);
         //   System.exit(-1); exceptions for bonus
        }
        return null; //TODO add realization newAircraft
    }
}
//This is section is done, only add exception L24
