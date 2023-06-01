package com.ynov;

import java.util.Scanner;

public class Tamagotchi {
    int age;
    int happiness;
    private int happinessMax;
    String state;
    private int nbPlay = 0;
    private int nbEat = 0;
    private boolean isSick;
    private boolean firstDayWithoutEating;
    private boolean badEnvironment;

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
            badEnvironment = true;
            System.out.println("Le Tamagotchi a mangé !");
        } else if (nbEat >= 1) {
            System.out.println("Le Tamagotchi ne veut plus manger pour l'instant.");
            System.out.println("Votre Tamagotchi a déjà mangé, il pourra manger au prochain tour.");
        }
    }
    public void clean() {
        badEnvironment = false;
        System.out.println("L'environnement du Tamagotchi est propre.");
    }

    public void heal() {
        isSick = false;
        System.out.println("Le Tamagotchi est guéri !");
    }

	public static void main(String[] args) {
		Tamagotchi tamagotchi = new Tamagotchi();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean continuer = true;

            while (continuer) {
                System.out.println("Le Tamagotchi est " + tamagotchi.isSick + ".");
                System.out.println("Le Tamagotchi est un " + tamagotchi.state + ".");
                System.out.println("Le Tamagotchi a " + tamagotchi.age + " ans.");
                System.out.println("Le Tamagotchi a " + tamagotchi.happiness + " de bonheur.");
                System.out.println("Que voulez-vous faire ?");
                System.out.println("1 : Passer une unité de temps");
                System.out.println("2 : Nourrir le Tamagotchi");
                System.out.println("3 : Jouer avec le Tamagotchi");
                System.out.println("4 : Nettoyer l'environnement du Tamagotchi");
                System.out.println("5 : Soigner le Tamagotchi");
                System.out.println("6 : Quitter");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        tamagotchi.UnitTime();
                        break;
                    case 2:
                        tamagotchi.feed();
                        break;
                    case 3:
                        tamagotchi.play();
                        break;
                    case 4:
                        tamagotchi.clean();
                        break;
                    case 5:
                        tamagotchi.heal();
                        break;
                    case 6:
                        continuer = false;
                        break;
                    default:
                        System.out.println("Choix invalide !");
                        break;
                }
            }
		}
    }
}
       

