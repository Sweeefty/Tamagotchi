package com.ynov;

public class Tamagotchi {
    int age;
    int happiness;
    private int happinessMax;
    String state;
    private int nbPlay = 0;
    private int nbEat = 0;
    private boolean isSick;
	private boolean badEnvironment;
	private boolean noHungry = false;

public Tamagotchi () {
    age = 0;
    happiness = 15;
    happinessMax = 50;
    state = "Oeuf";
    this.isSick = false;
    this.badEnvironment = false;
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
	public void Hungry() {
		noHungry = false;
        if (nbEat < 1) {
            if (happiness + 5 <= happinessMax) {
                happiness += 5; 
            } else {
                happiness = happinessMax; 
            }
            nbEat++; 
            badEnvironment = true; 
            System.out.println("Le Tamagotchi a mangé !");
        } else if (nbEat >= 1) {
            System.out.println("Le Tamagotchi est rassasié.");
            System.out.println("Votre Tamagotchi pourra mangé plus tard.");
        }
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

    public void clean() {
        badEnvironment = false;
        System.out.println("L'environnement du Tamagotchi est propre.");
    }
}

