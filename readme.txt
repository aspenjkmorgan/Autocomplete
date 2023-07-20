/******************************************************************************
 *  Name: Aspen Morgan
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 2: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/

The firstIndexOf() method utilizes a binary search algorithm but continues to search
even when the mid equals the key until array[mid] is greater than array[mid - 1] or 
until the mid is 0. The mid is a part of a binary search algorithm, defined as
mid = lo + (hi - lo)/2 to avoid overflow issues, and its an index value. If the a[mid] > a[mid - 1] 
and the a[mid] is equal to the key, then mid is the index of the first element that 
returns a positive search! Or, if mid = 0 and a[mid] equals the key, the first element 
in the array works and the function returns the index of zero.


/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?  (Big-Oh notation)
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor: NlogN 
(since copying array takes N + Arrays.sort uses NlogN, but we 
drop the lower-order term.)

allMatches(): NlogN 
(since each call to a BinarySearchDeluxe method is roughly logN 
+ N to copy over array + NlogN to sort, but we drop lower-order terms.)

numberOfMatches(): logN 
(since the constructor of Term is constant time + 
Each call to a BinarySearchDeluxe method is roughly logN + other constant ops.)




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/

The specification for this lab requests that all calls to comparator.compare
in firstIndexOf() is at worst (log base 2 of (n) + 1). My code wouldn't be as bad 
as linear, but I think the worst case would be something like 2logN + 1 since 
in the worst case every element is equal to the key and my while loop would make 
two compares every iteration in that case. If leading coefficient is omitted, 
my methods are fine.

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings or lectures, but do include
 *  any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/

I worked on this lab with Jayce Holdsambeck and I used a binary search implementation
 found on stack overflow.

/******************************************************************************
 *  Describe any serious problems you encountered.
 *****************************************************************************/


I had a bug from implementing a comparator wrong. I'm still wrapping my head around
the syntax for them.


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 *****************************************************************************/


