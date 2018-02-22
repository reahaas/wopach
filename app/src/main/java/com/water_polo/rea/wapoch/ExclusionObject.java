package com.water_polo.rea.wapoch;

/**
 * Created by rea on 2/2/2018.
 */

public class ExclusionObject {
    private long _exclusionGameTime;
    private long _exclusionShotTime;
    private int _period;
    private String _type;

    public ExclusionObject(String type, int period, long exclusionGameTime, long exclusionShotTime) {
        this._type = type;
        this._period = period;
        this._exclusionGameTime = exclusionGameTime;
        this._exclusionShotTime = exclusionShotTime;
    }

    public ExclusionObject(ExclusionObject exclusion) {
        this._type = exclusion.getType();
        this._period = exclusion.getPeriod();
        this._exclusionGameTime = exclusion.getExclusionGameTime();
        this._exclusionShotTime = exclusion.getExclusionShotTime();
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

    public long getExclusionGameTime() {
        return this._exclusionGameTime;
    }

    public void setExclusionGameTime(long exclusionGameTime) {
        this._exclusionGameTime = exclusionGameTime;
    }

    public long getExclusionShotTime() {
        return this._exclusionShotTime;
    }

    public void setExclusionShotTime(long exclusionShotTime) {
        this._exclusionShotTime = exclusionShotTime;
    }
}


