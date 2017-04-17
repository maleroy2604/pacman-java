/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Stack;


public class Gardien {
    
    Stack <Memento> mementos=new Stack<>();
 
    public void ajouteMemento(Memento m){
        mementos.push(m);
    }
    public Memento retournEnArriere(){
        return  mementos.pop();
       
       
    }
}
