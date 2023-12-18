import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SubTTT {
    
    private JPanel panel = new JPanel(){
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            
            g2.setColor(new Color(30, 0, 120));
            g2.fillRoundRect(48, 10, 4, 120, 4, 4);
            g2.fillRoundRect(88, 10, 4, 120, 4, 4);
            g2.fillRoundRect(10, 48, 120, 4, 4, 4);
            g2.fillRoundRect(10, 88, 120, 4, 4, 4);
        }
    };
    private JButton[][] tb = new tttButton[3][3];
    public int[][] game = new int[3][3];
    
    public JPanel panel(){

        panel.setSize(150, 150);
        panel.setLayout(null);
        panel.setOpaque(false);

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                tb[i][j] = new tttButton(i, j);
            }
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                panel.add(tb[i][j]);
            }
        }

        tb[0][0].setLocation(10, 10);
        tb[0][1].setLocation(50, 10);
        tb[0][2].setLocation(90, 10);
        tb[1][0].setLocation(10, 50);
        tb[1][1].setLocation(50, 50);
        tb[1][2].setLocation(90, 50);
        tb[2][0].setLocation(10, 90);
        tb[2][1].setLocation(50, 90);
        tb[2][2].setLocation(90, 90);

        return panel;
    }
}
