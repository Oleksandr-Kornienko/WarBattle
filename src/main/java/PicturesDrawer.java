import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class PicturesDrawer {
private JPanel panel;
    PicturesDrawer(final JPanel panel) {
this.panel=panel;
    }

    JPanel getContent(){
        int y = 100;
        final String textHP = "100";
        Font font = new Font("Century Gothic", Font.BOLD, 16);
        final int[][] damageForUnits = {getRandomNumbersForUnits()};
        final JButton[] buttonsPlayer = new JButton[5];
        final JButton[] buttonsComputer = new JButton[5];
        final JLabel labels[] = new JLabel[10];
        final JLabel labelPlayerWin = createLabel("Player " + " wins!",410,500,170,20);
        final JLabel labelComputerWin = createLabel("Computer " + " wins!",410,500,170,20);
        labelPlayerWin.setVisible(false);
        labelPlayerWin.setFont(font);
        panel.add(labelPlayerWin);
        labelComputerWin.setVisible(false);
        labelComputerWin.setFont(font);
        panel.add(labelComputerWin);
        for (int i = 0; i<5;i++, y +=130){
            JLabel [] images = createImages();
            panel.add(images[i]);
            panel.add(images[i+5]);
            final JLabel damageForUnitsLeft = createLabel(String.valueOf(damageForUnits[0][i]),240, y +20,120,20);
            labels[i]= damageForUnitsLeft;
            panel.add(damageForUnitsLeft);
            final JLabel damageForUnitsRight = createLabel(String.valueOf(damageForUnits[0][i+5]),665, y +20,120,20);
            labels[i+5]= damageForUnitsRight;
            panel.add(damageForUnitsRight);
            final JButton buttonPlayer = new JButton(textHP);
            final JButton buttonComputer = new JButton(textHP);
            buttonPlayer.setBounds(200, y,120,20);
            buttonPlayer.setEnabled(false);
            buttonsPlayer[i]= buttonPlayer;
            buttonsComputer[i]= buttonComputer;
            buttonComputer.setBounds(620, y,120,20);
            buttonComputer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int damage=0;
                    int playerWin=0;
                    int computerWin=0;
                    for (int i=0;i<5;i++){
                        if (Integer.parseInt(buttonsPlayer[i].getText())<=0) {
                            damageForUnits[0][i]=0;
                        computerWin+=1;
                        }
                        damage+= damageForUnits[0][i];
                    }
                    if (computerWin==5) {
                        for (int i=0;i<5;i++){
                            buttonsComputer[i].setEnabled(false);}
                        labelComputerWin.setVisible(true);
                        return;
                        }
                    buttonComputer.setText(String.valueOf(Integer.parseInt(buttonComputer.getText())- damage));
                    damage=0;
                    int random;
                    do {random = getRandomNumber(0,5);}
                    while (Integer.parseInt(buttonsPlayer[random].getText())==0);
                    for (int i=5;i<10;i++){
                        if (Integer.parseInt(buttonsComputer[i-5].getText())<=0) {
                            damageForUnits[0][i]=0;
                            playerWin+=1;
                        }
                        damage += damageForUnits[0][i];
                    }
                    if (Integer.parseInt(buttonComputer.getText())<=0){
                        buttonComputer.setText("0");
                        buttonComputer.setEnabled(false);
                    }
                    if (playerWin==5) {
                        for (int i=0;i<5;i++){
                            buttonsComputer[i].setEnabled(false);}
                        labelPlayerWin.setVisible(true);
                        return;}
                    buttonsPlayer[random].setText(String.valueOf(Integer.parseInt(buttonPlayer.getText())- damage));
                    damageForUnits[0] = getRandomNumbersForUnits();
                    for (int i=0;i<labels.length;i++)
                        labels[i].setText(String.valueOf(damageForUnits[0][i]));

                    for (int i = 0; i< buttonsPlayer.length; i++){
                        if (Integer.parseInt(buttonsPlayer[i].getText())<=0){
                            buttonsPlayer[i].setText("0");
                        }
                    }

                }
            });

            panel.add(buttonPlayer);
            panel.add(buttonComputer);
            //створюєм заголовки
            panel.add(createLabel("dmg",255, y + 20,120,20));
            panel.add(createLabel("dmg",680, y + 20,120,20));
        }
        //створюєм заголовки
        JLabel label = createLabel("Welcome to WarBattle!",400,50,200,40);
        label.setFont(font);
        panel.add(createLabel("Player",80,0,200,40));
        panel.add(createLabel("Computer",840,0,200,40));
        panel.add(label);
        return panel;
    }
    private JLabel createLabel(final String labelText, final int x, final int y, final int width, final int height){
        final JLabel label = new JLabel();
        label.setText(labelText);
        label.setBounds(x ,y,width,height);
        return label;
    }
    private JLabel [] createImages(){
        final JLabel [] images = new JLabel[10];
        JLabel image = null;
        for (int i = 0, y=0; i<10;i++, y +=130){
            if (i<5){
                image = new Race1().takeImagesFromLeft()[i];
                image.setBounds(0, y, 200, 200);
            }
            if (i==5){
                y=0;
            }
            if (i>=5) {
                image = new Race2().takeImagesFromRight()[i-5];
                image.setBounds(760, y, 200, 200);
            }
            images[i]=image;
        }
        return images;
    }

    private int getRandomNumber(final int firstValue, final int increasingValue)
    {
        final Random random = new Random();
        return random.nextInt(increasingValue) + firstValue;
    }
    private int[] getRandomNumbersForUnits()
    {
        int randomNumbersForUnits[] = new int[10];
        for (int i=0;i<randomNumbersForUnits.length;i++){
            if (i>=5)randomNumbersForUnits[i] = getRandomNumber(5,15);
            else randomNumbersForUnits[i] = getRandomNumber(5,15);
        }
        return randomNumbersForUnits;
    }
}
