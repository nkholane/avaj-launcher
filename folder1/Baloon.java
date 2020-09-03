package folder1;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower = new WeatherTower();

	Baloon(String name, Coordinates coordinates)  {
		super(name, coordinates);
		if (this.coordinates.getHeight() > 100 ) {
			this.coordinates.setHeight(100);
		}
		registerTower(weatherTower);
	}

	public void updateConditions() {
		if (unregistered != true) {
			String weather = weatherTower.getWeather(coordinates);

				if (weather.equals("SUN" )) {
					coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
					if (coordinates.getHeight() > 100)
						coordinates.setHeight(100);
					Simulation.logger = Simulation.logger + "Baloon#" + name + "(" + id + "): Let us enjoy the sunset view\n";
				}
				if (weather.equals("FOG" )) {
					coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
					Simulation.logger = Simulation.logger + "Baloon#" + name + "(" + id + "): Someone bring the fan, its cloudy up here\n";
					if (coordinates.getHeight() <= 0) {
						Simulation.logger = Simulation.logger + "Baloon#" + name + "(" + id + "): Landing... , long:" + coordinates.getLongitude() + ", lat:" + coordinates.getLatitude() + "\n";
						Simulation.logger = Simulation.logger + "Tower says Baloon#" + name + "(" + id + ") unregistered from weather tower.\n";
						unregistered = true;
					}
				}
				if (weather.equals("RAIN" )) {
					coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
					Simulation.logger = Simulation.logger + "Baloon#" + name + "(" + id + "): Put away your phones, lightning up ahead\n";
					if (coordinates.getHeight() <= 0) {
						Simulation.logger = Simulation.logger + "Baloon#" + name + "(" + id + "): Landing... , long:" + coordinates.getLongitude() + ", lat:" + coordinates.getLatitude() + "\n";
						Simulation.logger = Simulation.logger + "Tower says Baloon#" + name +  "(" + id + "): unregistered from weather tower.\n";
						unregistered = true;
					}
				}
				if (weather.equals("SNOW" )) {
					coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
					Simulation.logger = Simulation.logger + "Baloon#" + name + "(" + id + "): I don't know why we are killing ourselves in this cold weather\n";
					if (coordinates.getHeight() <= 0) {
						Simulation.logger = Simulation.logger + "Baloon#" + name + "(" + id + "): Landing... , long:" + coordinates.getLongitude() + ", lat:" + coordinates.getLatitude() + "\n";
						Simulation.logger = Simulation.logger + " Tower says Baloon#" + name + "(" + id + ") unregistered from weather tower.\n";
						unregistered = true;
					}
				}
			}
		}

	public void registerTower(WeatherTower WeatherTower) {
		Simulation.logger = Simulation.logger + "Tower says Baloon#" + name + "(" + id + ") registered to weather tower.\n";
	}
}