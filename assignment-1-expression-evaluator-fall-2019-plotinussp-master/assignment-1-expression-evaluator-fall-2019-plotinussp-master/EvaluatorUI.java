import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {
  private TextField txField = new TextField();
  private Panel buttonPanel = new Panel();

  private static final String[] bText = {
          "7", "8", "9", "+", "4", "5", "6", "- ", "1", "2", "3",
          "*", "0", "^", "=", "/", "(", ")", "C", "CE"
  };
  private Button[] buttons = new Button[bText.length];

  public static void main(String argv[]) {
    EvaluatorUI calc = new EvaluatorUI();
  }

  public EvaluatorUI() {
    setLayout(new BorderLayout());

    add(txField, BorderLayout.NORTH);
    txField.setEditable(false);

    add(buttonPanel, BorderLayout.CENTER);
    buttonPanel.setLayout(new GridLayout(5, 4));

    for (int i = 0; i < 20; i++) {
      buttons[i] = new Button(bText[i]);
    }

    for (int i = 0; i < 20; i++) {
      buttonPanel.add(buttons[i]);
    }

    for (int i = 0; i < 20; i++) {
      buttons[i].addActionListener(this);
    }

    setTitle("Calculator");
    setSize(400, 400);
    setLocationByPlatform(true);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent arg0) {

    String input = ((Button)(arg0.getSource())).getLabel();
      if(input == "="){
        Evaluator cal = new Evaluator();
        txField.setText(Integer.toString(cal.eval(txField.getText())));
      }
      else if (input == "C") {
        txField.setText(" ");
      }
      else if (input == "CE") {
        String line = txField.getText();
        String[] operators = { "+", "-", "*", "/", "^" };
        int max = 0;
        for (int i = 0; i < operators.length; i++) {
          if (line.lastIndexOf(operators[i]) > max)
          {
            max = line.lastIndexOf(operators[i]);
          }
        }
        txField.setText(line.substring(0, max + 1));
      }
      else
      {
        txField.setText(txField.getText() + input);
      }
  }
}
