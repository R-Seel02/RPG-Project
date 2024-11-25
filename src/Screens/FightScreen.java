package Screens;

import Engine.*;
//import GameObject.Sprite; Unused
import Level.Player;
import Level.Enemy;
import Maps.FightMap;
import SpriteFont.SpriteFont;
import java.awt.*;
import Level.Items;

//For sound stuff
import java.io.File;
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 

// This class is for the fight level screen
public class FightScreen extends Screen {
    protected SpriteFont turnMessage;
    protected SpriteFont instructions;
    protected SpriteFont healthMessage;
    protected SpriteFont attackButton;
    protected SpriteFont fleeButton;
    protected SpriteFont itemsButton;
    protected SpriteFont healthPot, defPot, atkPot, backButtonItems;
    protected SpriteFont weapon1, weapon2, weapon3, weapon4, weapon5, weapon6, punch, backButtonAttack;
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
    protected boolean itemMenu, attackMenu;
    protected SpriteFont damageMessage;
    protected Items[] inventory;
    protected String[] weapons;
    protected int numWeapons;

    public FightScreen(PlayLevelScreen playLevelScreen, Player player, Enemy enemy) {
        this.playLevelScreen = playLevelScreen;
        this.player = player;
        this.enemy = enemy;
        this.enemyHealth = enemy.getCurrentHealth();
        this.keyPressTimer = 0;
        this.enemySprite = enemy.getSprite();
        this.background = new FightMap();
        this.background.setEnemy(enemy);
        if(enemy.getSpriteHeight() >= 100 || enemy.getSpriteWidth() >= 100){
            this.background.setEnemySpriteWithScale(enemy.getSprite(), 2);
        }
        else {
            this.background.setEnemySprite(enemy.getSprite());
        }

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
        this.inventory = player.getInventoryList();
        this.weapons = new String[6];
        this.numWeapons = 0;
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

        backButtonItems = new SpriteFont("Back!", 550, 600, "Arial", 0, Color.white);
        backButtonItems.setOutlineColor(Color.white);
        backButtonItems.setOutlineThickness(3);

        damageMessage = new SpriteFont("", 1000, 310, "Arial", 0, Color.white);

        //waiter!! waiter!! more slop please!!
        //Goes through the inventory, essentially jotting down what weapons the player has
        for(int i = 0; i < 6; i++){
            if(inventory[i] == null){
                //This area intentionally left blank
            }else if(inventory[i].getName() == "placeholder"){
                //Skips any placeholder items
            }else{
                weapons[i] = inventory[i].getName();
                numWeapons++;
            }
        }

        //Assigns each weapon to the appropriate button
        for(int i = 0; i < numWeapons; i++){
            if(i == 0){
                weapon1 = new SpriteFont(weapons[i], 150, 500, "Arial", 0, Color.WHITE);
                weapon1.setOutlineColor(Color.white);
                weapon1.setOutlineThickness(3);        
            }else if(i == 1){
                weapon2 = new SpriteFont(weapons[i], 550, 500, "Arial", 0, Color.WHITE);
                weapon2.setOutlineColor(Color.white);
                weapon2.setOutlineThickness(3);   
            }else if(i == 2){
                weapon3 = new SpriteFont(weapons[i], 1050, 500, "Arial", 0, Color.WHITE);
                weapon3.setOutlineColor(Color.white);
                weapon3.setOutlineThickness(3);   
            }else if(i == 3){
                weapon4 = new SpriteFont(weapons[i], 150, 550, "Arial", 0, Color.WHITE);
                weapon4.setOutlineColor(Color.white);
                weapon4.setOutlineThickness(3);   
            }else if(i == 4){
                weapon5 = new SpriteFont(weapons[i], 550, 550, "Arial", 0, Color.WHITE);
                weapon5.setOutlineColor(Color.white);
                weapon5.setOutlineThickness(3);   
            }else if(i == 5){
                weapon6 = new SpriteFont(weapons[i], 1050, 550, "Arial", 0, Color.WHITE);
                weapon6.setOutlineColor(Color.white);
                weapon6.setOutlineThickness(3);   
            }
        }

        //Sets the unused buttons, if any, to nothing values
        for(int i = numWeapons; i < 6; i++){
            if(i == 0){
                weapon1 = new SpriteFont("Empty", 150, 500, "Arial", 0, Color.white);
                weapon1.setOutlineColor(Color.white);
                weapon1.setOutlineThickness(3);        
            }else if(i == 1){
                weapon2 = new SpriteFont("Empty", 550, 500, "Arial", 0, Color.white);
                weapon2.setOutlineColor(Color.white);
                weapon2.setOutlineThickness(3);  
            }else if(i == 2){
                weapon3 = new SpriteFont("Empty", 1050, 500, "Arial", 0, Color.white);
                weapon3.setOutlineColor(Color.white);
                weapon3.setOutlineThickness(3);   
            }else if(i == 3){
                weapon4 = new SpriteFont("Empty", 150, 550, "Arial", 0, Color.white);
                weapon4.setOutlineColor(Color.white);
                weapon4.setOutlineThickness(3);   
            }else if(i == 4){
                weapon5 = new SpriteFont("Empty", 550, 550, "Arial", 0, Color.white);
                weapon5.setOutlineColor(Color.white);
                weapon5.setOutlineThickness(3);   
            }else if(i == 5){
                weapon6 = new SpriteFont("Empty", 1050, 550, "Arial", 0, Color.white);
                weapon6.setOutlineColor(Color.white);
                weapon6.setOutlineThickness(3);   
            }
        }

        punch = new SpriteFont("Punch!", 550, 450, "Arial", 0, Color.white);
        punch.setOutlineColor(Color.white);
        punch.setOutlineThickness(3);

        backButtonAttack = new SpriteFont("Back", 550, 650, "Arial", 0, Color.white);

        backButtonAttack.setOutlineColor(Color.white);
        backButtonAttack.setOutlineThickness(3);

        keyLocker.lockKey(Key.E);

        background.rightSprites();
    }
    
