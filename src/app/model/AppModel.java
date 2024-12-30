package app.model;

import java.util.Random;

public class AppModel {
    private final Random random = new Random();

    public int[] createTestArray() {

        int size = 10;
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public int getRandomNumber() {
        return random.nextInt(100);
    }
}
