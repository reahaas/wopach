package com.water_polo.rea.wapoch;

/**
 * Created by rea on 2/3/2018.
 */

public class LostList {
    private LostNode _lostListHead;

    public LostList() {
        this._lostListHead = null;
    }

    public LostList(LostNode lostListHead) {
        this._lostListHead = lostListHead;
    }

    public boolean empty() {
        return this._lostListHead == null;
    }

    public LostNode nextElement(LostNode lostNode) {
        return lostNode.getNext();
    }

    public LostList(LostList lostList) {
        this._lostListHead = new LostNode(lostList.getLostListHead());
    }

    public void addToHead(LostNode lostNode) {
        LostNode temp = this._lostListHead;
        this._lostListHead = lostNode;
        lostNode.setNext(temp);
    }

    public int lenght() {
        int counter = 0;
        for (LostNode temp = this._lostListHead; temp != null; temp = temp.getNext()) {
            counter++;
        }
        return counter;
    }

    public LostNode getLostListHead() {
        return this._lostListHead;
    }

    public void setLostListHead(LostNode _lostListHead) {
        this._lostListHead = _lostListHead;
    }
}
