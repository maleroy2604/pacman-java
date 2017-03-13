package Model;

import java.util.Random;

public enum Direction {
    SUD("deplacer vers le bas"), OUEST("deplacer vers la gauche"), NORD("deplacer vers le haut"), EST("deplacer vers la droite");

    private final String msg;
    private static final Random rand = new Random();

    public int numero() {
        return ordinal();
    }

    Direction(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
   

    public static Direction directionOposee(Direction d) {
        if (d == NORD) {
            return SUD;
        } else if (d == SUD) {
            return NORD;
        } else if (d == EST) {
            return OUEST;
        } else if (d == OUEST) {
            return EST;
        }
        return null;
    }

    public static Direction randomDirection() {
        return Direction.values()[rand.nextInt(Direction.values().length)];
    }

    public static Direction getByInt(int choix) throws IndexOutOfBoundsException {
        if (choix < 0 || choix > Direction.values().length) {
            throw new IndexOutOfBoundsException();
        }
        return Direction.values()[choix];
    }
}
