package kg.aiu.weatherwatch.exception;


public class SensorAlreadyExistException extends RuntimeException {

    public SensorAlreadyExistException() {
        super("Sensor already exists");
    }
}