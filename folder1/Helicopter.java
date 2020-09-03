package folder1;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower = new WeatherTower();

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
		if (this.coordinates.getHeight() > 100 ) {
			this.coordinates.setHeight(100);
		}
		registerTower(weatherTower);
	}

	public void updateConditions() {
		if (!unregistered) {
			String weather = weatherTower.getWeather(coordinates);

				if (weather.equals("SUN" )) {
					coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
					if (coordinates.getHeight() > 100)
						coordinates.setHeight(100);
					Simulation.logger = Simulation.logger + "Helicopter#" + name + "(" + id + "): What a nice day to fly over the Niagra falls\n";
				}
				if (weather.equals("FOG" )) {
					coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
					Simulation.logger = Simulation.logger + "Helicopter#" + name + "(" + id + "): Flying through clouds makes me feel like Im in Jumanji\n";
				}
				if (weather.equals("RAIN" )) {
					coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
					Simulation.logger = Simulation.logger + "Helicopter#" + name + "(" + id + "): Close the doors, rain showers are heavy \n";
				}
				if (weather.equals("SNOW" )) {
					coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
					Simulation.logger = Simulation.logger + "Helicopter#" + name + "(" + id + "): MAYDAY, the controls are frozen solid\n";
					if (coordinates.getHeight() <= 0) {
						Simulation.logger = Simulation.logger + "Helicopter#" + name + "(" + id + "): Landing... , long:" + coordinates.getLongitude() + ", lat:" + coordinates.getLatitude() + "\n";
						Simulation.logger = Simulation.logger + "Helicopter#" + name + "(" + id + ") unregistered from weather tower.\n";
						unregistered = true;
					}
				}
			}
		}

	public void registerTower(WeatherTower WeatherTower) {
		Simulation.logger = Simulation.logger + "Tower says Helicopter#" + name + "(" + id + ") registered to weather tower.\n";

	}
}
