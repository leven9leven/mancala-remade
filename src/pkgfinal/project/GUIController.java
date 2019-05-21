package pkgfinal.project;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Prem Bhanderi
 */
public class GUIController implements Initializable {
    
    @FXML
    private Label lblH0, lblH1, lblH2, lblH3, lblH4, lblH5,
                  lblP0, lblP1, lblP2, lblP3, lblP4, lblP5,
                  lblM1, lblM2;
    
    @FXML
    private Label lblMessageBox, lblMessageBox2, lblGamemode, lblName1, lblName2;
    
    @FXML
    private ImageView imgH0, imgH1, imgH2, imgH3, imgH4, imgH5,
                      imgP0, imgP1, imgP2, imgP3, imgP4, imgP5, imgMancala1, imgMancala2;
    
    @FXML 
    private RadioButton standard, capture, avalanche, fourplayer, btnNormal, btnRandom;
    
    @FXML
    private TextField txtBox1;
    
    @FXML
    private Button btnSubmit, btnStart;
    
    private int side, hole, currentPlayer, playerWon, gameMode, sub, calc, max;
    public static final int BOARD_LENGTH = 6, TOTAL_PLAYERS = 2;
    private boolean mancalaPassed, toggleReset, randomMarbles;
    
    GridPane board = new GridPane();
    int[][] marbles = new int[2][6];
    int[] mancala = new int[2];
    List<ImageView> holesI = new ArrayList<>();
    List<Players> player = new ArrayList<>();
    
    
    
    public GUIController(){
        for(int i = 0; i < marbles[0].length;i++){
            marbles[0][i] = 4;
            marbles[1][i] = 4;
        }
        mancala[0] = 0;
        mancala[1] = 0;
        currentPlayer = 0 + (int)(Math.random() * ((1 - 0) + 1));
        toggleReset = false;
        mancalaPassed = false;
        System.out.println(currentPlayer);
    }
    
    @FXML
    private void handleButtonStart(ActionEvent event) throws IOException {
        
        if(gameMode == 3){
            Parent stuff = FXMLLoader.load(getClass().getResource("FXMLDocumentFourPlayer.fxml"));
            Scene newScene = new Scene(stuff);
            Stage newStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            newStage.setScene(newScene);
            newStage.show();
        }
        
        if(toggleReset){
            System.out.println("Resetting");
            btnStart.setText("Start");
            for(int i = 0; i < marbles[0].length;i++){
                marbles[0][i] = 0;
                marbles[1][i] = 0;
            }
            mancala[0] = 0;
            mancala[1] = 0;
            
            currentPlayer = 0 + (int)(Math.random() * ((1 - 0) + 1));
            toggleReset = false;
            
        }
        else if(!toggleReset){
            System.out.println("Initializing");
            holesI.add(imgH0);
            holesI.add(imgH1);
            holesI.add(imgH2);
            holesI.add(imgH3);
            holesI.add(imgH4);
            holesI.add(imgH5);
        
            holesI.add(imgP5);
            holesI.add(imgP4);
            holesI.add(imgP3);
            holesI.add(imgP2);
            holesI.add(imgP1);
            holesI.add(imgP0);
        
            lblMessageBox.setText("STARTING PLAYER: " + player.get(currentPlayer).getName());
            System.out.println(currentPlayer);
            btnStart.setText("Reset");
            toggleReset = true;
            
            if(!randomMarbles){
                for(int i = 0; i < marbles[0].length;i++){
                    marbles[0][i] = 4;
                    marbles[1][i] = 4;
                }
            }
            else if(randomMarbles){
                for(int i = 0; i < marbles[0].length;i++){
                    marbles[0][i] = 1 + (int)(Math.random() * (4) + 1);
                    marbles[1][i] = 1 + (int)(Math.random() * (4) + 1);
                }
                for(int i = 0; i < BOARD_LENGTH; i++){
                    calc += marbles[0][i];
                    calc += marbles[1][i];
                }
            
                max = calc/2;
            }
            
            mancala[0] = 0;
            mancala[1] = 0;
            mancalaPassed = false;
        }
        
        setLabels();
    }
    
    @FXML
    private void handleButtonSubmit(ActionEvent event){
        sub++;
        player.add(new Players(txtBox1.getText()));//1
        txtBox1.setText("");
        if(sub == 1){
            lblMessageBox2.setText("Player 2 Name?");
        }
        if(sub == 2){
            lblMessageBox2.setText("Marble mode?");
            btnSubmit.setVisible(false);
            txtBox1.setVisible(false);
            btnNormal.setVisible(true);
            btnRandom.setVisible(true);
        }
    }
    
