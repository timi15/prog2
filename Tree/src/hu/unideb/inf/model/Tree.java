package hu.unideb.inf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.Objects;


/**
 * This class representing a tree.
 * @author Varga Timea
 * @since 2024.12.01.
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tree implements Comparable<Tree> {

    /**
     * The name of the tree
     */
    private String nev;

    /**
     * The height of the tree
     */
    private Integer magassagMeterben;

    /**
     * The age of the tree
     */
    private Integer korEvben;

    /**
     * The rank of the tree
     */
    private String besorolas;

    /**
     * The price of the tree
     */
    private Integer ar;


    /**
     * compareTo method
     * @param other the object to be compared.
     * @return 0 if the objects are equal, minus number if this less than other object, positive number if this greater than other
     *
     */
    @Override
    public int compareTo(Tree other) {
        Comparator<Tree> treeComparator = Comparator
                .comparing(Tree::getNev)
                .thenComparingInt(Tree::getKorEvben)
                .thenComparingInt(Tree::getAr);
        return treeComparator.compare(this, other);
    }

    /**
     * Equals method
     * @param other the object to be compared.
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Tree tree)) return false;
        return Objects.equals(nev, tree.nev) && Objects.equals(magassagMeterben, tree.magassagMeterben) && Objects.equals(korEvben, tree.korEvben) && Objects.equals(besorolas, tree.besorolas) && Objects.equals(ar, tree.ar);
    }

    /**
     * hashCode method
     * @return the object's generated hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(nev, magassagMeterben, korEvben, besorolas, ar);
    }
}
