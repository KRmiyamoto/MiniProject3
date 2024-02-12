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
   */
   /**
   * JUnit tests for TBUtils.eqv():
   * two empty blocks (true)
   * two basic with different contents (true)
   * two truncated different basic blocks (true)
   * two different MakeList-BoxedBlocks (true)
   * two different VComp, then HFlipped (true)
   * a VComp and a double-VerticallyFlipped vComp (false)
   * a Centered BoxedBlock and a Boxed CenteredBlock (false)

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
   */
   /**
   * JUnit tests for TBUtils.eq():
   * two empty blocks (false)
   * two basic with different contents (false)
   * two basic blocks with identical contents (false)
   * the same BoxedBlock (true)
   * a VComp and its copy (true)
   * a Truncated Box and its copy (true)

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
  */
  

  /** Tests of Truncated, Centered, RightJustified, VerticallyFlipped
   *  HorizontallyFlipped, and MakeList -- CONVERT FROM VISUAL TO JUNIT!
   */

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
    */ 
    @Test
    void truncTest1() throws Exception {
      assertEquals("Hello W", trunc.row(0), "Truncated works with a basic TextBlock.");
    } // truncTest1

    @Test
    void truncTest2() throws Exception {
      assertEquals("+---------", new Truncated(boxedBasic, 10).row(0), "Truncated works with a BoxedBlock.");
      assertEquals("|Hello Wor", new Truncated(boxedBasic, 10).row(1), "Truncated works with a BoxedBlock.");
    } // truncTest2

    @Test
    void truncTest3() throws Exception {
      assertEquals("Hello World+---", new Truncated(hComp, 15).row(0), "Truncated works with a HComposition.");
      assertEquals("           |Hel", new Truncated(hComp, 15).row(1), "Truncated works with a HComposition.");
    } // truncTest3

    @Test
    void truncTest4() throws Exception {
      assertEquals("Hello Worl", new Truncated(vComp, 10).row(0), "Truncated works with a VComposition.");
      assertEquals("+---------", new Truncated(vComp, 10).row(1), "Truncated works with a VComposition.");
      assertEquals("|Hello Wor", new Truncated(vComp, 10).row(2), "Truncated works with a VComposition.");
    } // truncTest4

    @Test
    void truncTest5() throws Exception {
      assertEquals("H", new Truncated(basic, 1).row(0), "Truncated works with maxWith == 1.");
    } // truncTest5

    @Test
    void truncTest6() throws Exception {
      assertEquals("", new Truncated(basic, 0).row(0), "Truncated works with maxWith == 0.");
    } // truncTest6

    @Test
    void truncTest7() throws Exception {
      assertEquals("Hello World", new Truncated(basic, basic.width()).row(0), "Truncated works with maxWith == this.contents.width().");
    } // truncTest7

    /**
     * This test should throw an Exception!
     * @throws Exception
     */
    @Test
    void truncTest8() throws Exception {
      assertEquals("", new Truncated(basic, basic.width()*2).row(0), "Truncated works as expected with maxWidth > this.contents.width().");
    } // truncTest8

    @Test
    void truncTest9() throws Exception {
      assertEquals("+----------------+", new BoxedBlock(new Truncated(center, 16)).row(0), "Truncated works with Centered, then Boxed.");
      assertEquals("|    Hello World |", new BoxedBlock(new Truncated(center, 16)).row(1), "Truncated works with Centered, then Boxed.");
    } // truncTest9

    @Test
    void truncTest10() throws Exception {
      assertEquals("    Hello W", new Truncated(rightJ, 11).row(0), "Truncated works with RightJustified.");
    } // truncTest10


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
    @Test
    void centerTest1() throws Exception {
      assertEquals("    Hello World    ", center.row(0), "Centered works with a basic TextBlock.");
    } // centerTest1

    @Test
    void centerTest2() throws Exception {
      assertEquals("   +-----------+   ", new Centered(boxedBasic, 20).row(0), "Centered works with a BoxedBlock.");
      assertEquals("   |Hello World|   ", new Centered(boxedBasic, 20).row(1), "Centered works with a BoxedBlock.");
    } // centerTest2

    @Test
    void centerTest3() throws Exception {
      assertEquals("   Hello World+-----------+   ", new Centered(hComp, 30).row(0), "Centered works with a HComposition.");
      assertEquals("              |Hello World|   ", new Centered(hComp, 30).row(1), "Centered works with a HComposition.");
    } // centerTest3

    @Test
    void centerTest4() throws Exception {
      assertEquals(" Hello World   ", new Centered(vComp, 15).row(0), "Centered works with a VComposition.");
      assertEquals(" +-----------+ ", new Centered(vComp, 15).row(1), "Centered works with a VComposition.");
      assertEquals(" |Hello World| ", new Centered(vComp, 15).row(2), "Centered works with a VComposition.");
    } // centerTest4

    @Test
    void centerTest5() throws Exception {
      assertEquals("Hello World", new Centered(basic, basic.width()).row(0), "Centered works with maxWidth == this.contents.width().");
    } // centerTest5

    /**
     * This test should throw an Exception!
     * @throws Exception
     */
    @Test
    void centerTest6() throws Exception {
      assertEquals("", new Centered(basic, basic.width() - 2).row(0), "Centered works as expected with maxWidth < this.contents.width().");
    } // truncTest6

    @Test
    void centerTest7() throws Exception {
      assertEquals("   Hello W   ", new Centered(trunc, 13).row(0), "Centered works with Truncated.");
    } // centerTest7

    @Test
    void centerTest8() throws Exception {
      assertEquals("     Hello World ", new Centered(rightJ, 17).row(0), "Centered works with RightJustified.");
    } // centerTest8

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
    @Test
    void rightJTest1() throws Exception {
      assertEquals("    Hello World", rightJ.row(0), "RightJustified works with a basic TextBlock.");
    } // rightJTest1

    @Test
    void rightJTest2() throws Exception {
      assertEquals("  +-----------+", new RightJustified(boxedBasic, 15).row(0), "RightJustified works with a BoxedBlock.");
      assertEquals("  |Hello World|", new RightJustified(boxedBasic, 15).row(1), "RightJustified works with a BoxedBlock.");
    } // rightJTest2

    @Test
    void rightJTest3() throws Exception {
      assertEquals("      Hello World+-----------+", new RightJustified(hComp, 30).row(0), "RightJustified works with a HComposition.");
      assertEquals("                 |Hello World|", new RightJustified(hComp, 30).row(1), "RightJustified works with a HComposition.");
    } // rightJTest3

    @Test
    void rightJTest4() throws Exception {
      assertEquals("  Hello World  ", new RightJustified(vComp, 15).row(0), "RightJustified works with a VComposition.");
      assertEquals("  +-----------+", new RightJustified(vComp, 15).row(1), "RightJustified works with a VComposition.");
      assertEquals("  |Hello World|", new RightJustified(vComp, 15).row(2), "RightJustified works with a VComposition.");
    } // rightJTest4

    @Test
    void rightJTest5() throws Exception {
      assertEquals("Hello World", new RightJustified(basic, basic.width()).row(0), "RightJustified works with maxWidth == this.contents.width().");
    } // rightJTest5

    /**
     * This test should throw an Exception!
     * @throws Exception
     */
    @Test
    void rightJTest6() throws Exception {
      assertEquals("", new RightJustified(basic, basic.width() - 2).row(0), "RightJustified works as expected with maxWidth < this.contents.width().");
    } // rightJTest6

    @Test
    void rightJTest7() throws Exception {
      assertEquals("      Hello W", new RightJustified(trunc, 13).row(0), "RightJustified works with Truncated.");
    } // rightJTest7

    @Test
    void rightJTest8() throws Exception {
      assertEquals("       Hello World    ", new RightJustified(center, 22).row(0), "RightJustified works with Centered.");
    } // rightJTest8

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
   */
    @Test
    void HFlipTest1() throws Exception {
      assertEquals("dlroW olleH", new HorizontallyFlipped(basic).row(0), "HorizontallyFlipped works with a basic TextBlock.");
    } // HFlipTest1

    @Test
    void HFlipTest2() throws Exception {
      assertEquals("+-----------+", new HorizontallyFlipped(boxedBasic).row(0), "HorizontallyFlipped works with a BoxedBlock.");
      assertEquals("|dlroW olleH|", new HorizontallyFlipped(boxedBasic).row(1), "HorizontallyFlipped works with a BoxedBlock.");
    } // HFlipTest2

    @Test
    void HFlipTest3() throws Exception {
      assertEquals("+-----------+dlroW olleH", new HorizontallyFlipped(hComp).row(0), "HorizontallyFlipped works with a HComposition.");
      assertEquals("|dlroW olleH|           ", new HorizontallyFlipped(hComp).row(1), "HorizontallyFlipped works with a HComposition.");
    } // HFlipTest3

    @Test
    void HFlipTest4() throws Exception {
      assertEquals("  dlroW olleH", new HorizontallyFlipped(vComp).row(0), "HorizontallyFlipped works with a VComposition.");
      assertEquals("+-----------+", new HorizontallyFlipped(vComp).row(1), "HorizontallyFlipped works with a VComposition.");
      assertEquals("|dlroW olleH|", new HorizontallyFlipped(vComp).row(2), "HorizontallyFlipped works with a VComposition.");
    } // HFlipTest4

    @Test
    void HFlipTest5() throws Exception {
      assertEquals("    dlroW olleH    ", new HorizontallyFlipped(center).row(0), "HorizontallyFlipped works with Centered.");
    } // HFlipTest5

    @Test
    void HFlipTest7() throws Exception {
      assertEquals("W olleH", new HorizontallyFlipped(trunc).row(0), "HorizontallyFlipped works with Truncated.");
    } // HFlipTest7

    @Test
    void HFlipTest8() throws Exception {
      assertEquals("+-----------+", new HorizontallyFlipped(new VerticallyFlipped(vComp)).row(0), "HorizontallyFlipped works with VerticallyFlipped.");
      assertEquals("|dlroW olleH|", new HorizontallyFlipped(new VerticallyFlipped(vComp)).row(1), "HorizontallyFlipped works with VerticallyFlipped.");
      assertEquals("  dlroW olleH", new HorizontallyFlipped(new VerticallyFlipped(vComp)).row(3), "HorizontallyFlipped works with VerticallyFlipped.");
    } // HFlipTest8

    @Test
    void HFlipTest9() throws Exception {
      assertEquals("", new HorizontallyFlipped(new TextLine("")).row(0), "HorizontallyFlipped works with empty block.");
    } // HFlipTest9


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
  */
    @Test
    void VFlipTest1() throws Exception {
      assertEquals("Hello World", new VerticallyFlipped(basic).row(0), "VerticallyFlipped works with a basic TextBlock.");
    } // VFlipTest1

    @Test
    void VFlipTest2() throws Exception {
      assertEquals("+-----------+", new VerticallyFlipped(boxedBasic).row(0), "VerticallyFlipped works with a BoxedBlock.");
      assertEquals("|Hello World|", new VerticallyFlipped(boxedBasic).row(1), "VerticallyFlipped works with a BoxedBlock.");
    } // VFlipTest2

    @Test
    void VFlipTest3() throws Exception {
      assertEquals("           +-----------+", new VerticallyFlipped(hComp).row(0), "VerticallyFlipped works with a HComposition.");
      assertEquals("           |Hello World|", new VerticallyFlipped(hComp).row(1), "VerticallyFlipped works with a HComposition.");
    } // VFlipTest3

    @Test
    void VFlipTest4() throws Exception {
      assertEquals("+-----------+", new VerticallyFlipped(vComp).row(0), "VerticallyFlipped works with a VComposition.");
      assertEquals("|Hello World|", new VerticallyFlipped(vComp).row(1), "VerticallyFlipped works with a VComposition.");
      assertEquals("Hello World  ", new VerticallyFlipped(vComp).row(3), "VerticallyFlipped works with a VComposition.");
    } // VFlipTest4

    @Test
    void VFlipTest5() throws Exception {
      assertEquals("    Hello World    ", new VerticallyFlipped(center).row(0), "VerticallyFlipped works with Centered.");
    } // VFlipTest5

    @Test
    void VFlipTest7() throws Exception {
      assertEquals("Hello W", new VerticallyFlipped(trunc).row(0), "VerticallyFlipped works with Truncated.");
    } // VFlipTest7

    @Test
    void VFlipTest8() throws Exception {
      assertEquals("+-----------+", new VerticallyFlipped(new HorizontallyFlipped(vComp)).row(0), "VerticallyFlipped works with HorizontallyFlipped.");
      assertEquals("|dlroW olleH|", new VerticallyFlipped(new HorizontallyFlipped(vComp)).row(1), "VerticallyFlipped works with HorizontallyFlipped.");
      assertEquals("  dlroW olleH", new VerticallyFlipped(new HorizontallyFlipped(vComp)).row(3), "VerticallyFlipped works with HorizontallyFlipped.");
    } // VFlipTest8

    @Test
    void VFlipTest9() throws Exception {
      assertEquals("", new VerticallyFlipped(new TextLine("")).row(0), "VerticallyFlipped works with empty block.");
    } // VFlipTest9
  

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
    @Test
    void makeListTest1() throws Exception {
      assertEquals("  * Hello World", new MakeList(new TextLine("Hello World")).row(0), "MakeList works with a basic TextBlock.");
    } // makeListTest1

    @Test
    void makeListTest2() throws Exception {
      assertEquals("  * +-----------+", new MakeList(boxedBasic).row(0), "MakeList works with a BoxedBlock.");
      assertEquals("    * |Hello World|", new MakeList(boxedBasic).row(1), "MakeList works with a BoxedBlock.");
    } // makeListTest2

    @Test
    void makeListTest3() throws Exception {
      assertEquals("  * Hello World+-----------+", new MakeList(hComp).row(0), "MakeList works with a HComposition.");     

    } // rightJTest3

    @Test
    void makeListTest4() throws Exception {
      assertEquals("  * Hello World  ", new MakeList(vComp).row(0), "MakeList works with a VComposition.");
      assertEquals("    * +-----------+", new MakeList(vComp).row(1), "MakeList works with a VComposition.");
      assertEquals("    * |Hello World|", new MakeList(vComp).row(2), "MakeList works with a VComposition.");
    } // makeListTest4

    @Test
    void makeListTest5() throws Exception {
      assertEquals("  *     Hello World    ", new MakeList(center).row(0), "MakeList works with Centered.");
    } // makeListTest5

    @Test
    void makeListTest6() throws Exception {
      assertEquals("  * Hello W", new MakeList(trunc).row(0), "MakeList works with Truncated.");
    } // makeListTest6

    @Test
    void makeListTest7() throws Exception {
      assertEquals("  *     Hello World", new MakeList(rightJ).row(0), "MakeList works with RightJustified.");
    } // makeListTest7

    @Test
    void makeListTest8() throws Exception {
      assertEquals("  * dlroW olleH", new MakeList(new HorizontallyFlipped(basic)).row(0), "MakeList works with HorizontallyFlipped.");
    } // makeListTest8

    @Test
    void makeListTest9() throws Exception {
      assertEquals("  * +-----------+", new MakeList(new VerticallyFlipped(boxedBasic)).row(0), "MakeList works with VerticallyFlipped.");
      assertEquals("    * |Hello World|", new MakeList(new VerticallyFlipped(boxedBasic)).row(1), "MakeList works with VerticallyFlipped.");
    } // makeListTest9


} // TextBlockTests
