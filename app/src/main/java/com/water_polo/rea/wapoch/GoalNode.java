package com.water_polo.rea.wapoch;

/**
 * Created by rea on 2/3/2018.
 */

public class GoalNode {
    private long _goalGameTime;
    private long _goalShotTime;
    private GoalNode _next;
    private int _period;
    private String _type;

    public GoalNode(String type, long scoreGameTime, long scoreShotTime, int period) {
        this._type = type;
        this._period = period;
        this._goalGameTime = scoreGameTime;
        this._goalShotTime = scoreShotTime;
    }

    public GoalNode(GoalNode goalNode) {
        this._type = goalNode.getType();
        this._period = goalNode.getPeriod();
        this._goalGameTime = goalNode.getGoalGameTime();
        this._goalShotTime = goalNode.getGoalShotTime();
    }

    public String getType() {
        return this._type;
    }

    public void setType(String type) {
        this._type = type;
    }

    public int getPeriod() {
        return this._period;
    }

    public void setPeriod(int period) {
        this._period = period;
    }

    public long getGoalGameTime() {
        return this._goalGameTime;
    }

    public void setGoalGameTime(long goalGameTime) {
        this._goalGameTime = goalGameTime;
    }

    public long getGoalShotTime() {
        return this._goalShotTime;
    }

    public void setGoalShotTime(long goalShotTime) {
        this._goalShotTime = goalShotTime;
    }

    public GoalNode getNext() {
        return this._next;
    }

    public void setNext(GoalNode next) {
        this._next = next;
    }
}
