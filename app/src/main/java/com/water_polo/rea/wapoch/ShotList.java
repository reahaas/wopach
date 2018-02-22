package com.water_polo.rea.wapoch;

/**
 * Created by rea on 2/3/2018.
 */

public class ShotList {
    private ShotNode _shotListHead;

    public ShotList() {
        this._shotListHead = null;
    }

    public ShotList(ShotList shotList) {
        ShotNode temp = shotList.getShotListHead();
        this._shotListHead = new ShotNode(temp);
        for (temp = temp.getNext(); temp != null; temp = temp.getNext()) {
            addToHead(temp);
        }
    }

    public ShotNode getShotListHead() {
        return this._shotListHead;
    }

    public boolean empty() {
        return this._shotListHead == null;
    }

    public ShotNode nextElement(ShotNode shotNode) {
        return shotNode.getNext();
    }

    public void addToHead(ShotNode shotNode) {
        ShotNode temp = this._shotListHead;
        this._shotListHead = shotNode;
        shotNode.setNext(temp);
    }

    public int lenght() {
        int counter = 0;
        for (ShotNode temp = this._shotListHead; temp != null; temp = temp.getNext()) {
            counter++;
        }
        return counter;
    }
}
