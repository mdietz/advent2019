package day.one;

import java.io.File;
import java.util.Scanner;

class DayOne {
    public static void main(String[] args)throws Exception {
        File file = new File("/workspace/advent2019/day/one/input.txt"); 
        Scanner scanner = new Scanner(file);
        int total = 0;
        while (scanner.hasNext()) {
          String line = scanner.next();
          total += calculateFuel(Integer.parseInt(line));;
        }
        System.out.println(total);
        scanner.close();
    }

    private static int calculateFuel(int mass) {
      int fuel = Double.valueOf(Math.floor(mass/3.0)).intValue() - 2;
      if (fuel <= 0) {
        return 0;
      } else {
        return fuel + calculateFuel(fuel);
      }
    }
}