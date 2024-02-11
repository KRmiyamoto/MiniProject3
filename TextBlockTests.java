/**
 * A suite of tests for the Trucate, Centered, RightJustified, HorizontallyFlipped, 
 * VerticallyFlipped, MakeList, and TBUtils equality procedures.
 * 
 * @author Lucas Willett
 * @author Keely Miyamoto
 */

 import static org.junit.jupiter.api.Assertions.assertEquals;
 import org.junit.jupiter.api.Test;

import java.io.PrintWriter;

public class TextBlockTests {

  // Primitive TextBlocks
  TextBlock basic = new TextLine("Hello World");
  TextBlock basic2 = new TextLine("Goodbye World");
  BoxedBlock boxedBasic = new BoxedBlock(basic);
  HComposition hComp = new HComposition(basic, boxedBasic);
  VComposition vComp = new VComposition(basic, boxedBasic);
  TextBlock trunc = new Truncated(basic, 7);
  TextBlock center = new Centered(basic, 20);
  TextBlock rightJ = new RightJustified(basic, 15);
  TextBlock list = new MakeList(new VComposition(vComp, vComp));

  /**
   * JUnit tests for TBUtils.equal():
   * two empty blocks (true)
   * two identical basic blocks (true)
   * two differently truncated basic blocks (false)
   * two different VComps (false)
   * two identical VComps (true)
   * a VComp and a double-VerticallyFlipped vComp (true)
   */
  @Test
  void equalTest1() throws Exception {
    assertEquals(true, TBUtils.equal(new TextLine(""), new TextLine("")), "The contents of 2 empty blocks are equal.");
  } // equalTest1

  @Test
  void equalTest2() throws Exception {
    assertEquals(true, TBUtils.equal(basic, basic), "The contents of 2 identical basic blocks are equal.");
  } // equalTest2

  @Test
  void equalTest3() throws Exception {
    assertEquals(false, TBUtils.equal(basic, trunc), "The contents of 2 differently Truncated basic blocks are NOT equal.");
  } // equalTest3

  @Test
  void equalTest4() throws Exception {
    assertEquals(false, TBUtils.equal(vComp, new VComposition(boxedBasic, basic)), "The contents of 2 different VerticalCompositions are NOT equal.");
  } // equalTest4

  @Test
  void equalTest5() throws Exception {
    assertEquals(true, TBUtils.equal(vComp, new VComposition(basic, boxedBasic)), "The contents of 2 identical VerticalCompositions are equal.");
  } // equalTest5

  @Test
  void equalTest6() throws Exception {
    assertEquals(true, TBUtils.equal(vComp, new VerticallyFlipped(new VerticallyFlipped(vComp))), "The contents of a VerticalComp and the same double-flipped VerticalComp are equal.");
  } // equalTest6

   /**
   * JUnit tests for TBUtils.eqv():
   * two empty blocks (true)
   * two basic with different contents (true)
   * two truncated different basic blocks (true)
   * two different MakeList-BoxedBlocks (true)
   * two different VComp, then HFlipped (true)
   * a VComp and a double-VerticallyFlipped vComp (false)
   * a Centered BoxedBlock and a Boxed CenteredBlock (false)
   */
  @Test
  void eqvTest1() throws Exception {
    assertEquals(true, TBUtils.eqv(new TextLine(""), new TextLine("")), "The build of 2 empty blocks is equivalent.");
  } // eqvTest1

  @Test
  void eqvTest2() throws Exception {
    assertEquals(true, TBUtils.eqv(basic, basic2), "The build of 2 different basic blocks is equivalent.");
  } // eqvTest2

  @Test
  void eqvTest3() throws Exception {
    assertEquals(true, TBUtils.eqv(new Truncated(basic, 3), trunc), "The build of 2 differently Truncated basic blocks is equivalent.");
  } // eqvTest3

  @Test
  void eqvTest4() throws Exception {
    assertEquals(true, TBUtils.eqv(new MakeList(boxedBasic), new MakeList(new BoxedBlock(basic2))), "The build of 2 different MakeList BoxedBlocks is equivalent.");
  } // eqvTest4

  @Test
  void eqvTest5() throws Exception {
    assertEquals(true, TBUtils.eqv(new HorizontallyFlipped(vComp), new HorizontallyFlipped(new VComposition(boxedBasic, basic))), "The build of 2 different HorizontallyFlipped VerticalCompositions is equivalent.");
  } // eqvTest5

  @Test
  void eqvTest6() throws Exception {
    assertEquals(false, TBUtils.eqv(vComp, new VerticallyFlipped(new VerticallyFlipped(vComp))), "The build of a VerticalComp and the same double-flipped VerticalComp is NOT equivalent.");
  } // eqvTest6

  @Test
  void eqvTest7() throws Exception {
    assertEquals(false, TBUtils.eqv(new Centered(rightJ, 20), new RightJustified(center, 15)), "The build of a Centered RightJustified block and a RightJustified CenteredBlock is NOT equivalent.");
  } // eqvTest7

   /**
   * JUnit tests for TBUtils.eq():
   * two empty blocks (false)
   * two basic with different contents (false)
   * two basic blocks with identical contents (false)
   * the same BoxedBlock (true)
   * a VComp and its copy (true)
   * a Truncated Box and its copy (true)
   */
  @Test
  void eqTest1() throws Exception {
    assertEquals(false, TBUtils.eq(new TextLine(""), new TextLine("")), "The memory location of 2 empty blocks is NOT equal.");
  } // eqTest1

  @Test
  void eqTest2() throws Exception {
    assertEquals(false, TBUtils.eq(basic, basic2), "The memory location of 2 different basic blocks is NOT equal.");
  } // eqTest2

  @Test
  void eqTest3() throws Exception {
    assertEquals(false, TBUtils.eq(new TextLine("Hello World"), basic), "The memory location of 2 different basic blocks with the same content is NOT equal.");
  } // eqTest3

  @Test
  void eqTest4() throws Exception {
    assertEquals(true, TBUtils.eq(boxedBasic, boxedBasic), "The memory location of the same BoxedBlock is equivalent.");
  } // eqTest4

  @Test
  void eqTest5() throws Exception {
    VComposition vCompCopy = vComp;
    assertEquals(true, TBUtils.eq(vComp, vCompCopy), "The memory location of a VComposition and that of its copy are equivalent.");
  } // eqTest5

  @Test
  void eqTest6() throws Exception {
    TextBlock truncBox = new Truncated(boxedBasic, 10);
    TextBlock truncBoxCopy = truncBox;
    assertEquals(true, TBUtils.eqv(truncBox, truncBoxCopy), "The memory location of a Truncated Box and that of its copy are equivalent.");
  } // eqTest6
   
  /** Visual Tests of Truncated, Centered, RightJustified, VerticallyFlipped
   *  HorizontallyFlipped, and MakeList 
   */
  public static void main(String[] args) {
    
    PrintWriter pen = new PrintWriter(System.out, true);

    // Primitive TextBlocks to be used in main method (visual tests)
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
   * with maxWidth == 0
   * with maxWidth == 1
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
    pen.println("with maxWith == 1: ");
    TBUtils.print(pen, new Truncated(basic, 1));
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
   * with empty block

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
    pen.println("with empty block");
    TBUtils.print(pen, new HorizontallyFlipped(new TextLine("")));
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
   * with empty block

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
    pen.println("with empty block");
    TBUtils.print(pen, new VerticallyFlipped(new TextLine("")));
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
    * with a taller block
    
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
  */ 
  } // main
} // TextBlockTests
