import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.geom.Point2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {

    private static JFrame frame = new JFrame("Tic Tac Toe");
    public static JPanel mPanel = new JPanel(){
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            
            Point2D p1 = new Point2D.Float(0, 0);
            Point2D p2 = new Point2D.Float(450, 500);
            Color c1 = new Color(102, 0, 255);
            Color c2 = new Color(166, 0, 255);
            LinearGradientPaint gradientPaint = new LinearGradientPaint(p1, p2,
                                                new float[]{0f, 0.7f},
                                                new Color[]{c1, c2});
            g2.setPaint(gradientPaint);
            g2.fillRect(0, 0, 500, 500);
            g2.setColor(new Color(30, 0, 120));
            g2.fillRoundRect(160, 20, 10, 440, 10, 10);
            g2.fillRoundRect(310, 20, 10, 440, 10, 10);
            g2.fillRoundRect(20, 160, 440, 10, 10, 10);
            g2.fillRoundRect(20, 310, 440, 10, 10, 10);
            g2.fillRect(150, 150, 30, 30);
            g2.fillRect(300, 150, 30, 30);
            g2.fillRect(150, 300, 30, 30);
            g2.fillRect(300, 300, 30, 30);
            g2.setPaint(gradientPaint);
            g2.fillRoundRect(20, 20, 140, 140, 25, 25);
            g2.fillRoundRect(170, 20, 140, 140, 25, 25);
            g2.fillRoundRect(320, 20, 140, 140, 25, 25);
            g2.fillRoundRect(20, 170, 140, 140, 25, 25);
            g2.fillRoundRect(170, 170, 140, 140, 25, 25);
            g2.fillRoundRect(170, 320, 140, 140, 25, 25);
            g2.fillRoundRect(20, 320, 140, 140, 25, 25);
            g2.fillRoundRect(320, 170, 140, 140, 25, 25);
            g2.fillRoundRect(320, 320, 140, 140, 25, 25);
        }
    };
    public static JButton massage = new JButton("PLAYER-1 WIN 🥇"){
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            
            g2.setColor(new Color(24, 21, 84, 100));
            g2.fillRoundRect(10, 10, 460, 110, 7, 7);
            g2.setColor(new Color(24, 21, 84));
            g2.setStroke(new BasicStroke(4));
            g2.drawRoundRect(10, 10, 460, 110, 7, 7);
        }
    };
    public static int x, y;
    public static boolean starter = true;
    public static JButton[][] lock = new JButton[3][3];
    public static SubTTT[][] st = new SubTTT[3][3];
    public static int[][] game = new int[3][3];
    public static int player = 0;
    public static Color[] playerColor = {new Color(152, 247, 42, 170), new Color(247, 127, 42, 170)};

    public static void main(String[] args) throws Exception {

        frame.setSize(480, 508);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.red);

        mPanel.setBounds(0, 0, 500, 500);
        mPanel.setBackground(Color.darkGray);
        mPanel.setLayout(null);

        massage.setBounds(0, 175, 480, 130);
        massage.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
        massage.setForeground(new Color( 255, 200, 255));
        massage.setLayout(null);
        massage.setOpaque(false);
        massage.setContentAreaFilled(false);
        massage.setBorderPainted(false);
        massage.setFocusable(false);
        // mPanel.add(massage);

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                st[i][j] = new SubTTT(i, j);
            }
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                mPanel.add(st[i][j].panel());
            }
        }

        st[0][0].panel().setLocation(20, 20);
        st[0][1].panel().setLocation(170, 20);
        st[0][2].panel().setLocation(320, 20);
        st[1][0].panel().setLocation(20, 170);
        st[1][1].panel().setLocation(170, 170);
        st[1][2].panel().setLocation(320, 170);
        st[2][0].panel().setLocation(20, 320);
        st[2][1].panel().setLocation(170, 320);
        st[2][2].panel().setLocation(320, 320);

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                lock[i][j] = new LockButton();
            }
        }

        lock[0][0].setLocation(20, 20);
        lock[0][1].setLocation(170, 20);
        lock[0][2].setLocation(320, 20);
        lock[1][0].setLocation(20, 170);
        lock[1][1].setLocation(170, 170);
        lock[1][2].setLocation(320, 170);
        lock[2][0].setLocation(20, 320);
        lock[2][1].setLocation(170, 320);
        lock[2][2].setLocation(320, 320);

        frame.add(mPanel);

        frame.setVisible(true);
    }
}
