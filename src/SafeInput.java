import java.util.Scanner;

public class SafeInput
{
    public static boolean getYN(Scanner in, String prompt)
    {
        String respondYN = "";
        boolean returnVal = false;
        boolean validInput = false;

        do {
            System.out.println(prompt + ": ");
            respondYN = in.nextLine();

            if(respondYN.equalsIgnoreCase("Y"))
            {
                returnVal = true;
                validInput = true;
            }
            else if(respondYN.equalsIgnoreCase("N"))
            {
                returnVal = false;
                validInput = true;
            }else {
                System.out.println("You must enter Y/N. ");
            }

        }while(!validInput);
        return returnVal;
    }
    public static int getRangedInt(Scanner in, String prompt, int low, int high)
    {
        int intVal = 0;
        boolean validInput = false;
        do{
            System.out.print(prompt + "[ " + low + " - " + high + " ]: ");
            if(in.hasNextDouble())
            {
                intVal = in.nextInt();
                in.nextLine();
                if(intVal >= low && intVal <= high)
                {
                    validInput = true;
                } else {
                    System.out.println("This number is out of the range, [ " + low + " - " + high + " ], you entered: " + intVal);
                }
            }
        }while(!validInput);
        return intVal;
    }
}
