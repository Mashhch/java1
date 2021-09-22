package com.company;

public class Node {
    // int level = 0;
    int index = 0;
    private Node parent = null;
    private Node right = null;
    private Node left = null;
    private Node down = null;
    private Object value;

    Node(Node value) {
        this.value = value.getValue();
        this.parent = value.getParent();
        this.right = value.getRight();
        this.down = value.getDown();
        this.index = value.getIndex();
        this.left = value.getLeft();
        //  this.level = value.getLevel();
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    void setNode(Node value) {
        this.value = value.getValue();
        this.parent = value.getParent();
        this.left = value.getLeft();
        this.right = value.getRight();
        this.down = value.getDown();
        this.index = value.getIndex();
        //   this.level = value.getLevel();
    }

    Node(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    // public int getLevel() {
    //     return level;
    // }

    public Node getParent() {
        return parent;
    }

    public Node getRight() {
        return right;
    }

    public Node getDown() {
        return down;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setDown(Node down) {
        this.down = down;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
