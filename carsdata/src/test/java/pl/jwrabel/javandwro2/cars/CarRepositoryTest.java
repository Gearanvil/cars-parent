package pl.jwrabel.javandwro2.cars;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by RENT on 2017-03-14.
 */
public class CarRepositoryTest {
    @Test
    public void checkLines() throws IOException {
        CarRepository carRep = new CarRepository();
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Opel", "Vectra", 2005, 100));

        carRep.setCarList(carList);
        carRep.saveStateToFile("checkLines.txt");


        List<String> lines = Files.readLines(new File("checkLines.txt"), Charsets.UTF_8);

        assertEquals(carList.size(), lines.size());
    }

    @Test
    public void checkOneString() throws IOException {
        CarRepository carRep = new CarRepository();
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Opel", "Vectra", 2005, 100));

        carRep.setCarList(carList);
        carRep.saveStateToFile("checkOneString.txt");


        List<String> lines = Files.readLines(new File("checkOneString.txt"), Charsets.UTF_8);
        String check = "Opel, Vectra, 2005,100.0";
        boolean boo = lines.get(0).equals(check);
        assertEquals(boo,true);
    }    @Test
    public void checkLoadFromFile(){

    }

}