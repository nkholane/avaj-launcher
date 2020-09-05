package folder1;

import java.util.ArrayList;

public class Simulation {
    public static String logger = "";

    public static void main(String[] args) throws ErrorHandler {
    try {
        ReadFile readFile = new ReadFile();
        ArrayList<String> content = readFile.readFile(args[0]);
        WeatherTower tower = new WeatherTower();
        int simulationCount = Integer.parseInt(content.get(0));

        for (int i = 1; i <= content.size() - 1; i++) {
            String[] aircraftInfo = content.get(i).split(" ");
            Flyable flyable = AircraftFactory.newAircraft(aircraftInfo[0], aircraftInfo[1], Integer.parseInt(aircraftInfo[2]), Integer.parseInt(aircraftInfo[3]), Integer.parseInt(aircraftInfo[4]));
            tower.register(flyable);
        }
        for (int i = 0; i < simulationCount; i++) {
            tower.conditionsChanged();
        }
        WriteToFile writeToFile = new WriteToFile();
        writeToFile.writeToFile();
    } catch (ArrayIndexOutOfBoundsException e) {
        throw new ErrorHandler("enter a file as argument");   
    }
    }
}
