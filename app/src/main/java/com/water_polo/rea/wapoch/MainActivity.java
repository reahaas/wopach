package com.water_polo.rea.wapoch;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {


    /*
    declaration all  finals
     */
    private static final int SELCTOR_GOAL_SELECT_PLAYER = 1;
    final int SELCTOR_SET_GAME_TIME = 10;

    public static int period = 1;

    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;
    public static final int ELEVEN = 11;
    public static final int TWELVE = 12;
    public static final int THIRTEEN = 13;
    public static final int FOURTEEN = 14;
    public static final int FIFTEEN = 15;

    static final long MILLI_SECONDS_IN_MINUTE = 60000;
    static final long MILLI_SECONDS_IN_QUARTER = 480000;
    public static final long MILLI_SECONDS_IN_SECOND = 1000;
    static final long MILLI_SECONDS_IN_SHOT = 30000;
    public static long millisUntilQuarterFinish = MILLI_SECONDS_IN_QUARTER;
    public static long millisUntilShotFinish = MILLI_SECONDS_IN_SHOT;
    static final int SECONDS_IN_MINUTE = 60;
    static final int TIMER_INTERVAL = 100;
    final int TEN_TICKS = 10;


    /*
    declaration all the views in main activity
     */

    RadioGroup radioGroupHoldsTheBall;
    RadioButton radioButtonHoldsTheBall;

    Button buttonExclusion;
    Button buttonFoul;
    Button buttonGoal;
    Button buttonLost;
    Button buttonPass;
    Button buttonThroww;
    Button buttonStatistics;
    Button buttonGameRun;

    CountDownTimer countDownTimerGame;
    CountDownTimer countDownTimerShot;

    boolean isGameRun = false;
    TextView textViewExclusionRun;
    TextView textViewExclusionTime;

    TextView textViewGuest;
    TextView textViewGuestScore;
    TextView textViewHoldsTheBall;
    TextView textViewHome;
    TextView textViewHomeScore;
    TextView textViewPeriod;
    TextView textViewShotRun;
    TextView textViewShotTime;
    TextView textViewGameTime;

    public Game game = new Game();

    int tickCounterGame = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        reference to all activites views
         */

        this.radioGroupHoldsTheBall= (RadioGroup) findViewById(R.id.radioGroupHoldsTheBall);
        this.radioGroupHoldsTheBall.setOnClickListener(this);

        this.buttonGoal = (Button) findViewById(R.id.buttonGoal);
        this.buttonGoal.setOnClickListener(this);

        this.buttonExclusion = (Button) findViewById(R.id.buttonExclusion);
        this.buttonExclusion.setOnClickListener(this);

        this.buttonPass = (Button) findViewById(R.id.buttonPass);
        this.buttonPass.setOnClickListener(this);

        this.buttonThroww = (Button) findViewById(R.id.buttonThrow);
        this.buttonThroww.setOnClickListener(this);

        this.buttonLost = (Button) findViewById(R.id.buttonLost);
        this.buttonLost.setOnClickListener(this);

        this.buttonFoul = (Button) findViewById(R.id.buttonFoul);
        this.buttonFoul.setOnClickListener(this);

        this.buttonStatistics = (Button) findViewById(R.id.buttonStatistics);
        this.buttonStatistics.setOnClickListener(this);



        this.textViewHoldsTheBall = (TextView) findViewById(R.id.textViewHoldsTheBall);

        this.textViewPeriod = (TextView) findViewById(R.id.textViewPeriod);

        this.textViewHome = (TextView) findViewById(R.id.textViewHome);

        this.textViewGuest = (TextView) findViewById(R.id.textViewGuest);

        this.textViewHomeScore = (TextView) findViewById(R.id.textViewHomeScore);

        this.textViewGuestScore = (TextView) findViewById(R.id.textViewGuestScore);

        this.textViewShotRun = (TextView) findViewById(R.id.textViewShotRun);

        this.textViewExclusionRun = (TextView) findViewById(R.id.textViewExclusionRun);

        this.textViewShotTime = (TextView) findViewById(R.id.textViewShotTime);

        this.textViewExclusionTime = (TextView) findViewById(R.id.textViewExclosionTime);

        this.buttonGameRun = (Button) findViewById(R.id.buttonGameRun);
        this.buttonGameRun.setOnClickListener(this);
        this.textViewGameTime = (TextView) findViewById(R.id.textViewGameTime);
        this.textViewGameTime.setOnLongClickListener(this);


    }

    public void onClickRadioButtonHoldsTheBall(View view)
    {
        this.radioButtonHoldsTheBall = (RadioButton) findViewById(this.radioGroupHoldsTheBall.getCheckedRadioButtonId());

        if (radioButtonHoldsTheBall == findViewById(R.id.radioButtonHome))
        {
            this.game.setHoldsTheBall(this.game.getHomeTeam());
            Toast.makeText(this, "Home team holds the ball", Toast.LENGTH_SHORT).show();
        }
        else if (radioButtonHoldsTheBall == findViewById(R.id.radioButtonGuest)) {
            this.game.setHoldsTheBall(this.game.getGuestTeam());
            Toast.makeText(this, "Guest team holds the ball", Toast.LENGTH_SHORT).show();
        }
    }


    public void onClick(View v) {
        if (v == buttonGameRun) {
            //  (isGameRun) ? gameStop() : gameRun();


            if (isGameRun) {
                gameStop();
            } else {
                gameRun();
            }

        }
        if (v == this.buttonStatistics) {
            startActivity(new Intent(this, StatisticMainActivity.class));
        }
        if (v == this.buttonGoal) {
            if (this.game.getHoldsTheBall() != null) {
                if (this.isGameRun) {
                    gameStop();
                }
                startActivityForResult(new Intent(this, GoalSelectPlayer.class), SELCTOR_GOAL_SELECT_PLAYER);
            } else {
                Toast.makeText(this, "no team holds the ball", Toast.LENGTH_SHORT).show();
            }
        }
        if (v == this.buttonExclusion) {
            if (this.game.getHoldsTheBall() != null) {
                if (this.isGameRun) {
                    gameStop();
                }
                startActivity(new Intent(this, ExclusionSelectPlayer.class));
            } else {
                Toast.makeText(this, "no team holds the ball", Toast.LENGTH_SHORT).show();
            }
        }
        if (v == this.buttonPass) {
            Toast.makeText(this, "passes+1", Toast.LENGTH_SHORT).show();
        }
        if (v == this.buttonFoul) {
            if (this.game.getHoldsTheBall() != null) {
                Toast.makeText(this, "lost+1", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "fouls+1", Toast.LENGTH_SHORT).show();
        }
        if (v == this.buttonLost) {
            Toast.makeText(this, "lost+1", Toast.LENGTH_SHORT).show();
        }
        if (v == this.buttonThroww) {
            Toast.makeText(this, "throw+1", Toast.LENGTH_SHORT).show();
        }

    }



    @Override
    public boolean onLongClick(View view)
    {
        if (view == this.textViewGameTime) {
            if (this.isGameRun) {
                gameStop();
            }
            Intent intent = new Intent(this, SetGameTime.class);
            intent.putExtra("minutes", Integer.parseInt(String.valueOf(this.textViewGameTime.getText().charAt(1))));
            intent.putExtra("tenths", Integer.parseInt(String.valueOf(this.textViewGameTime.getText().charAt(3))));
            intent.putExtra("seconds", Integer.parseInt(String.valueOf(this.textViewGameTime.getText().charAt(4))));
            startActivityForResult(intent, SELCTOR_SET_GAME_TIME);
            Toast.makeText(this, "on click method activeted", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
        {
            switch (requestCode)
            {
                case SELCTOR_GOAL_SELECT_PLAYER: {
                    onActivityResultFromGoalSelectPlayyer (data);
                    break;
                }
                case SELCTOR_SET_GAME_TIME:
                {
                    onActivityResultFromSetGameTime (data);
                    break;
                }
                default:
                    return;
            }
        }
    }

    public void onActivityResultFromGoalSelectPlayyer(Intent data)
    {
        Toast.makeText(this, "goal by player number " + data.getExtras().getInt("scorer") + " from " + data.getExtras().get("goalType"), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, " in game time: " + (millisUntilQuarterFinish / MILLI_SECONDS_IN_MINUTE) + ":" + ((millisUntilQuarterFinish % MILLI_SECONDS_IN_MINUTE) / 1000) + "in shot time: " + (millisUntilShotFinish / 1000), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "isGameRun is: " + this.isGameRun, Toast.LENGTH_SHORT).show();
        updateTimesDisplay();
        Toast.makeText(this, "after update display in game time: " + (millisUntilQuarterFinish / MILLI_SECONDS_IN_MINUTE) + ":" + ((millisUntilQuarterFinish % MILLI_SECONDS_IN_MINUTE) / 1000) + "in shot time: " + (millisUntilShotFinish / 1000), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "after update display isGameRun is: " + this.isGameRun, Toast.LENGTH_SHORT).show();


    }


    public void onActivityResultFromSetGameTime(Intent data)
    {
        millisUntilQuarterFinish = ((((long) data.getExtras().getInt("minutes")) * MILLI_SECONDS_IN_MINUTE) + ((((long) data.getExtras().getInt("tenths")) * MILLI_SECONDS_IN_SECOND) * 10)) + (((long) data.getExtras().getInt("seconds")) * MILLI_SECONDS_IN_SECOND);
        Toast.makeText(this, "check in main activity", Toast.LENGTH_SHORT).show();
        updateGameTimeDisplay();

    }

    public void gameRun() {
        isGameRun = true;
        createQuarterTimmer();
        createShotTimmer();
        updateRunButtonDisplay();
    }

    public void gameStop() { this.isGameRun = false; updateRunButtonDisplay(); }


    public void updateRunButtonDisplay() {
        if (isGameRun) {
            buttonGameRun.setText("stop");
            buttonGameRun.setBackgroundColor(Color.RED);
            return;
        }
        this.buttonGameRun.setText("run");
        this.buttonGameRun.setBackgroundColor(Color.GREEN);
    }

    public void createQuarterTimmer() {
        this.countDownTimerGame = new CountDownTimer(millisUntilQuarterFinish, 100) {
            public void onTick(long millisUntilFinished) {
                if (isGameRun) // use for stop the game time
                {
                    //MainActivity mainActivity = MainActivity.this;
                    tickCounterGame++;
                    MainActivity.millisUntilQuarterFinish = millisUntilFinished;
                    if (tickCounterGame == 10)
                    {
                        //Toast.makeText( this , "if is ok" , Toast.LENGTH_SHORT).show();
                        updateGameTimeDisplay();
                        tickCounterGame = 1;
                        // return;
                    }
                    //return;
                }
                else {
                    cancel();
                }
            }

            public void onFinish() {
                MainActivity.this.quarterEnd();
            }
        }.start();
    }

    public void quarterEnd() {
        gameStop();
        this.tickCounterGame = 0;
        this.textViewGameTime.setText("08:00");
        millisUntilQuarterFinish = MILLI_SECONDS_IN_QUARTER;
        shotReset();
        increasePeriod();
        Toast.makeText(this, "period ended", Toast.LENGTH_SHORT).show();
    }

    public void increasePeriod ()
    {
        if (period != 4) {
            period++;
            this.textViewPeriod.setText("Period:" + period);
        } else {
            gameFinished();
        }

    }

    public void gameFinished() {
        this.textViewPeriod.setText("Game has ended!");
        Toast.makeText(this, "game has ended", Toast.LENGTH_SHORT).show();
    }

    public void createShotTimmer() {
        countDownTimerShot = new CountDownTimer(millisUntilShotFinish, TIMER_INTERVAL) {
            public void onTick(long millisUntilFinished) {
                if (isGameRun) {
                    millisUntilShotFinish = millisUntilFinished;
                    updateShotTimeDisplay();
                    return;
                }
                cancel();
            }

            public void onFinish() {
                shotReset();
                createShotTimmer();
            }
        }.start();
    }

    public void shotReset() {
        millisUntilShotFinish = MILLI_SECONDS_IN_SHOT;
        this.textViewShotTime.setText("30:00");
    }

    public void updateTimesDisplay() {
        updateGameTimeDisplay();
        updateShotTimeDisplay();
    }

    public void updateShotTimeDisplay() {
        String addZero = "";
        if (millisUntilShotFinish / MILLI_SECONDS_IN_SECOND < 10) {
            addZero = "0";
        }
        this.textViewShotTime.setText(addZero + ((int) (millisUntilShotFinish / MILLI_SECONDS_IN_SECOND)) + "." + (((int) (millisUntilShotFinish % MILLI_SECONDS_IN_SECOND)) / 100));
    }

    public void updateGameTimeDisplay() {
        if ((millisUntilQuarterFinish % MILLI_SECONDS_IN_MINUTE) / MILLI_SECONDS_IN_SECOND >= 10) {
            this.textViewGameTime.setText("0" + (millisUntilQuarterFinish / MILLI_SECONDS_IN_MINUTE) + ":" + ((millisUntilQuarterFinish % MILLI_SECONDS_IN_MINUTE) / MILLI_SECONDS_IN_SECOND));
        } else {
            this.textViewGameTime.setText("0" + (millisUntilQuarterFinish / MILLI_SECONDS_IN_MINUTE) + ":0" + ((millisUntilQuarterFinish % MILLI_SECONDS_IN_MINUTE) / MILLI_SECONDS_IN_SECOND));
        }
    }

}
