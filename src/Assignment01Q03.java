public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("The first " + x + " Fibonacci numbers are:");
        
        int numOdd = 0;
        int first = 0;  // The first number of the fibonacci sequence
        int second = 1; // The second number of the fibonacci sequence
                        // We will change both of these numbers as we run along the sequence
        for (int i = 0; i < x; i++) {
            System.out.print(first);
            // Check if the current number in the sequence is odd
            if (first % 2 == 1) {
                numOdd++;
            }

            // Go to the next number in the sequence
            int next = first + second;
            first = second;
            second = next;
            if (i < x - 1) 
                System.out.print(" "); // Make sure we don't print a trailing space
        }
        System.out.println();
        
        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
