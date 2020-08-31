package dev.avaj.aircraft;

import dev.avaj.Coordinates;
import dev.avaj.Flyable;
import dev.avaj.tower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates)
    {
        super(name,coordinates); //calling the name of the parent constructor Aircraft
    }

//    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather.equals("SUN"))
        {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 10,
                    coordinates.getHeight() + 2);
        }
        if (weather.equals("RAIN"))
        {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 5,
                    coordinates.getHeight());
        }
        if (weather.equals("SNOW"))
        {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 7);
        }
        if (weather.equals("FOG"))
        {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 1,
                    coordinates.getHeight());
        }
    }

//    @Override
    public void registerTower(WeatherTower WeatherTower) {
        //TODO registerTower
    }
}