    private void setLabels(){
        lblH0.setText(Integer.toString(marbles[1][0]));//P1: 
        lblH1.setText(Integer.toString(marbles[1][1]));
        lblH2.setText(Integer.toString(marbles[1][2]));
        lblH3.setText(Integer.toString(marbles[1][3]));
        lblH4.setText(Integer.toString(marbles[1][4]));
        lblH5.setText(Integer.toString(marbles[1][5]));
        
        lblP0.setText(Integer.toString(marbles[0][0]));//P2: 
        lblP1.setText(Integer.toString(marbles[0][1]));
        lblP2.setText(Integer.toString(marbles[0][2]));
        lblP3.setText(Integer.toString(marbles[0][3]));
        lblP4.setText(Integer.toString(marbles[0][4]));
        lblP5.setText(Integer.toString(marbles[0][5]));
        
        lblName1.setText(player.get(1).getName());
        lblName2.setText(player.get(0).getName());
        
        lblM1.setText(Integer.toString(mancala[1]));
        lblM2.setText(Integer.toString(mancala[0]));
        
        imgMancala1.setImage(new Image("resources/" + mancala[1] + ".png"));
        imgMancala2.setImage(new Image("resources/" + mancala[0] + ".png"));
        
        imgH0.setImage(new Image("resources/" + marbles[1][0] + ".png"));
        imgH1.setImage(new Image("resources/" + marbles[1][1] + ".png"));
        imgH2.setImage(new Image("resources/" + marbles[1][2] + ".png"));
        imgH3.setImage(new Image("resources/" + marbles[1][3] + ".png"));
        imgH4.setImage(new Image("resources/" + marbles[1][4] + ".png"));
        imgH5.setImage(new Image("resources/" + marbles[1][5] + ".png"));
        
        imgP0.setImage(new Image("resources/" + marbles[0][0] + ".png"));
        imgP1.setImage(new Image("resources/" + marbles[0][1] + ".png"));
        imgP2.setImage(new Image("resources/" + marbles[0][2] + ".png"));
        imgP3.setImage(new Image("resources/" + marbles[0][3] + ".png"));
        imgP4.setImage(new Image("resources/" + marbles[0][4] + ".png"));
        imgP5.setImage(new Image("resources/" + marbles[0][5] + ".png"));
    }
    
    @FXML
    private void handleButtonGM(ActionEvent event) throws IOException{
        if(standard.isSelected()){
            gameMode = 0;
        }
        else if(capture.isSelected()){
            gameMode = 1;
        }
        else if(avalanche.isSelected()){
            gameMode = 2;
        }
        else if(fourplayer.isSelected()){
            gameMode = 3;
        }
        
        standard.setVisible(false);
        capture.setVisible(false);
        avalanche.setVisible(false);
        fourplayer.setVisible(false);
        btnSubmit.setVisible(true);
        txtBox1.setVisible(true);
        lblMessageBox2.setText("Player 1 Name?");
        
        if(gameMode == 0){
            lblGamemode.setText("Gamemode: Standard");
        }
        else if(gameMode == 1){
            lblGamemode.setText("Gamemode: Capture");
        }
        else if(gameMode == 2){
            lblGamemode.setText("Gamemode: Avalanche");
        }
        else if(gameMode == 3){
            lblGamemode.setText("Gamemode: 4 Player");
            Parent stuff = FXMLLoader.load(getClass().getResource("FXMLDocumentFourPlayer.fxml"));
            Scene newScene = new Scene(stuff);
            Stage newStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            newStage.setScene(newScene);
            newStage.show();
        }
    }
    
    @FXML
    private void handleButtonR(ActionEvent event){
        if(btnNormal.isSelected()){
            randomMarbles = false;
        }
        else if(btnRandom.isSelected()){
            randomMarbles = true;
        }
        
        btnNormal.setVisible(false);
        btnRandom.setVisible(false);
        lblMessageBox2.setVisible(false);
        btnStart.setVisible(true);
    }
    
    @FXML
    private void handleWeave(MouseEvent event){
        
        Node source = (Node)event.getSource() ;
        Integer col = GridPane.getColumnIndex(source);
        Integer row = GridPane.getRowIndex(source);
        
        if(col == null)
            col = 0;
        if(row == null)
            row = 0;
        
        if(row == 0 && col == 5)//Grid panes work with Row and Col but go horizontally. This just fixes that issue
           col = 0;
        else if(row == 0 && col == 4)
            col = 1;
        else if(row == 0 && col == 3)
            col = 2;
        else if(row == 0 && col == 2)
            col = 3;
        else if(row == 0 && col == 1)
            col = 4;
        else if(row == 0 && col == 0)
            col = 5;
        
        hole = col;
        side = row;
        
        System.out.println("CURRENT PLAYER: " + currentPlayer);
        System.out.println("SIDE: " + side);
        
        if((marbles[side][hole] != 0) && (side == getPlayer())){
            switch (gameMode) {
            case 0:
                weave0();
                break;
            case 1:
                weave1();
                break;
            case 2:
                weave2();
                break;
            default:
                break;
            }   
        }
        else if(marbles[side][hole] == 0){
            lblMessageBox.setText("PICK A VALID HOLE");
        }
        else if(side != getPlayer()){
            lblMessageBox.setText("NOT CURRENT PLAYER");
        }
        setLabels();
    }
    
