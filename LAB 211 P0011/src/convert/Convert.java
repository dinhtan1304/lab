package convert;

import java.math.BigInteger;

public class Convert {

    static int baseNumberInput() {
        System.out.println("1. Convert from binary.");
        System.out.println("2. Convert from decimal.");
        System.out.println("3. Convert from hexa.");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = Check.inputIntLimit(1, 4);
        return choice;
    }

    //display choose convert
    public static int displayConvert(String from, String Case1, String Case2) {
        System.out.println("1. Convert from " + from + " to " + from);
        System.out.println("2. Convert from " + from + " to " + Case1);
        System.out.println("3. Convert from " + from + " to " + Case2);
        System.out.print("Enter your choice: ");
        int result = Check.inputIntLimit(1, 3);
        return result;
    }

    //convert from binary
    public static void convertFromBinary(String binary) {
        int choice = displayConvert("binary", "decimal", "hexadecimal");
        switch (choice) {
            case 1:
                System.out.println("Binary: " + binary);
                System.out.println("Binary: " + binary + "\n");
                break;
            case 2:
                System.out.println("Binary: " + binary);
                System.out.println("Decimal: " + convertBinToDec(binary) + "\n");
                break;
            case 3:
                System.out.println("Binary: " + binary);
                System.out.println("Hexadecimal: " + convertBinToHex(binary) + "\n");
                break;
        }
    }

    //convert from decimal
    public static void convertFromDecimal(String decimal) {
        int choice = displayConvert("decimal", "binary", "hexadecimal");
        switch (choice) {
            case 1:
                System.out.println("Decimal: " + decimal);
                System.out.println("Decimal: " + decimal + "\n");
                break;
            case 2:
                System.out.println("Decimal: " + decimal);
                System.out.println("Binary: " + convertDecToBin(decimal) + "\n");
                break;
            case 3:
                System.out.println("Decimal: " + decimal);
                System.out.println("Hexadecimal: " + convertDecToHex(decimal) + "\n");
                break;
        }
    }

    //convert from hexadecimal
    public static void convertFromHexa(String hexa) {
        int choice = displayConvert("hexadecimal", "binary", "decimal");
        switch (choice) {
            case 1:
                System.out.println("Hexadecimal: " + hexa);
                System.out.println("Hexadecimal: " + hexa + "\n");
                break;
            case 2:
                System.out.println("Hexadecimal: " + hexa);
                System.out.println("Binary: " + convertHexToBin(hexa) + "\n");
                break;
            case 3:
                System.out.println("Hexadecimal: " + hexa);
                System.out.println("Decimal: " + convertHexToDec(hexa) + "\n");
                break;
        }
    }
    public static final char[] hexDigits = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    //convert from decimal to binary
    public static String convertDecToBin(String decimal) {
        //Store binary variable after conversion
        String bin = "";
        BigInteger baseNumb = new BigInteger("2");
        BigInteger zero = new BigInteger("0");
        BigInteger dec = new BigInteger(decimal);
        int compare = dec.compareTo(zero);
        if (compare == 0) {
            return "0";
        }
        //loop until the decimal number is divisible
        while (compare != 0) {
            BigInteger modNumber = dec.mod(baseNumb);
            int mod = Integer.parseInt(modNumber.toString());
            bin = hexDigits[mod] + bin;
            dec = dec.divide(baseNumb);
            compare = dec.compareTo(zero);
        }
        return bin;
    }

    //convert from decimal to hexadecimal
    public static String convertDecToHex(String decimal) {
        //Store hexadecimal variable after conversion
        String hex = "";
        BigInteger baseNumb = new BigInteger("16");
        BigInteger zero = new BigInteger("0");
        BigInteger dec = new BigInteger(decimal);
        int compare = dec.compareTo(zero);
        if (compare == 0) {
            return "0";
        }
        //loop until the decimal number is divisible
        while (compare != 0) {
            BigInteger modNumber = dec.mod(baseNumb);
            int mod = Integer.parseInt(modNumber.toString());
            hex = hexDigits[mod] + hex;
            dec = dec.divide(baseNumb);
            compare = dec.compareTo(zero);
        }
        return hex;
    }

    //convert from binary to decimal
    public static String convertBinToDec(String bin) {
        String digits = "01";
        BigInteger baseNumb = new BigInteger("2");
        BigInteger dec = new BigInteger("0");
        //run from the first to the last character of the binary string
        for (int i = 0; i < bin.length(); i++) {
            int k = digits.indexOf(bin.charAt(i));
            BigInteger k1 = new BigInteger(Integer.toString(k));
            dec = dec.multiply(baseNumb);
            dec = dec.add(k1);
            if (k1 == null) {
                return "0";
            }
        }
        return dec.toString();
    }

    //convert from binary to hexadecimal
    public static String convertBinToHex(String binary) {
        String dec = convertBinToDec(binary);
        String hex = convertDecToHex(dec);
        return hex;
    }

    //convert from hexadecimal to decimal
    public static String convertHexToDec(String hexadecimal) {
        String digits = "0123456789ABCDEF";
        BigInteger baseNumb = new BigInteger("16");
        BigInteger dec = new BigInteger("0");
        //run from the first to the last character of the hexadecimal string
        for (int i = 0; i < hexadecimal.length(); i++) {
            int k = digits.indexOf(hexadecimal.charAt(i));
            BigInteger k1 = new BigInteger(Integer.toString(k));
            dec = dec.multiply(baseNumb);
            dec = dec.add(k1);
            if (k1 == null) {
                return "0";
            }
        }
        return dec.toString();
    }

    //convert from hexadecimal to binary
    public static String convertHexToBin(String hexadecimal) {
        String dec = convertHexToDec(hexadecimal);
        String bin = convertDecToBin(dec);
        return bin;
    }
}
