package model;

import java.util.ArrayList;

public class Path {
    private String name;
    private ArrayList<Space> spaces;
    private Path path1, path2;

    public Path(String name)
    {
        this.name = name;
        spaces = new ArrayList<Space>();

    }
    public Path(String name, Path normal) {
        spaces = new ArrayList<Space>();
        this.name = name;
        this.path1= normal;
    }
    public Path(String name, Path path1, Path path2)
    {
        spaces = new ArrayList<Space>();
        this.name = name;
        this.path1 = path1;
        this.path2 = path2;
    }

    public void addSpace(Space space) {
        spaces.add(space);
    }

    public ArrayList<Space> getSpaces() {
        return spaces;
    }

    public String getName() {
        return name;
    }

    public int getNSpaces() {
        return spaces.size();
    }

    public Path getPath1() {
        return path1;
    }

    public Path getPath2() {
        return path2;
    }

    public Space getSpace(int n)
    {
        return spaces.get(n);
    }


}
