import java.util.Random;

public class task_3 {

    public static void main(String[] args) {
        int[] array = new int[20];

        // Заполнение массива случайными числами от -10 до 10
        fillArray(array);

        // Вывод исходного массива
        System.out.println("Исходный массив:");
        printArray(array);

        // Поиск максимального отрицательного и минимального положительного элементов
        int maxNegative = findMaxNegative(array);
        int minPositive = findMinPositive(array);

        // Вывод максимального отрицательного и минимального положительного элементов
        System.out.println("Максимальный отрицательный элемент: " + maxNegative);
        System.out.println("Минимальный положительный элемент: " + minPositive);

        // Поменять местами максимальный отрицательный и минимальный положительный
        // элементы
        swapMaxNegativeAndMinPositive(array);

        // Вывод измененного массива
        System.out.println("Измененный массив:");
        printArray(array);
    }

    // Метод для заполнения массива случайными числами от -10 до 10
    public static void fillArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(21) - 10; // от -10 до 10
        }
    }

    // Метод для поиска максимального отрицательного элемента в массиве
    public static int findMaxNegative(int[] array) {
        int maxNegative = Integer.MIN_VALUE;
        boolean foundNegative = false;
        for (int num : array) {
            if (num < 0 && num > maxNegative) {
                maxNegative = num;
                foundNegative = true;
            }
        }
        return foundNegative ? maxNegative : 0; // Возвращаем 0, если не найдено отрицательных чисел
    }

    // Метод для поиска минимального положительного элемента в массиве
    public static int findMinPositive(int[] array) {
        int minPositive = Integer.MAX_VALUE;
        boolean foundPositive = false;
        for (int num : array) {
            if (num > 0 && num < minPositive) {
                minPositive = num;
                foundPositive = true;
            }
        }
        return foundPositive ? minPositive : 0; // Возвращаем 0, если не найдено положительных чисел
    }

    // Метод для вывода массива на экран
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Метод для обмена местами максимального отрицательного и минимального
    // положительного элементов
    public static void swapMaxNegativeAndMinPositive(int[] array) {
        int maxNegativeIndex = -1;
        int minPositiveIndex = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0 && array[i] == findMaxNegative(array)) {
                maxNegativeIndex = i;
            }
            if (array[i] >= 0 && array[i] == findMinPositive(array)) {
                minPositiveIndex = i;
            }
        }

        if (maxNegativeIndex != -1 && minPositiveIndex != -1) {
            int temp = array[maxNegativeIndex];
            array[maxNegativeIndex] = array[minPositiveIndex];
            array[minPositiveIndex] = temp;
        }
    }
}
