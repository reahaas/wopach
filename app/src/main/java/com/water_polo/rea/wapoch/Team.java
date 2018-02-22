package com.water_polo.rea.wapoch;

import android.app.Application;

/**
 * Created by rea on 2/2/2018.
 */

public class Team extends Application {
    final int TEAM_SIZE = 15;
    private int _exclusion;
    private int _foulTotal;
    private int _lossesTotal;
    private String _name;
    private int _passesTotal;
    private Player[] _players;
    private int _pointsTotal;
    private int _shotsInFrameTotal;
    private int _shotsOutFrameTotal;
    private int _shotsTotalTotal;
    private int _takesTotal;

    public Team(String nameOfTeam) {
        this._name = nameOfTeam;
        this._players = new Player[15];
        for (int i = 0; i < 15; i++) {
            this._players[i] = new Player(i + 1);
        }
        this._pointsTotal = 0;
        this._exclusion = 0;
        this._passesTotal = 0;
        this._foulTotal = 0;
        this._lossesTotal = 0;
        this._takesTotal = 0;
        this._shotsInFrameTotal = 0;
        this._shotsOutFrameTotal = 0;
        this._shotsTotalTotal = 0;
    }

    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public int getPointsTotal() {
        return this._pointsTotal;
    }

    public void updatePointsTotal() {
        for (int i = 0; i < 15; i++) {
            this._pointsTotal += getPlayerAt(i).getPointsTotal();
        }
    }

    public int getExclusion() {
        return this._exclusion;
    }

    public void updateExclusion() {
        for (int i = 0; i < 15; i++) {
            this._exclusion += getPlayerAt(i).getExclusionsNum();
        }
    }

    public int getPassesTotal() {
        return this._passesTotal;
    }

    public void setPassesTotal(int passesTotal) {
        this._passesTotal = passesTotal;
    }

    public int getFoulTotal() {
        return this._foulTotal;
    }

    public void setFoulTotal(int foulTotal) {
        this._foulTotal = foulTotal;
    }

    public int getLossesTotal() {
        return this._lossesTotal;
    }

    public void updateLossesTotal() {
        for (int i = 0; i < 15; i++) {
            this._lossesTotal += getPlayerAt(i).getLosses().lenght();
        }
    }

    public int getTakesTotal() {
        return this._takesTotal;
    }

    public void setTakesTotal(int takesTotal) {
        this._takesTotal = takesTotal;
    }

    public int getShotsInFrameTotal() {
        return this._shotsInFrameTotal;
    }

    public void updateShotsInFrame() {
        for (int i = 0; i < 15; i++) {
            ShotNode temp = getPlayerAt(i).getShotsTotal().getShotListHead();
            while (temp != null) {
                if (temp.getType()) {
                    this._shotsInFrameTotal++;
                    temp = temp.getNext();
                }
            }
        }
    }

    public int getShotsOutFrameTotal() {
        return this._shotsOutFrameTotal;
    }

    public void updateShotsOutFrame() {
        for (int i = 0; i < 15; i++) {
            ShotNode temp = getPlayerAt(i).getShotsTotal().getShotListHead();
            while (temp != null) {
                if (!temp.getType()) {
                    this._shotsOutFrameTotal++;
                    temp = temp.getNext();
                }
            }
        }
    }

    public int getShotsTotalTotal() {
        return this._shotsTotalTotal;
    }

    public void updateShotsTotalTotal(int shotsTotalTotal) {
        this._shotsTotalTotal = getShotsInFrameTotal() + getShotsOutFrameTotal();
    }

    public Player getPlayerAt(int playerNum) {
        return this._players[playerNum - 1];
    }

    public void setPlayerAt(int playerNumber, Player player) {
        this._players[playerNumber - 1] = new Player(player);
    }

    public void addGoal(int playerNum, String type, long scoreGameTime, long scoreShotTime, int period) {
        getPlayerAt(playerNum).addGoal(type, scoreGameTime, scoreShotTime, period);
    }
}
