    package com.example.resistor;

    import android.os.Bundle;
    import android.view.View;
    import android.widget.ArrayAdapter;
    import android.widget.Spinner;
    import android.widget.TextView;
    import android.widget.Toast;
    import android.widget.AdapterView;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.view.WindowCompat;

    public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

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
        // Fix Calculated Toast bug
        // Resistor Expert uses similar duplicate methods for calculateFourBand calculateFiveBand, fourBandResistor, fiveBandResistor
        // Look into reusing one method possibly with args or other methods

        public void configureBands(){
            // Find spinners
            Spinner bandsAmount = findViewById(R.id.spinner0);
            Spinner band3 = findViewById(R.id.spinner3);
            Spinner band5 = findViewById(R.id.spinner5);
            String amountOfBands = String.valueOf(bandsAmount.getSelectedItem());
            // Boolean to check if 5 bands was selected
            boolean fiveBand = amountOfBands.equals("5-band");
                // Create array copy of spinner1 digit colors
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                        this, R.array.spinner1, android.R.layout.simple_spinner_item);
                // Set spinner3 to spinner1 array digit colors
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                band3.setAdapter(adapter);
                // Create array copy of spinner3 array multiplier colors

                // Decide whether to show or hide 5 band spinner
                band5.setVisibility(fiveBand ? View.VISIBLE : View.GONE);

        }
        // Loads Android XML layout
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            WindowCompat.enableEdgeToEdge(getWindow());
            setContentView(R.layout.activity_main); // Creates Ui Components

            Spinner bandsAmount = findViewById(R.id.spinner0);
            bandsAmount.setOnItemSelectedListener(this);

            configureBands();

                // Find 5 bands spinners
                Spinner band1 = findViewById(R.id.spinner1);
                Spinner band2 = findViewById(R.id.spinner2);
                Spinner band3 = findViewById(R.id.spinner3);
                Spinner band4 = findViewById(R.id.spinner4);
                Spinner band5 = findViewById(R.id.spinner5);

                band1.setOnItemSelectedListener(this);
                band2.setOnItemSelectedListener(this);
                band3.setOnItemSelectedListener(this);
                band4.setOnItemSelectedListener(this);
                band5.setOnItemSelectedListener(this);
        }
        // If 4-band selected show 4 spinners
        // If 5-band selected show 5 spinners

        // Method to deal what happens when an item in the band spinners is selected
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            // An item is selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos).
            // No need to use parent, view, position and id because we need values from all spinners
            if (parent.getId() == R.id.spinner0) {
                configureBands();
            }
            onClickCalculate();
        }
        // When nothing is selected
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback.
            // Do nothing
        }

        //Call when the button gets clicked
        private void onClickCalculate() {
            //Get a reference to the TextView results that shows the final answer
            TextView results = findViewById(R.id.answer);

            Spinner bands = findViewById(R.id.spinner0);
            String amountOfBands = String.valueOf(bands.getSelectedItem());

            //Get a reference to the Spinners
            Spinner band1 = findViewById(R.id.spinner1);
            Spinner band2 = findViewById(R.id.spinner2);
            Spinner band3 = findViewById(R.id.spinner3);
            Spinner band4 = findViewById(R.id.spinner4);
            Spinner band5 = findViewById(R.id.spinner5);

            //Get the selected colors from the spinners
            String selectedColor1 = String.valueOf(band1.getSelectedItem());
            String selectedColor2 = String.valueOf(band2.getSelectedItem());
            String selectedColor3 = String.valueOf(band3.getSelectedItem());
            String selectedColor4 = String.valueOf(band4.getSelectedItem());
            String selectedColor5 = String.valueOf(band5.getSelectedItem());

            // Toast Calculated message
            Toast calculated = Toast.makeText(this /* MyActivity */, "Calculated!", Toast.LENGTH_SHORT);
            // https://developer.android.com/guide/topics/ui/notifiers/toasts#java

            // If 4 bands do fourBandResistor
            // String out = expert.fourBandResistor(selectedColor1, selectedColor2, selectedColor3, selectedColor4);
            // If 5-band resistor do fiveBandResistor

            String out;

            if (amountOfBands.equals("4-band")) {
                out = expert.fourBandResistor( selectedColor1, selectedColor2, selectedColor3, selectedColor4);
            } else if (amountOfBands.equals("5-band")) {
                out = expert.fiveBandResistor( selectedColor1, selectedColor2, selectedColor3, selectedColor4, selectedColor5);
            } else {
                out = "Invalid resistor type";
            }

            //Display the final calculation
            results.setText(out);
            calculated.show();
        }
    }

    // Look into modern way pf spinner: https://developer.android.com/develop/ui/views/components/spinner