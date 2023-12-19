import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TTTButton extends JButton {

    private boolean check = true;
    private int locX, locY;
    
    public TTTButton(int x, int y, int locX, int locY){
        setSize(40,40);
        setLayout(null);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusable(false);

        this.locX = locX;
        this.locY = locY;

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

        App.mPanel.updateUI();
        // if(!App.starter){
        //     App.st[App.x][App.y].game[x][y] = App.player+1;
        // }else{
        //     App.st[x][y].game[x][y] = App.player+1;
        //     App.starter = false;
        // }
        App.st[locX][locY].game[x][y] = App.player+1;
        if(Chaker.check(App.st[App.x][App.y].game, App.player+1, x, y)){
            App.game[App.x][App.y] = App.player+1;
            App.lock[App.x][App.y].add(new Circle(App.playerColor[App.player], 140, 100, 20, 20));
        }else if(Chaker.draw(App.st[App.x][App.y].game)){
            App.game[App.x][App.y] = 3;
        }

        add(new Circle(App.playerColor[App.player], 40, 25, 6, 7));
        App.player = (App.player+1) % 2;
        this.updateUI();
        check = false;

        if(App.game[x][y] == 0){
            App.x = x;
            App.y = y;
        }

        setUp(x, y);

    }

    private void setUp(int x, int y){

        App.mPanel.removeAll();

        if(App.game[x][y] == 0){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    App.mPanel.add(App.lock[i][j]);
                }
            }
            App.mPanel.remove(App.lock[x][y]);
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
                App.mPanel.add(App.st[i][j].panel());
            }
        }
    }
}
