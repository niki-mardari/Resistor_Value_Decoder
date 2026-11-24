package com.example.resistor;

public class ResistorExpert {

    public String fourBandResistor(String band1, String band2, String multiplier, String tolerance){
        // Band selectedColors are passed by reference copy.
        // Since Strings in Java live in the heap and cannot be changed
        // a local copy is created of the string
        // Convert colors to string number values
        switch (band1) {
            case "Black":  band1 = "0"; break;
            case "Brown":  band1 = "1"; break;
            case "Red":    band1 = "2"; break;
            case "Orange": band1 = "3"; break;
            case "Yellow": band1 = "4"; break;
            case "Green":  band1 = "5"; break;
            case "Blue":   band1 = "6"; break;
            case "Violet": band1 = "7"; break;
            case "Gray":   band1 = "8"; break;
            case "White":  band1 = "9"; break;
            default: System.out.println("Invalid resistor colour for band1!"); return "Error: Invalid resistor band 1 colour!";}

        switch (band2) {
            case "Black":  band2 = "0"; break;
            case "Brown":  band2 = "1"; break;
            case "Red":    band2 = "2"; break;
            case "Orange": band2 = "3"; break;
            case "Yellow": band2 = "4"; break;
            case "Green":  band2 = "5"; break;
            case "Blue":   band2 = "6"; break;
            case "Violet": band2 = "7"; break;
            case "Gray":   band2 = "8"; break;
            case "White":  band2 = "9"; break;
            default: System.out.println("Invalid resistor colour for band2!"); return "Error: Invalid resistor band 2 colour!";}

        // Multiplier stored as power
        switch (multiplier) {
            case "Black":  multiplier = " Ω"; break;
            case "Brown":  multiplier = "0 Ω"; break;
            case "Red":    multiplier = "00 Ω"; break;
            case "Orange": multiplier = " kΩ"; break;
            case "Yellow": multiplier = "0 kΩ"; break;
            case "Green":  multiplier = "00 kΩ"; break;
            case "Blue":   multiplier = " MΩ"; break;
            case "Violet": multiplier = "0 MΩ"; break;
            case "Gray":   multiplier = "00 MΩ"; break;
            case "White":  multiplier = " GΩ"; break;
            default: System.out.println("Invalid resistor colour for band3!"); return "Error: Invalid resistor band 3 colour!";}

        switch (tolerance) {
            case "Brown":  tolerance = "1"; break;
            case "Red":    tolerance = "2"; break;
            case "Green":  tolerance = "0.5"; break;
            case "Blue":   tolerance = "0.25"; break;
            case "Violet": tolerance = "0.1"; break;
            case "Gray":   tolerance = "0.05"; break;
            case "Gold":   tolerance = "5"; break;
            case "Silver": tolerance = "10"; break;
            default: System.out.println("Invalid resistor colour for band4!"); return "Error: Invalid resistor band 4 colour!";}

        return band1 + band2 + multiplier + "± " + tolerance + "%";
    }
}
