package com.water_polo.rea.wapoch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class GoalSelectPlayer extends AppCompatActivity {


    int goalSelectedPlayer = 0;

    RadioGroup radioGroupGoalSelectPlayer1_5;
    RadioGroup radioGroupGoalSelectPlayer6_10;
    RadioGroup radioGroupGoalSelectPlayer11_15;

    RadioButton radioButtonGoalSelectPlayer1_5;
    RadioButton radioButtonGoalSelectPlayer6_10;
    RadioButton radioButtonGoalSelectPlayer11_15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_select_player);


        this.radioGroupGoalSelectPlayer1_5 = (RadioGroup) findViewById(R.id.radioGroupGoalSelectPlayer1_5);
        this.radioGroupGoalSelectPlayer6_10 = (RadioGroup) findViewById(R.id.radioGroupGoalSelectPlayer6_10);
        this.radioGroupGoalSelectPlayer11_15 = (RadioGroup) findViewById(R.id.radioGroupGoalSelectPlayer11_15);


    }

    public void radioButtonGoalSelectPlayerOnClick(View view)
    {
            clearAllOtherGoalRadioGroups(view);
            goalSelectedPlayer = view.getTextAlignment();
    }

    private void clearAllOtherGoalRadioGroups(View view)
    {
        if((view.getParent()) == radioButtonGoalSelectPlayer1_5 )
        {
            radioButtonGoalSelectPlayer6_10.clearAnimation();
            radioButtonGoalSelectPlayer11_15.clearAnimation();
        }
        else if((view.getParent()) == radioButtonGoalSelectPlayer6_10 )
        {
            radioButtonGoalSelectPlayer1_5.clearAnimation();
            radioButtonGoalSelectPlayer11_15.clearAnimation();
        }
        else if((view.getParent()) == radioButtonGoalSelectPlayer11_15 )
        {
            radioButtonGoalSelectPlayer1_5.clearAnimation();
            radioButtonGoalSelectPlayer6_10.clearAnimation();
        }
    }


    public void sendInputBack() {
        this.selectedPlayer.putExtra("scorer", this.scorer);
        this.selectedPlayer.putExtra("goalType", this.goalType);
        setResult(-1, this.selectedPlayer);
        finish();
    }
}
