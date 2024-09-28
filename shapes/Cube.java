package shapes;

import java.util.*;

import utilities.Prototype;

public class Cube implements Prototype<Cube> {
    private int length;
    private List<List<List<Integer>>> list = new ArrayList<>();

    public Cube(int length) {
        this.length = length;

        for (int i = 0; i < length; i++) {
            List<List<Integer>> innerList = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                List<Integer> innerInnerList = new ArrayList<>();
                for (int k = 0; k < length; k++) {
                    innerInnerList.add(0);
                }
                innerList.add(innerInnerList);
            }
            list.add(innerList);
        }
    }

    public int getLength() {
        return length;
    }

    public int getVolume() {
        return length * length * length;
    }

    public void set(int x, int y, int z, int value) {
        list.get(x).get(y).set(z, value);
    }

    public int get(int x, int y, int z) {
        return list.get(x).get(y).get(z);
    }

    public Cube clone() {
        Cube newCube = new Cube(length);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    newCube.set(i, j, k, get(i, j, k));
                }
            }
        }
        return newCube;
    }

    public void randomize() {
        List<Integer> values = new ArrayList<>();
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                for (int z = 0; z < length; z++) {
                    values.add(get(x, y, z));
                }
            }
        }

        Collections.shuffle(values);
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                for (int z = 0; z < length; z++) {
                    set(x, y, z, values.remove(0));
                }
            }
        }
    }
}
