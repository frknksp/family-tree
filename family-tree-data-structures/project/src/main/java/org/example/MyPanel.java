package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class MyPanel extends JPanel{
public static int id=0;
    
    List<Kisi> people = ReadExcel.readFromExcel("C:\\Users\\frknk\\Desktop\\CE\\2022-2023\\3.Sınıf-Güz\\Prolab1\\3.Proje\\proje3_2\\proje3\\src\\main\\java\\org\\example\\prolabtest\\eminkayaailesi.xlsx");

    MyPanel(){
        //image = new ImageIcon("sky.png").getImage();
        this.setPreferredSize(new Dimension(1500,1000));
    }

    public  void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
int sayac=0;
int temp=0;
        for (Kisi aranankisi: people) {
            if(aranankisi.getId()==id){
                temp=sayac;
            }
            sayac++;
        }

        TreeNode root = new TreeNode(people.get(temp));
        for (int i = 1; i < people.size(); i++)

        {
            TreeNode foundNode = BreadthFirstSearch.searchParent(people.get(i), root);

            if (foundNode == null) {

            } else {
                foundNode.addChild(people.get(i));
            }
        }

       // ArrayList<Kisi> kardesler=new ArrayList<>();
        TreeNode current = root;
     //   DefaultMutableTreeNode first=new DefaultMutableTreeNode(current.kisi.getIsim()+current.kisi.getKizlikSoyismi()+current.kisi.getSoyisim()+"-"+current.kisi.getEsi());
       if(current.kisi.getCinsiyet().equals("Erkek") && current.kisi.getMedeniHal().equals("Evli")){
           g2D.setPaint(Color.BLUE);
           g2D.drawRect(500,80,100,60);
           g2D.drawString(current.kisi.isim+current.kisi.getSoyisim(),500,100);
           g2D.setPaint(Color.red);
           g2D.drawRect(700,80,100,60);
           g2D.drawString(current.kisi.getEsi(),700,100);
           g2D.setPaint(Color.BLACK);
          g2D.drawLine(600,100,700,100); //evliler arası yatay çizgi
       }else if(current.kisi.getCinsiyet().equals("Kadın") && current.kisi.getMedeniHal().equals("Evli")){
           g2D.setPaint(Color.red);
           g2D.drawString(current.kisi.isim,80,100);
           g2D.setPaint(Color.blue);
           g2D.drawString(current.kisi.getEsi(),200,100);
           g2D.setPaint(Color.BLACK);
           g2D.drawLine(150,100,200,100);
       }
       g2D.drawLine(650,100,650,150); //çocuklar için evliden aşağı gelen çizgi
        int xilk=100;
        int xilkes=300;
        int xilk1=0;
        int xilkes1=100;
        int xilk2=0;
        int xilkes2=100;
        for ( TreeNode child:current.children) {
            if(child.kisi.getCinsiyet().equals("Kadın") && child.kisi.getMedeniHal().equals("Evli")){
                g2D.setPaint(Color.orange);
                g2D.drawRect(xilk,200,100,60);
                g2D.setPaint(Color.red);
                g2D.drawString((child.kisi.isim+" "+child.kisi.getSoyisim()),xilk,250);
                g2D.setPaint(Color.blue);
                g2D.drawRect(xilkes,200,100,60);
                g2D.drawString(child.kisi.getEsi(),xilkes,250);
                g2D.setPaint(Color.BLACK);
                g2D.drawLine(xilk+100,225,xilkes,225); //eşler arası yatay çizgi
                g2D.drawLine(xilk+150,225,xilk+150,275); //çocuklar için evliden aşağı gelen çizgi
                xilkes=xilkes+500;
                xilk=xilk+500;
                for (TreeNode childchild:child.children) {
                    if(childchild.kisi.getCinsiyet().equals("Kadın")&& childchild.kisi.getMedeniHal().equals("Evli")){
                        g2D.setPaint(Color.orange);
                        g2D.drawRect(xilk1,300,80,60);
                        g2D.setPaint(Color.red);
                        g2D.drawString((childchild.kisi.isim+" "+childchild.kisi.getSoyisim()),xilk1,350);
                        g2D.setPaint(Color.blue);
                        g2D.drawRect(xilkes1,300,80,60);
                        g2D.drawString(childchild.kisi.getEsi(),xilkes1,350);
                        g2D.setPaint(Color.BLACK);
                        g2D.drawLine(xilk1+80,325,xilkes1,325); //eşler arası yatay çizgi
                        g2D.drawLine(xilk1+90,325,xilk1+90,380); //çocuklar için evliden aşağı gelen çizgi
                        xilkes1=xilkes1+200;
                        xilk1=xilk1+200;
                    }else if(childchild.kisi.getCinsiyet().equals("Erkek")&& childchild.kisi.getMedeniHal().equals("Evli")){
                        g2D.setPaint(Color.orange);
                        g2D.drawRect(xilk1,300,80,60);
                        g2D.setPaint(Color.BLUE);
                        g2D.drawString((childchild.kisi.isim+" "+childchild.kisi.getSoyisim()),xilk1,350);
                        g2D.setPaint(Color.red);
                        g2D.drawRect(xilkes1,300,80,60);
                        g2D.drawString(childchild.kisi.getEsi(),xilkes1,350);
                        g2D.setPaint(Color.BLACK);
                        g2D.drawLine(xilk1+80,325,xilkes1,325); //eşler arası yatay çizgi
                        g2D.drawLine(xilk1+90,325,xilk1+90,380); //çocuklar için evliden aşağı gelen çizgi
                        xilkes1=xilkes1+200;
                        xilk1=xilk1+200;
                    }
                    if(childchild.kisi.getCinsiyet().equals("Kadın")&& childchild.kisi.getMedeniHal().equals("Bekar")){
                        g2D.setPaint(Color.orange);
                        g2D.drawRect(xilk1,300,80,60);
                        g2D.setPaint(Color.red);
                        g2D.drawString((childchild.kisi.isim+" "+childchild.kisi.getSoyisim()),xilk1,350);
                        xilkes1=xilkes1+200;
                        xilk1=xilk1+200;
                    }else if(childchild.kisi.getCinsiyet().equals("Erkek")&& childchild.kisi.getMedeniHal().equals("Bekar")){
                        g2D.setPaint(Color.orange);
                        g2D.drawRect(xilk1,300,80,60);
                        g2D.setPaint(Color.BLUE);
                        g2D.drawString((childchild.kisi.isim+" "+childchild.kisi.getSoyisim()),xilk1,350);
                        xilkes1=xilkes1+200;
                        xilk1=xilk1+200;
                    }
                    for (TreeNode childchildchild:childchild.children) {
                        if(childchildchild.kisi.getCinsiyet().equals("Kadın")&& childchildchild.kisi.getMedeniHal().equals("Bekar")){
                            g2D.setPaint(Color.orange);
                            g2D.drawRect(xilk2,400,80,60);
                            g2D.setPaint(Color.red);
                            g2D.drawString((childchildchild.kisi.isim+" "+childchildchild.kisi.getSoyisim()),xilk2,450);
                            xilk2=xilk2+200;
                        }
                        if(childchildchild.kisi.getCinsiyet().equals("Erkek")&& childchildchild.kisi.getMedeniHal().equals("Bekar")){
                            g2D.setPaint(Color.orange);
                            g2D.drawRect(xilk2,400,80,60);
                            g2D.setPaint(Color.BLUE);
                            g2D.drawString((childchildchild.kisi.isim+" "+childchildchild.kisi.getSoyisim()),xilk2,450);
                            xilk2=xilk2+200;
                        }
                    }
                }





            }else if(child.kisi.getCinsiyet().equals("Erkek") && child.kisi.getMedeniHal().equals("Evli")) {
                g2D.setPaint(Color.orange);
                g2D.drawRect(xilk, 200, 100, 60);
                g2D.setPaint(Color.BLUE);
                g2D.drawString((child.kisi.isim + " " + child.kisi.getSoyisim()), xilk, 250);
                g2D.setPaint(Color.red);
                g2D.drawRect(xilkes, 200, 100, 60);
                g2D.drawString(child.kisi.getEsi(), xilkes, 250);
                g2D.setPaint(Color.BLACK);
                g2D.drawLine(xilk + 100, 225, xilkes, 225);
                g2D.drawLine(xilk + 150, 225, xilk + 150, 275); //çocuklar için evliden aşağı gelen çizgi
                xilkes = xilkes + 400;
                xilk = xilk + 400;
                for (TreeNode childchildd : child.children) {
                    if (childchildd.kisi.getCinsiyet().equals("Erkek") && childchildd.kisi.getMedeniHal().equals("Evli")) {
                        g2D.setPaint(Color.orange);
                        g2D.drawRect(xilk1, 300, 80, 60);
                        g2D.setPaint(Color.BLUE);
                        g2D.drawString((childchildd.kisi.isim + " " + childchildd.kisi.getSoyisim()), xilk1, 350);
                        g2D.setPaint(Color.red);
                        g2D.drawRect(xilkes1, 300, 80, 60);
                        g2D.drawString(childchildd.kisi.getEsi(), xilkes1, 350);
                        g2D.setPaint(Color.BLACK);
                        g2D.drawLine(xilk1 + 80, 325, xilkes1, 325); //eşler arası yatay çizgi
                        g2D.drawLine(xilk1 + 90, 325, xilk1 + 90, 380); //çocuklar için evliden aşağı gelen çizgi
                        xilkes1 = xilkes1 + 200;
                        xilk1 = xilk1 + 200;
                    } else if (childchildd.kisi.getCinsiyet().equals("Erkek") && childchildd.kisi.getMedeniHal().equals("Bekar")) {
                        g2D.setPaint(Color.orange);
                        g2D.drawRect(xilk1 + 100, 300, 80, 60);
                        g2D.setPaint(Color.BLUE);
                        g2D.drawString((childchildd.kisi.isim + " " + childchildd.kisi.getSoyisim()), xilk1 + 100, 350);
                        xilk1 = xilk1 + 200;
                    }
                    if (childchildd.kisi.getCinsiyet().equals("Kadın") && childchildd.kisi.getMedeniHal().equals("Evli")) {
                        g2D.setPaint(Color.orange);
                        g2D.drawRect(xilk1, 300, 80, 60);
                        g2D.setPaint(Color.red);
                        g2D.drawString((childchildd.kisi.isim + " " + childchildd.kisi.getSoyisim()), xilk1, 350);
                        g2D.setPaint(Color.blue);
                        g2D.drawRect(xilkes1, 300, 80, 60);
                        g2D.drawString(childchildd.kisi.getEsi(), xilkes1, 350);
                        g2D.setPaint(Color.BLACK);
                        g2D.drawLine(xilk1 + 80, 325, xilkes1, 325); //eşler arası yatay çizgi
                        g2D.drawLine(xilk1 + 90, 325, xilk1 + 90, 380); //çocuklar için evliden aşağı gelen çizgi
                        xilkes1 = xilkes1 + 200;
                        xilk1 = xilk1 + 200;

                    } else if (childchildd.kisi.getCinsiyet().equals("Kadın") && childchildd.kisi.getMedeniHal().equals("Bekar")) {
                        g2D.setPaint(Color.orange);
                        g2D.drawRect(xilk1 + 100, 300, 80, 60);
                        g2D.setPaint(Color.BLUE);
                        g2D.drawString((childchildd.kisi.isim + " " + childchildd.kisi.getSoyisim()), xilk1 + 100, 350);
                        xilk1 = xilk1 + 200;
                    }
                    for (TreeNode childchildchild : childchildd.children) {
                        if (childchildchild.kisi.getCinsiyet().equals("Kadın") && childchildchild.kisi.getMedeniHal().equals("Bekar")) {
                            g2D.setPaint(Color.orange);
                            g2D.drawRect(xilk2, 400, 80, 60);
                            g2D.setPaint(Color.red);
                            g2D.drawString((childchildchild.kisi.isim + " " + childchildchild.kisi.getSoyisim()), xilk2, 450);
                            xilk2 = xilk2 + 200;
                        }
                        if (childchildchild.kisi.getCinsiyet().equals("Erkek") && childchildchild.kisi.getMedeniHal().equals("Bekar")) {
                            g2D.setPaint(Color.orange);
                            g2D.drawRect(xilk2, 400, 80, 60);
                            g2D.setPaint(Color.BLUE);
                            g2D.drawString((childchildchild.kisi.isim + " " + childchildchild.kisi.getSoyisim()), xilk2, 450);
                            xilk2 = xilk2 + 200;
                        }
                    }


                }

            }
            else if(child.kisi.getCinsiyet().equals("Erkek")&& child.kisi.getMedeniHal().equals("Bekar")){
                g2D.setPaint(Color.orange);
                g2D.drawRect(xilk, 200, 100, 60);
                g2D.setPaint(Color.BLUE);
                g2D.drawString((child.kisi.isim + " " + child.kisi.getSoyisim()), xilk, 250);
                xilk = xilk + 400;
            }
            else if(child.kisi.getCinsiyet().equals("Kadın")&& child.kisi.getMedeniHal().equals("Bekar")){
                g2D.setPaint(Color.orange);
                g2D.drawRect(xilk, 200, 100, 60);
                g2D.setPaint(Color.red);
                g2D.drawString((child.kisi.isim + " " + child.kisi.getSoyisim()), xilk, 250);
                xilk = xilk + 400;
            }

        }

    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        MyPanel.id = id;
    }
}