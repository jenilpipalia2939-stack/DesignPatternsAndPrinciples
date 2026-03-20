package org.example;

import org.example.Builder.Cake;

public class Main {
    public static void main(String[] args) {

        /*
         * USAGE — identical to instructor's Stage 3 style.
         * Cake.getBuilder() — Cake provides its own builder (same as Stage 3).
         * Each setter returns 'this' — fluent chain reads like a recipe.
         * .build() — validates and locks the Cake into existence.
         *
         * WHAT IS NOW IMPOSSIBLE (unlike Stage 3):
         * new Cake(...)              — private constructor, compile error
         * new CakeBuilder()          — class doesn't exist anymore
         * cake.setSugar(99) after    — no setters on Cake, fields are final
         */
        Cake blackForest = Cake.getBuilder()
                .setSugar(1.0)          // 1 cup
                .setButter(0.5)         // 0.5 cup
                .setEggs(3.0)           // 3 eggs
                .setVanilla(1.5)        // 1.5 spoon
                .setFlour(2.0)          // 2 cups
                .setBakingPowder(0.5)   // 0.5 spoon
//                .setMilk(1.0)           // 1 cup
                .setCherry(10)          // 10 cherries
                .build();

        // Reading values — only via getters since fields are private + final
        System.out.println("Sugar: "   + blackForest.getSugar()        + " cup");
        System.out.println("Butter: "  + blackForest.getButter()       + " cup");
        System.out.println("Eggs: "    + blackForest.getEggs());
        System.out.println("Vanilla: " + blackForest.getVanilla()      + " spoon");
        System.out.println("Flour: "   + blackForest.getFlour()        + " cup");
        System.out.println("Baking Powder: " + blackForest.getBakingPowder() + " spoon");
        System.out.println("Milk: "    + blackForest.getMilk()         + " cup");
        System.out.println("Cherry: "  + blackForest.getCherry());
    }
}