package com.wg.demo.calculate.tree.preorder;

import lombok.Data;

import java.util.List;

/**
 * @author wg
 * @date 2021/3/10
 */
@Data
public class Node {

    private int val;

    private List<Node> children;

    public Node(){

    }

    public Node(int val){
        this.val = val;
    }

    public Node(int val, List<Node> children){
        this.val = val;
        this.children = children;
    }
}
