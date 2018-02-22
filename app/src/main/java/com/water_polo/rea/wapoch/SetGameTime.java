
package com.water_polo.rea.wapoch;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SetGameTime extends AppCompatActivity implements OnLongClickListener {

    /*
    all activetis finals
     */
    final int MINUTE_FULL_TENTHS = 6;
    final int QUARTER_FULL_MINUTES = 8;
    final int TENTH_FULL_SECONDS = 10;

    /*
    declaration all activites views
     */
    Button buttonMinus1TimeGame;
    Button buttonOkSetTimeGame;
    Button buttonPlus1TimeGame;
    int intMinutsGame;
    int intSecondsGame;
    int intTenthsGame;
    RadioButton radioButtonMinutes;
    RadioButton radioButtonSeconds;
    RadioButton radioButtonTenths;
    RadioGroup radioGroupMinutes;
    RadioGroup radioGroupSeconds;
    RadioGroup radioGroupTenths;
    Intent selectedTime;
    Handler setDeley;
    Runnable startDelay;
    TextView textViewGameTime;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_set_game_time);

        /*
        reference to all activites views
         */
        this.radioGroupMinutes = (RadioGroup) findViewById(R.id.radioGroupMinutes);
        this.radioGroupTenths = (RadioGroup) findViewById(R.id.radioGroupTenths);
        this.radioGroupSeconds = (RadioGroup) findViewById(R.id.radioGroupSeconds);
        this.textViewGameTime = (TextView) findViewById(R.id.textViewGameTime);
        this.buttonMinus1TimeGame = (Button) findViewById(R.id.buttonMinus1TimeGame);
        this.buttonMinus1TimeGame.setOnLongClickListener(this);
        this.buttonOkSetTimeGame = (Button) findViewById(R.id.buttonOkSetTimeGame);
        this.buttonPlus1TimeGame = (Button) findViewById(R.id.buttonPlus1TimeGame);
        this.buttonPlus1TimeGame.setOnLongClickListener(this);
        this.intMinutsGame = getIntent().getExtras().getInt("minutes");
        this.intTenthsGame = getIntent().getExtras().getInt("tenths");
        this.intSecondsGame = getIntent().getExtras().getInt("seconds");
        updateDisplay();
        this.selectedTime = new Intent();
    }


    public void radioButtonMinutesOnClick(View v) {
        this.radioButtonMinutes = (RadioButton) findViewById(this.radioGroupMinutes.getCheckedRadioButtonId());
        this.intMinutsGame = Integer.valueOf(this.radioButtonMinutes.getText().toString()).intValue();
        if (this.intMinutsGame == 8) {
            this.intTenthsGame = 0;
            this.intSecondsGame = 0;
            Toast.makeText(this, "quarter set to full", Toast.LENGTH_SHORT).show();
        }
        updateTimeDisplay();
    }

    public void radioButtonTenthsOnClick(View v) {
        this.radioButtonTenths = (RadioButton) findViewById(this.radioGroupTenths.getCheckedRadioButtonId());
        this.intTenthsGame = Integer.valueOf(this.radioButtonTenths.getText().toString()).intValue();
        if (this.intMinutsGame == 8) {
            this.intTenthsGame = 0;
            Toast.makeText(this, "quarter if full, can't add time", Toast.LENGTH_SHORT).show();
        }
        updateTimeDisplay();
    }

    public void radioButtonSecondsOnClick(View v) {
        this.radioButtonSeconds = (RadioButton) findViewById(this.radioGroupSeconds.getCheckedRadioButtonId());
        this.intSecondsGame = Integer.valueOf(this.radioButtonSeconds.getText().toString()).intValue();
        if (this.intMinutsGame == 8) {
            this.intSecondsGame = 0;
            Toast.makeText(this, "quarter if full, can't add time", Toast.LENGTH_SHORT).show();
            return;
        }
        updateTimeDisplay();
    }

    public void buttonSecOnClick(View v) {
        if (v == this.buttonPlus1TimeGame) {
            addSecond();
        } else if (v == this.buttonMinus1TimeGame) {
            subSecond();
        } else {
            sendInputBack();
        }
        updateDisplay();
    }

    public void addSecond() {
        if (this.intSecondsGame < 9 && this.intTenthsGame < 6 && this.intMinutsGame < 8) {
            this.intSecondsGame++;
        } else if (this.intTenthsGame < 5 && this.intMinutsGame < 8) {
            this.intTenthsGame++;
            this.intSecondsGame = 0;
        } else if (this.intMinutsGame < 8) {
            this.intMinutsGame++;
            this.intTenthsGame = 0;
            this.intSecondsGame = 0;
        } else {
            Toast.makeText(this, "quarter if full, can't add time", Toast.LENGTH_SHORT).show();
        }
    }

    public void subSecond() {
        if (this.intSecondsGame > 0) {
            this.intSecondsGame--;
        } else if (this.intTenthsGame > 0) {
            this.intTenthsGame--;
            this.intSecondsGame = 9;
        } else if (this.intMinutsGame > 0) {
            this.intMinutsGame--;
            this.intTenthsGame = 5;
            this.intSecondsGame = 9;
        } else {
            Toast.makeText(this, "quarter if empty, can't sub time", Toast.LENGTH_SHORT).show();
        }
    }

    public void sendInputBack() {
        this.selectedTime.putExtra("minutes", this.intMinutsGame);
        this.selectedTime.putExtra("tenths", this.intTenthsGame);
        this.selectedTime.putExtra("seconds", this.intSecondsGame);
        Toast.makeText(this, "send input back method", Toast.LENGTH_SHORT).show();
        setResult(-1, this.selectedTime);
        finish();
    }

    public void updateTimeDisplay() {
        this.textViewGameTime.setText("0" + this.intMinutsGame + ":" + this.intTenthsGame + "" + this.intSecondsGame + "");
    }

    public void updateRadioGroupsDisplay() {
        int radioButtonMinutesId = 0; // the id of the button to return
        if (this.intMinutsGame >= 0 && this.intMinutsGame <= 8) {
            switch (this.intMinutsGame) {
                case 0:
                    radioButtonMinutesId = R.id.radioButtonMinute0;
                    break;
                case 1:
                    radioButtonMinutesId = R.id.radioButtonMinute1;
                    break;
                case 2:
                    radioButtonMinutesId = R.id.radioButtonMinute2;
                    break;
                case 3:
                    radioButtonMinutesId = R.id.radioButtonMinute3;
                    break;
                case 4:
                    radioButtonMinutesId = R.id.radioButtonMinute4;
                    break;
                case 5:
                    radioButtonMinutesId = R.id.radioButtonMinute5;
                    break;
                case 6:
                    radioButtonMinutesId = R.id.radioButtonMinute6;
                    break;
                case 7:
                    radioButtonMinutesId = R.id.radioButtonMinute7;
                    break;
                case 8:
                    radioButtonMinutesId = R.id.radioButtonMinute8;
                    break;
            }
        }
        int radioButtonTenthsId = 0; // the id of the button to return
        if (this.intTenthsGame >= 0 && this.intTenthsGame <= 6) {
            switch (this.intTenthsGame) {
                case 0:
                    radioButtonTenthsId = R.id.radioButtonTenths0;
                    break;
                case 1:
                    radioButtonTenthsId = R.id.radioButtonTenths1;
                    break;
                case 2:
                    radioButtonTenthsId = R.id.radioButtonTenths2;
                    break;
                case 3:
                    radioButtonTenthsId = R.id.radioButtonTenths3;
                    break;
                case 4:
                    radioButtonTenthsId = R.id.radioButtonTenths4;
                    break;
                case 5:
                    radioButtonTenthsId = R.id.radioButtonTenths5;
                    break;
            }
        }
        int radioButtonSecondsId = 0;  // the id of the button to return
        if (this.intSecondsGame >= 0 && this.intSecondsGame <= 10) {
            switch (this.intSecondsGame) {
                case 0:
                    radioButtonSecondsId = R.id.radioButtonSeconds0;
                    break;
                case 1:
                    radioButtonSecondsId = R.id.radioButtonSeconds1;
                    break;
                case 2:
                    radioButtonSecondsId = R.id.radioButtonSeconds2;
                    break;
                case 3:
                    radioButtonSecondsId = R.id.radioButtonSeconds3;
                    break;
                case 4:
                    radioButtonSecondsId = R.id.radioButtonSeconds4;
                    break;
                case 5:
                    radioButtonSecondsId = R.id.radioButtonSeconds5;
                    break;
                case 6:
                    radioButtonSecondsId = R.id.radioButtonSeconds6;
                    break;
                case 7:
                    radioButtonSecondsId = R.id.radioButtonSeconds7;
                    break;
                case 8:
                    radioButtonSecondsId = R.id.radioButtonSeconds8;
                    break;
                case 9:
                    radioButtonSecondsId = R.id.radioButtonSeconds9;
                    break;
            }
        }
        this.radioGroupMinutes.check(radioButtonMinutesId);
        this.radioGroupTenths.check(radioButtonTenthsId);
        this.radioGroupSeconds.check(radioButtonSecondsId);
    }

    public void updateDisplay() {
        updateTimeDisplay();
        updateRadioGroupsDisplay();
    }

    public boolean onLongClick(View v) {
        if (v == this.buttonPlus1TimeGame) {
            longAddSeconds(v);
        } else if (v == this.buttonMinus1TimeGame) {
            longSubSeconds(v);
        }
        return false;
    }

    public void longAddSeconds(View v) {
        while (v.isPressed()) {
            this.startDelay = new Runnable() {
                public void run() {
                    SetGameTime.this.addSecond();
                }
            };
            this.setDeley.postDelayed(this.startDelay, 100);
        }
    }

    private void longSubSeconds(View v) {
        while (v.isPressed()) {
            this.startDelay = new Runnable() {
                public void run() {
                    SetGameTime.this.subSecond();
                }
            };
            this.setDeley.postDelayed(this.startDelay, 100);
        }
    }
}
