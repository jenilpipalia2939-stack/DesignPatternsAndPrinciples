package org.example.Builder;

/*
 * STAGE 3: Separate Builder Class with getBuilder() factory method.
 *
 * IMPROVEMENT OVER plain setter approach:
 * - Cake.getBuilder() is a static method inside Cake itself —
 *   Cake takes responsibility for providing its own builder.
 *   Caller never needs to know CakeBuilder exists directly.
 * - Each setter in CakeBuilder returns 'this' (CakeBuilder) —
 *   enables fluent method chaining: .setSugar().setFlour().build()
 * - build() inside CakeBuilder calls new Cake(this) —
 *   Cake is only created when all values are ready.
 *
 * STILL A PROBLEM:
 * - CakeBuilder is still a separate public class — Cake's constructor
 *   must remain accessible, so new Cake(builder) can still be called
 *   directly from anywhere, bypassing the builder chain.
 * - Fields in Cake are NOT final — Cake remains mutable after build().
 * - No true encapsulation — builder and product are in separate files.
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

    /*
     * Constructor accepts a CakeBuilder object.
     * Cake reads all values from builder — single point of assignment.
     * BUT: constructor is still package-accessible — not fully locked down.
     */
    public Cake(CakeBuilder cakeBuilder) {
        this.sugar = cakeBuilder.getSugar();
        this.butter = cakeBuilder.getButter();
        this.eggs = cakeBuilder.getEggs();
        this.vanilla = cakeBuilder.getVanilla();
        this.flour = cakeBuilder.getFlour();
        this.bakingPowder = cakeBuilder.getBakingPowder();
        this.milk = cakeBuilder.getMilk();
        this.cherry = cakeBuilder.getCherry();
    }

    /*
     * WHY getBuilder() here inside Cake?
     * Cake takes responsibility for providing its own builder.
     * Caller only needs to know Cake — not CakeBuilder directly.
     * This is cleaner than: new CakeBuilder() scattered everywhere.
     * Usage: Cake.getBuilder().setSugar(1.0).setFlour(2.0).build()
     */
    public static CakeBuilder getBuilder() {
        return new CakeBuilder();
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
        return bakingPowder;
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
