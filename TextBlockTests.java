/**
 * A suite of tests for the Trucate, Centered, RightJustified, HorizontallyFlipped, 
 * VerticallyFlipped, MakeList, and TBUtils equality procedures.
 * 
 * @author Lucas Willett
 * @author Keely Miyamoto
 */

 // Visual Tests vs JUnit Tests??
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;

public class TextBlockTests {

  public static void main(String[] args) {
    
    PrintWriter pen = new PrintWriter(System.out, true);

    // Primitive TextBlocks
    TextBlock basic = new TextLine("Hello World");
    BoxedBlock boxedBasic = new BoxedBlock(basic);
    HComposition hComp = new HComposition(basic, boxedBasic);
    VComposition vComp = new VComposition(basic, boxedBasic);
    TextBlock trunc = new Truncated(basic, 7);
    TextBlock center = new Centered(basic, 20);
    TextBlock rightJ = new RightJustified(basic, 15);
    TextBlock list = new MakeList(new VComposition(vComp, vComp));
  
  /**
   * Truncated:
   * with basic TextBlock 
   * with BoxedBlock 
   * with HComposition 
   * with VComposition
   * with maxWith == 0
   * with maxWidth == this.contents.width()
   * with maxWidth > this.contents.width()
   * with Centered
   * with RightJustified
   */

  /**
   * Centered:
   * with basic TextBlock 
   * with BoxedBlock 
   * with HComposition 
   * with VComposition
   * with maxWidth == this.contents.width()
   * with maxWidth < this.contents.width()
   * with Truncated
   * with RightJustified
   */

  /**
   * RightJustified:
   * with basic TextBlock 
   * with BoxedBlock 
   * with HComposition 
   * with VComposition
   * with maxWidth == this.contents.width()
   * with maxWidth < this.contents.width()
   * with Centered
   * with Truncated
   */

  /**
   * HorizontallyFlipped: 
   * with basic TextBlock 
   * with BoxedBlock 
   * with HComposition 
   * with VComposition
   * with Centered
   * with Truncated
   * with VerticallyFlipped
   */

  /**
   * VerticallyFlipped
   * with basic TextBlock 
   * with BoxedBlock 
   * with HComposition 
   * with VComposition
   * with Centered
   * with Truncated
   * with HorizontallyFlipped
   */

  /**
    * MakeList
    * with basic TextBlock 
    * with BoxedBlock 
    * with HComposition 
    * with VComposition
    * with Centered
    * with Truncated
    * with HorizontallyFlipped
    * with VerticallyFlipped
    */

  } // main
} // TextBlockTests
