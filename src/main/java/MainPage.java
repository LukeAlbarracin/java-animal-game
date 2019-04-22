import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.color.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.google.errorprone.annotations.Var;

public class MainPage implements Runnable, ActionListener {
    private final int MAX_CHOICES = 4;
    private GridLayout gridLayout = new GridLayout(MAX_CHOICES, MAX_CHOICES);
    private JToggleButton[] buttons = new JToggleButton[4];
    private JFrame frame = new JFrame("Pokemon Game");
    private Moves[] moves;
    private int playerNumber;
    private Player player;
    private Player opponent;

    public MainPage (Moves[] moves) {
        this.moves = moves;
    }

    public ArrayList<PokeName> getPokemonParty() {
        return player.getPokemonParty();
    }

    @Override
    public void run() {
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setOpacity(1);
        
        JToggleButton startButton = new JToggleButton("Click to begin!");
        startButton.setFont(new Font("Baskerville", Font.PLAIN, 100));
        frame.add(startButton);
        
        startButton.addActionListener(event -> {
            try {
                joinGame();
                frame.remove(startButton);
                frame.revalidate();
                frame.repaint();
                initButtons();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
    }

    private synchronized void joinGame() throws InterruptedException {
        App.playersJoined++;
        playerNumber = App.playersJoined;
    }

    private void initButtons() {
        frame.setLayout(new GridLayout(4,4));
        for (int i = 0; i < MAX_CHOICES; i++) {
            try {
                buttons[i] = new JToggleButton(String.format(moves[i].getBattleText().toUpperCase()));
                buttons[i].addActionListener(this);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                buttons[i] = new JToggleButton();
            }
            buttons[i].setHorizontalTextPosition(SwingConstants.CENTER);
            buttons[i].setFont(new Font("Baskerville", Font.PLAIN, 30));
            buttons[i].setSize(100, 100);
            frame.add(buttons[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
       for (int i = 0; i < buttons.length; i++) {
           try {
                if (event.getSource() == buttons[i]) {
                    attack(i);
                }
                frame.remove(buttons[i]);
                frame.revalidate();
                frame.repaint();
            }
            catch (NullPointerException e) {
               System.err.println("Error in MainPage class: " + e.toString());
            }
        }
        frame.setLayout(new GridLayout());
    }

    private void attack(int moveNumber)  {
        player.getPokemonParty().get(0).pokemon.useMove(moveNumber,opponent.getPokemonParty().get(0).pokemon);
    }

}