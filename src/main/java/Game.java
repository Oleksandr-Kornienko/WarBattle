import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Game  {
    Game(){
        String[] args = new String[0];
        main(args);
    }
    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        frame.setSize(1024, 768);
        //встановлюєм вихід на кнопку Esc
        frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "EXIT");
        frame.getRootPane().getActionMap().put("EXIT", new AbstractAction(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
            }
        }); //можна було використати System.exit()

        final JPanel panel = new JPanel();
        JButton button = new JButton("Restart");
        button.setBounds(400,700,120,20);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Game();
            }});
        panel.add(button);
        // кажем контейнеру що не будем використовувати layout manager (для можливості змінити розмір вікна)
        panel.setLayout(null);
        frame.add(new PicturesDrawer(panel).getContent());
        frame.setUndecorated(true); //забираєм рамки і лишні кнопки
        frame.setVisible(true); //робим видимим
    }
}
