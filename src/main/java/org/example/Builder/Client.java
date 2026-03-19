package org.example.Builder;

/*
 * PROBLEM: Telescoping Constructor Anti-Pattern
 * Creating a Cake object with a plain constructor forces us to pass all values
 * positionally. We have no idea what each number represents — is it layers? sugar? size?
 * This is error-prone, hard to read, and painful to maintain.
 */
public class Client {
    public static void client(String[] args) {

        // BAD: What does 1,2,4,5,6,7,8,9 mean? No clarity at all.
        // If you swap two values by mistake, the compiler won't catch it.
        Cake blackForest = new Cake(1, 2, 4, 5, 6, 7, 8, 9);
    }
}