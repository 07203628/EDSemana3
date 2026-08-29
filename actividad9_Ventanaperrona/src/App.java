import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame(":) HOLA");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JLabel label = new JLabel(":) HOLA", SwingConstants.CENTER);
        label.setBounds(150, 50, 100, 30);
        frame.add(label);
    }
}
