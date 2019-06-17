package hw5;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== Task 1 ==========");
        System.out.println("Recursive approach = " + recPowerNum(2, 10));
        System.out.println("Loop approach = " + loopPowerNum(2, 10));
        System.out.println("============================\n");
    }

    public static double loopPowerNum(double num, int power) {
        double numInPower = 1;
        for (int i=0; i<power; i++) {
            numInPower = numInPower * num;
        }
        return numInPower;
    }

    public static double recPowerNum(double num, int power) {
        if (power<2) {
            return num;
        }
        return recPowerNum(num, power - 1) * num;
    }
}
