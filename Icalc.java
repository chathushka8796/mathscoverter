/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.icalc;
import java.util.Scanner;

/**
 *
 * @author chath
 */
public class Icalc {
 
    public static void main(String[] args) {
        System.out.println("          |  \\ /      \\           |  \\           ");
        System.out.println("           \\$$|  $$$$$$\\  ______  | $$  _______ ");
        System.out.println("           __   ______             __           ");
        System.out.println("          |  \\| $$   \\$$ |      \\ | $$ /       \\");
        System.out.println("          | $$| $$        \\$$$$$$\\| $$|  $$$$$$$");
        System.out.println("          | $$| $$   __  /      $$| $$| $$      ");
        System.out.println("          | $$| $$__/  \\|  $$$$$$$| $$| $$_____ ");
        System.out.println("          | $$ \\$$    $$ \\$$    $$| $$ \\$$     \\");
        System.out.println("           \\$$  \\$$$$$$   \\$$$$$$$ \\$$  \\$$$$$$$");
        System.out.println("");
        System.out.println("");
        System.out.println(" _   _                 _                  _____                          _             ");
        System.out.println("| \\ | |               | |                / ____|                        | |            ");
        System.out.println("|  \\| |_   _ _ __ ___ | |__   ___ _ __  | |     ___  _ ____   _____ _ __| |_ ___ _ __  ");
        System.out.println("| . ` | | | | '_ ` _ \\| '_ \\ / _ \\ '__| | |    / _ \\| '_ \\ \\ / / _ \\ '__| __/ _ \\ '__| ");
        System.out.println("| |\\  | |_| | | | | | | |_) |  __/ |    | |___| (_) | | | \\ V /  __/ |  | ||  __/ |    ");
        System.out.println("|_| \\_|\\__,_|_| |_| |_|_.__/ \\___|_|     \\_____\\___/|_| |_|\\_/ \\___|_|   \\__\\___|_|    ");
        
    


    
     
     L0:
        do {
            System.out.println("\t[1] Decimal Converter");
            System.out.println("\t[2] Binary Converter");
            System.out.println("\t[3] Octal Converter");
            System.out.println("\t[4] Hexadecimal Converter");
            System.out.println("\t[5] Roman Number Converter");

            Scanner input = new Scanner(System.in);
            System.out.print("Enter option -> ");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    decimalConverter(input);
                    break;
                case 2:
                    binaryConverter(input);
                    break;
                case 3:
                    octalConverter(input);
                    break;
                case 4:
                    hexadecimalConverter(input);
                    break;
                case 5:
                    romanNumberConverter(input);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (true);
    }

    private static void decimalConverter(Scanner input) {
        L1:
        do {
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.println("|                             Decimal Converter                              |");
            System.out.println("+----------------------------------------------------------------------------+");

            System.out.print("Enter a decimal number -> ");
            int decimal = input.nextInt();

            if (decimal < 0) {
                System.out.println("Invalid Input");
                System.out.print("Do you want to input number again (Y/N) -> ");
                String doagain1 = input.next().toUpperCase();
                if ("Y".equals(doagain1)) {
                    continue;
                } else {
                    break;
                }
            }

            
            String binary = "";
            int tempDecimal = decimal;
            while (tempDecimal > 0) {
                binary = (tempDecimal % 2) + binary;
                tempDecimal = tempDecimal / 2;
            }
            if (binary.isEmpty()) binary = "0";

            
            String octal = "";
            tempDecimal = decimal;
            while (tempDecimal > 0) {
                octal = (tempDecimal % 8) + octal;
                tempDecimal = tempDecimal / 8;
            }
            if (octal.isEmpty()) octal = "0";

            
            String hexadecimal = "";
            tempDecimal = decimal;
            char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            while (tempDecimal > 0) {
                hexadecimal = hexChars[tempDecimal % 16] + hexadecimal;
                tempDecimal = tempDecimal / 16;
            }
            if (hexadecimal.isEmpty()) hexadecimal = "0";

            System.out.println("Binary Number: " + binary);
            System.out.println("Octal Number: " + octal);
            System.out.println("Hexadecimal Number: " + hexadecimal);

            System.out.print("Do you want to go to Home Page (Y/N) -> ");
            String answer = input.next().toUpperCase();
            if ("Y".equals(answer)) {
                break;
            } else {
                System.exit(0);
            }

        } while (true);
    }

    private static void binaryConverter(Scanner input) {
        L1:
        do {
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.println("|                             Binary Converter                               |");
            System.out.println("+----------------------------------------------------------------------------+");

            System.out.print("Enter a binary number -> ");
            String binary = input.next();
            boolean isValid = true;

            for (int i = 0; i < binary.length(); i++) {
                char bit = binary.charAt(i);
                if (bit != '0' && bit != '1') {
                    isValid = false;
                    break;
                }
            }

            if (!isValid) {
                System.out.println("Invalid Input");
                System.out.print("Do you want to input number again (Y/N) -> ");
                String doagain2 = input.next().toUpperCase();
                if ("Y".equals(doagain2)) {
                    continue;
                } else {
                    continue L0;
                }
            }

            int decimalValue = 0;
            for (int i = 0; i < binary.length(); i++) {
                char bit = binary.charAt(binary.length() - 1 - i);
                decimalValue += (bit - '0') * Math.pow(2, i);
            }

            // Binary to Octal
            String octal = "";
            int tempDecimal = decimalValue;
            while (tempDecimal > 0) {
                octal = (tempDecimal % 8) + octal;
                tempDecimal = tempDecimal / 8;
            }
            if (octal.isEmpty()) octal = "0";

            // Binary to Hexadecimal
            String hexadecimal = "";
            tempDecimal = decimalValue;
            char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            while (tempDecimal > 0) {
                hexadecimal = hexChars[tempDecimal % 16] + hexadecimal;
                tempDecimal = tempDecimal / 16;
            }
            if (hexadecimal.isEmpty()) hexadecimal = "0";

            System.out.println("Decimal Number: " + decimalValue);
            System.out.println("Octal Number: " + octal);
            System.out.println("Hexadecimal Number: " + hexadecimal);

            System.out.print("Do you want to go to Home Page (Y/N) -> ");
            String answer = input.next().toUpperCase();
            if ("Y".equals(answer)) {
                break;
            } else {
                System.exit(0);
            }

        } while (true);
    }

    private static void octalConverter(Scanner input) {
        L1:
        do {
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.println("|                               Octal Converter                              |");
            System.out.println("+----------------------------------------------------------------------------+");

            System.out.print("Enter an octal number -> ");
            String octal = input.next();
            boolean isValid = true;

            for (int i = 0; i < octal.length(); i++) {
                char digit = octal.charAt(i);
                if (digit < '0' || digit > '7') {
                    isValid = false;
                    break;
                }
            }

            if (!isValid) {
                System.out.println("Invalid Input");
                System.out.print("Do you want to input number again (Y/N) -> ");
                String doagain3 = input.next().toUpperCase();
                if ("Y".equals(doagain3)) {
                    continue;
                } else {
                    continue L0;
                }
            }

            int decimalValue = 0;
            for (int i = 0; i < octal.length(); i++) {
                char digit = octal.charAt(octal.length() - 1 - i);
                decimalValue += (digit - '0') * Math.pow(8, i);
            }

           
            String binary = "";
            int tempDecimal = decimalValue;
            while (tempDecimal > 0) {
                binary = (tempDecimal % 2) + binary;
                tempDecimal = tempDecimal / 2;
            }
            if (binary.isEmpty()) binary = "0";

            // Octal to Hexadecimal
            String hexadecimal = "";
            tempDecimal = decimalValue;
            char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            while (tempDecimal > 0) {
                hexadecimal = hexChars[tempDecimal % 16] + hexadecimal;
                tempDecimal = tempDecimal / 16;
            }
            if (hexadecimal.isEmpty()) hexadecimal = "0";

            System.out.println("Decimal Number: " + decimalValue);
            System.out.println("Binary Number: " + binary);
            System.out.println("Hexadecimal Number: " + hexadecimal);

            System.out.print("Do you want to go to Home Page (Y/N) -> ");
            String answer = input.next().toUpperCase();
            if ("Y".equals(answer)) {
                break;
            } else {
                System.exit(0);
            }

        } while (true);
    }

    private static void hexadecimalConverter(Scanner input) {
        L1:
        do {
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.println("|                             Hexadecimal Converter                          |");
            System.out.println("+----------------------------------------------------------------------------+");

            System.out.print("Enter a hexadecimal number -> ");
            String hexadecimal = input.next().toUpperCase();
            boolean isValid = true;

            for (int i = 0; i < hexadecimal.length(); i++) {
                char digit = hexadecimal.charAt(i);
                if (!(digit >= '0' && digit <= '9') && !(digit >= 'A' && digit <= 'F')) {
                    isValid = false;
                    break;
                }
            }

            if (!isValid) {
                System.out.println("Invalid Input");
                System.out.print("Do you want to input number again (Y/N) -> ");
                String doagain4 = input.next().toUpperCase();
                if ("Y".equals(doagain4)) {
                    continue;
                } else {
                    continue L0;
                }
            }

            int decimalValue = 0;
            for (int i = 0; i < hexadecimal.length(); i++) {
                char digit = hexadecimal.charAt(hexadecimal.length() - 1 - i);
                decimalValue += Character.digit(digit, 16) * Math.pow(16, i);
            }

            
            String binary = "";
            int tempDecimal = decimalValue;
            while (tempDecimal > 0) {
                binary = (tempDecimal % 2) + binary;
                tempDecimal = tempDecimal / 2;
            }
            if (binary.isEmpty()) binary = "0";

            
            String octal = "";
            tempDecimal = decimalValue;
            while (tempDecimal > 0) {
                octal = (tempDecimal % 8) + octal;
                tempDecimal = tempDecimal / 8;
            }
            if (octal.isEmpty()) octal = "0";

            System.out.println("Decimal Number: " + decimalValue);
            System.out.println("Binary Number: " + binary);
            System.out.println("Octal Number: " + octal);

            System.out.print("Do you want to go to Home Page (Y/N) -> ");
            String answer = input.next().toUpperCase();
            if ("Y".equals(answer)) {
                break;
            } else {
                System.exit(0);
            }

        } while (true);
    }

    private static void romanNumberConverter(Scanner input) {
        L1:
        do {
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.println("|                           Roman Number Converter                           |");
            System.out.println("+----------------------------------------------------------------------------+");

            System.out.println("1. Decimal to Roman");
            System.out.println("2. Roman to Decimal");
            System.out.print("Enter option number -> ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter a positive decimal number -> ");
                    int decimal = input.nextInt();
                    if (decimal < 0) {
                        System.out.println("Invalid Input");
                        System.out.print("Do you want to input number again (Y/N) -> ");
                        String doagain5 = input.next().toUpperCase();
                        if ("Y".equals(doagain5)) {
                            continue;
                        } else {
                            break L1;
                        }
                    }
                    System.out.println("Roman Number: " + decimalToRoman(decimal));
                    break;
                case 2:
                    System.out.print("Enter a Roman number -> ");
                    String roman = input.next().toUpperCase();
                    if (!roman.matches("[IVXLCDM]+")) {
                        System.out.println("Invalid Input");
                        System.out.print("Do you want to input number again (Y/N) -> ");
                        String doagain6 = input.next().toUpperCase();
                        if ("Y".equals(doagain6)) {
                            continue;
                        } else {
                            break L1;
                        }
                    }
                    System.out.println("Decimal Number: " + romanToDecimal(roman));
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    continue;
            }

            System.out.print("Do you want to go to Home Page (Y/N) -> ");
            String answer = input.next().toUpperCase();
            if ("Y".equals(answer)) {
                break;
            } else {
                System.exit(0);
            }

        } while (true);
    }

