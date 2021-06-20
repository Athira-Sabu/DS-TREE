package com.example.dstree.bst;

import java.util.TreeSet;

public class BST {
    private Node createNewNode(int val) {
        Node node = new Node();
        node.setData(val);
        node.setLeft(null);
        node.setRight(null);
        return node;
    }

    public Node insertElement(Node node, int val){
        if(node == null){
            return createNewNode(val);
        }
        else  if(node.getData() < val) {
          node.setRight(insertElement(node.getRight(), val));
        } else {
           node.setLeft(insertElement(node.getLeft(), val));
        }
        return node;
    }
    public Node delete(Node node, int val) {

        if(node == null) {
          return node;
        }
        if(node.getData() < val) {
            node.setRight(delete(node, val));
        } else if(node.getData()> val) {
            node.setLeft(delete(node, val));
        } else {
            // node with no child or node with one child
            Node temp = null;
            if(node.getLeft() == null || node.getRight() == null) {
                temp = node.getLeft() != null ? node.getLeft(): node.getRight();
                return temp;
            } else {

                temp = findMinFromRight(node);
                node.setData(temp.getData());
                node.setRight(delete(node.getRight(),temp.getData()));
                return node;
            }

        }
        return node;
    }

    private Node findMinFromRight(Node node) {
        if(node == null)
            return null;
        Node temp = node.getRight();
        while (temp.getLeft() != null){
           temp = node.getLeft();
        }
        return temp;

    }
}
