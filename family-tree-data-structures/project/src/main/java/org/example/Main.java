package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> cocuguolmayandugumler=new ArrayList<>();
        ArrayList<Kisi> kangrubulist =new ArrayList<>();
        List<String> uveykardes =new ArrayList<>();
        HashSet<String> uveyliste= new HashSet<String>();
        List<String> siraliuveyliste =new ArrayList<>();
        Kisi buyukkisi = null;
        Kisi kucukkisi=null;

        List<Kisi> people = ReadExcel.readFromExcel("C:\\Users\\frknk\\Desktop\\CE\\2022-2023\\3.Sınıf-Güz\\Prolab1\\3.Proje\\proje3_2\\proje3\\src\\main\\java\\org\\example\\gunceltestdosyasi.xlsx");

            System.out.println("Listedeki kişi sayısı : "+people.size());
            System.out.println(people);

            TreeNode root = new TreeNode(people.get(0));

            for (int i = 1; i < people.size(); i++) {
                TreeNode foundNode = BreadthFirstSearch.searchParent(people.get(i), root);

                if (foundNode == null) {

                } else {
                    foundNode.addChild(people.get(i));
                }
            }
           // TreeNode.printNAryTree(root);

while(true){
    System.out.println("\nMENU");
    System.out.println("1-Çocuğu olmayan düğümlerin listesinin yaş sıralamasına göre kaydedilmesi");
    System.out.println("2-Üvey kardeşlerin harf sıralamasına göre kaydedilmesi");
    System.out.println("3-Kan grubu A olanların listesi ");
    System.out.println("4-Soyunda aynı mesleği yapan çocuklar veya torunlar");
    System.out.println("5-Soy ağacında aynı isme sahip kişilerin ismi ve yaşları ");
    System.out.println("6-Alınacak 2 tane id girdisinden sonra büyük olan kişinin küçük olan kişiye yakınlığı ");
    System.out.println("7-Alınacak kişi bilgisi ile o kişiye ait soy ağacının gösterilmesi");
    System.out.println("8-Soy ağacının kaç nesilden oluştuğunu görmek (Ağacın maksimum derinliği)");
    System.out.println("9-Kullanıcıdan alınan id girdisinden sonra o isimden sonra kaç nesil geldiğini görmek");
    System.out.println("10-Soy Ağacını arayüzde görmek");
    System.out.println("0-Çıkış");
    System.out.print("Yapmak istediginiz islemi secin: ");
    Scanner scanner=new Scanner(System.in);
    int islem=scanner.nextInt();
    switch (islem) {
        case 1:
            List<TreeNode> leaves = DepthFirstSearch.findLeaves(root);
            for (TreeNode leaf : leaves) {
                int lastfor=leaf.kisi.dogumTarihi.length()-4;
                int birth= Integer.parseInt(leaf.kisi.dogumTarihi.substring(lastfor));
                int age=2022-birth;
                System.out.println("Leaf: "+leaf.kisi.isim+"("+age+")");
                cocuguolmayandugumler.add(age);
            }
            Collections.sort(cocuguolmayandugumler);
            System.out.println("\n"+cocuguolmayandugumler);
            break;
        case 2:
            uveykardes=BreadthFirstSearch.findSiblings(root);
            uveyliste.addAll(uveykardes);
            siraliuveyliste.addAll(uveyliste);
            Collections.sort(siraliuveyliste);
            System.out.println(siraliuveyliste);
            break;
        case 3:
            System.out.print("Aranacak kan grubunu girin: ");
            Scanner scanner1=new Scanner(System.in);
            String kangrubu=scanner1.nextLine();
            for (Kisi search:people) {
                if(search.kanGrubu.contains(kangrubu)){
                    System.out.print(search.getIsim()+" ");
                    kangrubulist.add(search);
                }
            }
            System.out.println("\n"+kangrubulist);
            break;
        case 4:
           TreeNode.MeslekTree(root);
           /* TreeNode rootes = new TreeNode(people.get(1));
            for (int i = 2; i < people.size(); i++) {
                TreeNode foundNodes = BreadthFirstSearch.searchParent(people.get(i), rootes);
                if (foundNodes == null) {
                } else {
                    foundNodes.addChild(people.get(i));
                }
            }
           TreeNode.MeslekTree(rootes);
            */
            break;
        case 5:
            for (int i = 0; i < people.size(); i++) {
                for (int j = i+1; j <people.size() ; j++) {
                    if(people.get(i).getIsim().equals(people.get(j).getIsim())){
                        int lastfouri=people.get(i).getDogumTarihi().length()-4;
                        int lastfourj=people.get(j).getDogumTarihi().length()-4;
                        int birthi= Integer.parseInt(people.get(i).getDogumTarihi().substring(lastfouri));
                        int birthj= Integer.parseInt(people.get(j).getDogumTarihi().substring(lastfourj));
                        int agei=2022-birthi;
                        int agej=2022-birthj;
                        System.out.println(people.get(i).getIsim()+" yasi: "+agei+"----"+people.get(j).getIsim()+" yasi: "+agej);
                    }
                }
            }
            break;
        case 6:
            System.out.print("Id giriniz: ");
            Scanner idal=new Scanner(System.in);
            int idk1=idal.nextInt();
            System.out.print("Id giriniz: ");
            int idk2=idal.nextInt();
            for (Kisi k1:people) {
                for (Kisi k2:people) {
                    if( k1.getId()==idk1 && k2.getId()==idk2){
                      int lastfourk1=k1.getDogumTarihi().length()-4;
                        int lastfourk2=k2.getDogumTarihi().length()-4;
                        int birthk1= Integer.parseInt(k1.getDogumTarihi().substring(lastfourk1));
                        int birthk2= Integer.parseInt(k2.getDogumTarihi().substring(lastfourk2));
                        if(birthk1>birthk2){
                            kucukkisi=k1;
                            buyukkisi=k2;
                        }else if(birthk2>birthk1){
                             kucukkisi=k2;
                             buyukkisi=k1;
                        }
                    }
                }
            }
            TreeNode rootbuyuk= new TreeNode(buyukkisi);
            for (int i = 2; i < people.size(); i++) {
                TreeNode foundbuyuk = BreadthFirstSearch.searchParent(people.get(i), rootbuyuk);
                if (foundbuyuk== null) {
                } else {
                    foundbuyuk.addChild(people.get(i));
                }
            }

            List<Kisi> visited;
            visited = DepthFirstSearch.searchRelationship(buyukkisi, kucukkisi, rootbuyuk);
            Functions.findRelations(visited);
            break;
        case 7:
            System.out.println("Id giriniz");
            Scanner scanner7=new Scanner(System.in);
            int findtree=scanner7.nextInt();
            MyPanel.setId(findtree);
            new MyFrame();
            for (Kisi aranankisi: people) {
                if(aranankisi.getId()==findtree){
                    TreeNode personfind= new TreeNode(aranankisi);
                    for (int i = 2; i < people.size(); i++) {
                        TreeNode foundperson = BreadthFirstSearch.searchParent(people.get(i), personfind);
                        if(foundperson == null) {
                        } else {
                            foundperson.addChild(people.get(i));
                        }
                    }
                    DepthFirstSearch dfs=new DepthFirstSearch();
                    dfs.Dugumler(personfind);
                    System.out.println("----------Tree----------");
                    TreeNode.printNAryTree(personfind);
                }
            }
            break;
        case 8:
            int depth = Functions.depthOfTree(root);
            System.out.println("Nesil sayisi: "+depth);
            break;
        case 9:
            System.out.println("Id giriniz");
            Scanner scanner2=new Scanner(System.in);
            int find=scanner2.nextInt();
            int say=0;
            for (Kisi search:people) {
                if(search.getId()==find){
                    TreeNode root2 = new TreeNode(search);
                    for (int i = say; i < people.size(); i++) {
                        TreeNode foundNodefind= BreadthFirstSearch.searchParent(people.get(i), root2);
                        if (foundNodefind == null) {
                        } else {
                            foundNodefind.addChild(people.get(i));
                        }
                    }
                    TreeNode.printNAryTree(root2);
                    int depthfind = Functions.depthOfTree(root2);
                    System.out.println("Kisiden sonra gelen nesil sayisi: "+(depthfind-1));
                }
                say++;
            }
            break;
        case 10:
          MyPanel.setId(0);
            new MyFrame();
            DepthFirstSearch dfs=new DepthFirstSearch();
            dfs.Dugumler(root);
            break;
    }
    if(islem==0){
        System.out.println("Cikis yapilmistir");
        break;
    }
}

    }
    }
