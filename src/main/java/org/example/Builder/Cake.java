package org.example.Builder;

/**
 * STAGE 4: Static Nested Builder Pattern — Final Solution.

 * WHAT CHANGED FROM STAGE 3?
 * - CakeBuilder is no longer a separate file — it lives INSIDE Cake as a static nested class.
 * - Cake's constructor is now PRIVATE — no one can do new Cake() or new Cake(builder) directly.
 * - All fields are now FINAL — once build() creates the Cake, nothing can change it.

 * WHY private constructor?
 * In Stage 3, Cake's constructor was public/package-accessible —
 * anyone could do new Cake(cakeBuilder) and bypass the builder chain.
 * Now the ONLY way to get a Cake is: Cake.getBuilder()...build()

 * WHY static nested class (not separate class like Stage 3)?
 * Static nested → lives inside Cake → can access Cake's private constructor.
 * No other class outside can call new Cake(builder) — only Builder can.
 * This enforces the contract: Builder is the ONE and ONLY way to create a Cake.

 * WHY static (not non-static inner class)?
 * Non-static inner class needs an existing Cake instance to be created.
 * But Builder's job IS to create Cake — we can't need a Cake before making a Cake.
 * Static removes that dependency: new Cake.Builder() works without any Cake existing yet.

 * WHY final fields?
 * Stage 3 fields were not final — Cake could be mutated after build() returned it.
 * Final fields are written ONCE inside the private constructor and locked forever.
 * Result: immutability + thread safety with zero extra effort.
 */

public class Cake {
    // Final — assigned once in private constructor, can never be changed after build()
    private final double sugar;        // cup
    private final double butter;       // cup
    private final double eggs;
    private final double vanilla;      // spoon
    private final double flour;        // cup
    private final double bakingPowder; // spoon
    private final double milk;         // cup
    private final int cherry;

    /*
     * Private constructor — completely hidden from the outside world.
     * Only Cake.Builder (nested inside) can reach this.
     * Reads all values from the Builder object passed in.
     *
     * WHY accept Builder instead of individual params?
     * If we wrote private Cake(double sugar, double butter...) we'd be
     * back to the telescoping constructor problem from Stage 1.
     * Accepting Builder keeps it clean — one object carries all values.
     */

    private Cake(Builder builder) {
        this.sugar        = builder.sugar;
        this.butter       = builder.butter;
        this.eggs         = builder.eggs;
        this.vanilla      = builder.vanilla;
        this.flour        = builder.flour;
        this.bakingPowder = builder.bakingPowder;
        this.milk         = builder.milk;
        this.cherry       = builder.cherry;
    }

    /*
     * getBuilder() — static factory method, same as instructor's Stage 3.
     * Cake still takes responsibility for providing its own builder.
     * Caller only interacts with Cake — never imports CakeBuilder separately.
     *
     * DIFFERENCE FROM STAGE 3:
     * Stage 3 → returned new CakeBuilder() (separate class)
     * Stage 4 → returns new Builder() (nested class inside Cake)
     * Outside world doesn't notice — usage stays identical:
     * Cake.getBuilder().setSugar(1.0)...build()
     */
    public static Builder getBuilder() {
        return new Builder();
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

    /*
     * -------------------------------------------------------------------------
     * Static Nested Builder Class
     * -------------------------------------------------------------------------
     * WHY nested?
     *   Belongs to Cake logically — exists only to build Cake.
     *   Being nested gives it exclusive access to Cake's private constructor.
     *   No other class in any other file can ever call new Cake(builder).
     *
     * WHY static?
     *   Can be created without an existing Cake instance: new Cake.Builder()
     *   Non-static would need: someCakeInstance.new Builder() — paradox.
     * -------------------------------------------------------------------------
     */

    public static class Builder {

        // Mutable staging fields — values collected here before Cake is born
        private double sugar;        // cup
        private double butter;       // cup
        private double eggs;
        private double vanilla;      // spoon
        private double flour;        // cup
        private double bakingPowder; // spoon
        private double milk;         // cup
        private int cherry;

        /*
         * Each setter names the ingredient clearly.
         * Returns 'this' (Builder).
         * Enables fluent chaining: .setSugar(1.0).setButter(0.5).setEggs(3.0)
         */
        public Builder setSugar(double sugar) {
            this.sugar = sugar;
            return this; // returns Builder so next setter can be called immediately
        }

        public Builder setButter(double butter) {
            this.butter = butter;
            return this;
        }

        public Builder setEggs(double eggs) {
            this.eggs = eggs;
            return this;
        }

        public Builder setVanilla(double vanilla) {
            this.vanilla = vanilla;
            return this;
        }

        public Builder setFlour(double flour) {
            this.flour = flour;
            return this;
        }

        public Builder setBakingPowder(double bakingPowder) {
            this.bakingPowder = bakingPowder;
            return this;
        }

        public Builder setMilk(double milk) {
            this.milk = milk;
            return this;
        }

        public Builder setCherry(int cherry) {
            this.cherry = cherry;
            return this;
        }

        /*
         * build() — single controlled gate where Cake is born.
         *
         * STEP 1: Validate — enforce business rules before creating anything.
         *         If validation fails, Cake is never created — no broken object escapes.
         * STEP 2: Call private Cake(this) — passes Builder itself to Cake constructor.
         *         Only reachable from here — no other class in the project can do this.
         * STEP 3: Returns a fully built, immutable Cake — final fields, locked forever.
         */
        public Cake build() {
            if (flour        <= 0) throw new IllegalArgumentException("Flour is required");
            if (eggs         <= 0) throw new IllegalArgumentException("At least 1 egg is required");
            if (bakingPowder <= 0) throw new IllegalArgumentException("Baking powder is required");
            if (sugar        <  0) throw new IllegalArgumentException("Sugar cannot be negative");
            if (milk         <  0) throw new IllegalArgumentException("Milk cannot be negative");
            return new Cake(this); // private constructor — ONLY this line in the entire project can do this
        }
    }
}
