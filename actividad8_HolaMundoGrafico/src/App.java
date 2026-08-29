import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Saludos");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JLabel label = new JLabel(":) HOLA", SwingConstants.CENTER);
        label.setBounds(150, 50, 100, 30);
        JButton button = new JButton("okay");
        button.setBounds(150, 100, 100, 30);
        button.addActionListener(e -> {
            label.setText("Adiós");
        });
        frame.add(label);
        frame.add(button);
    }
}