    //No longer deprecated 
    public void attack(int invNum){
        //enemyHealth -= ((int) (Math.random() * 10) + 1);
        //updateMessages();
        if(inventory[invNum] == null){
            dealtDamage = 0;
        }else{
            dealtDamage = inventory[invNum].getDamage();
        if(player.rollCrit()){
            dealtDamage *= 2;
        }
        if(player.hasAttackBuff()){
            dealtDamage += 6;
        }
        if(player.lastAttackWasCrit()){
            playSound("crit.wav");
        }else{
           playSound("playerHit.wav"); 
        }
        enemy.takeDamage(dealtDamage);
        isPlayerTurn = false;
        updateMessages();
        keyLocker.lockKey(Key.E);
        }
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
            playLevelScreen.backToGame();
            playSound("lose.wav");
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

        if(enemy.isDead()){
            fleeButton.setText("Leave!");
        }else{
            fleeButton.setText("Flee!");
        }
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
            playSound("moveCursor.wav");
            currentMenuItemHovered++;
        } else if (Keyboard.isKeyDown(Key.A) && keyPressTimer == 0) {
            keyPressTimer = 14;
            playSound("moveCursor.wav");
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
        }else if (attackMenu) {
            if(currentMenuItemHovered > numWeapons + 1){
                currentMenuItemHovered = 0;
            }else if (currentMenuItemHovered < 0){
                currentMenuItemHovered = numWeapons + 1;
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
            backButtonItems.setColor(Color.white);
            weapon1.setColor(Color.white);
            weapon2.setColor(Color.white);
            weapon3.setColor(Color.white);
            weapon4.setColor(Color.white);
            weapon5.setColor(Color.white);
            weapon6.setColor(Color.white);
            punch.setColor(Color.white);
            backButtonAttack.setColor(Color.blue);
        } else if (currentMenuItemHovered == 1) {
            attackButton.setColor(Color.white);
            itemsButton.setColor(Color.blue);
            fleeButton.setColor(Color.white);
            healthPot.setColor(Color.white);
            atkPot.setColor(Color.blue);
            defPot.setColor(Color.white);
            backButtonItems.setColor(Color.white);
            weapon1.setColor(Color.white);
            weapon2.setColor(Color.white);
            weapon3.setColor(Color.white);
            weapon4.setColor(Color.white);
            weapon5.setColor(Color.white);
            weapon6.setColor(Color.white);
            punch.setColor(Color.blue);
            backButtonAttack.setColor(Color.white);
        }else if(currentMenuItemHovered == 2){
            attackButton.setColor(Color.white);
            itemsButton.setColor(Color.white);
            fleeButton.setColor(Color.blue);
            healthPot.setColor(Color.white);
            atkPot.setColor(Color.white);
            defPot.setColor(Color.blue);
            backButtonItems.setColor(Color.white);
            weapon1.setColor(Color.blue);
            weapon2.setColor(Color.white);
            weapon3.setColor(Color.white);
            weapon4.setColor(Color.white);
            weapon5.setColor(Color.white);
            weapon6.setColor(Color.white);
            punch.setColor(Color.white);
            backButtonAttack.setColor(Color.white);
        }else if(currentMenuItemHovered == 3){
            attackButton.setColor(Color.white);
            itemsButton.setColor(Color.white);
            healthPot.setColor(Color.white);
            atkPot.setColor(Color.white);
            defPot.setColor(Color.white);
            backButtonItems.setColor(Color.blue);
            weapon1.setColor(Color.white);
            weapon2.setColor(Color.blue);
            weapon3.setColor(Color.white);
            weapon4.setColor(Color.white);
            weapon5.setColor(Color.white);
            weapon6.setColor(Color.white);
            punch.setColor(Color.white);
            backButtonAttack.setColor(Color.white);
        }else if(currentMenuItemHovered == 4){
            weapon1.setColor(Color.white);
            weapon2.setColor(Color.white);
            weapon3.setColor(Color.blue);
            weapon4.setColor(Color.white);
            weapon5.setColor(Color.white);
            weapon6.setColor(Color.white);
            punch.setColor(Color.white);
            backButtonAttack.setColor(Color.white);
        }else if(currentMenuItemHovered == 5){
            weapon1.setColor(Color.white);
            weapon2.setColor(Color.white);
            weapon3.setColor(Color.white);
            weapon4.setColor(Color.blue);
            weapon5.setColor(Color.white);
            weapon6.setColor(Color.white);
            punch.setColor(Color.white);
            backButtonAttack.setColor(Color.white);
        }else if(currentMenuItemHovered == 6){
            weapon1.setColor(Color.white);
            weapon2.setColor(Color.white);
            weapon3.setColor(Color.white);
            weapon4.setColor(Color.white);
            weapon5.setColor(Color.blue);
            weapon6.setColor(Color.white);
            punch.setColor(Color.white);
            backButtonAttack.setColor(Color.white);
        }else if(currentMenuItemHovered == 7){
            weapon1.setColor(Color.white);
            weapon2.setColor(Color.white);
            weapon3.setColor(Color.white);
            weapon4.setColor(Color.white);
            weapon5.setColor(Color.white);
            weapon6.setColor(Color.blue);
            punch.setColor(Color.white);
            backButtonAttack.setColor(Color.white);
        }
        if (Keyboard.isKeyUp(Key.E)) {
            keyLocker.unlockKey(Key.E);
        }

        if(isPlayerTurn){
            updateMessages();
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
                            playSound("heal.wav");
                            hasHealed = true;
                            updateMessages();
                        }
                        keyLocker.lockKey(Key.E);
                    }else if(menuItemSelected == 1){
                        if(player.hasAttackBuff()){
                            atkPot.setText("You already have an attack buff!");
                        }else if(player.damagePotCount() > 0){
                            playSound("select.wav");
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
                            playSound("select.wav");
                            updateMessages();
                        }
                        keyLocker.lockKey(Key.E);
                    }else if(menuItemSelected == 3){
                        showMainMenu();
                    }
                }else if(attackMenu){
                        if(menuItemSelected == 0){
                            showMainMenu();
                        }else if(menuItemSelected == 1){
                            dealtDamage = player.attack();
                            enemy.takeDamage(dealtDamage);
                            keyLocker.lockKey(Key.E);
                            if(player.lastAttackWasCrit()){
                                playSound("crit.wav");
                            }else{
                                playSound("punch.wav");
                            }
                            isPlayerTurn = false;
                            updateMessages();
                        }else if(menuItemSelected == 2){
                            attack(0);
                            keyLocker.lockKey(Key.E);
                            updateMessages();
                            isPlayerTurn = false;
                        }else if(menuItemSelected == 3){
                            attack(1);
                            keyLocker.lockKey(Key.E);
                            updateMessages();
                            isPlayerTurn = false;
                        }else if(menuItemSelected == 4){
                            attack(2);
                            keyLocker.lockKey(Key.E);
                            updateMessages();
                            isPlayerTurn = false;
                        }else if(menuItemSelected == 5){
                            attack(3);
                            keyLocker.lockKey(Key.E);
                            updateMessages();
                            isPlayerTurn = false;
                        }else if(menuItemSelected == 6){
                            attack(4);
                            keyLocker.lockKey(Key.E);
                            updateMessages();
                            isPlayerTurn = false;
                        }else if(menuItemSelected == 7){
                            attack(5);
                            keyLocker.lockKey(Key.E);
                            updateMessages();
                            isPlayerTurn = false;
                        }
                }else{
                    if (menuItemSelected == 0 && !player.isDead() && !enemy.isDead()) {
                        //OLD STUFF - weapon system actually makes player.attack() not as useful now since it's easier to just get the weapons in the FightScreen - still use it for punches
                        //dealtDamage = player.attack();
                        //if(player.hasAttackBuff()){
                        //    dealtDamage += (dealtDamage/2);
                        //}
                        //enemy.takeDamage(dealtDamage);
                        //isPlayerTurn = false;
                        //if(player.lastAttackWasCrit()){
                        //    playSound("crit.wav");
                        //}else{
                        //   playSound("playerHit.wav"); 
                        //}
                        //updateMessages();
                        keyLocker.lockKey(Key.E);
                        showAttackMenu();
                    }else if((menuItemSelected == 0 || menuItemSelected == 1) && player.isDead()){
                        //This area intentionally left blank.
                    }else if(menuItemSelected == 1){
                        showItemsMenu();
                    }else if(menuItemSelected == 2) {
                        playSound("select.wav");
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
                        backButtonItems.setFontSize(0);
                        updateMessages();
                        player.emptyCritBucket();
                        player.removeBuffs();
                        if(!enemy.isDead()){
                            enemy.heal(enemy.getMaxHealth());
                        }
                    }
                }
            }
        }else{
            if(enemy.isDead()){
                isPlayerTurn = true;
                playSound("win.wav");
            }else if(turnTimer == 0){
                takenDamage = enemy.attack();
                if(player.hasDefenseBuff()){
                    takenDamage = (int) takenDamage/2;
                    System.out.println(takenDamage);
                    if(takenDamage < 0){
                        takenDamage = 0;
                    }
                }
                player.takeDamage(takenDamage);
                playSound("enemyHit.wav");
                if(player.isDead()){
                    playLevelScreen.flagManager.setFlag("playerDied");
                }
                //System.out.println(takenDamage);
                updateMessages();
                turnTimer = 90;
                isPlayerTurn = true;
                hasHealed = false;
            }else{
                turnTimer--;
            }
        }
    }

    //Plays the sound from the selected filePath
    public void playSound(String filePath) {
		try {
			File soundPath = new File(filePath);
			
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundPath);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInput);
			clip.start();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

    public void showItemsMenu(){
        playSound("select.wav");
        attackButton.setFontSize(0);
        itemsButton.setFontSize(0);
        fleeButton.setFontSize(0);
        atkPot.setFontSize(30);
        defPot.setFontSize(30);
        healthPot.setFontSize(30);
        backButtonItems.setFontSize(50);
        keyLocker.lockKey(Key.E);
        currentMenuItemHovered = 3;
        itemMenu = true;
    }

    public void showAttackMenu(){
        playSound("select.wav");
        attackButton.setFontSize(0);
        itemsButton.setFontSize(0);
        fleeButton.setFontSize(0);
        weapon1.setFontSize(30);
        weapon2.setFontSize(30);
        weapon3.setFontSize(30);
        weapon4.setFontSize(30);
        weapon5.setFontSize(30);
        weapon6.setFontSize(30);
        punch.setFontSize(30);
        backButtonAttack.setFontSize(30);
        keyLocker.lockKey(Key.E);
        attackMenu = true;
    }

    public void showMainMenu(){
        itemMenu = false;
        attackMenu = false;
        playSound("select.wav");
        attackButton.setFontSize(50);
        itemsButton.setFontSize(50);
        fleeButton.setFontSize(50);
        atkPot.setFontSize(0);
        defPot.setFontSize(0);
        healthPot.setFontSize(0);
        backButtonItems.setFontSize(0);
        healthPot.setLocation(150, 550);
        atkPot.setLocation(550, 550);
        defPot.setLocation(1050,550);
        weapon1.setFontSize(0);
        weapon2.setFontSize(0);
        weapon3.setFontSize(0);
        weapon4.setFontSize(0);
        weapon5.setFontSize(0);
        weapon6.setFontSize(0);
        punch.setFontSize(0);
        backButtonAttack.setFontSize(0);
        updateMessages();
        keyLocker.lockKey(Key.E);
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
        backButtonItems.draw(graphicsHandler);

        weapon1.draw(graphicsHandler);
        weapon2.draw(graphicsHandler);
        weapon3.draw(graphicsHandler);
        weapon4.draw(graphicsHandler);
        weapon5.draw(graphicsHandler);
        weapon6.draw(graphicsHandler);
        punch.draw(graphicsHandler);
        backButtonAttack.draw(graphicsHandler);

        damageMessage.draw(graphicsHandler);

        // player health bar
        graphicsHandler.drawFilledRectangleWithBorder(275, 275, player.getMaxHealth() * 2, 25, Color.gray, Color.black, 3);
        graphicsHandler.drawFilledRectangle(275, 275, (player.getHealth() * 2), 25, new Color(190, 0, 0));

        // enemy health bar
        graphicsHandler.drawFilledRectangleWithBorder((950 + (100 - enemy.getMaxHealth())), 275, enemy.getMaxHealth() * 2, 25, Color.gray, Color.black, 3);
        graphicsHandler.drawFilledRectangle((950 + (100 - enemy.getMaxHealth())), 275, (enemy.getCurrentHealth() * 2), 25, new Color(190, 0, 0));
    }
}
