package pl.jwrabel.javandwro2.cars;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakubwrabel on 11.03.2017.
 */
public class CarRepository {
    private List<Car> carList; // null

    public CarRepository() {
        carList = new ArrayList<Car>();
        carList.add(new Car("Ford", "Mustang", 2001, 240));
        carList.add(new Car("Opel", "Vectra", 2005, 100));
        carList.add(new Car("Volkswagen,Passat B5,2003,101"));
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void saveStateToFile(String path) throws IOException {
        System.out.println("Saving to file");
        FileWriter fileWriter = new FileWriter(path);

        for (Car car : carList) {
            fileWriter.write(car.toString());
            fileWriter.write(System.lineSeparator());
        }
        fileWriter.flush();
        fileWriter.close();
    }

    public void addFromFileToCarList(String path) throws IOException {

        List<String> lines = Files.readLines(new File(path), Charsets.UTF_8);


        this.carList.clear(); //czysci liste
        for (String line : lines) {
            Car car = new Car(line);
            this.carList.add(car);
        }
        for (Car car:carList)
            System.out.println(car);
             {

        }

    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}

