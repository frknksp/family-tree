package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Functions {

    public static List<Kisi> searchBloodGroup(List<Kisi> allPersons, String kanGrubu) {
        List<Kisi> members = new ArrayList<>();

        for (Kisi kisi : allPersons) {
                if (kisi.kanGrubu.equals(kanGrubu)) {
                    if (members.size() == 0) {
                        members.add(kisi);
                    } else {
                        boolean flag = false;
                        for (Kisi member : members) {
                            if (member.id == kisi.id) {
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            members.add(kisi);
                        }
                    }
                }
            }
        return members;
    }

    static int depthOfTree(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 0;
        for (TreeNode it : root.children) {
            depth = Math.max(depth, depthOfTree(it));
        }
        return depth + 1;
    }


    public static TreeNode findRelations(List<Kisi> visited) {
        //Collections.reverse(visited);
        String relation = "";
        for(int i = 1; i < visited.size(); i++){
            if(visited.get(i).cinsiyet.equals("Kadın")){
                relation += "Anne ";
            }
            else if(visited.get(i).cinsiyet.equals("Erkek")){
                relation += "Baba ";
            }
        }
        System.out.println(relation);
        return null;
    }
}
