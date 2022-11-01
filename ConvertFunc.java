package p0011;

import static java.lang.Math.pow;
import java.math.BigInteger;

public class ConvertFunc {

    public String convertValue(int baseInput, int baseOutput, String inputValue) {
        String result = "";
        if (baseInput == 1 && baseOutput == 2) { //convert binary to decimal
            result = BiToDec(inputValue);
        } else if (baseInput == 1 && baseOutput == 3) { //convert binary to hexadecimal
            result = BiToHex(inputValue);
        } else if (baseInput == 2 && baseOutput == 1) { //convert decimal to binary
            result = DecToBi(inputValue);
        } else if (baseInput == 2 && baseOutput == 3) { //convert decimal to hexadecimal
            result = DecToHex(inputValue);
        } else if (baseInput == 3 && baseOutput == 1) { //convert hexadecimal to binary
            result = HexToBi(inputValue);
        } else if (baseInput == 3 && baseOutput == 2) { //convert hexadecimal to decimal
            result = HexToDec(inputValue);
        }
        return result;
    }

    private String BiToDec(String input) {
        String result;
        BigInteger convert = new BigInteger("0");
        BigInteger baseInput = new BigInteger("2");
        //loop to access each digit of binary string from left to right
        for (int i = 0; i < input.length(); i++) {
            BigInteger element = BigInteger.valueOf(Character.getNumericValue(input.charAt(i))).multiply(baseInput.pow(input.length() - 1 - i));
            convert = convert.add(element);
        }
        result = convert.toString();
        return result;
    }

    private String BiToHex(String input) {
        String result = "";
        //add missing 0
        while (input.length() % 4 != 0) {
            input = "0" + input;
        }
        //Split each 4 digit of binary string to a block of binary string
        String[] blocks = input.split("(?<=\\G....)");
        // \G: matches the point where the last match finished.
        // ....: followed by four characters
        // ?<= : before it(via zero-width positive lookbehind)
        //first loop to access to each of binary string
        for (String block : blocks) {
            int convert = 0;
            //second loop to access to each digit of the block
            for (int j = 0; j < block.length(); j++) {
                int add = Character.getNumericValue(block.charAt(j)) * (int) pow(2, block.length() - j - 1);
                convert += add;
            }
            if (convert >= 10) {
                switch (convert) {
                    case 10:
                        result = result + "A";
                        break;
                    case 11:
                        result = result + "B";
                        break;
                    case 12:
                        result = result + "C";
                        break;
                    case 13:
                        result = result + "D";
                        break;
                    case 14:
                        result = result + "E";
                        break;
                    case 15:
                        result = result + "F";
                        break;
                }
            } else {
                result = result + convert;
            }
        }
        return result;
    }

    private String DecToBi(String input) {
        String result = "";
        BigInteger dividend = new BigInteger(input);
        //Divide continuously by the base 2 to get the digits from the remainders until the quotient is 0
        while (dividend.signum() > 0) {
            result = (dividend.remainder(BigInteger.valueOf(2))) + result;
            dividend = dividend.divide(BigInteger.valueOf(2));
        }
        return result;
    }

    private String DecToHex(String input) {
        String result = "";
        BigInteger dividend = new BigInteger(input);
        //Divide continuously by the base 16 to get the digits from the remainders until the quotient is 0
        while (dividend.signum() > 0) {
            if (dividend.remainder(BigInteger.valueOf(16)).compareTo(BigInteger.valueOf(10)) < 0) {
                result = (dividend.remainder(BigInteger.valueOf(16))).toString() + result;
            } else {
                switch (dividend.remainder(BigInteger.valueOf(16)).intValue()) {
                    case 10:
                        result = "A" + result;
                        break;
                    case 11:
                        result = "B" + result;
                        break;
                    case 12:
                        result = "C" + result;
                        break;
                    case 13:
                        result = "D" + result;
                        break;
                    case 14:
                        result = "E" + result;
                        break;
                    case 15:
                        result = "F" + result;
                        break;
                }
            }
            dividend = dividend.divide(BigInteger.valueOf(16));
        }
        return result;
    }

    private String HexToDec(String input) {
        BigInteger convert = new BigInteger("0");
        BigInteger baseInput = new BigInteger("16");
        //loop to access to each elemnets of hexa string
        for (int i = 0; i < input.length(); i++) {
            BigInteger element;
            if (Character.isDigit(input.charAt(i))) {
                element = BigInteger.valueOf(Character.getNumericValue(input.charAt(i))).multiply(baseInput.pow(input.length() - 1 - i));
            } else {
                int num = 0;
                switch (input.charAt(i)) {
                    case 'A':
                        num = 10;
                        break;
                    case 'B':
                        num = 11;
                        break;
                    case 'C':
                        num = 12;
                        break;
                    case 'D':
                        num = 13;
                        break;
                    case 'E':
                        num = 14;
                        break;
                    case 'F':
                        num = 15;
                        break;
                }
                element = BigInteger.valueOf(num).multiply(baseInput.pow(input.length() - 1 - i));
            }
            convert = convert.add(element);
        }
        String result = convert.toString();
        return result;
    }

    private String HexToBi(String input) {
        String result = "";
        //loop to access to each elements of hexa string
        for (int i = input.length() - 1; i >= 0; i--) {
            int dividend = 0;
            if (Character.isDigit(input.charAt(i))) {
                dividend = Character.getNumericValue(input.charAt(i));
            } else {
                switch (input.charAt(i)) {
                    case 'A':
                        dividend = 10;
                        break;
                    case 'B':
                        dividend = 11;
                        break;
                    case 'C':
                        dividend = 12;
                        break;
                    case 'D':
                        dividend = 13;
                        break;
                    case 'E':
                        dividend = 14;
                        break;
                    case 'F':
                        dividend = 15;
                        break;
                }
            }
            //Divide continuously by the base 2 to get the digits from the remainders until the quotient is 0
            while (dividend > 0) {
                result = (dividend % 2) + result;
                dividend /= 2;
            }
            //add missing 0
            if (input.length() - 1 - i != input.length() - 1) {
                while (result.length() % 4 != 0) {
                    result = "0" + result;
                }
            }
        }
        return result;
    }

}
