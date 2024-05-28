package com.codestates.seb.electricityBill;

import java.util.Scanner;

public class ElectricityBill {
    public static void main(String[] args) {
        System.out.println("=".repeat(25));
        System.out.println(" 주택용 전기요금(저압) 계산기 ");
        System.out.println("=".repeat(25));

        int powerUsage = 0;
        System.out.print("전압 입력 -> ");
        Scanner sc = new Scanner(System.in);
        powerUsage = Integer.parseInt(sc.nextLine());

        Calculation calc = new Calculation(powerUsage);
        System.out.printf("%dkWh의 전기 요금은 %.1f원 입니다.\n", powerUsage, calc.getResult(powerUsage));
    }
}
