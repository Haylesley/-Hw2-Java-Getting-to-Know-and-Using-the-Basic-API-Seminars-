//К калькулятору из предыдущего ДЗ добавить логирование.

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FourthTask {
    private static final Logger logger = Logger.getLogger(FourthTask.class.getName());
    public static void main(String[] args) throws IOException {
        FileHandler fh = new FileHandler("logTask4.txt");
        logger.setUseParentHandlers(false); // для того чтобы логи в консоль не выводить
        logger.addHandler(fh);

        SimpleFormatter sFormatter = new SimpleFormatter();
        fh.setFormatter(sFormatter);
        logger.info("Начало");

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double num1 = sc.nextDouble();
        logger.info("Пользователь ввёл число: " + num1);

        System.out.print("Введите знак: ");
        char ch = sc.next().charAt(0);
        logger.info("Пользователь ввёл знак: " + ch);

        System.out.print("Введите второе число: ");
        double num2 = sc.nextDouble();
        logger.info("Пользователь ввёл число: " + num2);

        double result = 0;

        switch(ch) {
            case '+': result = num1 + num2;
                break;
            case '-': result = num1 - num2;
                break;
            case '*': result = num1 * num2;
                break;
            case '/': result = num1 / num2;
                break;
            default:  System.out.printf("Error! Enter correct operator");
                return;
        }
        System.out.println(num1 + " " + ch + " " + num2 + " = " + result);
        logger.info("Результат: " + result);
        
        sc.close();
    }
}
