package org.example.Prototype;

public class Client {
    public static void main(String[] args) {
        Car originalCar = new Car("Sedan", "2023", "Blue");
        Bike originalBike = new Bike("Mountain", true);

        // Create clones (faster than creating new objects)
        long startTime = System.currentTimeMillis();
        Car clonedCar = (Car) originalCar.doClone();
        Bike clonedBike = (Bike) originalBike.doClone();
        long endTime = System.currentTimeMillis();

        // Modify clone without affecting original
        clonedCar.setColor("Red");

        // Display results
        System.out.println("\nResults:");
        System.out.println("Original Car: " + originalCar);
        System.out.println("Cloned Car: " + clonedCar);
        System.out.println("Original Bike: " + originalBike);
        System.out.println("Cloned Bike: " + clonedBike);
        System.out.println("Cloning time: " + (endTime - startTime) + "ms");
    }
}
