package p0011;

import java.util.Scanner;

public class GetInput {

    public int enterBase() {
        Scanner sc = new Scanner(System.in);
        String input;
        int base;
        do {
            input = sc.nextLine();
            //check empty 
            if (input.isEmpty()) {
                System.out.println("Choice can't be empty. Please re-enter");
                continue;
            }
            try {
                //check valid base
                base = Integer.parseInt(input);
                if (base < 1 || base > 4) {
                    System.out.println("Choice is invalid. Please enter choice in range [1, 4]");
                    continue;
                }
                if(base==4){
                    System.exit(0);
                }
                break;
                //check special character
            } catch (NumberFormatException e) {
                System.out.println("Choice can't contain special character. Please re-enter");
            }
        } while (true);
        return base;
    }

    public String enterValue(int baseInput) {
        Scanner sc = new Scanner(System.in);
        String input;
        do {
            boolean valid = true;
            System.out.print("Enter input value: ");
            input = sc.nextLine();
            //check empty
            if (input.isEmpty()) {
                System.out.println("Input value can't be empty. Please re-enter");
                continue;
            }
            switch (baseInput) {
                case 1:
                    //check binary format
                    for (int i = 0; i < input.length(); i++) {
                        if (input.charAt(i) != '0' && input.charAt(i) != '1') {
                            System.out.println("Binary value can only contain 2 digits: 0 and 1. Please re-enter");
                            valid = false;
                            break;
                        }
                    }
                    break;
                case 2:
                    //check decimal format
                    for (int i = 0; i < input.length(); i++) {
                        if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9')) {
                            System.out.println("Decimal value can only contain numerical digits. Please re-enter");
                            valid = false;
                            break;
                        }
                    }
                    break;
                case 3:
                    //check hexadecimal fomart
                    for (int i = 0; i < input.length(); i++) {
                        if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9' || input.charAt(i) >= 'A' && input.charAt(i) <= 'F')) {
                            System.out.println("Hexadeciaml value can contain digits from 0 to 9 and A to F. Please re-enter");
                            valid = false;
                            break;
                        }
                    }
                    break;
            }
            if (valid == false) {
                continue;
            }
            break;
        } while (true);
        return input;
    }

    boolean checkBase(int baseInput, int baseOutput) {
        if(baseInput==baseOutput){
            System.out.println("Base of output must be different from base of input. Please re-enter");
            return false;        
        }
        return true;
    }
}
