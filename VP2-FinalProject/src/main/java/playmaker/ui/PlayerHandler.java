/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playmaker.ui;

/**
 *
 * @author carl
 */
public interface PlayerHandler {
    public void movePlayer();
    public void stopPlayer();
    public void resetPlayer();
    public void removePlayer();
    public void removePlayerPath();
}
