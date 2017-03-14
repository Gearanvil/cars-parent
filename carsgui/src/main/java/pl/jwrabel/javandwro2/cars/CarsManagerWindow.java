package pl.jwrabel.javandwro2.cars;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

/**
 * Created by jakubwrabel on 11.03.2017.
 */
public class CarsManagerWindow extends JFrame {

    private CarRepository carRepository;
    private JList<Car> carJList;

    public static void main(String[] args) {
        new CarsManagerWindow();
    }

    public CarsManagerWindow() throws HeadlessException {
        setTitle("Cars manager");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLayout(null);

        carJList = new JList<Car>();
        carJList.setSize(200, 300);
        carJList.setLocation(0, 0);
        add(carJList);


        JButton jButton = new JButton("Wczytaj");
        jButton.setLocation(300, 0);
        jButton.setSize(100, 50);
        add(jButton);
        JButton btnReadFromFile = new JButton("Z pliku");
        btnReadFromFile.setLocation(300, 110);
        btnReadFromFile.setSize(100, 50);
        add(btnReadFromFile);

        JButton jBtnSaveToFile = new JButton("Save to file");
        jBtnSaveToFile.setLocation(300, 55);
        jBtnSaveToFile.setSize(100, 50);
        add(jBtnSaveToFile);


        CarEditPanel carEditPanel = new CarEditPanel(this);
        carEditPanel.setLocation(400, 0);
        add(carEditPanel);

        carRepository = new CarRepository();

        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateListFromRepository();
            }
        });
        jBtnSaveToFile.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarRepository car = new CarRepository();
                try {
                    car.saveStateToFile("savedCarsList.txt");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnReadFromFile.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    carRepository.addFromFileToCarList("savedCarsList.txt");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                updateListFromRepository();


            }
        });
        carJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Car selectedCar = carJList.getSelectedValue();
                if (selectedCar != null) {
                    carEditPanel.setEditedCar(selectedCar);
                }

            }
        });

    }

    private void updateListFromRepository() {
        List<Car> carList = carRepository.getCarList();

        // ZAMIANA LISTY NA TABLICĘ
        Car[] cars = new Car[carList.size()];
        for (int i = 0; i < carList.size(); i++) {
            cars[i] = carList.get(i);
        }

        carJList.setListData(cars);
    }

}