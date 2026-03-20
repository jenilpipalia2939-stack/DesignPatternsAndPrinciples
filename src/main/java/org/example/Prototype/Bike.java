package org.example.Prototype;

public class Bike implements Prototype<Bike> {
    private String type;
    private boolean hasBasket;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHasBasket() {
        return hasBasket;
    }

    public void setHasBasket(boolean hasBasket) {
        this.hasBasket = hasBasket;
    }

    public Bike(String type, boolean hasBasket) {
        this.type = type;
        this.hasBasket = hasBasket;
        try{
            Thread.sleep(800);
            System.out.println("Original Bike created - expensive operation complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Bike doClone() {
        return new Bike(this.type, this.hasBasket);
    }
}
