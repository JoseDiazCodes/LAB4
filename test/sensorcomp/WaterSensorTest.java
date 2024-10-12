package sensorcomp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for WaterSensor.
 * This class contains JUnit tests to validate the functionality of the
 * WaterSensor class, focusing on its discrete sensor behavior and
 * inheritance from AtmosphericSensor.
 */
public class WaterSensorTest {
  private WaterSensor waterSensor;

  /**
   * Set up a new WaterSensor instance before each test.
   */
  @Before
  public void setUp() {
    waterSensor = new WaterSensor();
    SensorData.reset();
  }

  /**
   * Test the initial state of the WaterSensor.
   */
  @Test
  public void testInitialState() {
    assertFalse("Initial state should not be flooding", waterSensor.status());
    assertEquals(
            "Initial reading should be 0",
            0.0,
            waterSensor.lastReading(),
            0.001);
  }

  /**
   * Test taking new readings and updating the flooding status.
   */
  @Test
  public void testTakeNewReadingAndStatus() {
    assertEquals(0.1, waterSensor.takeNewReading(), 0.001);
    assertFalse(waterSensor.status());

    assertEquals(0.4, waterSensor.takeNewReading(), 0.001);
    assertFalse(waterSensor.status());

    assertEquals(0.0, waterSensor.takeNewReading(), 0.001);
    assertFalse(waterSensor.status());

    assertEquals(0.51, waterSensor.takeNewReading(), 0.001);
    assertTrue(waterSensor.status());
  }

  /**
   * Test the flipStatus method.
   */
  @Test
  public void testFlipStatus() {
    assertFalse(waterSensor.status());
    waterSensor.flipStatus();
    assertTrue(waterSensor.status());
    waterSensor.flipStatus();
    assertFalse(waterSensor.status());
  }

  /**
   * Test the setStatus method.
   */
  @Test
  public void testSetStatus() {
    assertFalse(waterSensor.status());
    waterSensor.setStatus(true);
    assertTrue(waterSensor.status());
    waterSensor.setStatus(false);
    assertFalse(waterSensor.status());
  }

  /**
   * Test the lastReading method inherited from AtmosphericSensor.
   */
  @Test
  public void testLastReading() {
    assertEquals(0.0, waterSensor.lastReading(), 0.001);

    double firstReading = waterSensor.takeNewReading(); // 0.1
    assertEquals(0.1, firstReading, 0.001);
    assertEquals(0.0, waterSensor.lastReading(), 0.001);

    double secondReading = waterSensor.takeNewReading(); // 0.4
    assertEquals(0.4, secondReading, 0.001);
    assertEquals(0.1, waterSensor.lastReading(), 0.001);
  }
}