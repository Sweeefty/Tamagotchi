package com.ynov;

public class Tamagotchi {
    int age;
    int happiness;
    private int happinessMax;
    String state;
    private int nbPlay = 0;
    private int nbEat = 0;

public Tamagotchi () {
    age = 0;
    happiness = 15;
    happinessMax = 50;
    state = "Oeuf";
    }

    public void play() {
        if (nbPlay < 3) {
            if (happiness + 3 <= happinessMax) {
                happiness += 3;
            } else {
                happiness = happinessMax;
            }
            nbPlay++;
            System.out.println("Il est content");
        }else if (nbPlay >= 3) {
            System.out.println("Le Tamagotchi ne veut plus jouer pour l'instant.");
            System.out.println("Vous avez joué 3 fois, vous pourrez jouer à nouveau au prochain tour.");
        } 
    }
}

