package org.example.Builder;

public class Cake {
    private final double sugar;   //cup
    private final double butter;  //cup
    private final int eggs;
    private final int vanilla;     //spoon
    private final double flour;   //cup
    private final double bakingpowder; //spoon
    private final double milk;  //cup
    private final int cherry;

    public double getSugar() {
        return sugar;
    }

    public int getEggs() {
        return eggs;
    }

    public int getVanilla() {
        return vanilla;
    }

    public double getFlour() {
        return flour;
    }

    public double getBakingpowder() {
        return bakingpowder;
    }

    public double getMilk() {
        return milk;
    }

    public int getCherry() {
        return cherry;
    }

    public double getButter() {
        return butter;
    }

    public Cake(double sugar, double butter, int eggs, int vanilla, double flour, double bakingpowder, double milk, int cherry) {
        this.sugar = sugar;
        this.butter = butter;
        this.eggs = eggs;
        this.vanilla = vanilla;
        this.flour = flour;
        this.bakingpowder = bakingpowder;
        this.milk = milk;
        this.cherry = cherry;
    }

}
