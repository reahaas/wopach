package com.water_polo.rea.wapoch;

/**
 * Created by rea on 2/3/2018.
 */

public class LostNode {
    private long _lostGameTime;
    private long _lostShotTime;
    private LostNode _next;
    private int _period;

    public LostNode(long lostGameTime, long lostShotTime, int period) {
        this._period = period;
        this._lostGameTime = lostGameTime;
        this._lostShotTime = lostShotTime;
    }

    public LostNode(LostNode lostNode) {
        this._period = lostNode.getPeriod();
        this._lostGameTime = lostNode.getLostGameTime();
        this._lostShotTime = lostNode.getLostShotTime();
    }

    public int getPeriod() {
        return this._period;
    }

    public void setPeriod(int period) {
        this._period = period;
    }

    public long getLostGameTime() {
        return this._lostGameTime;
    }

    public void setLostGameTime(long lostGameTime) {
        this._lostGameTime = lostGameTime;
    }

    public long getLostShotTime() {
        return this._lostShotTime;
    }

    public void setLostShotTime(long lostShotTime) {
        this._lostShotTime = lostShotTime;
    }

    public LostNode getNext() {
        return this._next;
    }

    public void setNext(LostNode next) {
        this._next = next;
    }
}
