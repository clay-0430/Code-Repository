package com.wg.demo.calculate.tree.preorder;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wg
 * @date 2021/3/10
 */
public class PreOrder {

    /**
     * 递归排序
     *
     * @return
     */
//    private static List<Integer> preOrder(List<Integer> res, Node node) {
//        if (node == null) {
//            return res;
//        }
//        res.add(node.getVal());
//        if (node.getChildren() != null) {
//            for (Node child : node.getChildren()) {
//                preOrder(res, child);
//            }
//        }
//        return res;
//    }
//
//    private static List<Integer> preOrderByStack(List<Integer> res, Node root){
//        Stack<Node> stack = new Stack<>();
//        if (root == null){
//            return res;
//        }
//        stack.push(root);
//        while(!stack.isEmpty())
//        {
//            Node node = stack.pop();
//            res.add (node.getVal());
//            for(int i =  node.getChildren().size()-1;i>= 0;i--)
//            {
//                stack.add(node.getChildren().get(i));
//            }
//        }
//        return res;
//    }
    public static void main(String[] args) {

        List<Integer> res = new ArrayList<>();

        Node n1 = new Node();
        n1.setVal(5);

        Node n2 = new Node();
        n2.setVal(6);

        Node n3 = new Node();
        n3.setVal(3);
        List<Node> children3 = Lists.newArrayList();
        children3.add(n1);
        children3.add(n2);
        n3.setChildren(children3);

        Node n4 = new Node();
        n4.setVal(2);

        Node n5 = new Node();
        n5.setVal(4);

        Node n6 = new Node();
        n6.setVal(1);
        List<Node> children6 = Lists.newArrayList();
        children6.add(n3);
        children6.add(n4);
        children6.add(n5);
        n6.setChildren(children6);
//        Node n7 = new Node();
//        n1.setVal(1);
//
//        Node n8 = new Node();
//        n1.setVal(1);
//
//        Node n9 = new Node();
//        n1.setVal(1);
//
//        Node n10 = new Node();
//        n1.setVal(1);
//        System.out.println(preOrder(res, n6));
//        System.out.println(preOrderByStack(res, n6));
//        System.out.println(preOrder1(n6));
        System.out.println(preOrderByStack1(n6));
    }

    static List<Integer> res = new ArrayList<>();

    private static List<Integer> preOrder1(Node node) {
        if (node == null) {
            return new ArrayList<>();
        }
        res.add(node.getVal());
        if (node.getChildren() != null) {
            for (Node child : node.getChildren()) {
                preOrder1(child);
            }
        }
        return res;
    }

    private static List<Integer> preOrderByStack1(Node node){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            res.add(pop.getVal());
            if (!CollectionUtils.isEmpty(pop.getChildren())){
                for (int i = pop.getChildren().size() - 1; i >= 0; i--) {
                    stack.push(pop.getChildren().get(i));
                }
            }
        }
        return res;
    }


}
