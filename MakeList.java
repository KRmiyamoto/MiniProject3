/**
 * Given a text block, returns a 'cascading list': Each line is bulletted, 
 * and indentation increases by 2 spaces per line for the first half of the lines.
 * Indentation decreases by 2 spaces per line for the next half of the lines.
 */
public class MakeList implements TextBlock {
  // Fields
  /**
   * The contents to be made into a 'cascading list'.
   */
  TextBlock contents;

  // Constructor
  /**
   * Build a Centered TextBlock of given width and contents.
   */
  public MakeList(TextBlock _contents) {
    this.contents = _contents;
  } // MakeList(String)

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
    } else if (i < (this.height() / 2)) {
      return TBUtils.spaces(2*(i + 1)) + "* " + this.contents.row(i);
    } else {
      return TBUtils.spaces(2 * (this.height() - i)) + "* " + this.contents.row(i);
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

} // MakeList