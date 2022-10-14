/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.b;

import java.util.ArrayList;

/**
 *
 * @author guill
 */
public class BTreeNode {
    int keys[];
    int t;
    ArrayList<BTreeNode> Childs;
    int n;
    boolean hoja;
    //Constructors and methods and functions
    public BTreeNode() {
        
    } 
    
    public BTreeNode(int tDada,boolean hojaDada){
        this.t=tDada;
        this.hoja=hojaDada;
        keys=new int[2*t-1];
        n=0;
    }
    public void insertNonfull(int kDada){
        int i= n-1;
        if(hoja==true){
            while(i>=0 && keys[i]>kDada){
                keys[i+1]=keys[i];
                i--;
            }
            keys[i+1]=kDada;
            n=n+1;
        }else{
            while(i>=0 && keys[i]>kDada){
                i--;
            }
            if(Childs.get(i+1).n==2*t-1){
                splitChild(i+1, Childs.get(i+1));
                if(keys[i+1]<kDada){
                    i++;
                }
            }
            Childs.get(i+1).insertNonfull(kDada);
        }
        
    }
    public void splitChild(int i , BTreeNode y){
        BTreeNode z = new BTreeNode(y.t,y.hoja);
        z.n=t-1;
        for (int j = 0; j < t-1; j++) {
            z.keys[j]=y.keys[j+t];
        }
        if(y.hoja==false){
            for(int j =0;j<t;j++){
                z.Childs.set(j, y.Childs.get(j+t));
            }
        }
        y.n=t-1;
        for (int j = n; j >=i+1; j--) {
            Childs.set(j+1, Childs.get(j));
        }
        Childs.set(i+1, z);
        for (int j = n-1; j >=i ; j--) {
            keys[j+1]=keys[j];
        }
        keys[i]=y.keys[t-1];
        n=n+1;
        
        
      
    }
    public void traverse(){
        int i;
        for (i = 0; i < n; i++) {
            if(hoja==false){
                Childs.get(i).traverse();
            }
            System.out.println(" "+keys[i]);
        }
        
        if(hoja==false){
            Childs.get(i).traverse();
        }
    }
    public BTreeNode search(int kDada){
        int i=0;
        while (i<n && kDada>keys[i]){
            i++;
            if(keys[i]==kDada){
                return this;
            }
            if(hoja==true){
                return null;
            }
            return Childs.get(i).search(kDada); 
        }
        
        return null;
    }

    //SETS AND GETS

//    public int getKeys() {
//        return keys;
//    }

//    public void setKeys(int keys) {
//        this.keys = keys;
//    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public boolean isHoja() {
        return hoja;
    }

    public void setHoja(boolean hoja) {
        this.hoja = hoja;
    }
    
}
