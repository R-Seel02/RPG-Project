package Screens;

import Engine.*;
import Maps.FightMap;
import Players.Knight;
import SpriteFont.SpriteFont;
import java.awt.*;

// This class is for the fight level screen
public class FightScreen extends Screen {
    protected SpriteFont turnMessage;
    protected SpriteFont instructions;
    protected SpriteFont healthMessage;
    protected SpriteFont attackButton;
    protected SpriteFont fleeButton;
    protected SpriteFont healButton;
    protected SpriteFont coinCounter;
    protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;
    protected Knight player;
    protected int enemyHealth; //temporary thing until I make an enemy class - Max
    protected int keyPressTimer;
    protected int menuItemSelected = -1;
    protected int currentMenuItemHovered = 0;
    protected FightMap background;
    protected boolean isPlayerTurn;
    protected boolean playerPerformedAction;
    protected boolean playerHasHealed;
    protected int turnTimer;

    public FightScreen(PlayLevelScreen playLevelScreen, Knight player, String enemySprite) {
        this.playLevelScreen = playLevelScreen;
        this.player = player;
        this.enemyHealth = 100;
        this.keyPressTimer = 0;
        this.background = new FightMap(enemySprite);
        this.isPlayerTurn = true;
        this.turnTimer = 100;
        this.playerHasHealed = false;
        initialize();
    }

    @Override
    public void initialize() {
        turnMessage = new SpriteFont("It is your turn.", 150, 239, "Arial", 30, Color.white);
        instructions = new SpriteFont("Press the attack button to attack. This is a fight for your honor. Good luck.", 75, 279, "Arial", 20, Color.white);
        healthMessage = new SpriteFont("You have " + player.getHealth() + " health. The enemy has " + enemyHealth + " health.", 150, 319, "Arial", 20, Color.white);
        //instructions = new SpriteFont("Press Escape to go back to the game.", 160, 279,"Arial", 20, Color.white);
        coinCounter = new SpriteFont("Coins: " + player.getCoinCount(), 1200, 60, "Arial", 40, Color.white);

        attackButton = new SpriteFont("Attack!", 75, 350, "Arial", 50, Color.white);
        fleeButton = new SpriteFont("Flee!", 675, 350, "Arial", 50, Color.white);
        healButton = new SpriteFont("Heal!", 375, 350, "Arial", 50, Color.white);

        attackButton.setOutlineColor(Color.white);
        attackButton.setOutlineThickness(3);

        fleeButton.setOutlineColor(Color.white);
        fleeButton.setOutlineThickness(3);;

        healButton.setOutlineColor(Color.white);
        healButton.setOutlineThickness(3);

        coinCounter.setOutlineColor(Color.black);
        coinCounter.setOutlineThickness(2);

        keyLocker.lockKey(Key.E);

        background.rightSprites();
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
        yesMoney();
        background.rightSprites();
        if(isPlayerTurn){
            //turnMessage = new SpriteFont("It is your turn.", 150, 239, "Arial", 30, Color.white);
            turnMessage.setText("It is your turn!");
        }else{
            //turnMessage = new SpriteFont("The enemy attacks!", 150, 239, "Arial", 30, Color.white);
            turnMessage.setText("The enemy attacks!");
        }
        if(player.isDead() && enemyHealth <= 0){
            healthMessage = new SpriteFont("You have died, but in your last stand, you took your enemy with you.", 150, 319, "Arial", 20, Color.orange);
            //healthMessage.setText("You have fallen, but in your last stand, you took your enemy with you.");
            //healthMessage.setColor(Color.yellow);
            background.flipPlayer();
            background.flipEnemy();
        }else if(player.isDead()){
            healthMessage = new SpriteFont("You have been bested by your foe!", 150, 319, "Arial", 20, Color.red);
            //healthMessage.setText("You have been bested by your foe!");
            //healthMessage.setColor(Color.red);
            background.flipPlayer();
        }else if(enemyHealth <= 0){
            healthMessage = new SpriteFont("You have killed the enemy! Congratulations.", 150, 319, "Arial", 20, Color.green);
            //healthMessage.setText("You have beaten your enemy! Congratulations!");
            //healthMessage.setColor(Color.green);
            background.flipEnemy();
        }else{
            healthMessage = new SpriteFont("You have " + player.getHealth() + " health. The enemy has " + enemyHealth + " health.", 150, 319, "Arial", 20, Color.white);
            //healthMessage.setText("You have " + player.getHealth() + " health. The enemy has " + enemyHealth + " health.");
        }
    }

