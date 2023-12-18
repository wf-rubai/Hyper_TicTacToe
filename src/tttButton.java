import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class tttButton extends JButton {

    private boolean check = true;
    
    public tttButton(int x, int y){
        setSize(40,40);
        setLayout(null);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusable(false);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(check){
                    lock(x, y);
                }
            }
        });
    }

    private void lock(int x, int y){

        App.mPanel.removeAll();

        if(App.game[x][y] == 0){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    App.mPanel.add(App.lock[i][j]);
                }
            }
        }else{
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(App.game[i][j] != 0)
                        App.mPanel.add(App.lock[i][j]);
                }
            }
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                App.mPanel.add(App.st[i][j]);
            }
        }

        App.mPanel.remove(App.lock[x][y]);
        App.mPanel.updateUI();
        App.x = x;
        App.y = y;
        add(new Circle(App.playerColor[App.player], 40, 25, 6, 7));
        App.player = (App.player+1) % 2;
        this.updateUI();
        check = false;

    }
}
