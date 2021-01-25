package patterns.observer.javautil;

import java.util.Observable;
import java.util.Observer;

import patterns.observer.custom.observers.DisplayElement;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable weatherData) {
        weatherData.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.printf("Current conditions are\nTemperature: %sF\nHumidity: %s percent\n---------------%n",
            temperature, humidity);
    }
}
