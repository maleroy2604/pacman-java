package Model;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 2604maleroy
 */
public class Game {

    private Labyrinthe lab;
    private Personnage perso;
    private Case c;
    
  
   
    

    Game() {
        this.lab= new Labyrinthe();
       perso =lab.getInitialeCase().getPerso();

    }

    public void affMsg(String msg) {
        System.out.println(msg);
    }

    private int nombreSaisi() {
        int entree = 0;
        Scanner sc =new Scanner(System.in);
        boolean entreeOK = false;
        while (!entreeOK) {
            try {
                entree = Integer.parseInt(sc.next());
                entreeOK = true;
            } catch (NumberFormatException e) {
                entreeIncorrecte();
            }
        }
        return entree;
    }

    private void entreeIncorrecte() {
        affMsg(" Votre choix  n'est pas Valide ! 0 : deplacer Bas, 1 : deplacer Gauche, 2 : deplacer Haut, 3 : deplacer droite");
    }

    private int rangeValidationSaisie(int nMax) {
        int choixDirection = nombreSaisi();
        if (choixDirection < 0 || choixDirection > nMax) {
            return -1;
        }
        return choixDirection;
    }

    private int trySaisirChoixDirection() {

        return rangeValidationSaisie(Direction.values().length);
    }

    public Direction saisirChoixDirection() {
        int choixInt = trySaisirChoixDirection();
        while (choixInt == -1) {
            entreeIncorrecte();
            choixInt = trySaisirChoixDirection();
        }
        return Direction.getByInt(choixInt);
    }
    
    
    public void deplacer(Position p){
        perso.deplacer(lab.getCase(p), p);
        lab.initialise(p);
        if(perso.PerdreVie())
            
            retourCaseInitial();
            
       
    }
    public void retourCaseInitial(){
        lab.setCase(lab.getCase(lab.Cour()), lab.getInitialPosition());
        
    }
            
    

    public void affichageLancement(Labyrinthe l) {
        
        l.afficher();
        affMsg("Score : " +perso.getBonnus() + " " + "Nombre de vies restantes : " + perso.getNbrVies());
    }

    public static void main(String[] args) {
        Game g=new Game();
        Labyrinthe lab=new Labyrinthe();
        g.affichageLancement(lab);
        Scanner sc=new Scanner(System.in);
        //g.nombreSaisi();
        Position posB=new Position(lab.getInitialPosition().getX()+1,lab.getInitialPosition().getY());
         Position posG=new Position(lab.getInitialPosition().getX(),lab.getInitialPosition().getY()-1);
          Position posH=new Position(lab.getInitialPosition().getX()-1,lab.getInitialPosition().getY());
           Position posD=new Position(lab.getInitialPosition().getX(),lab.getInitialPosition().getY()+1);
                
        while(g.nbrVies>=0){
            
            int k=sc.nextInt();
                switch(k){
                    case 0: g.perso.deplacer(lab.getCase(posB),posB);
                        break;
                        case 1: g.perso.deplacer(lab.getCase(posG),posG);
                        break;
                        case 2: g.perso.deplacer(lab.getCase(posH),posH);
                        break;
                        case 3: g.perso.deplacer(lab.getCase(posD),posD);
                        break;
                    }
                 g.affichageLancement(lab);
            }
    }
    
    }
   



