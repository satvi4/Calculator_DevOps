package Calc;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public Calculator() {
    }

    public double getSquareRoot(double num) {
        logger.info("SQUARE ROOT-" + num);
        double ans = Math.sqrt(num);
        logger.info("SQUARE ROOT-" + num + "-ANSWER " + ans);
        return ans;
    }
    public double fact(double num) {
        double factorial = 1;
        for(int i = 1; i <= num; i++)
            factorial = factorial * i;
        return  factorial;
    }
    public double getFactoral(double num) {
        logger.info("FACTORIAL-" + num);
        double ans = fact(num);
        logger.info("FACTORIAL-" + num + "-ANSWER " + ans);
        return ans;
    }

    public double getPower(double num, double power) {
        logger.info("POWER-" + num + " RAISED TO " + power);
        double ans = Math.pow(num, power);
        logger.info("POWER-" + num + " RAISED TO " + power + "-ANSWER " + ans);
        return ans;
    }

    public double getNaturalLog(double num) {
        logger.info("NATURAL LOG-" + num);
        double ans = 0;
        try {

            if (num <0 ) {
                ans = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            }
            else {
                ans = Math.log(num);
            }
        } catch (ArithmeticException error) {
            System.out.println("EXCEPTION LOG-Cannot find log of negative numbers " + error.getLocalizedMessage());
        }
        logger.info("NATURAL LOG-" + num + "-ANSWER " + ans);
        return ans;
    }
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        boolean loop = true;
        while(loop) {
            System.out.println("Calculator : ");
            System.out.print("1 : Factorial\n2 : Square Root\n3 : Power\n4 Natural Logarithm\n" +
                    "5 : Exit\nChoose Your Choice : ");
            int ch;
            try {
                ch = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }
            if(ch == 1) // do factorial
            {
                System.out.print("Enter Number : ");
                num1 = scanner.nextDouble();
                System.out.println("Factorial of "+num1+" is : " + calc.getFactoral(num1));
                System.out.println("\n");
            }

            else if(ch == 2) // find square root
            {
                System.out.print("Enter a number : ");
                num1 = scanner.nextDouble();
                System.out.println("Square root of "+num1+" is : " + calc.getSquareRoot(num1));
                System.out.println("\n");
            }

            else if(ch == 3) // find power
            {
                System.out.print("Enter the number : ");
                num1 = scanner.nextDouble();
                System.out.print("Enter the power of the number : ");
                num2 = scanner.nextDouble();
                System.out.println(num1+ " raised to power "+num2+" is : " + calc.getPower(num1, num2));
                System.out.println("\n");
            }

            else if(ch == 4) // find natural log
            {
                System.out.print("Enter a number : ");
                num1 = scanner.nextDouble();
                System.out.println("Natural log of "+num1+" is : " + calc.getNaturalLog(num1));
                System.out.println("\n");
            }

            else
            {
                System.out.println("Exiting....");
                loop = false;
                return;
            }
        }
    }
}
