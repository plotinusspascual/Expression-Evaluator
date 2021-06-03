import java.util.HashMap;
public abstract class Operator {
  static final HashMap<String, Operator> operators = new HashMap<>();
  public abstract int priority();
  static{
    operators.put("+", new AdditionOperator());
    operators.put("-", new SubtractionOperator());
    operators.put("*", new MultiplicationOperator());
    operators.put("/", new DivisionOperator());
    operators.put("^", new PowerOperator());
    operators.put("(", new OpenParOperator());
    operators.put("#", new StartExpressionOperator());
  }
  public abstract Operand execute( Operand op1, Operand op2 );

  public static boolean check( String token ) {
    return token.equals("+")|| token.equals("-")||token.equals("*") ||
            token.equals("/")||token.equals("^")||token.equals("(")||token.equals(")");
  }
  public static Operator getOperator(String token){
    return operators.get(token);
  }
}
