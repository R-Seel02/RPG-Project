package Screens;

import Engine.*;
import GameObject.Sprite;
import Level.Items;
import Level.PickableObject;
import Level.Player;
import Players.Mage;
import SpriteFont.SpriteFont;
import java.awt.*;


public class InventoryScreen extends Screen {

    protected SpriteFont returnToGame;
    protected Sprite background;
    protected SpriteFont itemName;
    protected SpriteFont slotNumber;
    protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;
    protected Player player;
    protected int pointerLocationX;
    protected int pointerLocationY;
    protected int menuItemSelected = -1;
    protected int currentMenuItemHovered = 0;
    protected int keyPressTimer;
    protected PickableObject pickableObject;
    protected PickableObject [] inventoryList;
    protected SpriteFont healthPotCount;
    protected SpriteFont damagePotCount;
    protected SpriteFont defensePotCount;
  
    public InventoryScreen(PlayLevelScreen playLevelScreen, Player player) {
        this.playLevelScreen = playLevelScreen;
        this.player = player;
        initialize();
    }

    @Override
    public void initialize() {
        
        
        background = new Sprite(ImageLoader.load("NewInventoryScreen.png"));
        
        healthPotCount = new SpriteFont("x " + player.healthPotCount(), 1200, 100, "Arial", 80, Color.white);
        healthPotCount.setOutlineColor(Color.black);
        healthPotCount.setOutlineThickness(2);

        damagePotCount = new SpriteFont("x " + player.damagePotCount(), 1200, 350, "Arial", 80, Color.white);
        damagePotCount.setOutlineColor(Color.black);
        damagePotCount.setOutlineThickness(2);

        defensePotCount = new SpriteFont("x " + player.defensePotCount(), 1200, 625, "Arial", 80, Color.white);
        defensePotCount.setOutlineColor(Color.black);
        defensePotCount.setOutlineThickness(2);
        
        // returnToGame = new SpriteFont("Leave?", 136, 680, "Arial", 40, Color.white);
        // keyPressTimer = 0;
        // keyLocker.lockKey(Key.SPACE);
    }
 

    @Override
    public void update() {
        if (currentMenuItemHovered >= 1 ) {
            currentMenuItemHovered = 0;
        } else if (currentMenuItemHovered < 0) {
            currentMenuItemHovered = 3;
        }

        // if (currentMenuItemHovered == 0) {
        //     returnToGame.setColor(Color.yellow);
        //     pointerLocationX = 136;
        //     pointerLocationY = 580;
        // } 
        // else{
        //     returnToGame.setColor(Color.white);
        // }

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
        }
        if (Keyboard.isKeyUp(Key.I)) {
            keyLocker.unlockKey(Key.I);
        }

        healthPotCount.setText("x " + player.healthPotCount());
        damagePotCount.setText("x " + player.damagePotCount());
        defensePotCount.setText("x " + player.defensePotCount());

    }


    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        


        background.draw(graphicsHandler);
        Items[] inventoryList = player.getInventoryList(); 

        //logic to see if the inventory list is filled with valid pickableObject
        // for (int i = 0; i < inventoryList.length; i++) {
        //     if (inventoryList[i] != null) {
                

        //        Sprite itemSprite = inventoryList[i].getFrame();
                
        //        //    inventoryList[i].getFrame().drawImage
        //         // Sprite itemSprite = new Sprite(inventoryList[i].getFrame(), 210 + (i * 200), 68); // Adjust position for each item
        //         itemSprite.draw(graphicsHandler);
        //     }
        // }

        int windowWidth = 1400;
        int windowHeight = 900;
    
        int columns = 5;          // Number of columns in the grid
        int rows = 3;             // Number of rows in the grid (based on image provided)
        int slotWidth = 120;      // Width of each inventory slot
        int slotHeight = 120;     // Height of each inventory slot
        int colSpacing = 20;      // Horizontal spacing between columns
        int rowSpacing = 30;      // Vertical spacing between rows
    
        // Calculate the total grid width and height
        int gridWidth = columns * slotWidth + (columns - 1) * colSpacing;
        int gridHeight = rows * slotHeight + (rows - 1) * rowSpacing;
    
        // Calculate the starting position to center the grid in the window
        int startX = (windowWidth - gridWidth) / 2;
        int startY = (windowHeight - gridHeight) / 2;
     
    
        // Loop through each inventory slot
        for (int i = 0; i < inventoryList.length; i++) {
            if (inventoryList[i] != null) {
                // Calculate the x and y position for the current item
                int row = i / columns; 
                int col = i % columns; 
                int x = startX + col * slotWidth;    // X position for item
                int y = startY + row * rowSpacing;   // Y position for item
    
               
                Sprite itemSprite = inventoryList[i].getFrame();
                itemSprite.setPosition(x, y); 
                itemSprite.draw(graphicsHandler);
            }
        }
        //returnToGame.draw(graphicsHandler);
        healthPotCount.draw(graphicsHandler);
        damagePotCount.draw(graphicsHandler);
        defensePotCount.draw(graphicsHandler);
        //graphicsHandler.drawFilledRectangle(pointerLocationX, pointerLocationY, 25, 25, Color.yellow);
    }

    




}