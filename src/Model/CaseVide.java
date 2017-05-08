
package Model;


public class CaseVide extends Case{
    private static final Case CASE_VIDE = new CaseVide();
    
    private CaseVide() {}
    
    public static Case getInstanceCaseVide() {
        return CASE_VIDE;
    }

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

    @Override
    public Case copy() {
       return CASE_VIDE;
    }
}
