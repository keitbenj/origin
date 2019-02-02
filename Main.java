import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        int i;
        int[] k;
        System.out.println("Welcome! This is a program that displays a Fibonacci Series of numbers, wherein each number is the sum of the previous two."); //welcome message
        System.out.println("Do you want to do this recursively or iteratively? (type rec or ite) "); //asks the user whether to use the recursive or iterative methods to calculate the Fibonacci series
        String option = input.nextLine();   //user types their answer here
        if (option.equals("rec")) {
            System.out.println("Please enter a number: ");  //prompts the user to for the length of the series
            n = input.nextInt();    //the length of the Fibonacci
            i = 0;
            k = new int[n];
            long startTime = System.nanoTime();
            fiboSeriesRec(n, i, k); //invokes the recursive series
            long endTime = System.nanoTime();
            System.out.println("Time: " + (endTime - startTime) + " nanoseconds");
        }
        else if(option.equals("ite"))
            System.out.println("Please enter a number: ");  //prompts the user to for the length of the series
            n = input.nextInt();
            k = new int[n];
            fiboSeriesIte(n, k);    //invokes the iterative series
        }
    public static void fiboSeriesRec(int n, int i, int[] k){
        if (i <= 1){
            k[i] = i;
        }
        else{
            k[i] = k[(i-1)] + k[(i-2)];  //each number in the series is the sum of the previous two numbers
        }   //there's a bug that I don't know how to fix, where the numbers start to go negative after around the 47th number
        System.out.print(k[i] + " ");
        i++;
        if (i < n){
            fiboSeriesRec(n, i, k);
        }

    }
    public static void fiboSeriesIte(int n, int k[]){
        long start = System.nanoTime();
        for (int i = 0; i < n; i++){
            if (i<=1){
                k[i] = i;
            }
            else{
                k[i] = k[(i-1)] + k[(i-2)];
            }
            System.out.print(k[i] + " ");
        }
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start) + " nanoseconds");
    }
}
