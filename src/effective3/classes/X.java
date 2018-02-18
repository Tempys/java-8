package effective3.classes;

import java.util.AbstractCollection;
import java.util.AbstractMap;

class X {
    private  int getX() {
        return 5;
    }

    public int get2X() {
        X x = new X();
        return 2 * x.getX();
    }

    public static void main(String[] args) {

    }
}
