package com.example.resistor;

public class ResistorExpert {

    public double calculate(int choice1, int choice2, int choice3) {
        //int digits = Integer.parseInt(String.valueOf(choice1) +choice2);
        return ((choice1*10)+choice2) * Math.pow(10, choice3); // Do power conversion in method instead of in each switch case
    }

    public String fourBandResistor(String selectedColor1, String selectedColor2, String selectedColor3, String selectedColor4){
        // Initialize 3 bands selections for 1st and 2nd digits, multiplier
        int choice1, choice2, choice3;
        double choice4; // Choice 4 double because tolerances values have decimal values

        // Convert colors to numbers
        switch (selectedColor1) {
            case "Black":  choice1 = 0; break;
            case "Brown":  choice1 = 1; break;
            case "Red":    choice1 = 2; break;
            case "Orange": choice1 = 3; break;
            case "Yellow": choice1 = 4; break;
            case "Green":  choice1 = 5; break;
            case "Blue":   choice1 = 6; break;
            case "Violet": choice1 = 7; break;
            case "Gray":   choice1 = 8; break;
            case "White":  choice1 = 9; break;
            default: System.out.println("Invalid resistor colour for band1!"); return "Error: Invalid resistor band 1 colour!";}

        switch (selectedColor2) {
            case "Black":  choice2 = 0; break;
            case "Brown":  choice2 = 1; break;
            case "Red":    choice2 = 2; break;
            case "Orange": choice2 = 3; break;
            case "Yellow": choice2 = 4; break;
            case "Green":  choice2 = 5; break;
            case "Blue":   choice2 = 6; break;
            case "Violet": choice2 = 7; break;
            case "Gray":   choice2 = 8; break;
            case "White":  choice2 = 9; break;
            default: System.out.println("Invalid resistor colour for band2!"); return "Error: Invalid resistor band 2 colour!";}

        // Multiplier stored as power
        switch (selectedColor3) {
            case "Black":  choice3 = 0; break;
            case "Brown":  choice3 = 1; break;
            case "Red":    choice3 = 2; break;
            case "Orange": choice3 = 3; break;
            case "Yellow": choice3 = 4; break;
            case "Green":  choice3 = 5; break;
            case "Blue":   choice3 = 6; break;
            case "Violet": choice3 = 7; break;
            case "Gray":   choice3 = 8; break;
            case "White":  choice3 = 9; break;
            case "Gold":   choice3 = -1; break;
            case "Silver": choice3 = -2; break;
            default: System.out.println("Invalid resistor colour for band3!"); return "Error: Invalid resistor band 3 colour!";}

        switch (selectedColor4) {
            case "Brown":  choice4 = 1; break;
            case "Red":    choice4 = 2; break;
            case "Green":  choice4 = 0.5; break;
            case "Blue":   choice4 = 0.25; break;
            case "Violet": choice4 = 0.1; break;
            case "Gray":   choice4 = 0.05; break;
            case "Gold":   choice4 = 5; break;
            case "Silver": choice4 = 10; break;
            default: System.out.println("Invalid resistor colour for band4!"); return "Error: Invalid resistor band 4 colour!";}

        return calculate(choice1, choice2, choice3) + " " + "± " + choice4 + "%";
    }
}