    private static String decimalToRoman(int num) {
        StringBuilder roman = new StringBuilder();

        while (num >= 1000) {
            roman.append("M");
            num -= 1000;
        }
        while (num >= 900) {
            roman.append("CM");
            num -= 900;
        }
        while (num >= 500) {
            roman.append("D");
            num -= 500;
        }
        while (num >= 400) {
            roman.append("CD");
            num -= 400;
        }
        while (num >= 100) {
            roman.append("C");
            num -= 100;
        }
        while (num >= 90) {
            roman.append("XC");
            num -= 90;
        }
        while (num >= 50) {
            roman.append("L");
            num -= 50;
        }
        while (num >= 40) {
            roman.append("XL");
            num -= 40;
        }
        while (num >= 10) {
            roman.append("X");
            num -= 10;
        }
        while (num >= 9) {
            roman.append("IX");
            num -= 9;
        }
        while (num >= 5) {
            roman.append("V");
            num -= 5;
        }
        while (num >= 4) {
            roman.append("IV");
            num -= 4;
        }
        while (num >= 1) {
            roman.append("I");
            num -= 1;
        }
        return roman.toString();
    }

    private static int romanToDecimal(String roman) {
        int decimal = 0;
        int lastNumber = 0;
        String romanNumeral = roman.toUpperCase();

        for (int x = romanNumeral.length() - 1; x >= 0; x--) {
            char convertToDecimal = romanNumeral.charAt(x);

            switch (convertToDecimal) {
                case 'M':
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;

                case 'D':
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;

                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;

                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;

                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;

                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;

                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
        }
        return decimal;
    }

    private static int processDecimal(int value, int lastNumber, int decimal) {
        if (lastNumber > value) {
            return decimal - value;
        } else {
            return decimal + value;
        }
    }
}
