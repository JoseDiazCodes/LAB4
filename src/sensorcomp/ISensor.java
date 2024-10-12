package sensorcomp;

/**
 * Represents a basic sensor capable of taking readings.
 * This interface defines the fundamental operations that any sensor should
 * support: taking a new reading and retrieving the last reading taken.
 * It serves as a base for more specific sensor types.
 */
public interface ISensor {

  /**
   * Takes a new reading from the sensor.
   * This method should update the sensor's internal state with a new
   * measurement from whatever phenomenon the sensor is monitoring.
   *
   * @return the new sensor reading as a double
   */
  double takeNewReading();

  /**
   * Retrieves the last reading taken by the sensor.
   * This method should return the most recent measurement taken by the
   * sensor, without taking a new reading.
   *
   * @return the last sensor reading as a double
   */
  double lastReading();
}