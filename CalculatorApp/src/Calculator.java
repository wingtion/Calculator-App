import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.*;
import java.util.ArrayList;

public class Calculator extends JFrame {
    JButton delButton = new JButton("DEL"); JButton cButton = new JButton("C");
    JButton subtractButton = new JButton("-");JButton sumButton = new JButton("+");JButton divButton = new JButton("/");
    JButton multiplyButton = new JButton("X"); JButton answerButton = new JButton("ANS"); JButton zeroButton = new JButton("0");
    JButton oneButton = new JButton("1");JButton twoButton = new JButton("2");JButton threeButton = new JButton("3");
    JButton fourButton = new JButton("4"); JButton fiveButton = new JButton("5"); JButton sixButton = new JButton("6");
    JButton sevenButton = new JButton("7"); JButton eightButton = new JButton("8"); JButton nineButton = new JButton("9");
    JButton dotButton = new JButton(".");
    JTextField textField = new JTextField();
    public double number1 , number2 , result = 0;
    String operator = null;
    public Calculator(){
        this.setTitle("Calculator"); //sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application (DO_NOTHING_ON_CLOSE çarpıya bassak da uygulama kapanmaz)
        this.setResizable(false); //prevent frame from being resized
        this.setSize(430,355); //sets the x-dimension, and y-dimension of frame
        this.setLocationRelativeTo(null);  //sets the window at center
        this.setLocation(getX(), getY());
        this.setLayout(null);

        //textfield editable true or false
        textField.setEditable(false);

        //layout manager null o yüzden setBounds() ile yer ve büyüklük belirleriz
        delButton.setBounds(0, 100, 70, 100); //(x,y , width,height)
        cButton.setBounds(0,210,70,100); subtractButton.setBounds(75,100,50,65);
        multiplyButton.setBounds(75,170,50,63); divButton.setBounds(75,240,50,70);
        sevenButton.setBounds(130,100,70,50); eightButton.setBounds(200,100,70,50);
        nineButton.setBounds(270,100,70,50); fourButton.setBounds(130,155,70,50);
        fiveButton.setBounds(200,155,70,50); sixButton.setBounds(270,155,70,50);
        oneButton.setBounds(130,210,70,50); twoButton.setBounds(200,210,70,50);
        threeButton.setBounds(270,210,70,50); zeroButton.setBounds(130,260,140,50);
        dotButton.setBounds(270,260,70,50); sumButton.setBounds(340,100,70,100);
        answerButton.setBounds(340,200,70,110);
        textField.setBounds(5, 20, 400, 65);

        //butona tıkladığımızda etrafında oluşan mavi şeritleri kaldırıyoruz
        delButton.setFocusable(false);cButton.setFocusable(false);subtractButton.setFocusable(false);multiplyButton.setFocusable(false);
        divButton.setFocusable(false);sevenButton.setFocusable(false);eightButton.setFocusable(false);nineButton.setFocusable(false);
        fourButton.setFocusable(false);fiveButton.setFocusable(false);sixButton.setFocusable(false);oneButton.setFocusable(false);
        twoButton.setFocusable(false);threeButton.setFocusable(false);zeroButton.setFocusable(false);dotButton.setFocusable(false);
        answerButton.setFocusable(false); sumButton.setFocusable(false); textField.setFocusable(false);

        delButton.addActionListener(e-> handleButtonClick(delButton));
        oneButton.addActionListener(e-> handleButtonClick(oneButton)); twoButton.addActionListener(e-> handleButtonClick(twoButton));
        threeButton.addActionListener(e-> handleButtonClick(threeButton)); fourButton.addActionListener(e-> handleButtonClick(fourButton));
        fiveButton.addActionListener(e-> handleButtonClick(fiveButton)); sixButton.addActionListener(e-> handleButtonClick(sixButton));
        sevenButton.addActionListener(e-> handleButtonClick(sevenButton)); eightButton.addActionListener(e-> handleButtonClick(eightButton));
        nineButton.addActionListener(e-> handleButtonClick(nineButton)); zeroButton.addActionListener(e-> handleButtonClick(zeroButton));
        cButton.addActionListener(e-> handleButtonClick(cButton)); subtractButton.addActionListener(e-> handleButtonClick(subtractButton));
        sumButton.addActionListener(e-> handleButtonClick(sumButton)); divButton.addActionListener(e-> handleButtonClick(divButton));
        multiplyButton.addActionListener(e-> handleButtonClick(multiplyButton)); answerButton.addActionListener(e-> handleButtonClick(answerButton));
        dotButton.addActionListener(e-> handleButtonClick(dotButton));

        
        this.add(delButton);this.add(cButton);this.add(subtractButton);this.add(sumButton);this.add(divButton);this.add(multiplyButton);this.add(answerButton);
        this.add(oneButton);this.add(twoButton);this.add(threeButton);this.add(fourButton);this.add(fiveButton);this.add(sixButton);this.add(sevenButton);
        this.add(eightButton);this.add(nineButton);this.add(dotButton); this.add(zeroButton); this.add(textField);

        this.setVisible(true);
    }
    public void handleButtonClick(JButton button){
        if(button.getText().equals("DEL")){

            String updatedText = textField.getText();

            textField.setText(updatedText.substring(0,updatedText.length()-1)); //substring(başlangıcIndex,bitişIndex)

        }else if(button.getText().equals("C")) {
            textField.setText("");
        }else if(button.getText().equals("-")) {
            number1 = Double.parseDouble(textField.getText());
            textField.setText("");
            operator = "-";

        }else if(button.getText().equals("X")) {
            number1 = Double.parseDouble(textField.getText());
            textField.setText("");
            operator = "X";

        }else if(button.getText().equals("/")) {
            number1 = Double.parseDouble(textField.getText());
            textField.setText("");
            operator = "/";

        }else if(button.getText().equals(".")) {
            textField.setText(textField.getText() +".");
        }else if(button.getText().equals("+")) {
            number1 = Double.parseDouble(textField.getText());
            textField.setText("");
            operator = "+";

        }else if(button.getText().equals("ANS")) {
            number2 = Double.parseDouble(textField.getText());

            if(operator.equals("+")){
                result = number1 + number2;
            }else if(operator.equals("-")){
                result = number1 - number2;
            }else if(operator.equals("X")){
                result = number1 * number2;
            }else if(operator.equals("/")){
                result = number1 / number2;
            }
            textField.setText(result + "");
            operator = "";

        }else if(button.getText().equals("0")) {
            textField.setText(textField.getText() +"0");
        }else if(button.getText().equals("1")){
            textField.setText(textField.getText() + "1");
        }else if(button.getText().equals("2")) {
            textField.setText(textField.getText() +"2");
        }else if(button.getText().equals("3")) {
            textField.setText(textField.getText() +"3");
        }else if(button.getText().equals("4")) {
            textField.setText(textField.getText() +"4");
        }else if(button.getText().equals("5")) {
            textField.setText(textField.getText() +"5");
        }else if(button.getText().equals("6")) {
            textField.setText(textField.getText() +"6");
        }else if(button.getText().equals("7")) {
            textField.setText(textField.getText() +"7");
        }else if(button.getText().equals("8")) {
            textField.setText(textField.getText() +"8");
        }else if(button.getText().equals("9")) {
            textField.setText(textField.getText() +"9");
        }
    }

    public static void main(String[] args) {
        try {
            // Use either light or dark theme
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new Calculator();
    }
}
