public class Main {

    // Метод, выбрасывающий исключение
    public static void riskyMethod(int value) throws CustomException {
        if (value < 0) {
            throw new CustomException("Value cannot be negative: " + value);
        } else {
            System.out.println("Value is valid: " + value);
        }
    }

    // Метод, перехватывающий исключение
    public static void handleException() {
        try {
            riskyMethod(-5);
        } catch (CustomException e) {
            System.out.println("Exception caught: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Запуск программы
    public static void main(String[] args) {
        handleException();
    }
}
