package p0011;

public class Main {

    public static void main(String[] args) {
        Display display = new Display();
        GetInput data = new GetInput();
        ConvertFunc func = new ConvertFunc();
        do {
            //display base input menu
            display.DisplayMenu("--- Input Base ---");
            //user choose the base number input
            int baseInput = data.enterBase();
            //display base output menu
            display.DisplayMenu("--- Output Base ---");
            //user choose the base number output
            int baseOutput;
            do {
                baseOutput = data.enterBase();
            } while (data.checkBase(baseInput,baseOutput)==false);
            //user enter input value
            String input = data.enterValue(baseInput);
            //Convert input to expected result
            String result = func.convertValue(baseInput, baseOutput, input);
            //Display result
            display.DisplayResult(baseInput, baseOutput, input, result);
        } while (true);
    }

}
