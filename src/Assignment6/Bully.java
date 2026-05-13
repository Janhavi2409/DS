package Assignment6;

import java.util.Scanner;

public class Bully {

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

        // Highest process initially coordinator
        int coordinator = processes[n - 1];

        System.out.println(
                "\nInitial Coordinator is Process "
                        + coordinator
        );

        // Coordinator failure
        System.out.print(
                "\nEnter process number which fails: ");

        int failed = sc.nextInt();

        System.out.println(
                "Process " + failed + " failed"
        );

        // Start election
        System.out.print(
                "\nEnter process initiating election: ");

        int initiator = sc.nextInt();

        System.out.println(
                "\nElection started by Process "
                        + initiator
        );

        // Send election messages
        for (int i = initiator; i < n; i++) {

            if (processes[i] != failed) {

                System.out.println(
                        "Election message sent from Process "
                                + initiator
                                + " to Process "
                                + processes[i]
                );
            }
        }

        // Find new coordinator
        int newCoordinator = -1;

        for (int i = n - 1; i >= 0; i--) {

            if (processes[i] != failed) {

                newCoordinator = processes[i];
                break;
            }
        }

        System.out.println(
                "\nNew Coordinator is Process "
                        + newCoordinator
        );

        sc.close();
    }
}

//Input: 5, 5, 2