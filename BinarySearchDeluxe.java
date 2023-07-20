import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;
// BS of a SORTED ARRAY that supports finding the first or the last of duplicate keys
// Still need log(n) time, avoid iterating thru entire array
// is this duplicate value to the right of a non 3?
// if no, do binary search from beginning to middle, keep splitting until you find the correct 3

public class BinarySearchDeluxe {


    // Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {

        // find an element that equals the specified key
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int compareVal = comparator.compare(a[mid], key);

            if (compareVal < 0) {
                lo = mid + 1;
            }
            else if (compareVal == 0) {
                if (mid == 0 || comparator.compare(a[mid - 1], a[mid]) < 0) {
                    return mid;
                }
                hi = mid - 1;
            }
            else {
                hi = mid - 1;
            }
        }

        // if element isn't found, return -1
        return -1;
    }


    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        // find an element that equals the specified key
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int compareVal = comparator.compare(a[mid], key);

            if (compareVal > 0) {
                hi = mid - 1;
            }
            else if (compareVal == 0) {
                if (mid == a.length - 1 || comparator.compare(a[mid], a[mid + 1]) < 0) {
                    return mid;
                }

                lo = mid + 1;
            }
            else {
                lo = mid + 1;
            }
        }

        // if element isn't found, return -1
        return -1;
    }

    // unit testing (you should have some Unit Testing here to confirm that your methods work); for example...
    public static void main(String[] args) {

        Term[] terms = new Term[5];
        terms[0] = new Term("Trevor", 45);
        terms[1] = new Term("Kathy", 43);
        terms[2] = new Term("Ellie", 11);
        terms[3] = new Term("Allen", 9);
        terms[4] = new Term("Eva", 1);
        Arrays.sort(terms);

        Term searchme = new Term("J", 0);
        int first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        int last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("J: " + first + " to " + last);

        searchme = new Term("A", 0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("A: " + first + " to " + last);

        searchme = new Term("E", 0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("E: " + first + " to " + last);

        searchme = new Term("T", 0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("T: " + first + " to " + last);
    }
}
