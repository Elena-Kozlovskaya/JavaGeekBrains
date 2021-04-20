 package lesson8;

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;

public class CounterApp extends JFrame {

    private int value1;
    private int value2;
    private int maxValue;
    public static final String VALIDATION_MASSAGE = "Число должно быть в пределах от -25 до 25";

    CounterApp (int initialValue1, int initialValue2) {
        setBounds(600, 600, 600, 300);
        setTitle("My simple counter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        Font font = new Font("Arial", Font.BOLD, 45);


        // Кнопка уменьшения 1
        JButton decrementButton1 = new JButton("<");
        decrementButton1.setFont(font);
        add(decrementButton1);

        // Счетчик 1
        JLabel label1 = new JLabel();
        label1.setFont(font);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        value1 = initialValue1;
        label1.setText(String.valueOf(value1));
        add(label1);

        // Кнопка увеличения 1
        JButton incrementButton1 = new JButton(">");
        incrementButton1.setFont(font);
        add(incrementButton1);

        // Кнопка уменьшения 2
        JButton decrementButton2 = new JButton("<");
        decrementButton2.setFont(font);
        add(decrementButton2);

        // Счетчик 2
        JLabel label2 = new JLabel();
        label2.setFont(font);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        value2 = initialValue2;
        label2.setText(String.valueOf(value2));
        add(label2);

        // Кнопка увеличения 2
        JButton incrementButton2 = new JButton(">");
        incrementButton2.setFont(font);
        add(incrementButton2);

        // Сообщение об ошибке
        Font errorFont = new Font("Arial", Font.BOLD, 25);
        JLabel errorLabel = new JLabel();
        errorLabel.setFont(errorFont);
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(errorLabel);

        // Кнопка поиска максимального значения
        JButton maxValueButton = new JButton("Найти MAX из двух чисел");
        maxValueButton.setFont(font);
        add(maxValueButton);

        // Сообщение результата поиска
        JLabel maxValueLabel = new JLabel();
        maxValueLabel.setFont(font);
        maxValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(maxValueLabel);


        incrementButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value1++;
                label1.setText(String.valueOf(value1));
                errorLabel.setText(value1 < 25 ? "" : VALIDATION_MASSAGE);
            }
        });

        decrementButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value1--;
                label1.setText(String.valueOf(value1));
                errorLabel.setText(value1 > -25 ? "" : VALIDATION_MASSAGE);
            }
        });

        incrementButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value2++;
                label2.setText(String.valueOf(value2));
                errorLabel.setText(value2 < 25 ? "" : VALIDATION_MASSAGE);
            }
        });

        decrementButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value2--;
                label2.setText(String.valueOf(value2));
                errorLabel.setText(value2 > -25 ? "" : VALIDATION_MASSAGE);
            }
        });

        maxValueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(value1 == value2)) {
                    maxValue = Math.max(value1, value2);
                    maxValueLabel.setText("Максимальное значение: " + maxValue);
                } else {
                    maxValueLabel.setText(value1 + " = " + value2);
                }
            }
        });


        setVisible(true);
    }

    public static void main(String[] args) {
        new CounterApp(1, 1);
    }

}
