package org.example.menu;


import org.example.model.Dog;
import org.example.model.Cat;
import org.example.model.Bird;
import org.example.model.AnimalId;

import org.example.model.Animal;
import org.example.shelter.Shelter;
import java.util.Scanner;


public class ConsoleMenu {
    private final Shelter<Animal> shelter;
    private final Scanner scanner =  new Scanner(System.in);
    public ConsoleMenu(Shelter<Animal> shelter) {
        this.shelter = shelter;
    }

    public void start(){

        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    System.out.print("Enter animal type (Dog/Cat/Bird): ");
                    String animalType = scanner.nextLine();

                    System.out.print("Enter animal name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter animal age: ");
                    int age = Integer.parseInt(scanner.nextLine());

                    if (animalType.equalsIgnoreCase("Dog")) {
                        shelter.addAnimal(new Dog(new AnimalId(), name, age));
                        System.out.println("Dog added!");

                    } else if (animalType.equalsIgnoreCase("Cat")) {
                        shelter.addAnimal(new Cat(new AnimalId(), name, age));
                        System.out.println("Cat added!");

                    } else if (animalType.equalsIgnoreCase("Bird")) {
                        shelter.addAnimal(new Bird(new AnimalId(), name, age));
                        System.out.println("Bird added!");

                    } else {
                        System.out.println("Unknown animal type!");
                    }
                    break;


                case "2":
                    for (Animal animal : shelter.getAllAnimals()) {
                        System.out.println(animal);
                    }
                    break;


                case "3":
                    System.out.print("Enter species: ");
                    String species = scanner.nextLine();

                    for (Animal animal : shelter.findBySpecies(species)) {
                        System.out.println(animal);
                    }
                    break;



                case "4":
                    for (Animal animal : shelter.findAvailableAnimals()) {
                        System.out.println(animal);
                    }
                    break;


                case "5":
                    System.out.print("Enter animal ID: ");
                    String id = scanner.nextLine();

                    shelter.markAsAdopted(id);
                    break;


                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

    }

    private void printMenu(){
        System.out.println("""
                1. Add animal
                2. List all animals
                3. Find animals by species
                4. List available animals
                5. Mark animal as adopted
                0. Exit
                """);
    }
}
