 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trigproblemsolver;

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.InputMismatchException;

/**
 *
 * @author Nick Mills
 */
public class TrigProblemSolver {

    public static Scanner input;
    public static NumberFormat decimal;
    
    public static void main(String[] args) {
        run();
    }
    public static void run() {
        // TODO code application logic here
        
        //Create Scanner
        
        input = new Scanner(System.in);
        
        //Prompt user for what kind of triangle
        
        System.out.println("What kind of triangle are you trying to solve?");
        System.out.println("1. Right Angle Triangle");
        //System.out.println("2. Double Triangle");
        try {
        int what = input.nextInt();
        //Run chosen Triangle Solver Class
        if (what == 1) {
            decimalPlaces();
        }/*else if (what == 2) {
            DoubleTriangle();
        } */
        else{
            System.out.println("Please enter a valid input!");
            run();
        }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid input!");
            run();
        }
        
    }
    
    public static void decimalPlaces() {
        //User chooses how many decimal places
        int decimalNum;
        try {
           
        System.out.print("\nHow many deicmal places do you want the answer to be? ");
        decimalNum = input.nextInt();
        decimalNum -= 1;
        //Create NumberFormat (decimal) with user decimal number option
        
        decimal = NumberFormat.getNumberInstance();
        decimal.setMinimumFractionDigits(decimalNum);
        
        RightTriangle();
        
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid input!");
        }
    }
    public static void RightTriangle() {
        
        double hypoteneuse, adjacent, opposite, angle;
        String angleOne, angleTwo;
        try {
        //Capture what angle the user wants to be solved
        System.out.println("\nEnter the angle you want to solve based on this Right-Angle Triangle: ");
        System.out.println("a");
        System.out.println(" *");
        System.out.println(" * *");
        System.out.println(" *  *");
        System.out.println(" *   *");
        System.out.println("b******c\n");
        System.out.print("\nWhich angle do you want to solve? A or C: ");
        angleOne = input.next();
        angleOne.toLowerCase();
        if(!"a".equals(angleOne) && !"c".equals(angleOne)) {
            System.out.println("\n\tPlease enter a valid input!");
            RightTriangle();
        }
        //Capture side lengths of the triangle
            System.out.println("\nEnter the side lengths relative to the angle you want to solve(enter 0 if the side is unknown. No more than one side can be unknown. Enter only two sides, even if you know all sides.):");
            System.out.print("\tHypoteneuse: ");
            hypoteneuse = input.nextDouble();
            System.out.print("\tAdjacent: ");
            adjacent = input.nextDouble();
            System.out.print("\tOpposite: ");
            opposite = input.nextDouble();

        //Different equations based on what angle is selected and what lengths are given
        if(opposite != 0 && adjacent != 0 && hypoteneuse != 0) {
            System.out.println("Please enter only two sides!");
            RightTriangle();
        }
        if("a".equals(angleOne) && opposite != 0 && hypoteneuse != 0) { //SOH
            System.out.println("The SOH (Sine) method can be used");
            System.out.println("Sina = " + opposite + " / " + hypoteneuse);
            angle = opposite/hypoteneuse;
            double answer = opposite/hypoteneuse;
            System.out.println("Sina = " + decimal.format(answer));
            angle = Math.asin(angle) * 180/Math.PI; //Converts answer to Degrees (default is radians)
            System.out.println("a = " + decimal.format(answer) + " sin^-1");
            System.out.println("a = " + decimal.format(angle));
            
        } else if ("a".equals(angleOne) && adjacent != 0 && hypoteneuse != 0) { //CAH
            System.out.println("The CAH (Cosine) method can be used");
            System.out.println("Cosa = " + adjacent + " / " + hypoteneuse);
            angle = adjacent/hypoteneuse;
            double answer = adjacent/hypoteneuse;
            System.out.println("Cosa = " + decimal.format(answer));
            angle = Math.acos(angle) * 180/Math.PI; //Converts answer to Degrees
            System.out.println("a = " + decimal.format(answer) + " cos^-1");
            System.out.println("a = " + decimal.format(angle));
            
        } else if ("a".equals(angleOne) && opposite != 0 && adjacent != 0) { //TOA
            System.out.println("The TOA (Tangent) method can be used");
            System.out.println("Tana = " + opposite + " / " + adjacent);
            angle = opposite/adjacent;
            double answer = opposite/adjacent;
            System.out.println("Tana = " + decimal.format(answer));
            angle = Math.atan(angle) * 180/Math.PI;
            System.out.println(decimal.format(angle));
            System.out.println("a = " + decimal.format(answer) + " tan^-1");
            System.out.println("a = " + decimal.format(angle));
            
        } else if("c".equals(angleOne) && opposite != 0 && hypoteneuse != 0) { //SOH
            System.out.println("The SOH (Sine) method can be used");
            System.out.println("Sinc = " + opposite + " / " + hypoteneuse);
            angle = opposite/hypoteneuse;
            double answer = opposite/hypoteneuse;
            System.out.println("Sinc = " + decimal.format(answer));
            angle = Math.asin(angle) * 180/Math.PI; //Converts answer to Degrees (default is radians)
            System.out.println("c = " + decimal.format(answer) + " sin^-1");
            System.out.println("c = " + decimal.format(angle));
            
        } else if ("c".equals(angleOne) && adjacent != 0 && hypoteneuse != 0) { //CAH
            System.out.println("The CAH (Cosine) method can be used");
            System.out.println("Cosc = " + adjacent + " / " + hypoteneuse);
            angle = adjacent/hypoteneuse;
            double answer = adjacent/hypoteneuse;
            System.out.println("Cosc = " + decimal.format(answer));
            angle = Math.acos(angle) * 180/Math.PI; //Converts answer to Degrees
            System.out.println("c = " + decimal.format(answer) + " cos^-1");
            System.out.println("c = " + decimal.format(angle));
            
        } else if ("c".equals(angleOne) && opposite != 0 && adjacent != 0) { //TOA
            System.out.println("The TOA (Tangent) method can be used");
            System.out.println("Tanc = " + opposite + " / " + adjacent);
            angle = opposite/adjacent;
            double answer = opposite/adjacent;
            System.out.println("Tanc = " + decimal.format(answer));
            angle = Math.atan(angle) * 180/Math.PI;
            System.out.println(decimal.format(angle));
            System.out.println("c = " + decimal.format(answer) + " tan^-1");
            System.out.println("c = " + decimal.format(angle));
            
        } else if (opposite == 0 && adjacent == 0 && hypoteneuse == 0){
            System.out.println("Please enter valid side lengths");
        }
        //B does not need to be solved because it is the 90 degree angle in the right-angle triangle
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid input!");
            RightTriangle();
        }
        String again;
        boolean flag = true;
        while(flag){
            System.out.println("Would you like to do another calculation?(Y/N): ");
            again = input.next();
            again.toLowerCase();
            try{
            switch (again) {
                case "y":
                    flag = false;
                    RightTriangle();
                    break;
                case "n":
                    System.out.println("Thank you for using Nick's Trigonometry Triangle Solver!");
                    flag = false;
                    break;
                default:
                    System.out.println("Please enter a valid input!\n");
                    break;
            }
            } catch (InputMismatchException e) {
            System.out.println("Please enter a valid input!");
            RightTriangle();
        }
        }
        
        
    }
    
    /*
    public static void DoubleTriangle() {
        decimalPlaces();
    }
    */
}
