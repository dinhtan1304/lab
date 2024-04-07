
package convert;

public class Main {

    public static void main(String[] args) {
        //loop until user want to exit
        while (true) {
            //user input base number
            int choice = Convert.baseNumberInput();
            switch (choice) {
                case 1: //Convert from binary 
                    String bin = Check.inputBinary();
                    Convert.convertFromBinary(bin);
                    break;
                case 2: //Convert from decimal
                    String dec = Check.inputDecimal();
                    Convert.convertFromDecimal(dec);
                    break;
                case 3: //Convert  from hexadecimal
                    String hex = Check.inputHexaDecimal();
                    Convert.convertFromHexa(hex);
                    break;
                case 4:
                    return;
            }
        }
    }
}
