package Model;

public class Case {

    private Position pos;
    private Element elem;
    private Personnage perso;

    public Case(Personnage perso, Position pos) {
        this.perso = perso;
        this.pos = pos;
    }

    public Case(Element elem, Position pos) {
        this.elem = elem;
        this.pos = pos;

    }

    public Case() {

    }

    public boolean isEmpty() {
        return elem == null && perso == null;
    }

    public boolean estUnAliment() {
        return getElem().isChampignon() || getElem().isFruit() || getElem().isPacgomme();
    }

    public Element getElem() {
        return this.elem;
    }

    public Position getPosition() {
        return pos;
    }

    public Personnage getPerso() {
        return perso;
    }

    public void setPerso(Personnage perso, Position pos) {
        this.perso = perso;
        this.pos = pos;
    }

    public boolean estUnPerso() {
        return perso != null;
    }

    public boolean estUnElement() {
        return elem != null;
    }

    @Override
    public String toString() {
        return "   ";
    }

}
