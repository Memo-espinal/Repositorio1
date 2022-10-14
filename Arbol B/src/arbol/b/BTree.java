/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.b;

/**
 *
 * @author guill
 */
public class BTree {
    BTreeNode root;
    int t=0;

    public BTree() {
       
    }
    public BTree(int tDada) {
         root=null;
        this.t=tDada;
    }
    public void traverse(){
        if(root!=null){
            root.traverse();
        }
            
    }
    public BTreeNode search(int kDada){
        if(root == null){
            return null;
        }else{
            return root.search(kDada);
        }
    }
    public void insert(int k){
        if(root==null){
            root= new BTreeNode(t,true);
            root.keys[0]=k;
            root.n=1;  
        }else{
            if(root.n==2*t-1){
                BTreeNode s = new BTreeNode(t, false);
                s.Childs.add(root);
                //s.Childs.set(0, root);
                s.splitChild(0, root);
                int i =0;
                if(s.keys[0]<k){
                    i++;
                }
                s.Childs.get(i).insertNonfull(k);
                root =s;
            }else{
                root.insertNonfull(k);
            }
            
        }
    }
    //Set and gets

    public BTreeNode getRoot() {
        return root;
    }

    public void setRoot(BTreeNode root) {
        this.root = root;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }
    
    
    
}
