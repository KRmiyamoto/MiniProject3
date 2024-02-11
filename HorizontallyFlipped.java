/**
 * Given a text block, rearranges horizontally.
 * 
 * @author Keely Miyamoto
 * @author Lucas Willett
 */
public class HorizontallyFlipped implements TextBlock {
  // Fields
  /**
   * The contents to be flipped.
   */
  TextBlock contents;

  // Constructor
  /**
   * Build a Centered TextBlock of given width and contents.
   */
  public HorizontallyFlipped(TextBlock _contents) {
    this.contents = _contents;
  } // HorizontallyFlipped(String)

  // Methods
  /**
   * Get one row from the block.
   *
   * @pre 0 <= i < this.height()
   * @exception Exception if the preconditions are not met
   */
  public String row(int i) throws Exception {
    if ((i < 0) || (i >= this.height())) {
       throw new Exception("Invalid row " + i);
     } else {
      String initial = this.contents.row(i);
      String flipped = "";
      for (int j = 0; j < initial.length(); j++) {
        flipped = initial.charAt(j) + flipped;
      } // for
      return flipped;
    } 
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.contents.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.contents.width();
  } // width()
} // HorizontallyFlipped
