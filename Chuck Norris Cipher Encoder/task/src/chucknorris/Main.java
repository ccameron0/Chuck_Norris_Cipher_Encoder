package chucknorris;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    static void encodeString () {
        System.out.println("Input string:");

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        //System.out.println();
        //System.out.println("The results:");
        //boolean same = true;
        //scan.

        for (int i =0; i < str.length(); i++){

            StringBuilder binary = new StringBuilder();

            for(i = 0; i < str.length(); i++){
                int ascii = str.charAt(i);
                binary.append(String.format("%7s", Integer.toBinaryString(ascii)).replace(" ", "0"));
            }


            //int wholeBinary = Integer.parseInt(str);
            //System.out.println(binary);


            System.out.println("Encoded string:");
            for (int j = 0; j < binary.length();){
                if(binary.charAt(j) == '1'){
                    System.out.print("0 ");
                    while (j < binary.length() && binary.charAt(j) == '1'){
                        System.out.print("0");
                        j++;
                    }
                    if(j != binary.length())
                        System.out.print(" ");

                }
                else {
                    System.out.print("00 ");
                    while (j < binary.length() &&  binary.charAt(j) == '0'){
                        System.out.print("0");
                        j++;
                    }
                    if(j != binary.length())
                        System.out.print(" ");

                }

            }
        }
    }

    static void decodeString (String encodedString) {

        String binary = convertToBinary(encodedString);
        StringBuilder decoded = new StringBuilder();

        String[] stringArray = binary.split("(?<=\\G.{7})");


        for (int j = 0; j < stringArray.length; j++) {
            int decimal = Integer.parseInt(stringArray[j],2);

            char ch = (char) decimal;
            decoded.append(ch);
        }
        System.out.println("Decoded string:");
        System.out.print(decoded);
    }

    static boolean isValidEncodedString(String encodedString) {
        for (int i = 0; i < encodedString.length(); i++) {
            if (encodedString.charAt(i) != '0' && encodedString.charAt(i) != ' ') {
                return false;
            }
        }

        String[] strInBlocks = encodedString.split("(?<!\\G\\w{1,100})\\s");
        String zeros = "000";

        for (int j = 0; j < strInBlocks.length; j++) {
            if (strInBlocks[j].startsWith(zeros)) {
                //System.out.println("zeros");
                return false;
            }
        }

        String binary = convertToBinary(encodedString);
        String[] stringArray = binary.split("(?<=\\G.{7})");

        for(String a: stringArray) {
            if(a.length() < 7)
                return false;
        }

        return true;
    }

    static String convertToBinary (String encodedString) {

        StringBuilder binary = new StringBuilder();

        String[] inputArray = encodedString.split(" ");

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].equals("0")) {
                binary.append(inputArray[i + 1].replaceAll("0", "1"));
            } else if (inputArray[i].equals("00")) {
                binary.append(inputArray[i + 1]);
            }
            i++;
        }

        return String.valueOf(binary);
    }

    public static void main(String[] args){

            Scanner scan = new Scanner(System.in);

            System.out.println("Please input operation (encode/decode/exit):");
            String input = scan.nextLine();

            while (!Objects.equals(input, "exit")) {

                if(Objects.equals(input, "encode")) {
                    encodeString();
                }
                else if(Objects.equals(input, "decode")) {
                    System.out.println("Input encoded string:");
                    String str = scan.nextLine();

                    if(isValidEncodedString(str)) {
                        decodeString(str);
                    }
                    else {
                        System.out.println("Encoded string is not valid.");

                    }

                }
                else  {
                    System.out.println("There is no '" + input + "' operation");
                }
                System.out.println();
                System.out.println("Please input operation (encode/decode/exit):");
                input = scan.nextLine();
            }
            System.out.println("Bye!");
    }
}
