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
   
    pen.println("Trucated Tests");
    pen.println("with basic TextBlock: ");
    TBUtils.print(pen, new Truncated(basic, 7));
    pen.println("with BoxedBlock: ");
    TBUtils.print(pen, new Truncated(boxedBasic, 10));
    pen.println("with HComposition: ");
    TBUtils.print(pen, new Truncated(hComp, 15));
    pen.println("with VComposition: ");
    TBUtils.print(pen, new Truncated(vComp, 10));
    pen.println("with maxWith == 0: ");
    TBUtils.print(pen, new Truncated(basic, 0));
    pen.println("with maxWidth == this.contents.width(): ");
    TBUtils.print(pen, new Truncated(boxedBasic, boxedBasic.width()));
    pen.println("with maxWidth > this.contents.width(): ");
    TBUtils.print(pen, new Truncated(boxedBasic, boxedBasic.width()*2));
    pen.println("with Centered, then Boxed: ");
    TBUtils.print(pen, new BoxedBlock(new Truncated(center, 16)));
    pen.println("with RightJustified, then Boxed: ");
    TBUtils.print(pen, new BoxedBlock(new Truncated(rightJ, 12)));
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
   
    pen.println("Centered Tests");
    pen.println("with basic TextBlock: ");
    TBUtils.print(pen, new Centered(basic, 15));
    pen.println("with BoxedBlock: ");
    TBUtils.print(pen, new Centered(boxedBasic, 20));
    pen.println("with HComposition: ");
    TBUtils.print(pen, new Centered(hComp, 30));
    pen.println("with VComposition: ");
    TBUtils.print(pen, new Centered(vComp, 15));
    pen.println("with maxWidth == this.contents.width(): ");
    TBUtils.print(pen, new Centered(basic, basic.width()));
    pen.println("with maxWidth < this.contents.width(): ");
    TBUtils.print(pen, new Centered(boxedBasic, boxedBasic.width() - 2));
    pen.println("with Truncated, then Boxed: ");
    TBUtils.print(pen, new BoxedBlock(new Centered(trunc, 16)));
    pen.println("with RightJustified, then Boxed: ");
    TBUtils.print(pen, new BoxedBlock(new Centered(rightJ, 25)));
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
   
    pen.println("RightJustified Tests");
    pen.println("with basic TextBlock: ");
    TBUtils.print(pen, new RightJustified(basic, 15));
    pen.println("with BoxedBlock: ");
    TBUtils.print(pen, new RightJustified(boxedBasic, 20));
    pen.println("with HComposition: ");
    TBUtils.print(pen, new RightJustified(hComp, 30));
    pen.println("with VComposition: ");
    TBUtils.print(pen, new RightJustified(vComp, 15));
    pen.println("with maxWidth == this.contents.width(): ");
    TBUtils.print(pen, new RightJustified(basic, basic.width()));
    pen.println("with maxWidth < this.contents.width(): ");
    TBUtils.print(pen, new RightJustified(boxedBasic, boxedBasic.width() - 2));
    pen.println("with Truncated, then Boxed: ");
    TBUtils.print(pen, new BoxedBlock(new RightJustified(trunc, 16)));
    pen.println("with Centered, then Boxed: ");
    TBUtils.print(pen, new BoxedBlock(new RightJustified(center, 25)));
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

    pen.println("HorizontallyFlipped Tests");
    pen.println("with basic TextBlock: ");
    TBUtils.print(pen, new HorizontallyFlipped(basic));
    pen.println("with BoxedBlock: ");
    TBUtils.print(pen, new HorizontallyFlipped(boxedBasic));
    pen.println("with HComposition: ");
    TBUtils.print(pen, new HorizontallyFlipped(hComp));
    pen.println("with VComposition: ");
    TBUtils.print(pen, new HorizontallyFlipped(vComp));
    pen.println("with Centered");
    TBUtils.print(pen, new HorizontallyFlipped(center));
    pen.println("with Truncated: ");
    TBUtils.print(pen, new HorizontallyFlipped(trunc));
    pen.println("with VerticallyFlipped: ");
    TBUtils.print(pen, new HorizontallyFlipped(new VerticallyFlipped(vComp)));
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

  pen.println("VerticallyFlipped Tests");
  pen.println("with basic TextBlock: ");
  TBUtils.print(pen, new VerticallyFlipped(basic));
  pen.println("with BoxedBlock: ");
  TBUtils.print(pen, new VerticallyFlipped(boxedBasic));
  pen.println("with HComposition: ");
  TBUtils.print(pen, new VerticallyFlipped(hComp));
  pen.println("with VComposition: ");
  TBUtils.print(pen, new VerticallyFlipped(vComp));
  pen.println("with Centered");
  TBUtils.print(pen, new VerticallyFlipped(center));
  pen.println("with Truncated: ");
  TBUtils.print(pen, new VerticallyFlipped(trunc));
  pen.println("with HorizontallyFlipped: ");
  TBUtils.print(pen, new VerticallyFlipped(new HorizontallyFlipped(vComp)));
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
    pen.println("MakeList Tests");
    pen.println("with basic TextBlock: ");
    TBUtils.print(pen, new MakeList(basic));
    pen.println("with BoxedBlock: ");
    TBUtils.print(pen, new MakeList(boxedBasic));
    pen.println("with HComposition: ");
    TBUtils.print(pen, new MakeList(hComp));
    pen.println("with VComposition: ");
    TBUtils.print(pen, new MakeList(vComp));
    pen.println("with Centered");
    TBUtils.print(pen, new MakeList(center));
    pen.println("with Truncated: ");
    TBUtils.print(pen, new MakeList(trunc));
    pen.println("with HorizontallyFlipped: ");
    TBUtils.print(pen, new HorizontallyFlipped(new MakeList(vComp)));
    pen.println("with VerticallyFlipped: ");
    TBUtils.print(pen, new VerticallyFlipped(new MakeList(vComp)));
    pen.println("with taller block: ");
    TBUtils.print(pen, new MakeList(new VComposition(vComp, vComp)));

  } // main
} // TextBlockTests
