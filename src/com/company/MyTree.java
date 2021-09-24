package com.company;




public class MyTree {


    MyNode root;
    private int size = 0;

    MyTree(Object root) {
        this.root = new MyNode(root);
        ReIndex(0, this.root);
    }

    MyTree(MyNode root) {
        this.root = new MyNode(root);
        ReIndex(0, this.root);
    }

    public int Size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public MyNode getRoot() {
        return root;
    }

    private void ReIndex(int index, MyNode fromNode) {
        if (isEmpty()) return;
        MyNode nowNode = new MyNode(fromNode);
        fromNode.setIndex(index);
        if (nowNode.getRight() != null) {
            index++;
            this.size=index+1;
            ReIndex(index, nowNode.getRight());
        }
        if (nowNode.getDown() != null) {
            index++;
            this.size=index+1;
            ReIndex(index, nowNode.getDown());
        }
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


    public void addNode(MyNode value) {
        if (isEmpty()) {
            this.root.setNode(value);
            return;
        }
        if (value.getParent() == null) return;
        if(value.getParent().getDown() != null) {
            MyNode valueSister = value.getParent().getDown();
            while (valueSister.getRight() != null)
                valueSister = valueSister.getRight();
            valueSister.setRight(value);
        }
        else {
            value.getParent().setDown(value);
        }
        ReIndex(0, root);
    }

//    private int removeNode1(int index, int nowIndex, int flag, MyNode fromNode) {
//        if (index <= 0) {
//            return 0;
//        }
//        MyNode nowNode = new MyNode(fromNode);
//        MyNode rightNode = new MyNode(fromNode);
//            if (nowNode.getRight() != null) {
//                nowIndex++;
//                flag = removeNode1(index, nowIndex, flag, nowNode.getRight());
//                if (flag == 1) return 1;
//            }
//            if (nowNode.getDown() != null) {
//                nowIndex++;
//                flag = removeNode1(index, nowIndex, flag, nowNode.getDown());
//                if (flag == 1) return 1;
//        }
//        if (index == fromNode.getIndex()) {
//            if (fromNode.getParent().getDown() != fromNode) {
//                MyNode Sister = fromNode.getParent().getDown();
//                while(Sister.getRight() != fromNode)
//                    Sister=Sister.getRight();
//                Sister.setRight(fromNode.getRight());
//                ReIndex(0, root);
//                return 1;
//            } else {
//                if (fromNode.getRight() != null) {
//                    fromNode.getParent().setDown(fromNode.getRight());
//                } else {
//                    fromNode.getParent().setDown(null);
//                }
//                ReIndex(0, root);
//                return 1;
//            }
//        }
//        return 0;
//    }

    public void removeNode(int index) {
        if (isEmpty()) {
            return;
        }
        if(index >= this.Size() || index <= 0) return;
        MyNode remoteNode = getNode(index);
        remoteNode.getParent().removeChild(remoteNode);

       // removeNode1(index, 0, 0, root);
    }


    public void removeNode(MyNode value) {
        if (isEmpty()) {
            return;
        }
        if (value.getParent() == null) return;
        value.getParent().removeChild(value);
//        if (value.getParent().getDown() != value) {
//            MyNode Sister = value.getParent().getDown();
//            while(Sister.getRight() != value)
//                Sister=Sister.getRight();
//            Sister.setRight(value.getRight());
//            ReIndex(0, root);
//            return;
//        } else {
//            if (value.getRight() != null) {
//                value.getParent().setDown(value.getRight());
//            } else {
//                value.getParent().setDown(null);
//            }
//       }
            ReIndex(0, root);
    }

    private MyNode getNode1(int index, int nowIndex, MyNode fromNode){
        if (fromNode.getIndex() == index)
            return fromNode;
        MyNode nowNode = new MyNode(fromNode);
            if (nowNode.getRight() != null) {
                nowIndex++;

                fromNode = getNode1(index, nowIndex, nowNode.getRight());
                if (fromNode.getIndex() == index)
                    return fromNode;
            }
            if (nowNode.getDown() != null) {
                nowIndex++;
                fromNode = getNode1(index, nowIndex, nowNode.getDown());
                if (fromNode.getIndex() == index)
                    return fromNode;
        }
        if(index==0){
            return root;
        }
        return fromNode;
    }

    public MyNode getNode(int index) {
        if (isEmpty()) {
            return null;
        }
        if (index < 0 || index >=this.Size()) return null;

        return getNode1(index, 0, root);
    }

    private MyNode findNode1(int index, MyNode fromNode, Object value){
        MyNode nowNode = new MyNode(fromNode);
        MyNode downNode;
        MyNode rightNode;
        while (value != fromNode.getValue()) {
            if (nowNode.getRight() != null) {
                rightNode = nowNode.getRight();
                index++;
                fromNode = findNode1(index, rightNode, value);
                if(fromNode != null) {
                    if (fromNode.getValue() == value)
                        return fromNode;
                }
            }
            if (nowNode.getDown() != null) {
                downNode = nowNode.getDown();
                index++;
                fromNode = findNode1(index, downNode, value);
                if (fromNode != null) {
                    if (fromNode.getValue() == value)
                        return fromNode;
                }
            }
        }
        return null;
    }

    public MyNode find(Object value){
        if (isEmpty()) {
            return null;
        }
        return findNode1(0, root, value);
    }

    public MyNode getParent(int index){
        if (index<=0 || index>= this.Size()) return null;
        MyNode findNode = getNode(index);
        return findNode.getParent();
    }

    public MyTree subTree(MyNode value){
        MyNode newRoot = new MyNode(value);
        newRoot.setParent(null);
        newRoot.setRight(null);
        return new MyTree(newRoot);
    }

    public MyList toList(){
        if(this.isEmpty()) return null;
        MyList newList = new MyList(root);
        for(int i =1;i<this.Size();i++){
            newList.add(this.getNode(i));
        }
        return newList;
    }

    public void deleteTree(){
        this.root =null;
    }
}


//    public MyList toList(MyNode child){
//        if(this.isEmpty()) return null;
//        if (child.getParent() == null) return null;
//        if (child.getParent().getDown() == null) return null;
//        MyNode nowNode = child.getParent().getDown();
//        while(nowNode != child && nowNode != null){
//            nowNode = nowNode.getRight();
//        }
//        if (nowNode == null) {
//            return null;
//        }
//        else {
//            MyList childParent = new MyList(child.getParent());
//            nowNode = child.getParent().getDown();
//            while (nowNode != child) {
//                childParent.add(nowNode);
//                nowNode = nowNode.getRight();
//            }
//            return childParent;
//        }
//    }


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

