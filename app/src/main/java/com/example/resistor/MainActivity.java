    package com.example.resistor;

    import android.os.Bundle;
    import android.view.View;
    import android.widget.Spinner;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.view.WindowCompat;

    public class MainActivity extends AppCompatActivity {

        // User selects the inputs from the dropdowns
        // Chooses 1st band, gets saved into choice 1
        // Chooses 2nd band, gets saved into choice 2
        // Chooses 3rd band, gets saved into choice 3
        // Chooses 4th band , gets saved into choice 4
        // Calculate function gets called anytime a choice gets updated
        // Answer number gets updated and displayed

        public double calculate(int choice1, int choice2, int choice3) {
            int digits = Integer.parseInt(String.valueOf(choice1) +choice2);
            return digits * Math.pow(10, choice3);
        }

        // Loads Android XML layout
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            WindowCompat.enableEdgeToEdge(getWindow());
            setContentView(R.layout.activity_main); // Creates Ui Components

        }
        //Call when the button gets clicked
        public void onClickCalculate(View view) {
            //Get a reference to the TextView results that shows the final answer
            TextView results = findViewById(R.id.answer);

            //Get a reference to the Spinners
            Spinner band1 = findViewById(R.id.spinner1);
            Spinner band2 = findViewById(R.id.spinner2);
            Spinner band3 = findViewById(R.id.spinner3);
            Spinner band4 = findViewById(R.id.spinner4);

            //Get the selected colors from the spinners
            String selectedColor1 = String.valueOf(band1.getSelectedItem());
            String selectedColor2 = String.valueOf(band2.getSelectedItem());
            String selectedColor3 = String.valueOf(band3.getSelectedItem());
            String selectedColor4 = String.valueOf(band4.getSelectedItem());

            // Initialize 3 bands selections for 1st and 2nd digits, multiplier
            int choice1, choice2, choice3;
            double choice4; // Choice 4 double because tolerances values have decimal values

            // Toast error message
            Toast error = Toast.makeText(this /* MyActivity */, "Error selecting band choice!", Toast.LENGTH_LONG);
            // Toast Calculated message
            Toast calculated = Toast.makeText(this /* MyActivity */, "Done!", Toast.LENGTH_SHORT);
            // https://developer.android.com/guide/topics/ui/notifiers/toasts#java

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
                default: choice1 = 0; error.show();            }

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
                default: choice2 = 0; error.show();            }

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
                default: choice3 = 0; error.show();            }

            switch (selectedColor4) {
                case "Brown":  choice4 = 1; break;
                case "Red":    choice4 = 2; break;
                case "Green":  choice4 = 0.5; break;
                case "Blue":   choice4 = 0.25; break;
                case "Violet": choice4 = 0.1; break;
                case "Gray":   choice4 = 0.05; break;
                case "Gold":   choice4 = 5; break;
                case "Silver": choice4 = 10; break;
                default: choice4 = 0; error.show();
            }

            String out = calculate(choice1, choice2, choice3) + " " + "±" + choice4 + "%";

            //Display the final calculation
            results.setText(out);
            calculated.show();
        }
    }

    // Look into modern way pf spinner: https://developer.android.com/develop/ui/views/components/spinner