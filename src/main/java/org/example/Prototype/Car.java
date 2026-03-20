package org.example.Prototype;

public class Car implements Prototype<Car> {
    private String model;
    private String year;
    private String color;

    public Car(String model, String year, String color) {
        this.model = model;
        this.year = year;
        this.color = color;
        try{
            Thread.sleep(1000);
            System.out.println("Original Car created - expensive operation complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public Car doClone() {
        return new Car(this.model, this.year, this.color);
    }
}
