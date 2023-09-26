import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // вызов task1()
        System.out.println(task1());
        //вызов task2()
        task2();

        //task3
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        }
        //Изменен порядок вызова обработок исключений
        catch (IndexOutOfBoundsException ex1) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
        catch (NullPointerException ex2) {
            System.out.println("Указатель не может указывать на null!");
        }
        catch (Throwable ex3) {
            System.out.println("Что-то пошло не так...");
        }
        //end_task3

        //task4
        try {
            task4();
        } catch (ExceptionForTask4 e){
            System.out.println(e.getMessage());
        }

    }

    public static float task1(){
        //Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
        //и возвращает введенное значение. Ввод текста вместо числа не должно приводить к
        //падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

        Scanner scanner = new Scanner(System.in);
        boolean flag1 = true;
        float res1 = 0;


        while (flag1) {
            System.out.print("Введите число: ");
            String st1 = scanner.nextLine();
            try{ res1 = Float.parseFloat(st1);

            } catch (NumberFormatException e) {
                System.out.println("Введена строка. Требуется ввести число.");
                continue;
            }

            flag1 = false;
        }
        return res1;
    }

    public static void task2(){
        //Если необходимо, исправьте данный код
        try {
            int d = 0;
            int[] intArray = new int[]{1,2,3,4,5,6,7,8,9};//Добавлено объявление массива
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

    }

    //метод для task3

    public static void printSum(Integer a, Integer b) {//Убрал выброс исключения. Непонятно зачем оно здесь.
        System.out.println(a + b);
    }

    public static void task4() throws ExceptionForTask4{
        //Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
        //Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String st2 = scanner.nextLine();

        if (st2.isEmpty()){
            throw new ExceptionForTask4("Пустую строку вводить нельзя.");
        }
    }

    public static class ExceptionForTask4 extends Exception{
        public ExceptionForTask4(String message) {
            super(message);
        }

    }

}
