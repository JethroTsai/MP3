package model;

import java.util.ArrayList;

public class Path {
    private ArrayList<Space> spaces;
    private Path path1, path2;

    public Path() {
        spaces = new ArrayList<Space>();
    }
    public Path(Path path1, Path path2)
    {
        spaces = new ArrayList<Space>();
        this.path1 = path1;
        this.path2 = path2;
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
