package com.company;

public class MyNode {
    int index;
    private MyNode parent = null;
    private MyNode right = null;
    private MyNode down = null;
    private Object value;

    MyNode(MyNode value) {
        this.value = value.getValue();
        this.parent = value.getParent();
        this.right = value.getRight();
        this.down = value.getDown();
        this.index = value.getIndex();
    }

    MyNode(Object value){
        this.value = value;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setRight(MyNode right) {
        this.right = right;
    }

    public void setDown(MyNode down) {
        this.down = down;
    }

    public void setParent(MyNode parent) {
        this.parent = parent;
    }

    public int getIndex() {
        return index;
    }

    public Object getValue() {
        return value;
    }

    public MyNode getParent() {
        return parent;
    }

    public MyNode getRight() {
        return right;
    }

    public MyNode getDown() {
        return down;
    }

    void setNode(MyNode value) {
        this.value = value.getValue();
        this.parent = value.getParent();
        this.right = value.getRight();
        this.down = value.getDown();
        this.index = value.getIndex();
    }

    public void addChild(MyNode child){
        if(this.getDown() == null){
            this.setDown(child);
        }
        MyNode nowNode = this.getDown();
        while (nowNode.getRight() != null) {
            nowNode = nowNode.getRight();
        }
        nowNode.setRight(child);
    }

    public MyNode getChild(int index) {
        if (index < 0) return null;
        if (this.getDown() == null) return null;
        if (index == 0) return this.getDown();
        int nowIndex =0;
        MyNode childNode = this.getDown();
        while (childNode != null) {
            childNode = childNode.getRight();
            nowIndex++;
            if(index == nowIndex) return childNode;
        }
        return null;
    }

    public boolean removeChild(int index){
        if (index<0) return false;
        if(this.getDown() == null){
            return false;
        }
        if(index == 0){
            if(this.getDown().getRight() != null) {
                this.setDown(this.getDown().getRight());
                return true;
            }
            else{
                this.setDown(null);
                return true;
            }
        }
        int nowIndex =0;
        MyNode prevNode = this.getDown();
        MyNode nowNode = this.getDown();
        while (nowNode.getRight() != null && nowIndex<index) {
            prevNode =nowNode;
            nowNode = nowNode.getRight();
            nowIndex++;
        }
        if(index != nowIndex) return false;
        else {
            if(nowNode.getRight() != null)
                prevNode.setRight(nowNode.getRight());
            else{
                prevNode.setRight(null);
            }
            return true;
        }
    }

    public boolean removeChild(MyNode child){
        if (child == null) return false;
        if(this.getDown() == null){
            return false;
        }
        if(this.getDown() ==child){
            if(this.getDown().getRight() != null) {
                this.setDown(this.getDown().getRight());
                return true;
            }
            else{
                this.setDown(null);
                return true;
            }
        }
        MyNode prevNode = this.getDown();
        MyNode nowNode = this.getDown();
        while (nowNode.getRight() != null && nowNode.getRight() != child) {
            prevNode =nowNode;
            nowNode = nowNode.getRight();
        }
        if(nowNode.getRight() != child) return false;
        else {
            if(nowNode.getRight() != null)
                prevNode.setRight(nowNode.getRight());
            else{
                prevNode.setRight(null);
            }
            return true;
        }
    }

    public  MyNode findPredecessor(MyNode another) {
        if(another == null) return null;
        if (another.getParent() == null) return null;
        if (this.getParent() == null) return null;
        MyNode anotherP = new MyNode(another.getParent());
        MyNode thisP = new MyNode(this.getParent());
        while (thisP.getParent() != null) {
            if (thisP.getParent() == anotherP) return anotherP;
            thisP = thisP.getParent();
        }
        thisP = this.getParent();
        while (anotherP.getParent() != null) {
            if (anotherP.getParent() == thisP) return thisP;
            anotherP = anotherP.getParent();
        }
        return null;
    }

    public  MyNode findParent(MyNode another) {
        if(another==null) return null;
        if (another.getParent() == null) return null;
        if (this.getParent() == null) return null;
        if(this.getParent() == another.getParent()) return this.getParent();
        return null;
    }

    public MyList path(MyNode child) {
        if(child == null) return null;
        if (this.getDown() == null) return null;
        MyNode nowNode = this.getDown();
        while (nowNode.getRight() != null && nowNode.getRight() != child) {
            nowNode = nowNode.getRight();
        }
        if(nowNode.getRight() != child) return null;
        else {
            nowNode = this.getDown();
            MyList newList = new MyList(child.getParent());
            while (nowNode != child) {
                newList.add(nowNode,0);
                nowNode = nowNode.getRight();
            }
            newList.add(nowNode);
            return newList;
        }


    }

}
