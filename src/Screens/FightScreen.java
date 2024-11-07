package Screens;

import Engine.*;
import Level.Player;
import Level.Enemy;
import Maps.FightMap;
import SpriteFont.SpriteFont;
import java.awt.*;

// This class is for the fight level screen
public class FightScreen extends Screen {
    protected SpriteFont turnMessage;
    protected SpriteFont instructions;
    protected SpriteFont healthMessage;
    protected SpriteFont attackButton;
    protected SpriteFont fleeButton;
    protected SpriteFont itemsButton;
    protected SpriteFont healthPot, defPot, atkPot, backButton;
    protected SpriteFont coinCounter;
    protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;
    // protected Knight player; 
    protected Player player;
    protected int enemyHealth; //temporary thing until I make an enemy class - Max
    protected int keyPressTimer;
    protected int menuItemSelected = -1;
    protected int currentMenuItemHovered = 0;
    protected FightMap background;
    protected boolean isPlayerTurn;
    protected boolean playerPerformedAction;
    protected boolean hasHealed, hasDef, hasAtk;
    protected int turnTimer;
    protected Enemy enemy;
    protected String enemySprite;
    protected int dealtDamage, takenDamage;
    protected boolean itemMenu;
    protected SpriteFont damageMessage;

    public FightScreen(PlayLevelScreen playLevelScreen, Player player, Enemy enemy) {
        this.playLevelScreen = playLevelScreen;
        this.player = player;
        this.enemy = enemy;
        this.enemyHealth = enemy.getCurrentHealth();
        this.keyPressTimer = 0;
        this.enemySprite = enemy.getSprite();
        this.background = new FightMap();
        this.background.setEnemy(enemy);
        this.background.setEnemySprite(enemy.getSprite());

        if(playLevelScreen.getCharacterSelection() == 0){
            this.background.setPlayerSprite("Assassin.png");
        }else if(playLevelScreen.getCharacterSelection() == 1){
            this.background.setPlayerSprite("Knight.png");
        }else if(playLevelScreen.getCharacterSelection() == 2){
            this.background.setPlayerSprite("Mage.png");
        }else{
            this.background.setPlayerSprite("error.png"); 
        }

        this.isPlayerTurn = true;
        this.turnTimer = 100;
        this.hasHealed = false;
        this.hasAtk = false;
        this.hasDef = false;
        initialize();
    }

    @Override
    public void initialize() {
        turnMessage = new SpriteFont("It is your turn.", 500, 100, "Arial", 30, Color.white);
        instructions = new SpriteFont("Press the attack button to attack. This is a fight for your honor. Good luck.", 425, 150, "Arial", 20, Color.white);
        healthMessage = new SpriteFont("You have " + player.getHealth() + " health. The enemy has " + enemyHealth + " health.", 400, 200, "Arial", 20, Color.white);
        //instructions = new SpriteFont("Press Escape to go back to the game.", 160, 279,"Arial", 20, Color.white);
        coinCounter = new SpriteFont("Coins: " + player.getCoinCount(), 1200, 60, "Arial", 40, Color.white);

        attackButton = new SpriteFont("Attack!", 150, 550, "Arial", 50, Color.white);
        fleeButton = new SpriteFont("Flee!", 1100, 550, "Arial", 50, Color.white);
        itemsButton = new SpriteFont("Items!", 600, 550, "Arial", 50, Color.white);

        attackButton.setOutlineColor(Color.white);
        attackButton.setOutlineThickness(3);

        fleeButton.setOutlineColor(Color.white);
        fleeButton.setOutlineThickness(3);;

        itemsButton.setOutlineColor(Color.white);
        itemsButton.setOutlineThickness(3);

        coinCounter.setOutlineColor(Color.black);
        coinCounter.setOutlineThickness(2);

        healthPot = new SpriteFont("Health Potion (" + player.healthPotCount() + ")", 150, 550, "Arial", 0, Color.white);
        healthPot.setOutlineColor(Color.white);
        healthPot.setOutlineThickness(3);

        atkPot = new SpriteFont("Attack Potion (" + player.damagePotCount() + ")", 550, 550, "Arial", 0, Color.white);
        atkPot.setOutlineColor(Color.white);
        atkPot.setOutlineThickness(3);

        defPot = new SpriteFont("Damage Potion (" + player.defensePotCount() + ")", 1050, 550, "Arial", 0, Color.white);
        defPot.setOutlineColor(Color.white);
        defPot.setOutlineThickness(3);

        backButton = new SpriteFont("Back!", 550, 600, "Arial", 0, Color.white);
        backButton.setOutlineColor(Color.white);
        backButton.setOutlineThickness(3);

        damageMessage = new SpriteFont("", 1000, 310, "Arial", 0, Color.white);

        keyLocker.lockKey(Key.E);

        background.rightSprites();
    }
    
