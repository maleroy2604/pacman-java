
package Model;


public class CaseVide extends Case{

    @Override
    public boolean estAccessible() {
        return true;
    }
    @Override
    public String toString(){
        return "   ";
    }

    @Override
    public void estMangerPar(PacMan p) {
       
    }
}
