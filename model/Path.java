package model;

import java.util.ArrayList;

public class Path {
    private ArrayList<Space> spaces;

    public Path() {
        spaces = new ArrayList<Space>();
    }

    public void addSpace(Space space) {
        spaces.add(space);
    }

    public ArrayList<Space> getSpaces() {
        return spaces;
    }

    public int getNSpaces() {
        return spaces.size();
    }

    public Space getWhichPathSpace() {
        return spaces.get(getNSpaces() - 1);
    }
}
