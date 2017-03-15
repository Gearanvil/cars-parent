package pl.jwrabel.javandwro2.cars;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.DoubleSummaryStatistics;

/**
 * Created by jakubwrabel on 13.03.2017.
 */
public class CarEditPanel extends JPanel {
    private Car editedCar;
    private CarsManagerWindow window;
    private CarRepository carRepository;

    JTextField txtBrand;
    JTextField txtModel;
    JTextField txtManYear;
    JTextField txtPower;

    public CarEditPanel(CarsManagerWindow carsManagerWindow, CarRepository carRepository) {
        this.window = carsManagerWindow;
        this.carRepository = carRepository;

        setSize(300, 300);
        setBackground(Color.GREEN);
        setLayout(null);

        JLabel lblBrand = new JLabel("Brand");
        lblBrand.setLocation(0, 0);
        lblBrand.setSize(100, 20);
        add(lblBrand);

        txtBrand = new JTextField();
        txtBrand.setLocation(0, 20);
        txtBrand.setSize(100, 50);
        add(txtBrand);

        JLabel lblModel = new JLabel("Model");
        lblModel.setLocation(0, 70);
        lblModel.setSize(100, 20);
        add(lblModel);

        txtModel = new JTextField();
        txtModel.setLocation(0, 90);
        txtModel.setSize(100, 50);
        add(txtModel);

        JLabel lblManYear = new JLabel("Manufacture year");
        lblManYear.setLocation(0, 140);
        lblManYear.setSize(100, 20);
        add(lblManYear);


        txtManYear = new JTextField();
        txtManYear.setLocation(0, 160);
        txtManYear.setSize(100, 50);
        add(txtManYear);

        JLabel lblPower = new JLabel("Power");
        lblPower.setLocation(0, 210);
        lblPower.setSize(100, 20);
        add(lblPower);

        txtPower = new JTextField();
        txtPower.setLocation(0, 230);
        txtPower.setSize(100, 50);
        add(txtPower);


        JButton btnSave = new JButton("Zapisz");
        btnSave.setLocation(100, 0);
        btnSave.setSize(100, 50);
        add(btnSave);

        JButton btnSaveToRepository = new JButton("Zapisz do listy");
        btnSaveToRepository.setLocation(100, 60);
        btnSaveToRepository.setSize(100, 50);
        add(btnSaveToRepository);



        btnSave.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editedCar.setBrand(txtBrand.getText());
                editedCar.setModel(txtModel.getText());
                int manufactureYear = Integer.parseInt(txtManYear.getText());
                editedCar.setManufactureYear(manufactureYear);
                editedCar.setPower(Double.parseDouble(txtPower.getText()));

                window.repaint();
            }
        });
        btnSaveToRepository.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String brand = txtBrand.getText();
                String model = txtModel.getText();
                int manYear = Integer.parseInt(txtManYear.getText());
                double power = Double.parseDouble(txtPower.getText());
                Car car = new Car(brand, model,manYear,power);
                window.getCarRepository().getCarList().add(car);
                window.updateListFromRepository();


            }
        });

    }

    public void setEditedCar(Car editedCar) {
        this.editedCar = editedCar;

        txtBrand.setText(editedCar.getBrand());
        txtModel.setText(editedCar.getModel());
        txtManYear.setText("" + editedCar.getManufactureYear());
        txtPower.setText("" + editedCar.getPower());
    }
}