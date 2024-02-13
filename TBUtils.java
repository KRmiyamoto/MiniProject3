import java.io.PrintWriter;

/**
 * Utilities for TextBlocks.
 * 
 * @author Samuel A. Rebelsky
 * @author Lucas Willett
 * @author Keely Miyamoto
 */
public class TBUtils {
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as the program operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program operates.
   */
  static String lotsOfSpaces = "  ";

  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len) {
    // Note: This strategy probably represents an overkill in
    // attempts at efficiency.
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    } // while
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)

  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block) {
    for (int i = 0; i < block.height(); i++) {
      // Even though we only call block.row with a valid i,
      // we need to put the call in a try/catch block.
      try {
        pen.println(block.row(i));
      } catch (Exception e) {
        pen.println();
      } // catch (Exception)
    } // for
  } // print(PrintWriter, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  static String spaces(int len) {
    // As with dashes, this is probably overkill.
    // Make sure the collection of dashes is big enough
    while (lotsOfSpaces.length() < len) {
      lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
    } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)

  /**
   * Converts TextBlock to a string.
   */
  static String toString(TextBlock block) {
    String ret = "";
    for (int i = 0; i < block.height(); i++) {
      try {
        ret.concat(block.row(i) + "\n");
      } catch (Exception invalidIndex) {
        ret.concat("");
      } // try
    } // for
    return ret;
  } // toString(TextBlock)
   
  /**
   * Equality methods for TextBlocks (1st attempt)
   */

  /**
   * Method to test equality of TextBlocks: Returns true if
   * t1 and t2 contain the same lines.
   */ 
  static boolean equal(TextBlock t1, TextBlock t2) throws Exception {
    if ((t1.height() != t2.height()) || (t1.width() != t2.width())) {
      return false;
    } else {
      for (int i = 0; i < t1.height(); i++) {
        if (!((t1.row(i)).equals(t2.row(i)))) {
          return false;
        } // if
      } // for
      return true;
    } // if
  } // equal(TextBlock, TextBlock)
  
  /**
   * Method to test equality of TextBlocks: Returns true if
   * t1 and t2 were built in the same way.
   */
  static boolean eqv(TextBlock t1, TextBlock t2) throws Exception {
    if (!((t1.getClass()).equals(t2.getClass()))) {
      return false;
    } else {
      for (int i = 0; i < (t1.getContents()).length; i++) {
        if (!(t1.getContents()[i].equals(t2.getContents()[i]))) {
          return false;
        }
      } // for
      return true;
    } // else
  } // eqv(TextBlock, TextBlock)

  /**
   * Method to test equality of TextBlocks: Returns true if
   * t1 and t2 occupy the same memory location.
   */
  static boolean eq(TextBlock t1, TextBlock t2) {
    return t1 == t2;
  } // eq(TextBlock, TextBlock)

} // class TBUtils
