import java.util.Random;

public class Main {
    /**
     * Replicates the profileMultiSet timing experiment from Python.
     * Note: Changed main signature slightly to standard args, and passing 'n' as a parameter.
     */
    public static void profileMultiSet(MultiSet myInput, int n) {
        // Equivalent to items_added = []
        int[] itemsAdded = new int[n];
        Random random = new Random();

        // 1. Add n random items (values between 0 and 100 inclusive)
        for (int i = 0; i < n; i++) {
            int x = random.nextInt(101); // bound is exclusive, matches randint(0, 100)
            myInput.add(x);
            itemsAdded[i] = x;
        }

        // Sanity check that we added n items (Ensure -ea JVM flag is enabled for asserts)
        assert myInput.size() == n : "Size must equal n";

        // 2. Track start time (using high-precision nanoTime)
        long startTime = System.nanoTime();

        // 3. Remove all items
        for (int x : itemsAdded) {
            myInput.remove(x);
        }

        // Track end time
        long endTime = System.nanoTime();

        // Convert duration from nanoseconds to seconds for decimal match
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;

        // Sanity check that we successfully removed all items
        assert myInput.is_empty() : "MultiSet should be empty";

        // 4. Print summary with formatting matching Python's rjust
        String classLabel = myInput.getClass().toString();
        System.out.printf("%5d %37s  %.6f%n", n, classLabel, durationInSeconds);
    }

    public static void main(String[] args) {
        // Example execution setup with a test size
        int n = 10000;

        // Example instantiation (Assuming you have implemented TreeMultiSet or ListMultiSet)
        // MultiSet myInput = new TreeMultiSet();
        // profileMultiSet(myInput, n);
    }
}
