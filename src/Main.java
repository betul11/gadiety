import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int maxCalorieIntake;

    public static void main(String[] args) throws IOException {
        Reader3ammo reader = new Reader3ammo();
        reader.CSVReaderMethod();
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Disclaimer: this program is suitable for people between the age of 18 and 65 and don't have health issues," +
                " and the recommendations do not compensate for medical consultation");
        System.out.println("Welcome! Please enter your age.");

        int age = s.nextInt();
        while (age > 65 || age < 18) {
            System.out.println("This program is suitable for users between the age of 18 and 65\n");
            System.out.println("Please enter your age:\n");
            age = s.nextInt();
        }

        System.out.println("Please select your gender: press 1 (for Female)/or 2 (for Male)");
        int gender = s.nextInt();
        while (gender != 1 && gender != 2) {
            System.out.println("Please enter a valid value: choose 1 (for Female)/or 2 (for Male)");
            gender = s.nextInt();
        }
        s.nextLine();

        System.out.println("Are you looking to lose weight? y/n");

        boolean loseWeight = false;
        if (s.nextLine().equals("y")) {
            loseWeight = true;
        }
        calculateMaxCalorie(gender, loseWeight);

        Population population = new Population(GeneticAlgorithm.populationSize).initializePopulation();
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        System.out.println("------------------------");
        System.out.println("Generation #0" + "| Fittest chromosome fitness:" + population.getChromosomes()[0].getFitness());
        printPopulation(population);

        int generationNumber = 0;
        while (generationNumber < 50) {

            generationNumber++;
            System.out.println("\n ---------------------------");
            population = geneticAlgorithm.evolve(population);
            population.sortChromosomesByFitness();
            System.out.println("Generation #" + generationNumber + " | Fittest chromosome fitness:" + population.getChromosomes()[0].getFitness()
                    +" (total grams of protein )");
            printPopulation(population);
        }


    }

    public static void calculateMaxCalorie(int gender, boolean loseWeight) {
        if (loseWeight) {
            if (gender == 1) {
                maxCalorieIntake = 375; // 25% of the recommended average maxCalorieIntake (1500)
            } else {
                maxCalorieIntake = 500; // 25% of the recommended average maxCalorieIntake (2000)
            }
        } else {
            if (gender == 1) {
                maxCalorieIntake = 500; // 25% of the recommended average maxCalorieIntake (2000)
            } else {
                maxCalorieIntake = 625; // 25% of the recommended average maxCalorieIntake (2500)
            }
        }
    }

    public static void printPopulation(Population population) throws IOException {
        printIngredients(population.getChromosomes()[0]);
        System.out.println("------------------------");
        for (int i = 0; i < population.getChromosomes().length; i++) {
            System.out.println("Chromosome #" + i + ":" + Arrays.toString(population.getChromosomes()[i].getGenes()) +
                    "| Fitness " + population.getChromosomes()[i].getFitness());
        }
    }

    public static void printIngredients(Chromosome chromosome) throws IOException {
        Reader3ammo reader = new Reader3ammo();
        reader.CSVReaderMethod();
        int[] genes = chromosome.getGenes();
        for (int i = 0; i < chromosome.getGenesLength(); i++) {
            if (genes[i] == 1) {
                System.out.println(reader.ingredients.get(i).getName() + " , GmWt: "+
                        reader.ingredients.get(i).getGmWeight() +", GmDesc: "+ reader.ingredients.get(i).getGmDesc()
                        + ", protein amount (gr): " + reader.ingredients.get(i).getProtein() + ", calories: "
                        + reader.ingredients.get(i).getCalorie() + " . ");
            }
        }

    }
}
