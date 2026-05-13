package Assignment4;

import java.util.Scanner;

public class Berkeley {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Enter number of clocks: ");
        n = sc.nextInt();

        int[] clocks = new int[n];

        int sum = 0;

        // Input clock times
        for (int i = 0; i < n; i++) {

            System.out.print("Enter time for clock " + (i + 1) + ": ");
            clocks[i] = sc.nextInt();

            sum += clocks[i];
        }

        // Calculate average time
        int average = sum / n;

        System.out.println("\nAverage Time = " + average);

        System.out.println("\nClock Adjustments:");

        // Calculate adjustments
        for (int i = 0; i < n; i++) {

            int adjustment = average - clocks[i];

            System.out.println(
                    "Clock " + (i + 1) +
                            " adjustment = " + adjustment
            );
        }

        System.out.println("\nSynchronized Clock Times:");

        // Display synchronized clocks
        for (int i = 0; i < n; i++) {

            clocks[i] = average;

            System.out.println(
                    "Clock " + (i + 1) +
                            " = " + clocks[i]
            );
        }

        sc.close();
    }
}

//Enter number of clocks: 4
//Enter time for clock 1: 10
//Enter time for clock 2: 12
//Enter time for clock 3: 8
//Enter time for clock 4: 14