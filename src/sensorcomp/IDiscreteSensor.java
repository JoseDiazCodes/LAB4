package sensorcomp;

/**
 * Represents a discrete sensor that can have binary states.
 * This interface extends ISensor and adds functionality for handling
 * discrete values, typically represented as on/off or true/false states.
 * Implementers should define the specific meaning of these states.
 */
public interface IDiscreteSensor extends ISensor {
  /**
   * Returns the current status of the discrete sensor.
   *
   * @return true if the sensor is in its "on" state, false otherwise
   */
  boolean status(); // discrete values like "on"/ off modeled here
  /**
   * Toggles the current status of the sensor.
   * If the current status is true, it becomes false, and vice versa.
   */

  void flipStatus();

  /**
   * Sets the status of the sensor to a specific value.
   *
   * @param value true to set the sensor to its "on" state, false for "off"
   */
  void setStatus(boolean value);

  /**
   * Returns the last reading taken by the sensor.
   * <p>
   * This default implementation always returns 0.
   * Implementing classes should override this method if needed.
   * </p>
   *
   * @return the last sensor reading, default is 0
   */
  default double lastReading() {
    return 0;
  }

  /**
   * Takes a new reading from the sensor.
   * This default implementation always returns 0.
   * Implementing classes should override this method if needed.
   *
   * @return the new sensor reading, default is 0
   */
  @Override
  default double takeNewReading() {
    return 0;
  }
}