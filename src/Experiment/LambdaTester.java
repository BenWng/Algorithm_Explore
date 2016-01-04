package Experiment;

// From this web page:
// http://www.tutorialspoint.com/java8/java8_lambda_expressions.htm
// It is for testing lambda expressions


public class LambdaTester {
    public static void main(String args[]){
        LambdaTester tester = new LambdaTester();

        //with type declaration
        MyOperation addition = (int a, int b) -> a + b;

        //with out type declaration
        MyOperation subtraction = (a, b) -> a - b;

        //with return statement along with curly braces
        MyOperation multiplication = (int a, int b) -> { return a * b; };

        //without return statement and without curly braces
        MyOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        //with parenthesis
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        //without parenthesis
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Mahesh");
        greetService2.sayMessage("Suresh");
    }

    interface MyOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MyOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
