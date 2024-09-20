package com.example.bmicalculationapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText edweightkg, edheightFeet, edheightIn, edweightpound;
        Button btncalculate;
        TextView txtresult;

        edweightkg = findViewById(R.id.edtweightkgs);
        edheightIn = findViewById(R.id.edtheightIn);
        edheightFeet = findViewById(R.id.edtheightft);
        btncalculate = findViewById(R.id.btnCalculateBMI);
        txtresult = findViewById(R.id.txtResult);


        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                {
                    int wtink = Integer.parseInt(edweightkg.getText().toString());
                    int hinf = Integer.parseInt(edheightFeet.getText().toString());
                    int hini = Integer.parseInt(edheightIn.getText().toString());


                    double totalin = 12 * hinf + hini;
                    totalin = (totalin) * (2.54);
                    totalin = totalin / 100;

                    // BMI calculation
                    double bmi = (wtink) / ((totalin) * (totalin));


                    String bmiCategory;
                    if (bmi < 18.5) {
                        txtresult.setText("Underweight");
                    } else if (bmi >= 18.5 && bmi < 24.9) {
                        txtresult.setText("Normal Weight");
                    } else if (bmi >= 25 && bmi < 29.9) {
                        txtresult.setText("Over weight");
                    } else if (bmi >= 30 && bmi < 34.9) {
                        txtresult.setText("Obesity Class 1 (Moderate)");
                    } else if (bmi >= 35 && bmi < 39.9) {
                        txtresult.setText("Obesity Class 2 (Severe)");
                    } else {
                        txtresult.setText("Obesity Class 3 (Very Severe)");
                    }
                }
            }
        });
    }
}

