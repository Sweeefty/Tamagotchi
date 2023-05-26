package com.ynov;

public class Tamagotchi {
    int age;
    int happiness;
    private int happinessMax;
    String state;
    private int nbPlay = 0;
    private int nbEat = 0;
    private boolean isSick;

public Tamagotchi () {
    age = 0;
    happiness = 15;
    happinessMax = 50;
    state = "Oeuf";
    this.isSick = false;
    }

    public void UnitTime() {
        age++;
        nbPlay = 0;
        if (state == "Oeuf") {
            happiness = 15;
            if (age >= 1) {
                state = "Bébé";
                System.out.println("Le Tamagotchi est né !");
            }
        } else if (state == "Bébé") {
            happiness -= 10;
            if (age >= 4 && happiness >= 40) {
                state = "Adulte";
                System.out.println("Le Tamagotchi est devenu adulte !");
            }
        } else if (state == "Adulte") {
            happiness -= 10;
            if (age >= 15) {
                state = "Vieillard";
                System.out.println("Le Tamagotchi est devenu vieux !");
            }
        } else if (state == "Vieillard") {
            happiness -= 10;
            if (isSick == Math.random() < 1 / 3) {
                isSick = true;
                System.out.println("Le Tamagotchi est tombé malade !");
            }
            if (isSick == true) {
                age = 0;
                happiness = 15;
                state = "Oeuf";
                System.out.println("Le Tamagotchi est mort de malade.");
            }
            }
            if (age >= 20) {
                age = 0;
                happiness = 15;
                state = "Oeuf";
                System.out.println("Le Tamagotchi est mort de vieillesse.");
            }
    }
}


