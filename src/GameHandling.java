import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GameGUIHandling extends JFrame {
    GameGUI gameGUI;
    WordsLogic wordsLogic = new WordsLogic();


    public GameGUIHandling(GameGUI gameGUI) {
        this.gameGUI = gameGUI;
    }

    public void addButtonsArray() {
        wordsLogic.randomWord();
        wordsLogic.wordInCharArray();
        JPanel panel = new JPanel(new GridLayout(1, wordsLogic.wordInCharArray().length));
        JButton[] button = new JButton[wordsLogic.wordInCharArray().length];
        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton("" + wordsLogic.wordInCharArray()[i]);
            textSetFontsAndSize(button[i]);
            panel.add(button[i]);
        }
        gameGUI.add(panel, BorderLayout.SOUTH);
    }

    public void textSetFontsAndSize(JComponent component) {
        component.setFont(new Font("TimesRoman", Font.BOLD, 20));
    }

    public void textFieldHandler() {
        gameGUI.textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    gameGUI.textField.setText("");
                }
            }
        });
    }

}
