    package com.example.resistor;

    import android.os.Bundle;
    import android.view.View;
    import android.widget.Spinner;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.view.WindowCompat;

    public class MainActivity extends AppCompatActivity {

        private final ResistorExpert expert = new ResistorExpert();
        // User selects the inputs from the dropdowns
        // Chooses 1st band, gets saved into choice 1
        // Chooses 2nd band, gets saved into choice 2
        // Chooses 3rd band, gets saved into choice 3
        // Chooses 4th band , gets saved into choice 4
        // Calculate function gets called anytime a choice gets updated
        // Answer number gets updated and displayed

        // To Do: Button selectors for choosing amount of resistor bands
        // Method to decide how many bands to pass, nullify others, calls appropriate method in ResistorExpert

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

            // Toast Calculated message
            Toast calculated = Toast.makeText(this /* MyActivity */, "Calculated!", Toast.LENGTH_SHORT);
            // https://developer.android.com/guide/topics/ui/notifiers/toasts#java

            String out = expert.fourBandResistor(selectedColor1, selectedColor2, selectedColor3, selectedColor4);

            //Display the final calculation
            results.setText(out);
            calculated.show();
        }
    }

    // Look into modern way pf spinner: https://developer.android.com/develop/ui/views/components/spinner