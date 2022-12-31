package org.example;


import java.util.*;
import java.util.List;


public class BreadthFirstSearch {
    public static TreeNode searchParent(Kisi kisi, TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if (current.kisi.isim.equals(kisi.babaAdi) || current.kisi.isim.equals(kisi.anneAdi)) {
               if(current.kisi.soyisim.equals(kisi.soyisim) || current.kisi.soyisim.equals(kisi.kizlikSoyismi))
                    return current;
            } else {
                queue.addAll(current.children);
            }
        }
        return null;
    }

    public static List<String> findSiblings(TreeNode node) {
        // Üvey kardeşlerin bulunacağı liste
        List<String> siblings = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            ArrayList<Kisi> kardesler = new ArrayList<>();
            TreeNode current = queue.remove();
            if (current.children != null) {
                for (TreeNode child : current.children) {
                    kardesler.add(child.kisi);
                }
                for (int i = 0; i < kardesler.size(); i++) {
                    String esadi;
                    for (int j = i + 1; j < kardesler.size(); j++) {
                        int adindis = current.kisi.getEsi().indexOf(" ");
                        if (adindis != -1) {
                            esadi = current.kisi.getEsi().substring(0, adindis);
                        } else {
                            esadi = current.kisi.getEsi();
                        }


                        if (kardesler.get(i).getBabaAdi() == kardesler.get(j).getBabaAdi()) {
                        } else {
                            if (kardesler.get(i).getBabaAdi() != esadi) {
                                siblings.add(kardesler.get(i).getIsim());
                            } else if (kardesler.get(j).getBabaAdi() != esadi) {
                                siblings.add(kardesler.get(j).getIsim());
                            }
                        }

                        if (kardesler.get(i).getAnneAdi() == kardesler.get(j).getAnneAdi()) {

                        } else {
                            if (kardesler.get(i).getAnneAdi() != esadi) {
                                siblings.add(kardesler.get(i).getIsim());
                            } else if (kardesler.get(j).getAnneAdi() != esadi) {
                                siblings.add(kardesler.get(j).getIsim());

                            }
                        }
                    }
                }
            }
            for (TreeNode child : current.children) {
                queue.add(child);
            }
        }
        return siblings;
    }
}