package model;

import java.util.ArrayList;

public class Path {
    private String name;
    private ArrayList<Space> spaces;
    private Path path1, path2;

    /**
     * instantiates the object
     * @param name name of the path
     */
    public Path(String name)
    {
        this.name = name;
        spaces = new ArrayList<Space>();

    }

    /**
     * instantiates the object
     * @param name name of the path
     * @param normal is the normal Path
     */
    public Path(String name, Path normal) {
        spaces = new ArrayList<Space>();
        this.name = name;
        this.path1= normal;
    }

    /**
     * instantiates the object
     * @param name name of the path
     * @param path1 is the first path
     * @param path2 is the second path
     */
    public Path(String name, Path path1, Path path2)
    {
        spaces = new ArrayList<Space>();
        this.name = name;
        this.path1 = path1;
        this.path2 = path2;
    }

    /**
     * adds spaces to arraylist
     * @param space space to be added
     */
    public void addSpace(Space space) {
        spaces.add(space);
    }

    /**
     * returns arraylist of spaces
     * @return arraylist of spaces
     */
    public ArrayList<Space> getSpaces() {
        return spaces;
    }

    /**
     * returns name of path
     * @return name of path
     */
    public String getName() {
        return name;
    }

    /**
     * returns the max number of spaces
     * @return number of spaces
     */
    public int getNSpaces() {
        return spaces.size();
    }

    /**
     * returns first path of the parent Path
     * @return first path
     */
    public Path getPath1() {
        return path1;
    }
    /**
     * returns second path of the parent Path
     * @return second path
     */
    public Path getPath2() {
        return path2;
    }

    /**
     * returns the space with the corresponding index
     * @param n is the index
     * @return space with index n
     */
    public Space getSpace(int n)
    {
        return spaces.get(n);
    }
}
