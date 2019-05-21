/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Prem Bhanderi
 */
public class GUIControllerFour implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private ImageView imgB0, imgB1, imgB2, imgB3, imgB4, imgB5,
                      imgR0, imgR1, imgR2, imgR3, imgR4, imgR5,
                      imgT0, imgT1, imgT2, imgT3, imgT4, imgT5,
                      imgL0, imgL1, imgL2, imgL3, imgL4, imgL5;
    
    @FXML
    private Label lblB0, lblB1, lblB2, lblB3, lblB4, lblB5,
                  lblR0, lblR1, lblR2, lblR3, lblR4, lblR5,
                  lblT0, lblT1, lblT2, lblT3, lblT4, lblT5,
                  lblL0, lblL1, lblL2, lblL3, lblL4, lblL5;
    
    @FXML
    private Label lblBM, lblRM, lblTM, lblLM, lblM, lblName1, lblName2, lblName3, lblName4;
    
    @FXML
    private Button btnStart, btnSubmit;
    
    @FXML
    private TextField txtBox1;
    
    private int side, hole, currentPlayer, sub;
    private boolean mancalaPassed, randomMarbles;
    
    int[][] marbles = new int[4][6];
    int[] mancala = new int[4];
    List<Players> player = new ArrayList<>();
    
    @FXML
    private void handleButtonFourPlayer(ActionEvent event){
        for(int i = 0; i < marbles[0].length; i++){
            marbles[0][i] = 4;
            marbles[1][i] = 4;
            marbles[2][i] = 4;
            marbles[3][i] = 4;
        }
        currentPlayer = 0 + (int)(Math.random() * ((3 - 0) + 1));
        lblM.setText(player.get(currentPlayer).getName() + "'s Turn!");
        setLabels();
    }
    
    @FXML
    private void handleButtonSubmit(MouseEvent event){
        sub++;
        player.add(new Players(txtBox1.getText()));
        if(sub <= 4){
            lblM.setText("Player " + sub + " name?");
            txtBox1.setText("");
        }
        else{
            btnStart.setVisible(true);
            txtBox1.setVisible(false);
            btnSubmit.setVisible(false);
        }
    }
    
    public GUIControllerFour(){
        sub = 1;
    }
    
    private void setLabels(){
        lblB0.setText(Integer.toString(marbles[0][0]));//P1: 
        lblB1.setText(Integer.toString(marbles[0][1]));
        lblB2.setText(Integer.toString(marbles[0][2]));
        lblB3.setText(Integer.toString(marbles[0][3]));
        lblB4.setText(Integer.toString(marbles[0][4]));
        lblB5.setText(Integer.toString(marbles[0][5]));
        
        lblR0.setText(Integer.toString(marbles[1][0]));//P2: 
        lblR1.setText(Integer.toString(marbles[1][1]));
        lblR2.setText(Integer.toString(marbles[1][2]));
        lblR3.setText(Integer.toString(marbles[1][3]));
        lblR4.setText(Integer.toString(marbles[1][4]));
        lblR5.setText(Integer.toString(marbles[1][5]));
        
        lblT0.setText(Integer.toString(marbles[2][0]));//P3: 
        lblT1.setText(Integer.toString(marbles[2][1]));
        lblT2.setText(Integer.toString(marbles[2][2]));
        lblT3.setText(Integer.toString(marbles[2][3]));
        lblT4.setText(Integer.toString(marbles[2][4]));
        lblT5.setText(Integer.toString(marbles[2][5]));
        
        lblL0.setText(Integer.toString(marbles[3][0]));//P4: 
        lblL1.setText(Integer.toString(marbles[3][1]));
        lblL2.setText(Integer.toString(marbles[3][2]));
        lblL3.setText(Integer.toString(marbles[3][3]));
        lblL4.setText(Integer.toString(marbles[3][4]));
        lblL5.setText(Integer.toString(marbles[3][5]));
        
        lblBM.setText(Integer.toString(mancala[0]));
        lblRM.setText(Integer.toString(mancala[1]));
        lblTM.setText(Integer.toString(mancala[2]));
        lblLM.setText(Integer.toString(mancala[3]));
        
        lblName1.setText(player.get(0).getName());
        lblName2.setText(player.get(1).getName());
        lblName3.setText(player.get(2).getName());
        lblName4.setText(player.get(3).getName());
        
        imgB0.setImage(new Image("resources/" + marbles[0][0] + ".png"));
        imgB1.setImage(new Image("resources/" + marbles[0][1] + ".png"));
        imgB2.setImage(new Image("resources/" + marbles[0][2] + ".png"));
        imgB3.setImage(new Image("resources/" + marbles[0][3] + ".png"));
        imgB4.setImage(new Image("resources/" + marbles[0][4] + ".png"));
        imgB5.setImage(new Image("resources/" + marbles[0][5] + ".png"));
        
        imgR0.setImage(new Image("resources/" + marbles[1][0] + ".png"));
        imgR1.setImage(new Image("resources/" + marbles[1][1] + ".png"));
        imgR2.setImage(new Image("resources/" + marbles[1][2] + ".png"));
        imgR3.setImage(new Image("resources/" + marbles[1][3] + ".png"));
        imgR4.setImage(new Image("resources/" + marbles[1][4] + ".png"));
        imgR5.setImage(new Image("resources/" + marbles[1][5] + ".png"));
        
        imgT0.setImage(new Image("resources/" + marbles[2][0] + ".png"));
        imgT1.setImage(new Image("resources/" + marbles[2][1] + ".png"));
        imgT2.setImage(new Image("resources/" + marbles[2][2] + ".png"));
        imgT3.setImage(new Image("resources/" + marbles[2][3] + ".png"));
        imgT4.setImage(new Image("resources/" + marbles[2][4] + ".png"));
        imgT5.setImage(new Image("resources/" + marbles[2][5] + ".png"));
        
        imgL0.setImage(new Image("resources/" + marbles[3][0] + ".png"));
        imgL1.setImage(new Image("resources/" + marbles[3][1] + ".png"));
        imgL2.setImage(new Image("resources/" + marbles[3][2] + ".png"));
        imgL3.setImage(new Image("resources/" + marbles[3][3] + ".png"));
        imgL4.setImage(new Image("resources/" + marbles[3][4] + ".png"));
        imgL5.setImage(new Image("resources/" + marbles[3][5] + ".png"));
    }
    
    private void weave(){//NORMAL GAMEMODE
        if(side == getPlayer()){
            if(hole == 6)
                hole = 5;
            
            int weaving = marbles[side][hole];
            marbles[side][hole] = 0;
            
            while(weaving > 0){
                hole = nextHole(hole);
                
                if(hole == 6 && side == getPlayer()){//Only your mancala will be added to if you weave into it
                    side = nextSide(side);
                    mancala[getPlayer()]++;
                    weaving--;
                    hole = 0;
                    
                    if(weaving == 0){
                        mancalaPassed = true;
                    }
                }
                else if(hole == 6){
                    side = nextSide(side);
                    hole = 0;
                }
                if(weaving == 0){
                    break;
                }
                
                marbles[side][hole]++;
                weaving--;
            }
            
            currentPlayer = nextPlayer(currentPlayer);
            
            if(hole == 0 && mancalaPassed == true){
                System.out.println("FREE TURN");
                //lblMessageBox.setText("FREE TURN");
                currentPlayer = nextPlayer(currentPlayer);
                currentPlayer = nextPlayer(currentPlayer);
                currentPlayer = nextPlayer(currentPlayer);
                mancalaPassed = false;
            }
            checkSkipTurn();
            
        }
        checkWin();
    }
    
    @FXML
    private void handleWeaveB(MouseEvent event){//Use 4 different handles
        Node source = (Node)event.getSource() ;
        Integer col = GridPane.getColumnIndex(source);
        Integer row = GridPane.getRowIndex(source);
        
        if(col == null)
            col = 0;
        if(row == null)
            row = 0;
        
        hole = col;
        side = 0;
        
        weave();
        setLabels();
    }
    
    @FXML
    private void handleWeaveR(MouseEvent event){
        Node source = (Node)event.getSource() ;
        Integer col = GridPane.getColumnIndex(source);
        Integer row = GridPane.getRowIndex(source);
        
        if(col == null)
            col = 0;
        if(row == null)
            row = 0;
        
        if(row == 5){
            row = 0;
        }
        else if(row == 4){
            row = 1;
        }
        else if(row == 3){
            row = 2;
        }
        else if(row == 2){
            row = 3;
        }
        else if(row == 1){
            row = 4;
        }
        else if(row == 0){
            row = 5;
        }
        
        hole = row;
        side = 1;
        
        weave();
        setLabels();
    }
    
    @FXML
    private void handleWeaveT(MouseEvent event){
        Node source = (Node)event.getSource() ;
        Integer col = GridPane.getColumnIndex(source);
        Integer row = GridPane.getRowIndex(source);
        
        if(col == null)
            col = 0;
        if(row == null)
            row = 0;
        
        if(col == 5){
            col = 0;
        }
        else if(col == 4){
            col = 1;
        }
        else if(col == 3){
            col = 2;
        }
        else if(col == 2){
            col = 3;
        }
        else if(col == 1){
            col = 4;
        }
        else if(col == 0){
            col = 5;
        }
        
        hole = col;
        side = 2;
        
        weave();
        setLabels();
    }
    
    @FXML
    private void handleWeaveL(MouseEvent event){
        Node source = (Node)event.getSource() ;
        Integer col = GridPane.getColumnIndex(source);
        Integer row = GridPane.getRowIndex(source);
        
        if(col == null)
            col = 0;
        if(row == null)
            row = 0;
        
        hole = row;
        side = 3;
        
        weave();
        setLabels();
    }
    
    private int nextSide(int sideI){
        sideI++;
        if(sideI >= 4){
            sideI = 0;
        }
        return sideI;
    }
    
    private int nextHole(int holeI){
        holeI++;
        return holeI;
    }
    
    private int nextPlayer(int input){//Ends turn by changing the player. 
        input++;                      //Also used for getting free turns
        if(input >= 4){
            input = 0;
        }
        return input;
    }
    
    private int getPlayer(){//returns current player turn
        return currentPlayer;
    }
    
    private void checkSkipTurn(){
        int b = 0, r = 0, t = 0, l = 0;
        
        for(int i = 0; i < marbles[0].length; i++){
            b += marbles[0][i];
            r += marbles[1][i];
            t += marbles[2][i];
            l += marbles[3][i];
        }
        
        if((b == 0 && currentPlayer == 0) || (r == 0 && currentPlayer == 1) || (t == 0 && currentPlayer == 2) || (l == 0 && currentPlayer == 3)){
            currentPlayer = nextPlayer(currentPlayer);
        }
    }
    
    private void checkWin(){
        if(mancala[0] + mancala[1] + mancala[2] + mancala[3] >= 96){
            if(mancala[0] > mancala [1] || mancala[0] > mancala[2] || mancala[0] > mancala [3]){
                txtBox1.setText(player.get(0).getName() + " WINS!!");
            }
            else if(mancala[1] > mancala [0] || mancala[1] > mancala[2] || mancala[1] > mancala [3]){
                txtBox1.setText(player.get(1).getName() + " WINS!!");
            }
            else if(mancala[2] > mancala [0] || mancala[2] > mancala[1] || mancala[2] > mancala [3]){
                txtBox1.setText(player.get(2).getName() + " WINS!!");
            }
            else if(mancala[3] > mancala [0] || mancala[3] > mancala[1] || mancala[3] > mancala [2]){
                txtBox1.setText(player.get(3).getName() + " WINS!!");
            }
        }
    }
        
        
}
    
    

