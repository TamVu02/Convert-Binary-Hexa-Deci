package p0011;

public class Display {

    public void DisplayMenu(String msg) {
        System.out.println(msg);
        System.out.print("1. Binary\n"
                + "2. Decimal\n"
                + "3. Hexadecimal\n"
                + "4. Exit\n"
                + "Your choice: ");
    }

    public void DisplayResult(int baseInput, int baseOutput, String inputValue, String result) {
        String baseI, baseO;
        switch (baseInput) {
            case 1:
                baseI = "BIN";
                break;
            case 2:
                baseI = "DEC";
                break;
            default:
                baseI = "HEX";
                break;
        }
        switch (baseOutput) {
            case 1:
                baseO = "BIN";
                break;
            case 2:
                baseO = "DEC";
                break;
            default:
                baseO = "HEX";
                break;
        }
        System.out.println(inputValue + "(" + baseI + ")" + " = " + result + "(" + baseO + ")\n");
    }

}
