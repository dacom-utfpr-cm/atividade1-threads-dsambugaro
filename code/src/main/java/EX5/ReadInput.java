package EX5;
/*
 *
 * @author Danilo Sambugaro created on 27/08/2019 inside the package - EX5
 *
 */

import java.util.ArrayList;
import java.util.Scanner;;

public class ReadInput implements Runnable {

    private ArrayList<Integer> inputList = null;

    ReadInput(ArrayList<Integer> inputList) {
        this.inputList = inputList;
    }

    @Override
    public void run() {

        boolean getInput = true;

        while (getInput) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter an integer (s to stop): ");

            if (keyboard.hasNext()) {
                String input = keyboard.nextLine();

                if (input.equals("s")) {
                    getInput = false;
                } else if (isNumber(input)) {
                    Integer number = Integer.parseInt(input);
                    inputList.add(number);
                }
            }
        }

    }

    private boolean isNumber(String input) {

        boolean isNumeric = false;

        try {
            int number = Integer.parseInt(input);
            isNumeric = true;
        } catch (Exception e) {
            isNumeric = false;
        }

        return isNumeric;
    }
}
