package com.water_polo.rea.wapoch;

/**
 * Created by rea on 2/2/2018.
 */

public class Player {
    final int MAX_EXCLUSION_NUM = 3;
    private int _age;
    private ExclusionObject[] _exclusions;
    private int _exclusionsNum;
    private GoalList _goals;
    private LostList _losses;
    private String _name;
    private int _number;
    private int _pointsTotal;
    private ShotList _shotsTotal;

    public Player(int number, String name, int age) {
        this._number = number;
        this._name = name;
        this._age = age;
        this._exclusions = new ExclusionObject[3];
        this._exclusionsNum = 0;
        this._goals = null;
        this._pointsTotal = 0;
        this._losses = null;
        this._shotsTotal = null;
    }

    public Player(int number) {
        this._number = number;
        this._name = Integer.toString(number);
        this._age = 0;
        this._exclusions = new ExclusionObject[3];
        this._exclusionsNum = 0;
        this._goals = null;
        this._pointsTotal = 0;
        this._losses = null;
        this._shotsTotal = null;
    }

    public Player(Player player) {
        this._number = player.getNumber();
        this._name = player.getName();
        this._age = player.getAge();
        this._exclusions = new ExclusionObject[3];
        this._exclusionsNum = player.getExclusionsNum();
        for (int i = 0; i < this._exclusions.length; i++) {
            addExclusion(player.getExclusionIndex(i));
        }
        this._goals = player.getGoals();
        this._losses = player.getLosses();
        this._shotsTotal = player.getShotsTotal();
    }

    public int getNumber() {
        return this._number;
    }

    public void setNumber(int number) {
        this._number = number;
    }

    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public int getAge() {
        return this._age;
    }

    public void setAge(int age) {
        this._age = age;
    }

    public ExclusionObject[] getExclusionsArray() {
        return this._exclusions;
    }

    public int getExclusionsNum() {
        return this._exclusionsNum;
    }

    public ExclusionObject getExclusionIndex(int index) {
        return getExclusionsArray()[index];
    }

    public void addExclusion(ExclusionObject exclusion) {
        if (getExclusionsArray()[0] == null) {
            getExclusionsArray()[0] = new ExclusionObject(exclusion);
        } else if (getExclusionsArray()[1] == null) {
            getExclusionsArray()[1] = new ExclusionObject(exclusion);
        } else if (getExclusionsArray()[2] == null) {
            getExclusionsArray()[2] = new ExclusionObject(exclusion);
        }
    }

    public GoalList getGoals() {
        return new GoalList(this._goals);
    }

    public int getPointsTotal() {
        return this._pointsTotal;
    }

    public void addPointsTotal() {
        this._pointsTotal++;
    }

    public LostList getLosses() {
        return this._losses;
    }

    public void addLossesTotal(LostNode losses) {
        this._losses.addToHead(losses);
    }

    public ShotList getShotsTotal() {
        return this._shotsTotal;
    }

    public void setShotsTotal(ShotList shotsTotalTotal) {
        this._shotsTotal = shotsTotalTotal;
    }

    public void addGoal(String type, long scoreGameTime, long scoreShotTime, int period) {
        getGoals().addToHead(new GoalNode(type, scoreGameTime, scoreShotTime, period));
    }
}


