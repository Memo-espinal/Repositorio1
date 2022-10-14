/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.b;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class ArbolB {

    /**
     * @param args the command line arguments
     */
    static Scanner zelda = new Scanner(System.in);
    public static void main(String[] args) {
       int tamano=0;
        System.out.println("ingrese el tama del arbol: ");
        tamano =zelda.nextInt();
        BTree t = new BTree(tamano);
        int key,resp;
        do{
            System.out.println("Ingrese llave:");
            key= zelda.nextInt();
            t.insert(key);
            System.out.println("Desea continuar No=0: ");
            resp= zelda.nextInt();
            
        }while(resp!=0);
        System.out.println("Traversal of the constructed tree is:");
        t.traverse();
        
        
        
    }
    
}
