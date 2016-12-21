package Model;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Labyrinthe {
    private static  int score=0,  nbrVies=3;
    private int  nbrFantome=4;
    private int posx, posy;
    private static int posInitX,posInitY;
    private boolean superPacMan=false;
    private List<Case> caseValide = new LinkedList<>();
    private Case[][] board = new Case[TAB.length][TAB[0].length];
    private static final int[][] TAB = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1},
        {1, 5, 1, 1, 1, 4, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 4, 1, 1, 1, 5, 1},
        {1, 4, 1, 1, 1, 4, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 4, 1, 1, 1, 4, 1},
        {1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1},
        {1, 4, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 4, 1},
        {1, 4, 4, 4, 4, 4, 1, 4, 1, 1, 1, 1, 1, 1, 1, 4, 1, 4, 4, 4, 4, 4, 1},
        {1, 1, 1, 1, 1, 4, 1, 4, 4, 4, 4, 1, 4, 4, 4, 4, 1, 4, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 4, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 4, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 4, 1, 4, 1, 0, 0, 0, 0, 0, 1, 4, 1, 4, 1, 1, 1, 1, 1},
        {1, 4, 4, 4, 4, 4, 6, 4, 1, 0, 0, 0, 0, 0, 1, 4, 6, 4, 4, 4, 4, 4, 1},
        {1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 4, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 4, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 1},
        {1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1},
        {1, 4, 1, 1, 1, 4, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 4, 1, 1, 1, 4, 1},
        {1, 5, 4, 4, 1, 4, 4, 4, 4, 4, 4, 2, 4, 4, 4, 4, 4, 4, 1, 4, 4, 5, 1},
        {1, 1, 1, 4, 1, 4, 1, 4, 1, 1, 1, 1, 1, 1, 1, 4, 1, 4, 1, 4, 1, 1, 1},
        {1, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 1, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4, 1},
        {1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1},
        {1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1},
        {1, 6, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 6, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public Labyrinthe() {

        for (int i = 0; i < TAB.length; ++i) {
            for (int j = 0; j < TAB[i].length; ++j) {

                choixElement(TAB[i][j], i, j);
            }
        }
        for(int k=0;k<nbrFantome;++k){
            randomFantome();
        }
    }

    public void randomFantome() {
        
        Random generateur = new Random();
        Case caseFant = caseValide.remove(generateur.nextInt(caseValide.size()));
        board[caseFant.getX()][caseFant.getY()] = new Case(new Fantome(caseFant.getX(), caseFant.getY()));

    }

    private void choixElement(int caseInt, int i, int j) {

        switch (caseInt) {

            case (1):
                board[i][j] = new Case(new Mur(),i,j);
                break;
            case (2):
                board[i][j] = new Case(new PacMan(i, j));
                posInitX=i; posInitY=j;posx=i; posy=j;
                
                break;
            case (4):
                board[i][j] = new Case(new Pacgomme(),i,j);
                caseValide.add(board[i][j]);
                break;
            case (5):
                board[i][j] = new Case(new Fruit(),i,j);
                caseValide.add(board[i][j]);
                break;
            case (6):
                board[i][j] = new Case(new Champignon(),i,j);
                caseValide.add(board[i][j]);
                break;
            case(0):
                board[i][j]=new Case();break;

        }
    }
    
    public Case getCase(int x,int y){
        return board[x][y];
    }

    
   
    @Override
   public String toString(){
       String boardaff="";
       for(int i=0;i<board.length;++i){
           for (int j=0;j<board[i].length;++j){
               
               if(board[i][j].getPerso() instanceof Personnage)
                   boardaff+= board[i][j].getPerso().toString();
               else if(board[i][j].getElem() instanceof Element)
                    boardaff+= board[i][j].getElem().toString(); 
               else
                   boardaff+=board[i][j].toString();
           }
           boardaff+="\n";
       }
       return boardaff;
   }
    public boolean estUnPacMan(int i , int j ){
        return board[i][j].getPerso()instanceof PacMan;
   }
   public boolean estUnFantome(int i,int j ){
        return board[i][j].getPerso() instanceof Fantome;
   }
   public boolean estUnFruit(int i , int j){
        return board[i][j].getElem() instanceof Fruit;
   }
   public boolean estUnGome(int i , int j){
        return board[i][j].getElem() instanceof Pacgomme;
   }
   public boolean estUnChampignon(int i, int j ){
        return board[i][j].getElem() instanceof Champignon;
   }
   public boolean estUnMur(int i , int j){
        return board[i][j].getElem() instanceof Mur;
   }
   public boolean estUnAliment(int i , int j){
       return estUnFruit(i,j) || estUnGome(i,j) || estUnChampignon(i,j);
    }
   public void mange(int i, int j){
        if (estUnFruit(i,j))
           superPacMan=true;
        if(estUnGome(i,j))
            score+=1;
        if (estUnFantome(i,j))
            score+=20;
        if(estUnChampignon(i,j))
            score=score;        
   }
   public void rienDeplace( ){
        board[posInitX][posInitY]=new Case(new PacMan(posInitX,posInitY));
        }
   public void deplaceCase(int i , int j){
         board[posInitX][posInitY]=new Case();
         board[i][j]=new Case(new PacMan(i,j));
         posInitX=i;posInitY=j;
   }
   public void perdreVie(){
        nbrVies--;
        board[posInitX][posInitY]=new Case() ;
        board[posx][posy]=new Case(new PacMan(posx,posy));
        posInitX=posx;posInitY=posy;
    }
   public void deplacer(int i, int j){
       
        if(estUnAliment(i,j)){
            mange(i,j);
            deplaceCase(i,j);  
        }
        else if(estUnFantome(i,j)){
            if(superPacMan){
                mange(i,j);
                deplaceCase(i,j);
                nbrFantome--;
            }
            else 
                perdreVie();    
        }
        else if(estUnMur(i,j))
            rienDeplace();
        else 
            deplaceCase(i,j);
   }
   

   
    public static void main(String[] args) {
        Labyrinthe lab=new Labyrinthe();
        System.out.print(lab);
        Scanner input = new Scanner(System.in);
        String lettre=input.nextLine();
        while (nbrVies>=0){
        System.out.println("Score : "+lab.score+" "+"Nombre de vies restantes : "+lab.nbrVies);
        lettre=input.nextLine();
        switch(lettre.toUpperCase()){
            case "H" : 
                lab.deplacer((posInitX-1),posInitY);
                System.out.print(lab);
                 break;
           case "B" : lab.deplacer((posInitX+1),posInitY);
                 System.out.print(lab);
                 break;

           case "G" : lab.deplacer(posInitX,(posInitY-1));
                System.out.print(lab);
                break;

            case "D" : lab.deplacer(posInitX,(posInitY+1));
                System.out.print(lab);
                break;
        }
        }  
    }
    }
    
        
        
   
