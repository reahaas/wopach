package com.water_polo.rea.wapoch;

/**
 * Created by rea on 2/3/2018.
 */

public class GoalList {
    private GoalNode _goalListHead;

    public GoalList() {
        this._goalListHead = null;
    }

    public GoalList(GoalList goalList) {
        GoalNode temp = goalList.getGoalListHead();
        this._goalListHead = new GoalNode(temp);
        for (temp = temp.getNext(); temp != null; temp = temp.getNext()) {
            addToHead(temp);
        }
    }

    public GoalNode getGoalListHead() {
        return this._goalListHead;
    }

    public boolean empty() {
        return this._goalListHead == null;
    }

    public GoalNode nextElement(GoalNode goalNode) {
        return goalNode.getNext();
    }

    public void addToHead(GoalNode goalNode) {
        GoalNode temp = this._goalListHead;
        this._goalListHead = goalNode;
        goalNode.setNext(temp);
    }

    public int lenght() {
        int counter = 0;
        for (GoalNode temp = this._goalListHead; temp != null; temp = temp.getNext()) {
            counter++;
        }
        return counter;
    }
}
