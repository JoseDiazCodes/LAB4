package sensorcomp;

/**
 * Provides simulated sensor data for testing purposes.
 * This class contains a predefined set of readings that cycle through
 * when requested. It's used to simulate real sensor data in a controlled
 * environment.
 */
public class SensorData {
  /** Predefined array of sensor readings. */
  private static double[] readings
          = {0.1, 0.4, 0.0, 0.51, 0.5, 0.7, 0.0, 2.2, 1.0};

  /** Counter to keep track of the current reading index. */
  private static int counter = 0;

  /**
   * Retrieves the current simulated sensor reading.
   * This method returns readings from the predefined array in a cyclic manner.
   * Once all readings have been returned, it starts over from the beginning.
   *
   * @return the current reading from the predefined set
   */
  public static double currentReading() {
    int value = counter;
    counter++;
    if (counter >= readings.length) {
      counter = 0;
    }
    return readings[value];
  }

  /**
   * Resets the counter for the simulated readings back to the beginning.
   * After calling this method, the next call to currentReading() will return
   * the first element of the readings array.
   */
  public static void reset() {
    counter = 0;
  }
}