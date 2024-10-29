package org.example.ndl011;

import java.util.Scanner;

public class App {
    private static final int MAX_BUS_LOAD = 4;
    private static final int MAX_FAMILIES_PER_BUS = 2;

    private static int getBus(int[] familySizes) {
        int totalBus = 0;
        int currentBusLoad = 0;
        int familiesInBus = 0;

        for (int size : familySizes) {
            if (size > MAX_BUS_LOAD) {
                totalBus += (size / MAX_BUS_LOAD) + (size % MAX_BUS_LOAD != 0 ? 1 : 0);
            } else {
                if (currentBusLoad + size > MAX_BUS_LOAD || familiesInBus == MAX_FAMILIES_PER_BUS) {
                    totalBus++;
                    currentBusLoad = size;
                    familiesInBus = 1;
                } else {
                    currentBusLoad += size;
                    familiesInBus++;
                }
            }
        }

        if (currentBusLoad > 0) {
            totalBus++;
        }

        return totalBus;
    }

    public void start(Scanner scanner) {
        System.out.print("Input the number of families: ");
        int numberOfFamilies = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Input the number of members in the family (separated by a space): ");
        String[] membersInput = scanner.nextLine().split(" ");

        if (numberOfFamilies != membersInput.length) {
            System.out.println("Input must be equal with count of families.");
            return;
        }

        int[] familySizes = new int[numberOfFamilies];
        for (int index = 0; index < numberOfFamilies; index++) {
            try {
                familySizes[index] = Integer.parseInt(membersInput[index]);
                if (familySizes[index] < 0) {
                    System.out.println("Family members count cannot be negative.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: Please enter integers only.");
                return;
            }
        }

        int minimumBuses = getBus(familySizes);
        System.out.println("Minimum bus required is : " + minimumBuses);
    }
}