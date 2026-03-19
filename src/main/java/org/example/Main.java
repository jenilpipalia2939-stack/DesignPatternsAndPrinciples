package org.example;

import org.example.Builder.Cake;
import org.example.Builder.CakeBuilder;

/*
 * PROBLEM: Telescoping Constructor Anti-Pattern
 * Creating a Cake object with a plain constructor forces us to pass all values
 * positionally. We have no idea what each number represents — is it layers? sugar? size?
 * This is error-prone, hard to read, and painful to maintain.
 */


public class Main {
    public static void main(String[] args) {

        // WAY 1 — Old style (separate setters, no chaining) — verbose, breaks easily
        CakeBuilder cakeBuilder = new CakeBuilder();
        cakeBuilder.setSugar(1.0);
        cakeBuilder.setButter(0.5);
        cakeBuilder.setEggs(3.0);
        cakeBuilder.setVanilla(1.5);
        cakeBuilder.setFlour(2.0);
        cakeBuilder.setBakingPowder(0.5);
        cakeBuilder.setMilk(1.0);
        cakeBuilder.setCherry(10);
        Cake cake1 = new Cake(cakeBuilder); // constructor still exposed — not enforced

        /*
         * WAY 2 — Instructor's improved style using getBuilder() + method chaining.
         * Cake.getBuilder() — we ask Cake itself for the builder (cleaner ownership).
         * Each setter returns 'this' — fluent chain, reads like a recipe.
         * .build() at end — Cake is created only when all ingredients are set.
         * Much cleaner than Way 1, but builder is still a separate class (Stage 4 fixes this).
         */
        Cake blackForest = Cake.getBuilder()
                .setSugar(1.0)          // 1 cup
                .setButter(0.5)         // 0.5 cup
                .setEggs(3.0)           // 3 eggs
                .setVanilla(1.5)        // 1.5 spoon
                .setFlour(2.0)          // 2 cups
                .setBakingPowder(0.5)   // 0.5 spoon
                .setMilk(1.0)           // 1 cup
                .setCherry(10)          // 10 cherries
                .build();

    }
}
