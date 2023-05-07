package com.example.a41p_workout_timer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.EditText;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {
    private EditText workoutDuration;
    private EditText restPeriodDuration;
    private EditText numberOfSets;
    private Button startStopWorkoutDurationBtn;
    private ProgressBar workoutProgressBar;
    private CountDownTimer workoutCountdownTimer;
    private CountDownTimer restPeriodCountdownTimer;
    private int timeLeft;
    private long setsLeft;
    private int restPeriod;
    private boolean timerRunning = false;
    private boolean isFirstRun = true;
    private int progressBarToEmpty;
    private int progressBarCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startStopWorkoutDurationBtn = findViewById(R.id.idStartWorkoutTimerBtn);
        startStopWorkoutDurationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timerRunning) {
                    pauseWorkoutTimer();
                } else {
                    startWorkoutTimer();
                }
            }

            private void pauseWorkoutTimer() {
                timerRunning = false;
                workoutCountdownTimer.cancel();
                startStopWorkoutDurationBtn.setText("START");
            }

            private void startWorkoutTimer() {
                if (isFirstRun) {
                    // Initialise workout variables from user input
                    numberOfSetsParseLong();
                    restPeriodDurationParseLong();
                    workoutDurationParseLong();

                    isFirstRun = false;
                }

                System.out.println("TIMELEFT: " + timeLeft);
                    workoutCountdownTimer = new CountDownTimer(timeLeft, 1000) {
                        int tempTimeLeft = timeLeft;
                        @Override
                        public void onTick(long l) {
                            timeLeft = timeLeft - 1000;
                            progressBarCounter = (timeLeft / 10); // Todo: Fix the progressBar();
                            updateWorkoutProgressBar(progressBarCounter);
                        }

                        @Override
                        public void onFinish() {
                            setsLeft--;
                            System.out.println("SETS LEFT: " + setsLeft);
                            if (setsLeft > 0) {
                                timeLeft = tempTimeLeft;
                                startRestPeriodTimer();
                            }
                        }
                    }.start();
                    timerRunning = true;
                    startStopWorkoutDurationBtn.setText("PAUSE");
                }

                private void startRestPeriodTimer() {
                int tempRestTime = restPeriod;
                if (isFirstRun) {
                    restPeriodDurationParseLong();
                }

                restPeriodCountdownTimer = new CountDownTimer(restPeriod, 1000) {
                    @Override
                    public void onTick(long l) {
                        restPeriod -= 1000;
                        updateWorkoutProgressBar(restPeriod + 1000);
                    }

                    @Override
                    public void onFinish() {
                        restPeriod = tempRestTime;
                        startWorkoutTimer();
                    }
                }.start();
            }

            private int workoutDurationParseLong() {
                workoutDuration = findViewById(R.id.idWorkoutDurationEditText);
                String workoutDurationStr = workoutDuration.getText().toString();

                if (workoutDurationStr.isEmpty()) {
                    workoutDurationStr = "30";
                }

                int workoutDurationNum = Integer.parseInt(workoutDurationStr);
                progressBarToEmpty = workoutDurationNum * 1000;
                return timeLeft = workoutDurationNum * 1000;
            }

            private void restPeriodDurationParseLong() {
                restPeriodDuration = findViewById(R.id.idRestPeriodDurationEditText);
                String restPeriodDurationStr = restPeriodDuration.getText().toString();

                if (restPeriodDurationStr.isEmpty()) {
                    restPeriodDurationStr = "30";
                }

                int restPeriodDurationNum = Integer.parseInt(restPeriodDurationStr);

                restPeriod = restPeriodDurationNum * 1000;
            }

            private void numberOfSetsParseLong() {
                numberOfSets = findViewById(R.id.idSetSelector);
                String numberOfSetsStr = numberOfSets.getText().toString();

                if (numberOfSetsStr.isEmpty()) {
                    numberOfSetsStr = "3";
                }

                long numberOfSetsNum = Long.parseLong(numberOfSetsStr);
                setsLeft = numberOfSetsNum;
            }

            private void updateWorkoutProgressBar(int workoutProgress) {
                workoutProgressBar = findViewById(R.id.idWorkoutProgressBar);
                workoutProgressBar.setProgress(workoutProgress);
            }
        });
    }}