/**
 * Given a text block and a width, builds a new block 
 * that right-justifies the input block within that width.
 */
public class RightJustified implements TextBlock {
  // Fields
  /**
   * The contents to be centered, and
   * the given width to be centered within.
   */
  TextBlock contents;
  int maxWidth;

  // Constructor
  /**
   * Build a RightJustified TextBlock of given width and contents.
   */
  public RightJustified(TextBlock _contents, int widthParam) {
    this.contents = _contents;
    this.maxWidth = widthParam;
  } // RightJustified(String, int)

  // Methods
  /**
   * Get one row from the block.
   *
   * @pre 0 <= i < this.height()
   * @pre this.contents.width() <= this.maxWidth
   * @exception Exception if the preconditions are not met
   */
  public String row(int i) throws Exception {
    if ((i < 0) || (i >= this.height())) {
       throw new Exception("Invalid row " + i);
     } else if (this.contents.width() <= this.maxWidth) {
      int buffer = this.maxWidth - this.contents.row(i).length();
      return TBUtils.spaces(buffer) + this.contents.row(i);
     } else {
       // Ensure error is issued if too much space is provided.
       throw new Exception("Too little space to Right Justify.");
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
   * Note that width is the given widthParam "rounded down" such that
   * the contents of the block can be centered appropriately.
   */
  public int width() {
    return this.maxWidth;
  } // width()

} // RightJustified
