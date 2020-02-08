package io.github.dyslexicalphabet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class EnigmaDerpGUI {
    private static GraphicsConfiguration gc;


    public static void main(String[] args) {
        new EnigmaDerpGUI();
    }
    public EnigmaDerpGUI() {

        /***********************************************************************************************************
         * Setup
         ***********************************************************************************************************/
        JFrame eDGUI = new JFrame(gc);
        eDGUI.setTitle("EnigmaDerp");
        eDGUI.setSize(new Dimension(900, 600));
        eDGUI.setResizable(false);
        eDGUI.setLocationRelativeTo(null);
        eDGUI.setVisible(true);
        eDGUI.setLayout(null);
        eDGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /***********************************************************************************************************
         * Components
         ***********************************************************************************************************/
        //MENU
        JLabel eDText = new JLabel("EnigmaDerp");
        eDText.setBounds(324, 230, 300, 200);
        eDText.setFont(new Font("Serif", Font.PLAIN, 50));
        JLabel eDText2 = new JLabel("Made by a derp");
        eDText2.setBounds(419, 340, 100, 50);
        eDText2.setFont(new Font("Serif", Font.PLAIN, 10));
        JButton encryptButton = new JButton("Encrypt");
        encryptButton.setBounds(380, 400, 140, 40);
        JButton decryptButton = new JButton("Decrypt");
        decryptButton.setBounds(380, 450, 140, 40);
        JLabel derpFace = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("DerpFace.jpeg")));
        derpFace.setBounds(300, 0, 300, 300);
        // -> MENU
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(680, 450, 140, 40);
        //ENCRYPT
        JLabel encryptText1 = new JLabel("Please type in the message you would like to encrypt.");
        encryptText1.setBounds(260, 0, 1000, 200);
        JLabel encryptText2 = new JLabel("The message should contain only capital letters of the english alphabet and spaces.");
        encryptText2.setBounds(260, 12, 1000, 200);
        JLabel encryptText3 = new JLabel("Unidentified characters translate to a '?'.");
        encryptText3.setBounds(260, 24, 1000, 200);
        JTextField messageForEncryption = new JTextField();
        messageForEncryption.setBounds(0, 200, 890, 50);
        messageForEncryption.setFont(new Font("Serif", Font.PLAIN, 20));
        //ENCRYPT RESULT
        JLabel encryptText4 = new JLabel("Your encrypted text is as follows:");
        encryptText4.setBounds(355, -150, 900, 600);
        JLabel encryptText5 = new JLabel("Make sure every letter is copied! The decryption process will fail even with just one missed letter!");
        encryptText5.setBounds(170, -130, 900, 600);
        JTextField encryptedMessage = new JTextField();
        encryptedMessage.setBounds(0, 200, 890, 50);
        //DECRYPT
        JLabel decryptText1 = new JLabel("Please type in the message you would like to decrypt.");
        decryptText1.setBounds(260, 0, 1000, 200);
        JLabel decryptText2 = new JLabel("The message should contain only capital letters of the english alphabet and spaces.");
        decryptText2.setBounds(260, 12, 1000, 200);
        JLabel decryptText3 = new JLabel("Unidentified characters translate to a '?'.");
        decryptText3.setBounds(260, 24, 1000, 200);
        JTextField messageForDecryption = new JTextField();
        messageForDecryption.setBounds(0, 200, 890, 50);
        messageForDecryption.setFont(new Font("Serif", Font.PLAIN, 20));
        //DECRYPT RESULT
        JLabel decryptText4 = new JLabel("Your message is the following:");
        decryptText4.setBounds(355, -150, 900, 600);
        JTextField decryptedMessage = new JTextField();
        decryptedMessage.setBounds(0, 200, 890, 50);
        /***********************************************************************************************************
         * Assemble
         ***********************************************************************************************************/
        //MENU
        eDGUI.add(encryptButton);
        eDGUI.add(decryptButton);
        eDGUI.add(eDText);
        eDGUI.add(eDText2);
        eDGUI.add(encryptText1);
        eDGUI.add(derpFace);
        //ENCRYPT
        encryptText1.setVisible(false);
        eDGUI.add(encryptText2);
        encryptText2.setVisible(false);
        eDGUI.add(encryptText3);
        encryptText3.setVisible(false);
        eDGUI.add(returnButton);
        returnButton.setVisible(false);
        eDGUI.add(messageForEncryption);
        messageForEncryption.setVisible(false);
        //ENCRYPT RESULT
        eDGUI.add(encryptedMessage);
        encryptedMessage.setVisible(false);
        eDGUI.add(encryptText4);
        encryptText4.setVisible(false);
        eDGUI.add(encryptText5);
        encryptText5.setVisible(false);
        //DECRYPT
        eDGUI.add(decryptText1);
        decryptText1.setVisible(false);
        eDGUI.add(decryptText2);
        decryptText2.setVisible(false);
        eDGUI.add(decryptText3);
        decryptText3.setVisible(false);
        eDGUI.add(messageForDecryption);
        messageForDecryption.setVisible(false);
        //DECRYPT RESULT
        eDGUI.add(decryptText4);
        decryptText4.setVisible(false);
        eDGUI.add(decryptedMessage);
        decryptedMessage.setVisible(false);
        /***********************************************************************************************************
         *Action Listeners
         ***********************************************************************************************************/
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!returnButton.isVisible()) {
                    //MENU -> ENCRYPT
                    encryptButton.setBounds(380, 280, 140, 40);
                    decryptButton.setVisible(false);
                    eDText.setBounds(260, -50, 300, 200);
                    eDText2.setBounds(525, -52, 300, 200);
                    returnButton.setVisible(true);
                    messageForEncryption.setVisible(true);
                    encryptText1.setVisible(true);
                    encryptText2.setVisible(true);
                    encryptText3.setVisible(true);
                    derpFace.setVisible(false);

                } else if (!(decryptButton.isVisible())) {
                    //ENCRYPT -> ENCRYPT RESULT
                    Scanner scanner = new Scanner(messageForEncryption.getText());
                    Character[] array = new Character[]{' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
                    List<Character> alphabet = Arrays.asList(array);
                    try {
                        String input = scanner.nextLine();
                        List<Character> l = new ArrayList<>();
                        int i;
                        for (i = 0; i < input.length(); i++) {
                            Object cOld = input.charAt(i);
                            if (alphabet.contains(cOld)) {
                                char cNew = alphabet.get((alphabet.indexOf(cOld) + i) % 27);
                                l.add(cNew);
                            } else {
                                l.add('?');
                            }
                        }
                        String s = l.toString();
                        int m;
                        for (m = 0; m < s.length(); m++) {
                            if ((m % 3 == 1) && s.charAt(m) == ' ') {
                                char c = '-';
                                s = s.substring(0, m) + c + s.substring(m + 1);
                            }
                        }
                        String s1 = s.replace("[", "");
                        String s2 = s1.replace("]", "");
                        String s3 = s2.replace(",", "");
                        String s4 = s3.replace(" ", "");
                        String output = s4.replace("-", " ");
                        encryptedMessage.setText(output);
                        encryptedMessage.setFont(new Font("Serif", Font.PLAIN, 20));
                        encryptedMessage.setVisible(true);
                        encryptText1.setVisible(false);
                        encryptText2.setVisible(false);
                        encryptText3.setVisible(false);
                        encryptText4.setVisible(true);
                        encryptText5.setVisible(true);
                        messageForEncryption.setVisible(false);
                        encryptButton.setVisible(false);

                    } catch (NoSuchElementException e) {
                        return;
                    }
                }
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!returnButton.isVisible()) {
                    //MENU -> DECRYPT
                    decryptButton.setBounds(380, 280, 140, 40);
                    encryptButton.setVisible(false);
                    eDText.setBounds(260, -50, 300, 200);
                    eDText2.setBounds(525, -52, 300, 200);
                    returnButton.setVisible(true);
                    messageForDecryption.setVisible(true);
                    decryptText1.setVisible(true);
                    decryptText2.setVisible(true);
                    decryptText3.setVisible(true);
                    derpFace.setVisible(false);
                }
                else if (!(encryptButton.isVisible())) {
                    //DECRYPT -> DECRYPT RESULT

                    Scanner scanner = new Scanner(messageForDecryption.getText());
                    Character[] array2 = new Character[]{' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
                    List<Character> alphabet2 = Arrays.asList(array2);
                    try {
                        String input2 = scanner.nextLine();
                        ArrayList<Character> l = new ArrayList<>();
                        int i2;
                        for (i2 = 0; i2 < input2.length(); i2++) {
                            Object cOld = input2.charAt(i2);
                            if (alphabet2.contains(cOld)) {
                                int cNewIndex = alphabet2.indexOf(cOld) - i2;
                                while (cNewIndex < 0) {
                                    cNewIndex = 27 + cNewIndex;
                                }
                                char cNew = alphabet2.get(cNewIndex);
                                l.add(cNew);
                            } else {
                                l.add('?');
                            }
                            String s1 = l.toString().replace("[", "");
                            String s2 = s1.replace("]", "");
                            String s3 = s2.replace(",", "");
                            int m;
                            for (m = 0; m < s3.length(); m++) {
                                if (m % 2 == 0 && s3.charAt(m) == ' ') {
                                    char c = '-';
                                    s3 = s3.substring(0, m) + c + s3.substring(m + 1);
                                }
                            }
                            String s4 = s3.replace(" ","");
                            String output = s4.replace("-", " ");
                            decryptedMessage.setText(output);
                            decryptedMessage.setFont(new Font("Serif", Font.PLAIN, 20));
                            decryptedMessage.setVisible(true);
                            decryptText1.setVisible(false);
                            decryptText2.setVisible(false);
                            decryptText3.setVisible(false);
                            decryptText4.setVisible(true);
                            messageForDecryption.setVisible(false);
                            decryptButton.setVisible(false);

                        }
                    } catch (NoSuchElementException e) {
                        return;
                    }
                }
            }

        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (messageForEncryption.isVisible()) {
                    //ENCRYPT -> MENU
                    eDText.setBounds(324, 230, 300, 200);
                    eDText2.setBounds(419, 340, 100, 50);
                    encryptButton.setBounds(380, 400, 140, 40);
                    decryptButton.setVisible(true);
                    encryptText1.setVisible(false);
                    encryptText2.setVisible(false);
                    encryptText3.setVisible(false);
                    messageForEncryption.setVisible(false);
                    returnButton.setVisible(false);
                    derpFace.setVisible(true);
                    messageForEncryption.setText("");
                } else if (messageForDecryption.isVisible()) {
                    //DECRYPT -> MENU
                    eDText.setBounds(324, 230, 300, 200);
                    eDText2.setBounds(419, 340, 100, 50);
                    decryptButton.setBounds(380, 450, 140, 40);
                    encryptButton.setVisible(true);
                    decryptText1.setVisible(false);
                    decryptText2.setVisible(false);
                    decryptText3.setVisible(false);
                    messageForDecryption.setVisible(false);
                    returnButton.setVisible(false);
                    derpFace.setVisible(true);
                    messageForDecryption.setText("");
                } else if (encryptedMessage.isVisible()) {
                    //ENCRYPT RESULT -> MENU
                    eDText.setBounds(324, 230, 300, 200);
                    eDText2.setBounds(419, 340, 100, 50);
                    encryptButton.setBounds(380, 400, 140, 40);
                    decryptButton.setVisible(true);
                    returnButton.setVisible(false);
                    encryptButton.setVisible(true);
                    encryptText4.setVisible(false);
                    encryptText5.setVisible(false);
                    encryptedMessage.setVisible(false);
                    derpFace.setVisible(true);
                    messageForEncryption.setText("");
                    encryptedMessage.setText("");
                }
                    else if (decryptedMessage.isVisible()) {
                        //DECRYPT RESULT -> MENU
                    eDText.setBounds(324, 230, 300, 200);
                    eDText2.setBounds(419, 340, 100, 50);
                    decryptButton.setBounds(380, 450, 140, 40);
                    encryptButton.setVisible(true);
                    returnButton.setVisible(false);
                    decryptButton.setVisible(true);
                    decryptText4.setVisible(false);
                    decryptedMessage.setVisible(false);
                    derpFace.setVisible(true);
                    messageForDecryption.setText("");
                    decryptedMessage.setText("");
                    }

                }
        });

    }
}
