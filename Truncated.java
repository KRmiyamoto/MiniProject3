/**
 * Given a text block and a maximum width, builds a new block 
 * that truncates the input block to that width.
 * 
 * @author Keely Miyamoto
 * @author Lucas Willett
 */

public class Truncated implements TextBlock{
  
  // Fields
  /**
   * The contents to be Truncated, and
   * the maximum width.
   */
  TextBlock contents;
  int maxWidth;

  // Constructors
  /**
   * Build a Trucated TextBlock with contents _contents.
   */
  public Truncated(TextBlock _contents, int _maxWidth) {
    this.contents = _contents;
    this.maxWidth = _maxWidth;
  } // Truncated(String, int)

  // Methods
  /**
   * Get one row from the Truncated block.
   *
   * @pre 0 <= i < this.height()
   * @pre this.maxWidth <= this.contents.width()
   * @exception Exception if the preconditions are not met
   */
  public String row(int i) throws Exception {
   if ((i < 0) || (i >= this.height())) {
      throw new Exception("Invalid row " + i);
    } else if (this.maxWidth <= this.contents.width()) {
      return this.contents.row(i).substring(0, this.maxWidth);
    } else {
      // Ensure error is issued if too much space is provided.
      throw new Exception("Truncation bounds exceeded.");
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
    return this.maxWidth;
  } // width()

} // Truncated
