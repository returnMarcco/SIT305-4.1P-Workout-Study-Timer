package com.example.a41p_workout_timer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.util.Log;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected CountDownTimer createWorkoutTimer() {
        EditText workoutDurationInput = findViewById(R.id.idWorkoutDurationEditText);
        String workoutDurationValStr = workoutDurationInput.getText().toString();
        long workoutDurationVal = Long.parseLong(workoutDurationValStr);

        CountDownTimer workoutDurationCountdownTimer = new CountDownTimer(workoutDurationVal, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {

            }
        };

        return workoutDurationCountdownTimer;
    }
    protected CountDownTimer createRestPeriodTimer() {
        EditText restPeriodDurationInput = findViewById(R.id.idRestPeriodDurationEditText);
        String restPeriodDurationInputValStr = restPeriodDurationInput.getText().toString();
        long restPeriodDurationVal = Long.parseLong(restPeriodDurationInputValStr);

        CountDownTimer restPeriodDurationCountdownTimer = new CountDownTimer(restPeriodDurationVal, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {

            }
        };

        return restPeriodDurationCountdownTimer;
    }
}
