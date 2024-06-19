package se.lexicon;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Original code
        int size = NameRepository.getSize();
        System.out.println("Initial size: " + size);

        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        System.out.println("Size after setting names: " + NameRepository.getSize());

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nName Repository Menu:");
            System.out.println("1. Show all names");
            System.out.println("2. Add a name");
            System.out.println("3. Find a name");
            System.out.println("4. Find by first name");
            System.out.println("5. Find by last name");
            System.out.println("6. Update a name");
            System.out.println("7. Remove a name");
            System.out.println("8. Show amount of names");
            System.out.println("9. Clear all names");
            System.out.println("10. Replace all existing names with new ones");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    String[] allNames = NameRepository.findAll();
                    System.out.println("All names: ");
                    for (String name : allNames) {
                        System.out.println(name);
                    }
                    break;
                case 2:
                    System.out.print("Enter the full name to add: ");
                    String nameToAdd = scanner.nextLine();
                    if (NameRepository.add(nameToAdd)) {
                        System.out.println("Name added successfully.");
                    } else {
                        System.out.println("Name already exists.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the full name to find: ");
                    String nameToFind = scanner.nextLine();
                    String foundName = NameRepository.find(nameToFind);
                    if (foundName != null) {
                        System.out.println("Found name: " + foundName);
                    } else {
                        System.out.println("Name not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the first name to search: ");
                    String firstName = scanner.nextLine();
                    String[] namesWithFirstName = NameRepository.findByFirstName(firstName);
                    System.out.println("Names with first name " + firstName + ": ");
                    for (String name : namesWithFirstName) {
                        System.out.println(name);
                    }
                    break;
                case 5:
                    System.out.print("Enter the last name to search: ");
                    String lastName = scanner.nextLine();
                    String[] namesWithLastName = NameRepository.findByLastName(lastName);
                    System.out.println("Names with last name " + lastName + ": ");
                    for (String name : namesWithLastName) {
                        System.out.println(name);
                    }
                    break;
                case 6:
                    System.out.print("Enter the original name to update: ");
                    String originalName = scanner.nextLine();
                    System.out.print("Enter the new name: ");
                    String updatedName = scanner.nextLine();
                    if (NameRepository.update(originalName, updatedName)) {
                        System.out.println("Name updated successfully.");
                    } else {
                        System.out.println("Update failed. Original name not found or updated name already exists.");
                    }
                    break;
                case 7:
                    System.out.print("Enter the name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    if (NameRepository.remove(nameToRemove)) {
                        System.out.println("Name removed successfully.");
                    } else {
                        System.out.println("Name not found.");
                    }
                    break;
                case 8:
                    System.out.println("Amount of names: " + NameRepository.getSize());
                    break;
                case 9:
                    NameRepository.clear();
                    System.out.println("All names cleared.");
                    break;
                case 10:
                    System.out.println("Enter the names to change (separated by commas): ");
                    String namesLine = scanner.nextLine();
                    String[] newNames = namesLine.split(",\\s*");
                    NameRepository.setNames(newNames);
                    System.out.println("Names have been changed.");
                    break;
                case 11:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
