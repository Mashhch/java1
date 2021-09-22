package com.company;




public class MyTree {


    // int[] Arraylvl = new int[1];
    Node root = null;
    private int size = 0;

    MyTree(Object root) {
        this.root = new Node(root);
        //this.Arraylvl[0]=1;
        this.size++;
    }

    MyTree(Node root) {
        this.root = new Node(root);
        this.size++;
    }

    public int Size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Node getRoot() {
        return root;
    }

    public void ReIndex(int index, Node fromNode) {
        if (isEmpty()) return;
        Node nowNode = new Node(fromNode);
        Node downNode = new Node(fromNode);
        Node rightNode = new Node(fromNode);
        int indexNow = index;
        //  for(int i =0; i<this.Size();i++){}
        //while(nowNode != null){
        nowNode.setIndex(indexNow);
        indexNow++;
        //while(nowNode != null) {
        if (nowNode.getRight() != null) {
            rightNode = nowNode.getRight();
            ReIndex(indexNow, rightNode);
        }
        if (nowNode.getDown() != null) {
            downNode = nowNode.getDown();
            ReIndex(indexNow, downNode);
        }
        //  }
        //  }
    }

    /*public void addNode1(int index, Node whereNode, Node fromNode) {
        Node nowNode = new Node(whereNode);
        Node downNode = new Node(whereNode);
        Node rightNode = new Node(whereNode);
        if (index == 0) {
            nowNode = root;
            nowNode.setValue(fromNode.getValue());
            if (fromNode.getDown() != null) {
                while (nowNode.getDown() != null) {
                    nowNode = nowNode.getRight();
                }
                nowNode.setRight(fromNode.getDown());
                fromNode.getDown().setLeft(nowNode);
                ReIndex(0, root);
            }
            return;
        }
        while (index < fromNode.getIndex()) {
            if (nowNode.getRight() != null) {
                rightNode = nowNode.getRight();
                index++;
                addNode1(index, rightNode,fromNode);
            }
            if (nowNode.getDown() != null) {
                downNode = nowNode.getDown();
                index++;
                addNode1(index, downNode, fromNode);
            }
        }
        if (index == fromNode.getIndex()) {
            if (nowNode.getLeft() != null) {
                nowNode.getLeft().setRight(fromNode);
                fromNode.setLeft(nowNode.getLeft());
                fromNode.setRight(nowNode);
                fromNode.setParent(nowNode.getParent());
                nowNode.setLeft(fromNode);
                ReIndex(0, root);
                return;
            } else {
                nowNode.getParent().setDown(fromNode);
                fromNode.setParent(nowNode.getParent());
                fromNode.setRight(nowNode);
                fromNode.setLeft(null);
                nowNode.setLeft(fromNode);
                ReIndex(0, root);
                return;
            }
        }
        if (index > fromNode.getIndex()) {
            if (fromNode.getParent() == nowNode) {
                nowNode.setDown(fromNode);
                fromNode.setIndex(nowNode.getIndex() + 1);
                return;
            } else {
                nowNode.setRight(fromNode);
                fromNode.setLeft(nowNode);
                fromNode.setParent(nowNode.getParent());
                fromNode.setIndex(nowNode.getIndex() + 1);
                return;
            }
        }
        return;
    }

    public void addChild(Node value) {
        if (isEmpty()) {
            this.root.setNode(value);
            return;
        }
        if (value.getIndex() < 0) value.setIndex(0);
        addNode1(0, root, value);
        return;
    }*/

    public void addChild(Node value) {
        if (isEmpty()) {
            this.root.setNode(value);
            return;
        }
        Node valueParent = value.getParent();
        Node valueSister = valueParent.getDown();
        while (valueSister.getRight() != null)
            valueSister = valueSister.getRight();
        valueSister.setRight(value);
        value.setLeft(valueSister);
        ReIndex(0, root);
        this.size++;
    }


    public void removeNode1(int index, Node fromNode) {
        if (index == 0) {
            return;
        }
        Node nowNode = new Node(fromNode);
        Node downNode = new Node(fromNode);
        Node rightNode = new Node(fromNode);
        while (index < fromNode.getIndex()) {
            if (nowNode.getRight() != null) {
                rightNode = nowNode.getRight();
                index++;
                removeNode1(index, rightNode);
            }
            if (nowNode.getDown() != null) {
                downNode = nowNode.getDown();
                index++;
                removeNode1(index, downNode);
            }
        }
        if (index == fromNode.getIndex()) {
            if (nowNode.getLeft() != null) {
                nowNode.getLeft().setRight(nowNode.getRight());
                nowNode.getRight().setLeft(nowNode.getLeft());
                nowNode = null;
                ReIndex(0, root);
                this.size--;
                return;
            } else {
                if (nowNode.getRight() != null) {
                    nowNode.getParent().setDown(nowNode.getRight());
                    nowNode.getRight().setLeft(null);
                } else {
                    nowNode.getParent().setDown(null);
                }
                nowNode = null;
                this.size--;
                ReIndex(0, root);
                return;
            }
        }
       // if(index > this.Size()) return;
        return;
    }

