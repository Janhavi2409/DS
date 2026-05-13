package Assignment5;

import java.util.Scanner;

public class TokenRing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Enter number of processes: ");
        n = sc.nextInt();

        int[] processes = new int[n];

        // Initialize processes
        for (int i = 0; i < n; i++) {

            processes[i] = i + 1;
        }

        int token = 0;

        int choice;

        do {

            System.out.println("\nProcesses are:");

            for (int i = 0; i < n; i++) {

                System.out.print(processes[i] + " ");
            }

            System.out.println("\nToken at process: " +
                    processes[token]);

            System.out.print(
                    "\nEnter process number to enter critical section: ");

            int request = sc.nextInt();

            // Find requested process
            while (processes[token] != request) {

                System.out.println(
                        "Token passed from Process "
                                + processes[token]
                                + " to Process "
                                + processes[(token + 1) % n]
                );

                token = (token + 1) % n;
            }

            // Critical section execution
            System.out.println(
                    "\nProcess " + request +
                            " entered Critical Section");

            System.out.println(
                    "Process " + request +
                            " exiting Critical Section");

            // Pass token
            token = (token + 1) % n;

            System.out.println(
                    "Token passed to Process "
                            + processes[token]
            );

            System.out.print("\nContinue? (1-Yes / 0-No): ");
            choice = sc.nextInt();

        } while (choice == 1);

        sc.close();
    }
}

//Input: 4, 3