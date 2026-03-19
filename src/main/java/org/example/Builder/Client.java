package org.example.Builder;

/*
 * PROBLEM: Telescoping Constructor Anti-Pattern
 * Creating a Cake object with a plain constructor forces us to pass all values
 * positionally. We have no idea what each number represents — is it layers? sugar? size?
 * This is error-prone, hard to read, and painful to maintain.
 */
public class Client {
    public static void client(String[] args) {

        // We know what each value is — clear improvement over telescoping.
        // BUT: Cake is alive as an empty object before every setter runs.
        Cake blackForest = new Cake();
        blackForest.setSugar(1.0);
        blackForest.setButter(0.5);
        blackForest.setEggs(3.0);
        blackForest.setVanilla(1.5);
        blackForest.setFlour(2.0);
        blackForest.setBakingPowder(0.5);
        // Forgot setMilk() and setCherry() — no compile error, no runtime error.
        // Cake exists but is silently incomplete — a hidden bug in production.

    }
}