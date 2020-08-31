package dev.avaj.aircraft;

import dev.avaj.Coordinates;
import dev.avaj.Flyable;
import dev.avaj.tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates)
    {
        super(name,coordinates);
    }

//    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather.equals("SUN"))
        {
            coordinates = new Coordinates(
                    coordinates.getLongitude() + 10,
                    coordinates.getLatitude(),
                    coordinates.getHeight() + 2);
        }
        if (weather.equals("RAIN"))
        {
            coordinates = new Coordinates(
                    coordinates.getLongitude() + 5,
                    coordinates.getLatitude(),
                    coordinates.getHeight());
        }
        if (weather.equals("SNOW"))
        {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 12);
        }
        if (weather.equals("FOG"))
        {
            coordinates = new Coordinates(
                    coordinates.getLongitude() + 1,
                    coordinates.getLatitude() ,
                    coordinates.getHeight());
        }
    }

//    @Override
    public void registerTower(WeatherTower WeatherTower) {
        //TODO registerTower
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);

    }
}
