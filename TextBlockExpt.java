import java.io.PrintWriter;

public class TextBlockExpt {
  
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    // Testing TextBlocks
    TextBlock test = new TextLine("Hello");
    TextBlock test2 = new TextLine("Goodbye");
    TextBlock vert = new VComposition(new VComposition(test, test2),new VComposition(test, test2));
    TextBlock centeredVert = new VComposition(new Centered(test, 10), new Centered(test2, 10));
    TextBlock rjVert = new VComposition(new RightJustified(test, 10), new RightJustified(test2, 10));
/** 
    // Test Centered
    TBUtils.print(pen, test);
    TBUtils.print(pen, new BoxedBlock(new Centered(test, 6)));
    TBUtils.print(pen, new BoxedBlock(new Centered(test, 5)));
    TBUtils.print(pen, new BoxedBlock(new Centered(test, 10)));
    TBUtils.print(pen, new BoxedBlock(new Centered(test, 4)));
    // Test Centered with VComp
    TBUtils.print(pen, new BoxedBlock(centeredVert));
    TBUtils.print(pen, new BoxedBlock(new VComposition(new Centered(centeredVert, 22), new Centered(centeredVert, 22))));

    // Test Truncate
    TBUtils.print(pen, test);
    TBUtils.print(pen, new BoxedBlock(new Truncated(test, 6)));
    TBUtils.print(pen, new Truncated(test, 5));
    TBUtils.print(pen, new Truncated(new Truncated(test, 4), 2));
    TBUtils.print(pen, new BoxedBlock(new Truncated(test, 0)));
    // Test Truncate with VComp
    TBUtils.print(pen, new Truncated(vert, 5));
    TBUtils.print(pen, new Truncated(vert, 2));

    // Test Centered and Truncate Together
    TBUtils.print(pen, new BoxedBlock (new Centered(test, 20)));
    TBUtils.print(pen, new BoxedBlock(new Truncated(new Centered(test, 20), 13)));
*/
    // Test RightJustified
    TBUtils.print(pen, new BoxedBlock(rjVert));

    TBUtils.print(pen, new BoxedBlock(new RightJustified(vert, 10)));
  } // main
  
} // TextBlockExpt