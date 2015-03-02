

/**
 * Class to store a single integer for use in algorithm analysis
 * @author garry
 */
public class CM2015Integer implements Comparable<CM2015Integer> {

    private int value;

    public CM2015Integer(int val) {
        this.value = val;
    }

    public boolean equals(CM2015Integer other) {
        return (this.value == other.value);
    }

    @Override
    public int compareTo(CM2015Integer other) {
        return this.value - other.value;
    }

    public int getValue() {
        return value;
    }
    
    public void setValue(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
    
}
