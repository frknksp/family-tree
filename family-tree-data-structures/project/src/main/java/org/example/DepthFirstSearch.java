package org.example;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.*;
import java.util.List;


public class DepthFirstSearch extends JFrame {
    JFrame f;

    public static TreeNode searchParent(Kisi kisi, TreeNode root) {

        if (root == null) return null;

        if (root.kisi.isim.equals(kisi.babaAdi) || root.kisi.isim.equals(kisi.anneAdi)) {
            return root;
        }
        for (TreeNode it : root.children) {
            TreeNode result = searchParent(kisi, it);
            if (result != null) return result;
        }
        return null;
    }


    public static List<TreeNode> findLeaves(TreeNode root) {
        List<TreeNode> leaves  = new ArrayList<>();
        if (root == null) {
            return leaves;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.children.isEmpty()) {
                leaves.add(current);
            } else {
                stack.addAll(current.children);
            }
        }
        return leaves;
    }


    public static List<Kisi> searchRelationship(Kisi buyuk,Kisi kucuk, TreeNode root) {
        List<Kisi> visited = new ArrayList<>();
        boolean flag = false;
        Kisi ilkkisi = null;

        if (root == null) {
            return visited;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode curr = stack.peek();
            boolean haveUnknownPath = false;
            for (TreeNode child : curr.children) {
                if (!visited.contains(child.kisi)) {
                    visited.add(child.kisi);
                    stack.push(child);
                    haveUnknownPath = true;
                    break;
                }
            }
            if (haveUnknownPath && !curr.kisi.isim.equals(buyuk.isim)) {
                continue;
            }
            if (curr.kisi.isim.equals(buyuk.isim)) {
                flag = true;
                ilkkisi = curr.kisi;
            }
            if (flag) {
                visited.add(curr.kisi);
            }
            if (curr.kisi.isim.equals(kucuk.isim)) {
                break;
            }
            if (!haveUnknownPath) {
                stack.pop();
            }
        }

        List<Kisi> stackList = new ArrayList<>();
        while (!stack.empty()) {
            stackList.add(stack.pop().kisi);
        }

//        System.out.println("visited = " + stackList);
        for (Kisi kisi : stackList) {
            System.out.print(kisi.isim + "-");
        }
        System.out.println();
        return stackList;

    }

    public  void Dugumler(TreeNode node) {
        f=new JFrame("Family Tree");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        ArrayList<Kisi> kardesler=new ArrayList<>();
        TreeNode current = queue.remove();
        DefaultMutableTreeNode first=new DefaultMutableTreeNode(current.kisi.getIsim()+current.kisi.getKizlikSoyismi()+current.kisi.getSoyisim()+"-"+current.kisi.getEsi());
        if (current.children!=null) {
            for (TreeNode child : current.children) {
        DefaultMutableTreeNode second = new DefaultMutableTreeNode(child.kisi.getIsim()+" "+child.kisi.getKizlikSoyismi()+" "+child.kisi.getSoyisim() + "-" + child.kisi.getEsi());
           first.add(second);
                    kardesler.add(child.kisi);
                    for (int i = 0; i < child.children.size(); i++) {
                        DefaultMutableTreeNode third = new DefaultMutableTreeNode(child.children.get(i).kisi.getIsim()+" "+child.children.get(i).kisi.getKizlikSoyismi()+" "+child.children.get(i).kisi.getSoyisim() + "-" + child.children.get(i).kisi.getEsi());
                        second.add(third);
                        for (int j = 0; j < child.children.get(i).children.size(); j++) {
                            DefaultMutableTreeNode fourth = new DefaultMutableTreeNode(child.children.get(i).children.get(j).kisi.getIsim() +" "+child.children.get(i).children.get(j).kisi.getKizlikSoyismi()+" "+child.children.get(i).children.get(j).kisi.getSoyisim()+ "-" + child.children.get(i).children.get(j).kisi.getEsi());
                            third.add(fourth);
                            for (int k = 0; k < child.children.get(i).children.get(j).children.size(); k++) {
                                DefaultMutableTreeNode fifth = new DefaultMutableTreeNode(child.children.get(i).children.get(j).children.get(k).kisi.getIsim() + "-" + child.children.get(i).children.get(j).children.get(k).kisi.getEsi());
                                fourth.add(fifth);
                            }
                        }
                }
            }
            for (TreeNode child : current.children) {
                queue.add(child);
            }
            JTree jt=new JTree(first);
            jt.setRowHeight(50);
            f.add(jt);
            f.setSize(800,1200);
            f.setVisible(true);
        }
}

}


