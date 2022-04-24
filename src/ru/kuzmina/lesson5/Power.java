package ru.kuzmina.lesson5;

public class Power {
    public static double calc(double number, int power){
        if (power == 0) {
            return 1;
        } else if (power > 0) {
            return number * calc(number, power - 1);
        }
        return 1 / number * calc(number, power + 1);
    }

}
