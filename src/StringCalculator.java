import java.util.ArrayList;
import java.util.Scanner;


public class StringCalculator {
    static Scanner scanner = new Scanner(System.in);
    static int number;
    static char operator;
    static String result = "";


    public static void main(String[] args) throws Exception {
        String userInput = scanner.nextLine();
        char[] userChar = new char[25];
        ArrayList<String> strBlock00 = new ArrayList<>(10);

        for (int i = 0; i < userInput.length(); i++) {
            userChar[i] = userInput.charAt(i);
            if (userChar[i] == '+') {
                operator = '+';
            }
            if (userChar[i] == '-') {
                operator = '-';
            }
            if (userChar[i] == '*') {
                operator = '*';
            }
            if (userChar[i] == '/') {
                operator = '/';
            }
        }

        String[] blocks = userInput.split("[+-/*\"]");

        if (blocks.length == 5) {
            String st00 = blocks[0];
            String st01 = blocks[1];
            String st02 = blocks[2];
            String st03 = blocks[3];
            String st04 = blocks[4];
            result = calculated(st01, st04, operator);
            printResult(result);
        } else {
            String st01 = blocks[1];
            String st03 = blocks[3];
            number = Integer.parseInt(st03);
            result = calculated(st01, number, operator);
            printResult(result);
        }
    }
    public static String calculated(String num1, String num2, char op) throws Exception{

        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                int index = num1.indexOf(num2);
                if (index == -1){
                    result = num1;
                }
                else{
                    result = num1.substring(0, index);
                    result += num1.substring(index+num2.length());
                    }
                break;

            case '*':
                throw new Exception("Неверный знак операции. Введите + или -");

            case '/':
                throw new Exception("Обратите внимание на знак операции. Введите + или -");
            }
        return result;
    }

    public static String calculated(String num1, int num, char op) throws Exception{
            switch (op) {
                case '+':
                    throw new Exception("Обратите внимание на оператор. Введите * или /");
                case '-':
                    throw new Exception("Введен неверный оператор. Введите * или /");

                case '*':
                    if(num>=1 && num<=10) {
                        for (int u = 0; u < num; u++) {
                            result += num1;
                        }
                    }else if(num<1 || num>10){
                        throw new Exception("Умножать можно только на целое число от 1 до 10");
                    }
                    break;

                case '/':
                    if(num>=1 && num<=10) {
                    int resultB = num1.length() / num;
                    result = num1.substring(0, resultB);
                    }else if(num<1 || num>10){
                        throw new Exception("Делить можно только на целое число от 1 до 10");
                    }else {
                    if (num1.length() < num) {
                        throw new Exception("Делимое не может меньше делителя");
                    }
                }
                    break;
            default:
                throw new Exception("Неверный знак операции");
        }
        return result;
    }
    static void printResult(String text){
        System.out.println("\""+text+"\"");
    }
}