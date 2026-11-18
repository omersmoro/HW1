import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        if (direction != 'R' && direction != 'L') {
            return array;
        }

        int n = array.length;

        if (n == 0) {
            return array;
        }

        // No need to shift more than the array length
        move = move % n;

        if (move == 0) {
            return array;
        }

        // Convert negative moves into the opposite direction
        if (move < 0) {
            move = -move;
            if(direction == 'R'){
                direction = 'L';
            }
            else{
                direction = 'R';
            }
        }

        // Convert right shifts into equivalent left shifts
        if (direction == 'R') {
            move = n - move;
        }

        // Perform the left shift
        for (int i = 0; i < move; i++) {
            int first = array[0];

            for (int j = 0; j < n - 1; j++) {
                array[j] = array[j + 1];
            }

            array[n - 1] = first;
        }


        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}