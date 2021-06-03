public class EvaluatorTester {
  public static void main(String[] args) {
    Evaluator evaluator = new Evaluator();
    String[] test = {
            "1 + 2",
            "3 * 5",
    };
    for ( String arg : test ) {
      System.out.format( "%s = %d\n", arg, evaluator.eval( arg ) );
    }
  }
}