    //Temporary method. Hurts the "enemy" by a random value from 1 - 10.
    //DEPRECATED -- use Player class built-in attack function instead
    public void attack(){
        enemyHealth -= ((int) (Math.random() * 10) + 1);
        updateMessages();
    }

    //Temporary method. Damages the player by a random value from 1 - 10.
    //DEPRECATED -- use Enemy class built-in attack function instead
    public void damagePlayer(){
        player.takeDamage((int) (Math.random() * 10) + 1);
        updateMessages();
    }

    //Returns the current enemy sprite as a temporary fix to an endless loop I'm stuck in where the PlayLevelScreen keeps resetting the fight screen
    //DEPRECATED -- issue fixed
    public String getEnemySprite(){
        return this.background.getEnemySprite();
    }

    public Enemy getCurrentEnemy(){
        return this.enemy;
    }

    public void updateMessages(){
        background.rightSprites();
        if(isPlayerTurn){
            //turnMessage = new SpriteFont("It is your turn.", 150, 239, "Arial", 30, Color.white);
            turnMessage.setText("It is your turn!");
        }else{
            //turnMessage = new SpriteFont("The enemy attacks!", 150, 239, "Arial", 30, Color.white);
            turnMessage.setText(enemy.getName() + " attacks! You take " + takenDamage + " damage!");
        }
        if(player.isDead() && enemy.isDead()){
            healthMessage = new SpriteFont("You have fallen, but in your last stand, you took your enemy with you.", 150, 319, "Arial", 20, Color.orange);
            //healthMessage.setText("You have fallen, but in your last stand, you took your enemy with you.");
            //healthMessage.setColor(Color.yellow);
            background.flipPlayer();
            background.flipEnemy();
        }else if(player.isDead()){
            //healthMessage = new SpriteFont("You have been bested by your foe!", 150, 319, "Arial", 20, Color.red);
            healthMessage.setText("You have been bested by your foe!");
            healthMessage.setColor(Color.red);
            background.flipPlayer();
        }else if(enemy.isDead()){
            //healthMessage = new SpriteFont("You have killed the enemy! Congratulations.", 150, 319, "Arial", 20, Color.green);
            healthMessage.setText("You have beaten your enemy! Congratulations!");
            healthMessage.setColor(Color.green);
            background.flipEnemy();
        }else{
            //healthMessage = new SpriteFont("You have " + player.getHealth() + " health. The enemy has " + enemy.getCurrentHealth() + " health.", 150, 319, "Arial", 20, Color.white);
            healthMessage.setText("You have " + player.getHealth() + " health. The enemy has " + enemy.getCurrentHealth() + " health.");
        }
        healthPot.setText("Health Potion (" + player.healthPotCount() + ")");
        atkPot.setText("Attack Potion (" + player.damagePotCount() + ")");
        defPot.setText("Defense Potion (" + player.defensePotCount() + ")");

        damageMessage.setFontSize(20);
        if(player.lastAttackWasCrit()){
            damageMessage.setText("CRIT! " + "-" + dealtDamage + " HP!");
        }else{
            damageMessage.setText("-" + dealtDamage + " HP!");
        }
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

        if(itemMenu){
            if(currentMenuItemHovered > 3){
                currentMenuItemHovered = 0;
            }else if (currentMenuItemHovered < 0){
                currentMenuItemHovered = 3;
            }
        }else{
            if (currentMenuItemHovered > 2) {
                currentMenuItemHovered = 0;
            } else if (currentMenuItemHovered < 0) {
                currentMenuItemHovered = 2;
            }
        }
        

        if (currentMenuItemHovered == 0) {
            attackButton.setColor(Color.blue);
            itemsButton.setColor(Color.white);
            fleeButton.setColor(Color.white);
            healthPot.setColor(Color.blue);
            atkPot.setColor(Color.white);
            defPot.setColor(Color.white);
            backButton.setColor(Color.white);
        } else if (currentMenuItemHovered == 1) {
            attackButton.setColor(Color.white);
            itemsButton.setColor(Color.blue);
            fleeButton.setColor(Color.white);
            healthPot.setColor(Color.white);
            atkPot.setColor(Color.blue);
            defPot.setColor(Color.white);
            backButton.setColor(Color.white);
        }else if(currentMenuItemHovered == 2){
            attackButton.setColor(Color.white);
            itemsButton.setColor(Color.white);
            fleeButton.setColor(Color.blue);
            healthPot.setColor(Color.white);
            atkPot.setColor(Color.white);
            defPot.setColor(Color.blue);
            backButton.setColor(Color.white);
        }else if(currentMenuItemHovered == 3){
            attackButton.setColor(Color.white);
            itemsButton.setColor(Color.white);
            healthPot.setColor(Color.white);
            atkPot.setColor(Color.white);
            defPot.setColor(Color.white);
            backButton.setColor(Color.blue);
        }
        if (Keyboard.isKeyUp(Key.E)) {
            keyLocker.unlockKey(Key.E);
        }

        if(isPlayerTurn){
            if (!keyLocker.isKeyLocked(Key.E) && Keyboard.isKeyDown(Key.E)) {
                menuItemSelected = currentMenuItemHovered;
                if(itemMenu){
                    if(menuItemSelected == 0){
                        if(hasHealed){
                            healthPot.setText("You have already healed this turn!");
                            healthPot.setLocation(80, 550);
                        }else if(player.getHealth() == player.getMaxHealth()){
                            healthPot.setText("You are at full health!");
                        }else if(player.healthPotCount() > 0){
                            player.useHealthPot();
                            hasHealed = true;
                            updateMessages();
                        }
                        keyLocker.lockKey(Key.E);
                    }else if(menuItemSelected == 1){
                        if(player.hasAttackBuff()){
                            atkPot.setText("You already have an attack buff!");
                        }else if(player.damagePotCount() > 0){
                            player.useDamagePot();
                            updateMessages();
                        }
                        keyLocker.lockKey(Key.E);
                    }else if(menuItemSelected == 2){
                        if(player.hasDefenseBuff()){
                            defPot.setText("You already have a defense buff!");
                            defPot.setFontSize(25);
                            defPot.setLocation(975, 550);
                        }else if(player.defensePotCount() > 0){
                            player.useDefensePot();
                            updateMessages();
                        }
                        keyLocker.lockKey(Key.E);
                    }else if(menuItemSelected == 3){
                        itemMenu = false;
                        attackButton.setFontSize(50);
                        itemsButton.setFontSize(50);
                        fleeButton.setFontSize(50);
                        atkPot.setFontSize(0);
                        defPot.setFontSize(0);
                        healthPot.setFontSize(0);
                        backButton.setFontSize(0);
                        healthPot.setLocation(150, 550);
                        atkPot.setLocation(550, 550);
                        defPot.setLocation(1050,550);
                        updateMessages();
                        keyLocker.lockKey(Key.E);
                    }
                }else{
                    if (menuItemSelected == 0 && !player.isDead() && !enemy.isDead()) {
                        dealtDamage = player.attack();
                        if(player.hasAttackBuff()){
                            dealtDamage += (dealtDamage/2);
                        }
                        enemy.takeDamage(dealtDamage);
                        isPlayerTurn = false;
                        updateMessages();
                        keyLocker.lockKey(Key.E);
                    }else if((menuItemSelected == 0 || menuItemSelected == 1) && player.isDead()){
                        //This area intentionally left blank.
                    }else if(menuItemSelected == 1){
                        attackButton.setFontSize(0);
                        itemsButton.setFontSize(0);
                        fleeButton.setFontSize(0);
                        atkPot.setFontSize(30);
                        defPot.setFontSize(30);
                        healthPot.setFontSize(30);
                        backButton.setFontSize(50);
                        keyLocker.lockKey(Key.E);
                        currentMenuItemHovered = 3;
                        itemMenu = true;
                    }else if(menuItemSelected == 2) {
                        playLevelScreen.backToGame();
                        currentMenuItemHovered = 0;
                        background.rightSprites();
                        healthMessage.setColor(Color.white);
                        attackButton.setFontSize(50);
                        itemsButton.setFontSize(50);
                        fleeButton.setFontSize(50);
                        atkPot.setFontSize(0);
                        defPot.setFontSize(0);
                        healthPot.setFontSize(0);
                        backButton.setFontSize(0);
                        updateMessages();
                        player.emptyCritBucket();
                    }
                }
            }
        }else{
            if(enemy.isDead()){
                isPlayerTurn = true;
            }else if(turnTimer == 0){
                takenDamage = enemy.attack();
                if(player.hasDefenseBuff()){
                    takenDamage -= 3;
                    if(takenDamage < 0){
                        takenDamage = 0;
                    }
                }
                player.takeDamage(takenDamage);
                if(player.isDead()){
                    playLevelScreen.flagManager.setFlag("playerDied");
                }
                turnTimer = 60;
                isPlayerTurn = true;
                hasHealed = false;
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
        itemsButton.draw(graphicsHandler);
        instructions.draw(graphicsHandler);
        
        atkPot.draw(graphicsHandler);
        healthPot.draw(graphicsHandler);
        defPot.draw(graphicsHandler);
        backButton.draw(graphicsHandler);

        damageMessage.draw(graphicsHandler);

        // player health bar
        graphicsHandler.drawFilledRectangleWithBorder(275, 275, player.getMaxHealth() * 2, 25, Color.gray, Color.black, 3);
        graphicsHandler.drawFilledRectangle(275, 275, (player.getHealth() * 2), 25, new Color(190, 0, 0));

        // enemy health bar
        graphicsHandler.drawFilledRectangleWithBorder(975, 275, enemy.getMaxHealth() * 2, 25, Color.gray, Color.black, 3);
        graphicsHandler.drawFilledRectangle(975, 275, (enemy.getCurrentHealth() * 2), 25, new Color(190, 0, 0));
    }
}
