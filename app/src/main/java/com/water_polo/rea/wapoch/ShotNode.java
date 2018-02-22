package com.water_polo.rea.wapoch;

/**
 * Created by rea on 2/3/2018.
 */

public class ShotNode {
    private ShotNode _next;
    private int _period;
    private long _shotGameTime;
    private long _shotShotTime;
    private boolean _type;

    public ShotNode(boolean type, long scoreGameTime, long scoreShotTime, int period) {
        this._type = type;
        this._period = period;
        this._shotGameTime = scoreGameTime;
        this._shotShotTime = scoreShotTime;
    }

    public ShotNode(ShotNode shotNode) {
        this._type = shotNode.getType();
        this._period = shotNode.getPeriod();
        this._shotGameTime = shotNode.getShotGameTime();
        this._shotShotTime = shotNode.getShotShotTime();
    }

    public boolean getType() {
        return this._type;
    }

    public void setType(boolean type) {
        this._type = type;
    }

    public int getPeriod() {
        return this._period;
    }

    public void setPeriod(int period) {
        this._period = period;
    }

    public long getShotGameTime() {
        return this._shotGameTime;
    }

    public void setShotGameTime(long shotGameTime) {
        this._shotGameTime = shotGameTime;
    }

    public long getShotShotTime() {
        return this._shotShotTime;
    }

    public void setShotShotTime(long shotShotTime) {
        this._shotShotTime = shotShotTime;
    }

    public ShotNode getNext() {
        return this._next;
    }

    public void setNext(ShotNode next) {
        this._next = next;
    }
}
