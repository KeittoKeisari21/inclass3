import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    @org.junit.jupiter.api.Test
    void fahrenheitToCelsius() {
        TemperatureConverter converter = new TemperatureConverter();
        assertEquals(0.0, converter.fahrenheitToCelsius(32), 0.01);
        assertEquals(5.0, converter.fahrenheitToCelsius(41), 0.1);
        assertEquals(23.9, converter.fahrenheitToCelsius(75), 0.1);

    }

    @org.junit.jupiter.api.Test
    void celsiusToFahrenheit() {
        TemperatureConverter converter = new TemperatureConverter();
        assertEquals(32.0, converter.celsiusToFahrenheit(0), 0.1);
        assertEquals(44.1, converter.celsiusToFahrenheit(6.7), 0.1);
        assertEquals(75.0, converter.celsiusToFahrenheit(23.9), 0.1);
    }
    @org.junit.jupiter.api.Test
    void kelvinToCelsius() {
        TemperatureConverter converter = new TemperatureConverter();
        assertEquals(0.0, converter.kelvinToCelsius(273.15), 0.01);
        assertEquals(26.85, converter.kelvinToCelsius(300), 0.01);
        assertEquals(-270.15, converter.kelvinToCelsius(3), 0.01);
    }

    @org.junit.jupiter.api.Test
    void isExtremeTemperature() {
        TemperatureConverter converter = new TemperatureConverter();
        assertTrue(converter.isExtremeTemperature(-45));
        assertTrue(converter.isExtremeTemperature(53));
        assertFalse(converter.isExtremeTemperature(-40));
        assertFalse(converter.isExtremeTemperature(50));
        assertFalse(converter.isExtremeTemperature(29));
    }
}