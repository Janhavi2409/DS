import mpi.*;

public class Assignment2 {

    public static void main(String[] args) throws Exception {

        // Initialize MPI
        MPI.Init(args);

        // Rank of current process
        int rank = MPI.COMM_WORLD.Rank();

        // Total number of processes
        int size = MPI.COMM_WORLD.Size();

        // Array elements
        int[] array = {10, 20, 30, 40, 50, 60, 70, 80};

        int n = array.length;

        // Number of elements per process
        int elementsPerProcess = n / size;

        // Local array for each process
        int[] localArray = new int[elementsPerProcess];

        // Scatter array elements to all processes
        MPI.COMM_WORLD.Scatter(
                array,
                0,
                elementsPerProcess,
                MPI.INT,
                localArray,
                0,
                elementsPerProcess,
                MPI.INT,
                0
        );

        // Calculate local sum
        int localSum = 0;

        for (int i = 0; i < elementsPerProcess; i++) {

            localSum += localArray[i];
        }

        // Display local sum
        System.out.println("Process " + rank +
                " calculated local sum = " + localSum);

        // Array to store final sum at root process
        int[] globalSum = new int[1];

        // Reduce all local sums into global sum
        MPI.COMM_WORLD.Reduce(
                new int[]{localSum},
                0,
                globalSum,
                0,
                1,
                MPI.INT,
                MPI.SUM,
                0
        );

        // Root process displays final sum
        if (rank == 0) {

            System.out.println("\nFinal Sum = " + globalSum[0]);
        }

        // Finalize MPI
        MPI.Finalize();
    }
}

//Execute:
//1. File -> Project Structure -> Libraries
//2. Add mpj.jar
//3. Path: C:\mpj\lib\mpj.jar
//4. javac -cp "C:\Users\janha\Downloads\mpj-v0_44\mpj-v0_44\lib\mpj.jar" Assignment2.java
//5. mpjrun.bat -np 4 Assignment2
