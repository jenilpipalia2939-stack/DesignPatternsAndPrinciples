package org.example.Builder;

/*
 * Separate CakeBuilder class — exists only to build Cake step by step.
 *
 * KEY CHANGE from plain setter Stage 2:
 * Every setter now returns 'this' (CakeBuilder) instead of void.
 * This enables method chaining — each call flows into the next.
 *
 * build() at the end calls new Cake(this) — passes itself to Cake constructor.
 * Cake is born only here, only when all values are set.
 */
public class CakeBuilder {

    private double sugar;        // cup
    private double butter;       // cup
    private double eggs;
    private double vanilla;      // spoon
    private double flour;        // cup
    private double bakingPowder; // spoon
    private double milk;         // cup
    private int cherry;

    // Returns CakeBuilder (not void) — this is what enables chaining
    public CakeBuilder setSugar(double sugar) {
        this.sugar = sugar;
        return this; // hands back same builder so next setter can be called
    }

    public CakeBuilder setButter(double butter) {
        this.butter = butter;
        return this;
    }

    public CakeBuilder setEggs(double eggs) {
        this.eggs = eggs;
        return this;
    }

    public CakeBuilder setVanilla(double vanilla) {
        this.vanilla = vanilla;
        return this;
    }

    public CakeBuilder setFlour(double flour) {
        this.flour = flour;
        return this;
    }

    public CakeBuilder setBakingPowder(double bakingPowder) {
        this.bakingPowder = bakingPowder;
        return this;
    }

    public CakeBuilder setMilk(double milk) {
        this.milk = milk;
        return this;
    }

    public CakeBuilder setCherry(int cherry) {
        this.cherry = cherry;
        return this;
    }

    // Getters — used by Cake constructor to read values from builder
    public double getSugar() {
        return sugar;
    }

    public double getButter() {
        return butter;
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
        return bakingPowder;
    }

    public double getMilk() {
        return milk;
    }

    public int getCherry() {
        return cherry;
    }

    /*
     * build() — final assembly step.
     * Validation can be added here before Cake is created.
     * Only a valid, complete Cake is returned to the caller.
     */
    public Cake build() {
        if (flour <= 0) throw new IllegalArgumentException("Flour is required");
        if (eggs <= 0) throw new IllegalArgumentException("At least 1 egg is required");
        if (bakingPowder <= 0) throw new IllegalArgumentException("Baking powder is required");
        return new Cake(this); // passes itself — Cake reads all values from builder
    }
}