package dev.avaj.weather;

import dev.avaj.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"SNOW", "RAIN", "FOG", "SUN"};

    private WeatherProvider(){
    }

    public static WeatherProvider getProvider(){
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        if (coordinates.getHeight() >= 0  && coordinates.getHeight() <= 25)
            return weather[0];
        if (coordinates.getHeight() >=26  && coordinates.getHeight() <=50 )
            return weather[1];
        if (coordinates.getHeight() >=51  && coordinates.getHeight() <=75 )
            return weather[2];
        else
            return weather[3];
    }
}
//This section is done for now. Check later
