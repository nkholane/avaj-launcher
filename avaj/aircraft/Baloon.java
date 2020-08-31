package dev.avaj.aircraft;

import dev.avaj.Coordinates;
import dev.avaj.Flyable;
import dev.avaj.tower.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates)
    {
        super(name,coordinates);
    }

//    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather.equals("SUN"))
        {
            coordinates = new Coordinates(
                    coordinates.getLongitude() + 2,
                    coordinates.getLatitude(),
                    coordinates.getHeight() + 4);
        }
        if (weather.equals("RAIN"))
        {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 5);
        }
        if (weather.equals("SNOW"))
        {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 15);
        }
        if (weather.equals("FOG"))
        {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 3);
        }
    }

//    @Override
    public void registerTower(WeatherTower WeatherTower) {
        //TODO registerTower
    }
}
