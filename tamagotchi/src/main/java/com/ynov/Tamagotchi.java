package com.ynov;

public class Tamagotchi {
    int age;
    int happiness;
    private int happinessMax;
    String state;
    private int nbPlay = 0;
    private int nbEat = 0;
    private boolean isSick;
    private boolean firstDayWithoutEating;
    private boolean secondDayWithoutEating;
    private boolean thirdDayWithoutEating;
    private boolean dirtyEnvironment;

public Tamagotchi () {
    age = 0;
    happiness = 15;
    happinessMax = 50;
    state = "Oeuf";
    this.isSick = false;
    this.firstDayWithoutEating = true;
    this.secondDayWithoutEating = true;
    this.thirdDayWithoutEating = true;
    this.dirtyEnvironment = false;
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
            if (nbEat == 0 && age >= 1) {
                int pointsDeBonheurPerdus = 5;
    
                if (firstDayWithoutEating) {
                    pointsDeBonheurPerdus = 5;
                    firstDayWithoutEating = false;
                } else if (secondDayWithoutEating) {
                    pointsDeBonheurPerdus = 10;
                    secondDayWithoutEating = false;
                } else if (thirdDayWithoutEating) {
                    pointsDeBonheurPerdus = 15;
                    thirdDayWithoutEating = false;
                }
    
                happiness -= pointsDeBonheurPerdus;
                System.out.println("Le Tamagotchi a perdu " + pointsDeBonheurPerdus + " points de bonheur car il n'a pas mangé.");
            } else {
                if (dirtyEnvironment) {
                    happiness -= 3;
                }
                nbEat = 0;
                firstDayWithoutEating = true;
                secondDayWithoutEating = true;
                thirdDayWithoutEating = true;
            }
    
            if (happiness <= 0) {
                age = 0;
                happiness = 15;
                state = "Oeuf";
                System.out.println("Le Tamagotchi est mort de tristesse.");
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

    public void feed() {
        firstDayWithoutEating = false;
        if (nbEat < 1) {
            if (happiness + 5 <= happinessMax) {
                happiness += 5;
            } else {
                happiness = happinessMax;
            }
            nbEat++;
            dirtyEnvironment = true;
            System.out.println("Le Tamagotchi a mangé !");
        } else if (nbEat >= 1) {
            System.out.println("Le Tamagotchi ne veut plus manger pour l'instant.");
            System.out.println("Votre Tamagotchi a déjà mangé, il pourra manger au prochain tour.");
        }
    }
    public void clean() {
        dirtyEnvironment = false;
        System.out.println("L'environnement du Tamagotchi est propre.");
    }
}

