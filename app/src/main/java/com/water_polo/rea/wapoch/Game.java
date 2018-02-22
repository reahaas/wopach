package com.water_polo.rea.wapoch;

/**
 * Created by rea on 2/2/2018.
 */

public class Game {
    private Team _guestTeam = new Team("home");
    private Team _holdsTheBall = null;
    private Team _homeTeam = new Team("guest");

    public Team getHomeTeam() {
        return this._homeTeam;
    }

    public void setHomeTeam(String nameOfTeam) {
        this._homeTeam = new Team(nameOfTeam);
    }

    public Team getGuestTeam() {
        return this._guestTeam;
    }

    public void setGuestTeam(String nameOfTeam) {
        this._guestTeam = new Team(nameOfTeam);
    }

    public Team getHoldsTheBall() {
        return this._holdsTheBall;
    }

    public void setHoldsTheBall(Team holdsTheBall) {
        this._holdsTheBall = holdsTheBall;
    }
}