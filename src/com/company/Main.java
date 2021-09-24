package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here



//        MyTree NewMyTree = new MyTree(100);
//        System.out.println(NewMyTree.Size());
//        MyNode node = new MyNode(10);
//        MyNode node2 = new MyNode(20);
//        MyNode node3 = new MyNode(30);
//        MyNode node4 = new MyNode(40);
//        MyNode node5 = new MyNode(50);
//        node.setParent(NewMyTree.getRoot());
//        NewMyTree.addNode(node);
//        System.out.println(NewMyTree.Size());
//        node2.setParent(NewMyTree.getRoot());
//        NewMyTree.addNode(node2);
//        System.out.println(NewMyTree.Size());
//        node3.setParent(NewMyTree.getRoot().getDown());
//        NewMyTree.addNode(node3);
//        System.out.println(NewMyTree.Size());
//        node4.setParent(NewMyTree.getRoot().getDown());
//        NewMyTree.addNode(node4);
//        System.out.println(NewMyTree.Size());
//        node5.setParent(NewMyTree.getRoot().getDown().getDown().getRight());
//        //node5.setParent(NewMyTree.getRoot().getDown().getRight());
//        NewMyTree.addNode(node5);
//        System.out.println(NewMyTree.Size());
//        System.out.println("vvv");
////        System.out.println(NewMyTree.getRoot().getDown().getRight().getRight().getValue());
//        System.out.println(NewMyTree.getNode(0).getValue());
//        System.out.println("A");
//        System.out.println(NewMyTree.getNode(1).getValue());
//        System.out.println("A");
//        System.out.println(NewMyTree.getNode(2).getValue());
//        System.out.println("A");
//        System.out.println(NewMyTree.getNode(3).getValue());
//        System.out.println("A");
//        System.out.println(NewMyTree.getNode(4).getValue());
//        System.out.println(NewMyTree.getNode(5).getValue());
//        System.out.println("start");
//        System.out.println(NewMyTree.getRoot().getValue());
//        System.out.println(NewMyTree.getRoot().getDown().getValue());
//        System.out.println(NewMyTree.getRoot().getDown().getRight().getValue());
//        System.out.println(NewMyTree.getRoot().getDown().getDown().getValue());
//        System.out.println(NewMyTree.getRoot().getDown().getDown().getRight().getValue());
//        System.out.println(NewMyTree.getRoot().getDown().getDown().getRight().getDown().getValue());
//        System.out.println(NewMyTree.getRoot().getValue());
//        System.out.println(NewMyTree.getRoot().getDown().getIndex());
//        System.out.println(NewMyTree.getRoot().getDown().getRight().getIndex());
//        System.out.println(NewMyTree.getRoot().getDown().getDown().getIndex());
//        System.out.println(NewMyTree.getRoot().getDown().getDown().getRight().getIndex());
//        System.out.println(NewMyTree.getRoot().getDown().getDown().getRight().getDown().getIndex());
//        System.out.println("end");
//        NewMyTree.removeNode(0);
//        System.out.println(NewMyTree.getRoot().getValue());
//        System.out.println(NewMyTree.Size());
//        //NewMyTree.removeChild(1);
//        //System.out.println(NewMyTree.getRoot().getDown().getValue());
//        //NewMyTree.removeChild(4);
//        NewMyTree.removeNode(NewMyTree.getRoot());
//        NewMyTree.removeNode(NewMyTree.getRoot().getDown());
//        //NewMyTree.removeChild(2);
//        System.out.println(NewMyTree.Size());
////        System.out.println("vvv");
////        System.out.println(NewMyTree.getRoot().getDown().getRight().getRight().getValue());
////        System.out.println(NewMyTree.getChild(0).getValue());
////        System.out.println("A");
////        System.out.println(NewMyTree.getChild(1).getValue());
////        System.out.println("A");
////        System.out.println(NewMyTree.getChild(2).getValue());
////        System.out.println("A");
////        System.out.println(NewMyTree.getChild(3).getValue());
////        System.out.println(NewMyTree.Size());
////        System.out.println(NewMyTree.getChild(4).getValue());
//        System.out.println("vvv");
//        //NewMyTree.removeChild(3);
//        System.out.println(NewMyTree.Size());
//        System.out.println(NewMyTree.getNode(1).getValue());
//        System.out.println(NewMyTree.getRoot().getValue());
//        System.out.println(NewMyTree.getRoot().getDown() == null);
//        System.out.println(NewMyTree.getRoot().getDown().getRight() == null);
//        NewMyTree.deleteTree();
//        System.out.println(NewMyTree.isEmpty());
//




      /*  MyList NewMyList = new MyList(1);
        System.out.println(NewMyList.indexOf(1));
        System.out.println(NewMyList.isEmpty());
        System.out.println(NewMyList.Size());
        NewMyList.add(5);
        System.out.println(NewMyList.indexOf(5));
        System.out.println(NewMyList.isEmpty());
        System.out.println(NewMyList.Size());
        if (NewMyList.get(0) !=null)
        System.out.println(NewMyList.get(0));
        if (NewMyList.get(1) !=null)
        System.out.println(NewMyList.get(1));
        System.out.println(NewMyList.remove(1));
        System.out.println(NewMyList.remove(0));
        System.out.println(NewMyList.Size());
        System.out.println(NewMyList.isEmpty());
        NewMyList.add(6,5);
        if (NewMyList.get(0) !=null)
            System.out.println(NewMyList.get(0));
        NewMyList.add(8,-1);
        if (NewMyList.get(0) !=null)
            System.out.println(NewMyList.get(0));
        NewMyList.add(7,1);
        System.out.println(NewMyList.Size());
        if (NewMyList.get(0) !=null)
            System.out.println(NewMyList.get(0));
        if (NewMyList.get(1) !=null)
            System.out.println(NewMyList.get(1));
        if (NewMyList.get(2) !=null)
            System.out.println(NewMyList.get(2));

        System.out.println(NewMyList.Size());
        NewMyList.set(10, 1);
        NewMyList.set(9, 0);
        NewMyList.set(8, 5);
        if (NewMyList.get(0) !=null)
            System.out.println(NewMyList.get(0));
        if (NewMyList.get(1) !=null)
            System.out.println(NewMyList.get(1));
        if (NewMyList.get(2) !=null)
            if (NewMyList.get(2) !=null)
                System.out.println(NewMyList.get(2));
        System.out.println(NewMyList.isEmpty());




        System.out.println("MAP");
        Map newMap = new Map( 5,12);
        System.out.println(newMap.isEmpty());
        System.out.println(newMap.get(5));
        System.out.println(newMap.Size());
        System.out.println(newMap.get(3, 8));
        System.out.println(newMap.Size());
        newMap.put(1,100);
        System.out.println(newMap.Size());
        newMap.put(5,500);
        newMap.put(2,200);
        System.out.println(newMap.Size());
        System.out.println(newMap.get(5));
        System.out.println(newMap.remove(1));
        System.out.println(newMap.Size());
        System.out.println(newMap.remove(5));
        System.out.println(newMap.remove(2));
        System.out.println(newMap.remove(3));
        System.out.println(newMap.isEmpty());
*/
    }


}
