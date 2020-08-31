package dev.avaj.tower;

import dev.avaj.Coordinates;
import dev.avaj.weather.WeatherProvider;

public class WeatherTower extends Tower{
    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() //default
    {
        conditionsChanged();
    }
}
//This section is done