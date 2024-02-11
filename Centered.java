/**
 * Given a text block and a width, 
 * builds a new block that centers the block within that width.
 * 
 * Note that Centered "rounds down" to achieve centering. (That is, if the given
 * block has length 5 and is to be centered in width 10, there will be 2 spaces on
 * either side of the block.)
 * 
 * @author Keely Miyamoto
 * @author Lucas Willett
 */
public class Centered implements TextBlock {
  // Fields
  /**
   * The contents to be centered, and
   * the given width to be centered within.
   */
  TextBlock contents;
  int maxWidth;

  // Constructor
  /**
   * Build a Centered TextBlock of given width and contents.
   */
  public Centered(TextBlock _contents, int _maxWidth) {
    this.contents = _contents;
    this.maxWidth = _maxWidth;
  } // Centered(String, int)

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
      int buffer = (this.maxWidth - this.contents.row(i).length()) / 2;
      return TBUtils.spaces(buffer) + this.contents.row(i) + TBUtils.spaces(buffer);
     } else {
       // Ensure error is issued if too much space is provided.
      throw new Exception("Too little space to render Centered.");
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
   * Note that width is the given maxWidth "rounded down" such that
   * the contents of the block can be centered appropriately.
   */
  public int width() {
    int buffer = (this.maxWidth - this.contents.width()) / 2;
    return this.contents.width() + (2 * buffer);
  } // width()

} // Centered
