import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;


public class Autocomplete {
    private Term[] array;
    private Comparator<Term> comparator;

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {

        // Arrays.sort uses nlogn time, puts in lexicographic order
        this.array = terms;
        Arrays.sort(array);
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
        int length = prefix.length();
        Term theKey = new Term(prefix, 0);
        int end = BinarySearchDeluxe.lastIndexOf(array, theKey, Term.byPrefixOrder(length));
        int beg = BinarySearchDeluxe.firstIndexOf(array, theKey, Term.byPrefixOrder(length));

        // int aSize = end - beg + 1;
        int aSize = array.length;


        Term[] matches = new Term[aSize];
        matches = Arrays.copyOfRange(this.array, beg, end + 1);

        // sort in descending order by weight
        Arrays.sort(matches, Term.byReverseWeightOrder());
        return matches;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        int length = prefix.length();
        Term theKey = new Term(prefix, 0);
        int end = BinarySearchDeluxe.lastIndexOf(array, theKey, Term.byPrefixOrder(length));
        int beg = BinarySearchDeluxe.firstIndexOf(array, theKey, Term.byPrefixOrder(length));
        return end - beg;
    }


    // A sample client for unit testing
    public static void main(String[] args) {

        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        int i;
        for (i = 0; i < N; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }

        // read in queries from standard input and print out the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for (i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }
}
