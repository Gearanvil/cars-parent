package pl.jwrabel.javandwro2.cars;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jakubwrabel on 11.03.2017.
 */
public class CarTest {

	@Test
	public void constructor_shouldCreateCorrectObject() {
		// given
		String text = "Ford,Mustang,2001,240";
		String expectedBrand = "Ford";
		String expectedModel = "Mustang";
		int expectedManYear = 2001;
		double expectedPower = 240;

		// when
		Car car = new Car(text);

		// then
		assertEquals(expectedBrand, car.getBrand());
		assertEquals(expectedModel, car.getModel());
		assertEquals(expectedManYear, car.getManufactureYear());
		assertEquals(expectedPower, car.getPower(), 0.000001d);
	}

	@Test
	public void constructor_shouldCreateCorrectObjectForNonTrimmedString() {
		// given
		String text = "   Ford  ,  Mustang  ,  2001 ,   240  ";
		String expectedBrand = "Ford";
		String expectedModel = "Mustang";
		int expectedManYear = 2001;
		double expectedPower = 240;

		// when
		Car car = new Car(text);

		// then
		assertEquals(expectedBrand, car.getBrand());
		assertEquals(expectedModel, car.getModel());
		assertEquals(expectedManYear, car.getManufactureYear());
		assertEquals(expectedPower, car.getPower(), 0.000001d);
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructor_nullString() {
		Car car = new Car(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructor_incorrectInput() {
		Car car = new Car("asdb");
	}

	}

