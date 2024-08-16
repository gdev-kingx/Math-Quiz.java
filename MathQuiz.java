import java.util.*;

public class MathQuiz {
    private static final String[] OPERATORS = {"+", "-", "*"};
    private static final int MIN_OPERAND = 3;
    private static final int MAX_OPERAND = 12;
    private static final int TOTAL_PROBLEMS = 10;

    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int wrong = 0;
        System.out.println("Press Enter to Start!");
        scanner.nextLine();
        System.out.println("----------------------");

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < TOTAL_PROBLEMS; i++) {
            String[] problem = generateProblem();
            String expr = problem[0];
            int answer = Integer.parseInt(problem[1]);

            while (true) {
                System.out.print("Problem #" + (i + 1) + ": " + expr + " = ");
                String guess = scanner.nextLine();
                if (guess.equals(String.valueOf(answer))) {
                    break;
                }
                wrong++;
            }
        }

        long endTime = System.currentTimeMillis();
        double totalTime = (endTime - startTime) / 1000.0;

        System.out.println("----------------------");
        System.out.printf("Nice Work! You Finished in %.2f seconds!%n", totalTime);

        scanner.close();
    }

    private static String[] generateProblem() {
        int left = random.nextInt(MAX_OPERAND - MIN_OPERAND + 1) + MIN_OPERAND;
        int right = random.nextInt(MAX_OPERAND - MIN_OPERAND + 1) + MIN_OPERAND;
        String operator = OPERATORS[random.nextInt(OPERATORS.length)];

        String expr = left + " " + operator + " " + right;
        int answer = 0;

        switch (operator) {
            case "+":
                answer = left + right;
                break;
            case "-":
                answer = left - right;
                break;
            case "*":
                answer = left * right;
                break;
        }

        return new String[]{expr, String.valueOf(answer)};
    }
}