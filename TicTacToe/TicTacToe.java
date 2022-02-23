package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPannel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1Turn; 

    TicTacToe() {

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.ITALIC, 55));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("TicTacToe Game <3 Wait 3 sec");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        titlePanel.add(textField);

        buttonPannel.setLayout(new GridLayout(3, 3));
        buttonPannel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPannel.add(buttons[i]);
            buttons[i].setFocusable(false);
            buttons[i].setFont(new Font("Verdana", Font.BOLD, 120));
            buttons[i].addActionListener(this);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.getContentPane().setBackground(new Color(50, 14, 36));
        frame.setLayout(new BorderLayout());
        frame.add(buttonPannel);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.setVisible(true);

        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1Turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.green);
                        buttons[i].setText("X");
                        player1Turn = false;
                        textField.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.blue);
                        buttons[i].setText("O");
                        player1Turn = true;
                        textField.setText("X turn");
                        check();
                    }

                }
            }
        }
    }


    public void firstTurn() {

        try {
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            Thread.sleep(3000); 

            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(true);
            }

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        if (random.nextInt() == 0) {
            player1Turn = true;
            textField.setText("X turn");
        } else {
            player1Turn = false;
            textField.setText("O turn");
        }

    }

    public void check() {

        if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
            xWins(0, 1, 2);
        }

        if ((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) {
            xWins(3, 4, 5);
        }

        if ((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")) {
            xWins(6, 7, 8);
        }

        if ((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")) {
            xWins(0, 3, 6);
        }

        if ((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")) {
            xWins(1, 4, 7);
        }

        if ((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")) {
            xWins(2, 5, 8);
        }

        if ((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")) {
            xWins(0, 4, 8);
        }

        if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
            xWins(2, 4, 6);
        }

        // **************************************************************************************

        if ((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")) {
            oWins(0, 1, 2);
        }

        if ((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")) {
            oWins(3, 4, 5);
        }

        if ((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")) {
            oWins(6, 7, 8);
        }

        if ((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O")) {
            oWins(0, 3, 6);
        }

        if ((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")) {
            oWins(1, 4, 7);
        }

        if ((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")) {
            oWins(2, 5, 8);
        }

        if ((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")) {
            oWins(0, 4, 8);
        }

        if ((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")) {
            oWins(2, 4, 6);
        }

    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.black);
        buttons[b].setBackground(Color.black);
        buttons[c].setBackground(Color.black);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("X Wins <3");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.black);
        buttons[b].setBackground(Color.black);
        buttons[c].setBackground(Color.black);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("O Wins <3");
    }

}
