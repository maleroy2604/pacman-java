package Model;

public class Case {

    private final Position pos;
    private Aliment alim;
    private Personnage perso;
    private Mur mur;

    public Case(Personnage perso, Position pos) {
        this.perso = perso;
        this.pos = pos;
    }

    public Case(Aliment alim, Position pos) {
        this.alim = alim;
        this.pos = pos;

    }

    public Case(Mur mur, Position pos) {
        this.mur = mur;
        this.pos = pos;
    }

    public Case(Position pos) {
        this.pos = pos;
    }

    public boolean isEmpty() {
        return alim == null && perso == null && mur == null;
    }

    public Aliment getAlim() {
        return this.alim;
    }

    public Mur getMur() {
        return mur;
    }

    public Position getPosition() {
        return pos;
    }

    public Personnage getPerso() {
        return perso;
    }

    public void setPerso(Personnage perso) {
        this.perso = perso;

    }
    public void setAlim(Aliment al){
        this.alim=al;
    }

    public boolean estUnPerso() {
        return perso != null;
    }

    public boolean estUnMur() {
        return mur != null;
    }

    public boolean estUnAliment() {
        return alim != null;
    }

    public void placePerso(Personnage p) {
        this.setPerso(p);

    }

    public void retirePerso() {
        this.setPerso(null);
        this.setAlim(null);
    }

    public void effacerCase(PacMan p) {
        this.perso=p;
        this.alim=null;
    }

    @Override
    public String toString() {
        return "   ";
    }

}
