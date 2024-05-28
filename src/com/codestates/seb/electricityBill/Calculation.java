package com.codestates.seb.electricityBill;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    private int powerUsage;

    public Calculation(int powerUsage) {
    }

    private double calculation(int powerUsage) {
        // 300이라면 -> 1 ~ 100, 101~200 (100), 201~300 (100)
        // 100kWh 125.9원, 200kWh 초과는 187.9원
        // 300kWh 초과는 280.6원, 400kWh 초과는 417.7원
        // 500kWh 초과는 670.6원, 그 외에는 1000.0
        if (powerUsage == 0) return 0;
        else if (powerUsage < 0) return -1;

        double result = 0;
        int cnt = 0;
        int remain = 0;

        List<Integer> power = new ArrayList<>();

        //  사용량 100단위로 분할
        if (powerUsage > 100) { // 150
            cnt = powerUsage / 100;
            for (int i = 0; i < cnt; i++) {
                power.add(100);
            }
            if (powerUsage % 100 != 0) power.add(powerUsage % 100);
        } else power.add(powerUsage);

        // 조건문
        for (int i = 0; i < power.size(); i++) {  // i의 수가 높아질수록
                switch (i) {
                    case 0: // ~ 100
                        result += (power.get(i) * 60.7);
                        break;
                    case 1: // 101 ~ 200
                        result += (power.get(i) * 125.9);
                        break;
                    case 2: // 201 ~ 300
                        result += (power.get(i) * 187.9);
                        break;
                    case 3: // 301 ~ 400
                        result += (power.get(i) * 280.6);
                        break;
                    case 4: // 401 ~ 500
                        result += (power.get(i) * 417.7);
                        break;
                    case 5: // 501 ~ 600
                        result += (power.get(i) * 670.6);
                        break;
                    default:
                        result += (power.get(i) * 1000.0);
                        break;
            }
        }

        return result;
    }

    public double getResult(int powerUsage) {
        return calculation(powerUsage);
    }
}
