package sensorcomp;

/**
 * Represents an atmospheric sensor that takes readings from the environment.
 * This sensor implements the ISensor interface and provides functionality
 * for taking new readings and retrieving the last reading.
 */

public class AtmosphericSensor implements ISensor {

  private double currentValue;
  private double lastValue;

  /**
   * Constructs a new AtmosphericSensor with a specified initial value.
   *
   * @param value the initial sensor reading
   */
  public AtmosphericSensor(double value) {

    this.currentValue = this.lastValue = value;

  }

  /**
   * Constructs a new AtmosphericSensor with an initial value of 0.
   */
  public AtmosphericSensor() {

    this(0);

  }

  /**
   * Takes a new sensor reading from the environment.
   *
   * @return the new sensor reading
   */
  @Override

  public double takeNewReading() {

    // Simulate a sensor reading
    this.lastValue = this.currentValue; // save previous
    this.currentValue = SensorData.currentReading();

    return this.currentValue;

  }

  /**
   * Retrieves the last sensor reading taken.
   *
   * @return the last sensor reading
   */
  @Override

  public double lastReading() {

    return this.lastValue;

  }

}