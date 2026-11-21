package com.example.resistor;

// import static android.os.Build.VERSION_CODES_FULL.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // User selects the inputs from the dropdowns
    // Chooses 1st band, gets saved into choice 1
    // Chooses 2nd band, gets saved into choice 2
    // Chooses 3rd band, gets saved into choice 3
    // Chooses 4th band , gets saved into choice 4

    // Calculate function gets called anytime a choice gets updated
    // Answer number gets updated and displayed

    Button calculate;
    Spinner spinner1, spinner2, spinner3, spinner4;
    // float choice1 = 0, choice2 = 0, choice3 = 0, choice4 = 0; // Initialize all as zero

    public double calculate(int choice1, int choice2, int choice3) {
        return (choice1 * 10 + choice2) * Math.pow(10, choice3);
    }

    // What happens when a spinner item is selected
    public static class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item is selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos).
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback.
        }
    }

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);

        TextView textView;
        // Initialize Objects
        // Create spinner and button objects
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);
        calculate = findViewById(R.id.calculate_btn);
        textView = findViewById(R.id.answer);

        spinner1.getOnItemSelectedListener();
        spinner2.getOnItemSelectedListener();
        spinner3.getOnItemSelectedListener();
        spinner4.getOnItemSelectedListener();

        // Button onClick listener
        // Get values of spinner arrays into choices
        calculate.setOnClickListener(v -> {
            int choice1 = getResources().getIntArray(R.array.spinner1_values)[spinner1.getSelectedItemPosition()];
            int choice2 = getResources().getIntArray(R.array.spinner2_values)[spinner2.getSelectedItemPosition()];
            int choice3 = getResources().getIntArray(R.array.spinner3_values)[spinner3.getSelectedItemPosition()];
            float choice4 = Float.parseFloat(getResources().getStringArray(R.array.spinner4_values)[spinner4.getSelectedItemPosition()]);

            // Calculate the resistance
            double resistance = calculate(choice1, choice2, choice3);
            // Display the resistance with the tolerance
            textView.setText(String.format(java.util.Locale.getDefault(),"%.2f Ω ±%.2f%%", resistance, choice4));
        });

        /////////////// Spinner 1 ///////////////
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.spinner1,
                android.R.layout.simple_spinner_item
        );
// Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        spinner.setAdapter(adapter);

        /////////////// Spinner 2 ///////////////
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.spinner2,
                android.R.layout.simple_spinner_item
        );
// Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        spinner.setAdapter(adapter2);

        /////////////// Spinner 3 ///////////////
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
                this,
                R.array.spinner3,
                android.R.layout.simple_spinner_item
        );
// Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        spinner.setAdapter(adapter3);

        /////////////// Spinner 4 ///////////////
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(
                this,
                R.array.spinner1,
                android.R.layout.simple_spinner_item
        );
// Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        spinner.setAdapter(adapter4);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}