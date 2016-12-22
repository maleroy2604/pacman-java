/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Noreddine
 */
public enum Direction {
    SUD("deplacer vers le bas"),OUEST("deplacer vers la gauche"),NORD("deplacer vers le haut"),EST("deplacer vers la droite");
    private final String msg;
    public int  numero(){
        return ordinal();
    }
    Direction(String msg){
        this.msg=msg;
    }
    public String toSting(){
        return msg;
    }
    public static Direction getByInt(int choix)throws IndexOutOfBoundsException{
        if(choix <0 || choix>Direction.values().length){
            throw new IndexOutOfBoundsException();
        }
        return Direction.values()[choix];
    }
    
}
