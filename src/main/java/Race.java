import javax.swing.*;

class Race {
    String pathUnit1Race1;
    String pathUnit2Race1;
    String pathUnit3Race1;
    String pathUnit4Race1;
    String pathUnit5Race1;

    String pathUnit1Race2;
    String pathUnit2Race2;
    String pathUnit3Race2;
    String pathUnit4Race2;
    String pathUnit5Race2;

    JLabel[] takeImagesFromLeft(){
        return new JLabel[]{
                new JLabel(new ImageIcon( pathUnit1Race1)),
                new JLabel(new ImageIcon( pathUnit2Race1)),
                new JLabel(new ImageIcon( pathUnit3Race1)),
                new JLabel(new ImageIcon( pathUnit4Race1)),
                new JLabel(new ImageIcon( pathUnit5Race1))
        };
    }

    JLabel[] takeImagesFromRight(){
        return new JLabel[]{
                new JLabel(new ImageIcon( pathUnit1Race2)),
                new JLabel(new ImageIcon( pathUnit2Race2)),
                new JLabel(new ImageIcon( pathUnit3Race2)),
                new JLabel(new ImageIcon( pathUnit4Race2)),
                new JLabel(new ImageIcon( pathUnit5Race2))
        };
    }
}
