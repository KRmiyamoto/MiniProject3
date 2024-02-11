/**
 * Given a text block, rearranges vertically.
 */
public class VerticallyFlipped implements TextBlock {
  // Fields
  /**
   * The contents to be flipped.
   */
  TextBlock contents;

  // Constructor
  /**
   * Build a Centered TextBlock of given width and contents.
   */
  public VerticallyFlipped(TextBlock _contents) {
    this.contents = _contents;
  } // VerticallyFlipped(String)

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
      return this.contents.row(this.height() - (i + 1));
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

} // VerticallyFlipped