    public void removeChild(int index) {
        if (isEmpty()) {
            return;
        }
        if(index > this.Size()) return;
        if (index < 0 ) index = 0;
        removeNode1(index, root);
    }


    public void removeChild(Node value) {
        if (isEmpty()) {
            return;
        }
        if (value.getIndex() <= 0) {
            return;
        }

        if (value.getIndex() > this.Size()) {
            return;
        }
        if (value.getLeft() != null) {
            value.getLeft().setRight(value.getRight());
            value.getRight().setLeft(value.getLeft());
            value = null;
            ReIndex(0, root);
            this.size--;
            return;
        } else {
            if (value.getRight() != null) {
                value.getParent().setDown(value.getRight());
                value.getRight().setLeft(null);
            } else {
                value.getParent().setDown(null);
            }
            value = null;
            this.size--;
            ReIndex(0, root);
            return;
        }
    }

    public Node getNode(int index,Node fromNode){
        Node nowNode = new Node(fromNode);
        Node downNode;
        Node rightNode;
        while (index < fromNode.getIndex()) {
            if (nowNode.getRight() != null) {
                rightNode = nowNode.getRight();
                index++;
                fromNode = getNode(index, rightNode);
                if (fromNode.getIndex() == index)
                    return fromNode;
            }
            if (nowNode.getDown() != null) {
                downNode = nowNode.getDown();
                index++;
                fromNode = getNode(index, downNode);
                if (fromNode.getIndex() == index)
                    return fromNode;
            }
        }
        if(index==0){
            return root;
        }
        return fromNode;
    }

    public Node getChild(int index) {
        if (isEmpty()) {
            return null;
        }
        if (index < 0) index = 0;
        return getNode(index, root);
    }

    public Node find1(int index, Node fromNode, Object value){
        Node nowNode = new Node(fromNode);
        Node downNode;
        Node rightNode;
        while (value != fromNode.getValue()) {
            if (nowNode.getRight() != null) {
                rightNode = nowNode.getRight();
                index++;
                fromNode = find1(index, rightNode, value);
                if (fromNode.getValue() == value)
                    return fromNode;
            }
            if (nowNode.getDown() != null) {
                downNode = nowNode.getDown();
                index++;
                fromNode = find1(index, downNode, value);
                if (fromNode.getValue() == value)
                    return fromNode;
            }
        }
        return null;
    }

    public Node find(Object value){
        if (isEmpty()) {
            return null;
        }
        return find1(0, root, value);
    }

    public Node getParent(int index){
        if (index<=0 || index>= this.Size()) return null;
        Node findNode = getNode(index, root);
        return findNode.getParent();
    }


}
      /*  private class Node{
            int index = 0;
            Node parent = null;
            MyList children = new MyList();
            Object value;
            Node(Node value){
                this.index = value.getIndex();
                this.value = value.getValue();
                this.parent = value.getParent();
                this.children = value.getChildren();
            }
            Node(int index, Object value){
            this.value = value;
            }
            public Object getValue() {
                return value;
            }

            void setNode(Node value){
                this.index = value.getIndex();
                this.value = value.getValue();
                this.parent = value.getParent();
                this.children = value.getChildren();
            }

            public Node getParent() {
                return parent;
            }

            public int getIndex() {
                return index;
            }

            public MyList getChildren() {
                return children;
            }

            public void setValue(Object value) {
                this.value = value;
            }

            public void setParent(Node parent) {
                this.parent = parent;
            }

            public void setChildren(Object children) {
                this.children.add(children);
            }

            public void setChildren(MyList children) {
                this.children = children;
            }
        }
        Node root = null;
        int size = 0;

         MyTree(Object root) {
             this.root = new Node(0, root);
             this.size++;
         }
        MyTree(Node root){
            this.root = new Node(root);
            this.size++;
        }

        public boolean isEmpty(){
            return this.size == 0;
        }

        public void Func(Node node, Node value) {
            Node nodeSeach = new Node(node);
             for(int i=0; i<node.getChildren().Size(); i++) {
                 if (value.getParent() == node.getChildren().get(i)){
                     nodeSeach.setChildren(value);
                     this.size++;
                     return;
                 }
             }
            for(int i=0; i<node.getChildren().Size(); i++) {
                nodeSeach =null;
            }
        }
        public void addChild(Node value){

            if (isEmpty()){
                this.root.setNode(value);
                return;
            }
            Node nodeSeach = new Node(root);
            if (this.root.getIndex() == value.getIndex())
            while(nodeSeach != null){
                if (nodeSeach.getParent() == value.getParent()){
                    nodeSeach.setChildren(value);
                    this.size++;
                    return;
                }
                for(int i=0; i<nodeSeach.getChildren().Size(); i++){
                    Node nodeSeach1 = new Node(root);
                    if ()

                }
            }
        }



*/

