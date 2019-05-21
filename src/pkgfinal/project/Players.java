/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;

/**
 *
 * @author bhanderi3627
 */
public class Players {
    
    private String playerName;
    
    public Players(String x){
        playerName = x;
    }
    
    public void setName(String y){
        playerName = y;
    }
    public String getName(){
        return playerName;
    }
}
