package sensorcomp;

/**
 * Represents a water sensor that detects flooding conditions.
 * This sensor extends AtmosphericSensor and implements IDiscreteSensor.
 * It considers water levels above 0.5 inches as flooding.
 */

public class WaterSensor extends AtmosphericSensor
        implements IDiscreteSensor {
  /**
   * declares isFlooding variable.
   */
  private boolean isFlooding;

  /**
   * Constructs a new WaterSensor with initial non-flooding status.
   */

  public WaterSensor() {
    super();
    this.isFlooding = false;
    // default case is the location is not flooding...
  }

  /**
   * Returns the current flooding status of the sensor.
   *
   * @return true if flooding is detected, false otherwise
   */
  @Override
  public boolean status() {
    return isFlooding;
  }

  /**
   * Toggles the current flooding status of the sensor.
   */

  @Override
  public void flipStatus() {
    this.isFlooding = !this.isFlooding;
  }

  /**
   * Sets the flooding status of the sensor.
   *
   * @param value true to set flooding status, false for non-flooding
   */
  @Override
  public void setStatus(boolean value) {
    this.isFlooding = value;
  }

  /**
   * Takes a new water level reading and updates the flooding status.
   *
   * @return the new water level reading in inches
   */
  @Override
  public double takeNewReading() {
    double newReading = super.takeNewReading();
    this.isFlooding = newReading > 0.5;
    return newReading;
  }
}
