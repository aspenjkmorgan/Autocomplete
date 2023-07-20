import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term> {
    private String query;
    private long weight;

    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
        this.query = query;
        this.weight = weight;
    }

    public static Comparator<Term> byReverseWeightOrder() {
        return new Comparator<Term>() {
            int val = 0;

            public int compare(Term v, Term w) {
                if (v.weight > w.weight) {
                    val = -1;
                }
                else if (v.weight < w.weight) {
                    val = 1;
                }
                else {
                    val = 0;
                }
                return val;
            }

        };
    }

    // Compares the two terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        return new Comparator<Term>() {
            int buf = r;

            public int compare(Term v, Term w) {
                if (v.query.length() < buf) {
                    buf = v.query.length();
                }
                if (w.query.length() < buf) {
                    buf = w.query.length();
                }
                String substringOne = v.query.substring(0, buf);
                String substringTwo = w.query.substring(0, buf);

                return substringOne.compareTo(substringTwo);
            }
        };
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        return (this.query.compareTo(that.query));
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return this.weight + "\t" + this.query;
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
        for (Term t : terms) {
            StdOut.println(t);
        }

        StdOut.println("");
        Arrays.sort(terms, Term.byReverseWeightOrder());
        for (Term t : terms) {
            StdOut.println(t);
        }

        StdOut.println("");
        Arrays.sort(terms, Term.byPrefixOrder(1));
        for (Term t : terms) {
            StdOut.println(t);
        }
    }
}
