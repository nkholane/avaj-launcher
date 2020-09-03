package folder1;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower = new WeatherTower();

	JetPlane(String name, Coordinates coordinates)  {
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
					coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
					if (coordinates.getHeight() > 100)
						coordinates.setHeight(100);
					Simulation.logger = Simulation.logger + "JetPlane#" + name + "(" + id + "): What a hot sunny day\n";
				}
				if (weather.equals("FOG" )) {
					coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
					Simulation.logger = Simulation.logger + "JetPlane#" + name + "(" + id + "):  Hopefully I don't crash in this fog\n";
				}
				if (weather.equals("RAIN" )) {
					coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
					Simulation.logger = Simulation.logger + "JetPlane#" + name + "(" + id + "): Its a rainy day I see\n";
				}
				if (weather.equals("SNOW" )) {
					coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
					Simulation.logger = Simulation.logger + "JetPlane#" + name + "(" + id + "): This area is frozen solid\n";
					if (coordinates.getHeight() <= 0) {
						Simulation.logger = Simulation.logger + "JetPlane#" + name + "(" + id + "): Landing... , long:" + coordinates.getLongitude() + ", lat:" + coordinates.getLatitude() + "\n";
						Simulation.logger = Simulation.logger + "JetPlane#" + name + "(" + id + ") unregistered from weather tower.\n";
						unregistered = true;
					}
				}
			}
		}

	public void registerTower(WeatherTower WeatherTower) {
		Simulation.logger = Simulation.logger + "Tower says JetPlane#" + name + "(" + id + ") registered to weather tower.\n";
	}
}