    private void weave0(){//NORMAL GAMEMODE
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
                lblMessageBox.setText("FREE TURN");
                currentPlayer = nextPlayer(currentPlayer);
                mancalaPassed = false;
            }
        
        checkOver();
    }
    
    private void weave1(){//CAPTURE GAMEMODE
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
            
            if(checkEmpty()){
                if(!mancalaPassed){
                    int test = 5 - hole;
                    if(marbles[(nextSide(side))][test] > 0){
                        int add = marbles[nextSide(side)][test];
                        marbles[nextSide(side)][test] = 0;
                        mancala[side] += add;
                    
                        add = marbles[side][hole];
                        marbles[side][hole] = 0;
                        mancala[side] += add;
                        lblMessageBox.setText("CAPTURED");
                    }
                }
            }
            
            currentPlayer = nextPlayer(currentPlayer);
            
            if(hole == 0 && mancalaPassed == true){
                lblMessageBox.setText("FREE TURN");
                currentPlayer = nextPlayer(currentPlayer);
                mancalaPassed = false;
            }
        checkOver();
        //setLabels();
    }
    
    private void weave2(){//AVALANCHE MODE (MAY SEEM RANDOM)
            if(hole == 6)
                hole = 5;
            
            int weaving = marbles[side][hole];
            
            while(!checkEmpty()){
                weaving = marbles[side][hole];
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
                        else{
                            mancalaPassed = false;
                        }
                    }
                    else if(hole == 6){
                        side = nextSide(side);
                        hole = 0;
                    }
                
                    if(weaving != 0){
                        marbles[side][hole]++;
                        weaving--;
                    }
                }
                if(mancalaPassed == true){
                    lblMessageBox.setText("FREE TURN");
                    currentPlayer = nextPlayer(currentPlayer);
                    break;
                }
            }
            
            currentPlayer = nextPlayer(currentPlayer);
            
            
        checkOver();
    }
    
    private int nextSide(int sideI){
        sideI++;
        if(sideI >= TOTAL_PLAYERS){
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
        if(input > 1){
            input = 0;
        }
        return input;
    }
    
    private int getPlayer(){//returns current player turn
        System.out.println(currentPlayer);
        return currentPlayer;
        
    }
    
    private boolean checkEmpty(){ //Need for capture
        return marbles[side][hole] == 1;
    }
    
    private void checkOver(){//FIX HERE
        int zeroMarbles = 0;
        int oneMarbles = 0;
        
        for(int i = 0; i < BOARD_LENGTH; i++){
            zeroMarbles += marbles[0][i];
            oneMarbles += marbles[1][i];
        }
        
        if(zeroMarbles == 0){
            oneMarbles = 0;
            for(int i = 0; i < BOARD_LENGTH; i++){
                oneMarbles += marbles[1][i];
                marbles[1][i] = 0;
            }
            
            mancala[0] += oneMarbles;
        }
        else if(oneMarbles == 0){
            zeroMarbles = 0;
            for(int i = 0; i < BOARD_LENGTH; i++){
                zeroMarbles += marbles[0][i];
                marbles[0][i] = 0;
            }
            
            mancala[1] += zeroMarbles;
        }
        
        if(!randomMarbles){
            if(mancala[0] >= 24 || mancala[1] >= 24){
                if(mancala[0] > mancala[1]){
                    playerWon = 0;
                }
                else{
                    playerWon = 1;
                }
            
                if(playerWon == 0){
                    lblMessageBox.setText("GAME OVER. " + player.get(0).getName() + " WINS!!");
                }
                else if(playerWon == 1){
                    lblMessageBox.setText("GAME OVER. " + player.get(1).getName() + " WINS!!");
                }
            }
        }
        else if(randomMarbles){
            if(mancala[0] >= max || mancala[1] >= max){
                if(mancala[0] > mancala[1]){
                    playerWon = 0;
                }
                else{
                    playerWon = 1;
                }
            
                if(playerWon == 0){
                    lblMessageBox.setText("GAME OVER. " + player.get(0).getName() + " WINS!!");
                }
                else if(playerWon == 1){
                    lblMessageBox.setText("GAME OVER. " + player.get(1).getName() + " WINS!!");
                }
            }
        }
        setLabels();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
