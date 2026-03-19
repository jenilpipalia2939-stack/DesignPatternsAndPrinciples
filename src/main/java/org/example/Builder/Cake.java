package org.example.Builder;

/*
 * STAGE 2: Setter Methods Approach
 * We remove the heavy constructor and expose setters for each field.
 * BETTER THAN: Telescoping — at least we know what each value means.
 *
 * PROBLEM 1 — Inconsistent State:
 * The object is created first (empty), then fields are set one by one.
 * Between new Cake() and the last setter, the object is half-built and invalid.
 *
 * PROBLEM 2 — Not thread-safe:
 * Another thread can read the Cake object before all setters are called.
 *
 * PROBLEM 3 — No immutability:
 * Anyone can call setters anytime and mutate the object after creation.
 */

public class Cake {
    private double sugar;   //cup
    private double butter;  //cup
    private double eggs;
    private double vanilla;     //spoon
    private double flour;   //cup
    private double bakingPowder; //spoon
    private double milk;  //cup
    private int cherry;

    public Cake() {};

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public void setButter(double butter) {
        this.butter = butter;
    }

    public void setEggs(double eggs) {
        this.eggs = eggs;
    }

    public void setVanilla(double vanilla) {
        this.vanilla = vanilla;
    }

    public void setFlour(double flour) {
        this.flour = flour;
    }
    public void setBakingPowder(double bakingPowder) {
        this.bakingPowder = bakingpowder;
    }
    public void setMilk(double milk) {
        this.milk = milk;
    }
    public void setCherry(int cherry) {
        this.cherry = cherry;
    }

    public double getSugar() {
        return sugar;
    }

    public double getEggs() {
        return eggs;
    }

    public double getVanilla() {
        return vanilla;
    }

    public double getFlour() {
        return flour;
    }

    public double getBakingPowder() {
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
}
