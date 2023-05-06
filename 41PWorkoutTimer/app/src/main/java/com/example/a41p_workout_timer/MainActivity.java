package com.example.a41p_workout_timer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.EditText;
import android.util.Log;
import android.widget.Button;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startStopWorkoutDurationBtn = findViewById(R.id.idStartWorkoutTimerBtn);
        startStopWorkoutDurationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                triggerWorkoutTimer();
            }
        });
    }
    protected CountDownTimer createWorkoutTimer(int workoutDurationVal, int numberOfSets) {
        return new CountDownTimer((workoutDurationVal * numberOfSets), 1000) {
            @Override
            public void onTick(long l) {

            }
            @Override
            public void onFinish() {
             // Todo: Vibrate device
            }
        };
    }
    protected CountDownTimer createRestPeriodTimer(int restPeriodDurationVal) {


        return new CountDownTimer(restPeriodDurationVal, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
            // Todo: Vibrate device
            }
        };
    }
    protected void triggerWorkoutTimer() { // Event-Handler
        // Timer start/pause flag
        boolean timerRunning = false;

        try {
            if (timerRunning = false) {
                timerRunning = true;

                EditText workoutDurationInput = findViewById(R.id.idWorkoutDurationEditText);
                String workoutDurationStr = workoutDurationInput.getText().toString();

                if (workoutDurationStr.isEmpty()) {
                    workoutDurationStr = "1";
                    System.out.println(workoutDurationStr);
                }


                int workoutDuration = Integer.parseInt(workoutDurationStr);
                System.out.println(workoutDuration);

                EditText restPeriodDurationInput = findViewById(R.id.idRestPeriodDurationEditText);
                String restPeriodDurationStr = restPeriodDurationInput.getText().toString();

                if (restPeriodDurationStr.isEmpty()) {
                    restPeriodDurationStr = "1";
                }

                int restPeriodDuration = Integer.parseInt(restPeriodDurationStr);
                System.out.println(restPeriodDuration);
                EditText numberOfSetsInput = findViewById(R.id.idSetSelector);
                String numberOfSetsStr = numberOfSetsInput.getText().toString();

                if (numberOfSetsStr.isEmpty()) {
                    numberOfSetsStr = "1";
                }

                int numberOfSets = Integer.parseInt(numberOfSetsStr);
                System.out.println(numberOfSets);

//              CountDownTimer workoutDurationTimer = createWorkoutTimer(workoutDuration, numberOfSets);
//              CountDownTimer restPeriodTimer = createRestPeriodTimer(restPeriodDuration);


            } else {
                // When the timer is running and the start/pause button is pressed again
            }
        } catch(Error e) {
            Log.e("triggerWorkoutTimer: ", "An error has occurred");
        }
    }

    protected void resetAllTimers() {
        // Button that resets all timers
    }



}