    public void noMoney(){
        healButton.setText("You don't have enough money!");
        healButton.setFontSize(20);
    }

    public void yesMoney(){
        healButton.setText("Heal!");
        healButton.setFontSize(50);
    }

    @Override
    public void update() {
        if (Keyboard.isKeyDown(Key.D) && keyPressTimer == 0) {
            keyPressTimer = 14;
            currentMenuItemHovered++;
        } else if (Keyboard.isKeyDown(Key.A) && keyPressTimer == 0) {
            keyPressTimer = 14;
            currentMenuItemHovered--;
        } else {
            if (keyPressTimer > 0) {
                keyPressTimer--;
            }
        }

        if (currentMenuItemHovered > 2) {
            currentMenuItemHovered = 0;
        } else if (currentMenuItemHovered < 0) {
            currentMenuItemHovered = 2;
        }

        if (currentMenuItemHovered == 0) {
            attackButton.setColor(Color.blue);
            healButton.setColor(Color.white);
            fleeButton.setColor(Color.white);
        } else if (currentMenuItemHovered == 1) {
            attackButton.setColor(Color.white);
            healButton.setColor(Color.blue);
            fleeButton.setColor(Color.white);
        }else if(currentMenuItemHovered == 2){
            attackButton.setColor(Color.white);
            healButton.setColor(Color.white);
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
                }else if((menuItemSelected == 0 || menuItemSelected == 1) && player.isDead()){
                    //This area intentionally left blank.
                }else if(menuItemSelected == 1){
                    if(playerHasHealed){
                        healButton.setText("You have already healed this turn.");
                        healButton.setFontSize(20);
                    }else if(player.getHealth() == 100){
                        healButton.setText("You are at full health!");
                        healButton.setFontSize(20);
                    }else{
                        if(player.getCoinCount() >= 1){
                            player.heal(10);
                            player.setCoinCount(player.getCoinCount() - 1);
                            coinCounter.setText("Coins: " + player.getCoinCount());
                            playerHasHealed = true;
                            updateMessages();
                        }else{
                            noMoney();
                        }
                    }
                    keyLocker.lockKey(Key.E);
                }else if(menuItemSelected == 2) {
                    playLevelScreen.backToGame();
                    currentMenuItemHovered = 0;
                    background.rightSprites();
                    enemyHealth = 100;
                    healthMessage.setColor(Color.white);
                    updateMessages();
                }
            }
        }else{
            if(enemyHealth <= 0){
                //This area intentionally left blank.
                isPlayerTurn = true;
            }else if(turnTimer == 0){
                damagePlayer();
                turnTimer = 60;
                isPlayerTurn = true;
                playerHasHealed = false;
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
        coinCounter.draw(graphicsHandler);
        attackButton.draw(graphicsHandler);
        fleeButton.draw(graphicsHandler);
        healButton.draw(graphicsHandler);
        instructions.draw(graphicsHandler);
        
        // player health bar
        graphicsHandler.drawFilledRectangleWithBorder(25, 25, 200, 25, Color.gray, Color.black, 3);
        graphicsHandler.drawFilledRectangle(25, 25, (player.getHealth() * 2), 25, new Color(190, 0, 0));

        // enemy health bar
        graphicsHandler.drawFilledRectangleWithBorder(1175, 25, 200, 25, Color.gray, Color.black, 3);
        graphicsHandler.drawFilledRectangle(1175, 25, (enemyHealth * 2), 25, new Color(190, 0, 0));
    }
}
