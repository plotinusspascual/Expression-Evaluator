public class PowerOperator extends Operator{

  @Override
  public int priority() {
    return 4;
  }

  @Override
  public Operand execute(Operand op1, Operand op2) {
    Operand answer = new Operand(power(op1.getValue(),op2.getValue() ));
    return answer;
  }
  public int power(int i, int j){
    int answer = i;
    for(int count = 2; count <= j; count++){
      answer = answer * i;
    }
    return answer;

  }

}