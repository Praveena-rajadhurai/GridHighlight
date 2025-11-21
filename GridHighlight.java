
import java.util.Random;
import java.util.Scanner;

public class GridHighlight {

    public static void printHeader(int n) {
        System.out.print("    ");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-5s", String.format("%02d", i));
        }
        System.out.println();
    }

    public static void printBorder(int n) {
        System.out.print("   ");
        for (int i = 0; i < n; i++) {
            System.out.print("+----");
        }
        System.out.println("+");
    }

    public static void printGrid(int[][] grid) {
        int n = grid.length;

        System.out.println();
        printHeader(n);
        printBorder(n);

        for (int i = 0; i < n; i++) {
            System.out.printf("%02d ", i);

            for (int j = 0; j < n; j++) {
                System.out.printf("| %-3d", grid[i][j]);
            }
            System.out.println("|");
            printBorder(n);
        }
    }

    public static int printHighlighted(int[][] grid, int target) {
        int n = grid.length;
        int count = 0;

        System.out.println();
        printHeader(n);
        printBorder(n);

        for (int i = 0; i < n; i++) {
            System.out.printf("%02d ", i);

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == target) {
                    System.out.printf("|[%02d]", target);
                    count++;
                } else {
                    System.out.printf("| %-3d", grid[i][j]);
                }
            }
            System.out.println("|");
            printBorder(n);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Enter array size (for NxN array): ");
        int n = sc.nextInt();

        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 2 * (1 + rand.nextInt(10));
            }
        }

        System.out.println("\nGenerated 2D array:");
        printGrid(grid);

        System.out.print("\nEnter a number to highlight (even number 2–20): ");
        int target = sc.nextInt();

        System.out.println("\nArray with " + target + " highlighted:");
        int count = printHighlighted(grid, target);

        System.out.println("\nNumber " + target + " appeared " + count + " time(s)");
    }
}
