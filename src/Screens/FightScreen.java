package Screens;

import Engine.*;
import SpriteFont.SpriteFont;
import Players.Cat;
import Maps.FightMap;
import Level.Map;

import java.awt.*;

// This class is for the fight level screen
public class FightScreen extends Screen {
    protected SpriteFont turnMessage;
    protected SpriteFont instructions;
    protected SpriteFont healthMessage;
    protected SpriteFont attackButton;
    protected SpriteFont fleeButton;
    protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;
    protected Cat player;
    protected int enemyHealth; //temporary thing until I make an enemy class - Max
    protected int keyPressTimer;
    protected int menuItemSelected = -1;
    protected int currentMenuItemHovered = 0;
    protected FightMap background;
    protected boolean isPlayerTurn;
    protected boolean playerPerformedAction;
    protected int turnTimer;

    public FightScreen(PlayLevelScreen playLevelScreen, Cat player, String enemySprite) {
        this.playLevelScreen = playLevelScreen;
        this.player = player;
        this.enemyHealth = 100;
        this.keyPressTimer = 0;
        this.background = new FightMap(enemySprite);
        this.isPlayerTurn = true;
        this.turnTimer = 100;
        initialize();
    }

    @Override
    public void initialize() {
        turnMessage = new SpriteFont("It is your turn.", 150, 239, "Arial", 30, Color.white);
        instructions = new SpriteFont("Press the attack button to attack. This is a fight to the death. Good luck.", 75, 279, "Arial", 20, Color.white);
        healthMessage = new SpriteFont("You have " + player.getHealth() + " health. The enemy has " + enemyHealth + " health.", 150, 319, "Arial", 20, Color.white);
        //instructions = new SpriteFont("Press Escape to go back to the game.", 160, 279,"Arial", 20, Color.white);

        attackButton = new SpriteFont("Attack!", 75, 350, "Arial", 50, Color.white);
        fleeButton = new SpriteFont("Flee!", 375, 350, "Arial", 50, Color.white);

        attackButton.setOutlineColor(Color.white);
        attackButton.setOutlineThickness(3);

        fleeButton.setOutlineColor(Color.white);
        fleeButton.setOutlineThickness(3);;

        keyLocker.lockKey(Key.E);
    }

    //Temporary method. Hurts the "enemy" by a random value from 1 - 10.
    public void attack(){
        enemyHealth -= ((int) (Math.random() * 10) + 1);
        updateMessages();
    }

    //Temporary method. Damages the player by a random value from 1 - 10.
    public void damagePlayer(){
        player.takeDamage((int) (Math.random() * 10) + 1);
        updateMessages();
    }

    //Returns the current enemy sprite as a temporary fix to an endless loop I'm stuck in where the PlayLevelScreen keeps resetting the fight screen
    public String getEnemySprite(){
        return this.background.getEnemySprite();
    }

    public void updateMessages(){
        if(isPlayerTurn){
            turnMessage = new SpriteFont("It is your turn.", 150, 239, "Arial", 30, Color.white);
        }else{
            turnMessage = new SpriteFont("The enemy attacks!", 150, 239, "Arial", 30, Color.white);
        }
        if(player.isDead() && enemyHealth <= 0){
            healthMessage = new SpriteFont("You have died, but in your last stand, you took your enemy with you.", 150, 319, "Arial", 20, Color.orange);
            background.flipPlayer();
            background.flipEnemy();
        }else if(player.isDead()){
            healthMessage = new SpriteFont("You have died. The enemy had " + enemyHealth + " health left. Better luck next time.", 150, 319, "Arial", 20, Color.red);
            background.flipPlayer();
        }else if(enemyHealth <= 0){
            healthMessage = new SpriteFont("You have killed the enemy! Congratulations.", 150, 319, "Arial", 20, Color.green);
            background.flipEnemy();
        }else{
            healthMessage = new SpriteFont("You have " + player.getHealth() + " health. The enemy has " + enemyHealth + " health.", 150, 319, "Arial", 20, Color.white);
        }
    }

    @Override
    public void update() {
        if (Keyboard.isKeyDown(Key.A) && keyPressTimer == 0) {
            keyPressTimer = 14;
            currentMenuItemHovered++;
        } else if (Keyboard.isKeyDown(Key.D) && keyPressTimer == 0) {
            keyPressTimer = 14;
            currentMenuItemHovered--;
        } else {
            if (keyPressTimer > 0) {
                keyPressTimer--;
            }
        }

        if (currentMenuItemHovered > 1) {
            currentMenuItemHovered = 0;
        } else if (currentMenuItemHovered < 0) {
            currentMenuItemHovered = 1;
        }

        if (currentMenuItemHovered == 0) {
            attackButton.setColor(Color.blue);
            fleeButton.setColor(Color.white);
        } else if (currentMenuItemHovered == 1) {
            attackButton.setColor(Color.white);
            fleeButton.setColor(Color.blue);
        }
        
        if (Keyboard.isKeyUp(Key.E)) {
            keyLocker.unlockKey(Key.E);
        }
        if(isPlayerTurn){
            if (!keyLocker.isKeyLocked(Key.E) && Keyboard.isKeyDown(Key.E)) {
                menuItemSelected = currentMenuItemHovered;
                if (menuItemSelected == 0 && !player.isDead() && enemyHealth > 0) {
                    attack();
                    isPlayerTurn = false;
                    updateMessages();
                    keyLocker.lockKey(Key.E);
                }else if(menuItemSelected == 0 && player.isDead()){
                    //This area intentionally left blank.
                }else if(menuItemSelected == 1) {
                    playLevelScreen.backToGame();
                    currentMenuItemHovered = 0;
                    background.rightSprites();
                    enemyHealth = 100;
                    player.revive();
                    updateMessages();
                }
            }
        }else{
            if(turnTimer == 0){
                damagePlayer();
                turnTimer = 60;
                isPlayerTurn = true;
                updateMessages();
            }else{
                turnTimer--;
            }
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
        background.draw(graphicsHandler);
        turnMessage.draw(graphicsHandler);
        healthMessage.draw(graphicsHandler);
        attackButton.draw(graphicsHandler);
        fleeButton.draw(graphicsHandler);
        instructions.draw(graphicsHandler);
    }
}
