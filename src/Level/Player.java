package Level;

import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import GameObject.GameObject;
import GameObject.Rectangle;
import GameObject.SpriteSheet;
import Utils.Direction;
import java.util.Random;

public abstract class Player extends GameObject {
    // values that affect player movement
    // these should be set in a subclass
    protected float walkSpeed = 0;
    protected int interactionRange = 1;
    protected Direction currentWalkingXDirection;
    protected Direction currentWalkingYDirection;
    protected Direction lastWalkingXDirection;
    protected Direction lastWalkingYDirection;

    // inventory
    private Items[] inventoryList;
    private int[] potions;

    // potion constants
    public static final int HEALTH_POT = 0;
    public static final int DAMAGE_POT = 1;
    public static final int DEFENSE_POT = 2;

    // buffs
    boolean hasDamageBuff = false;
    boolean hasDefenseBuff = false;
    
    //combat stuff
    protected int health, maxHealth;
    protected int critChance;
    protected boolean isDead;
    protected Random random;
    protected boolean justCrit;
    protected int critBucket;

    // values used to handle player movement
    protected float moveAmountX, moveAmountY;
    protected float lastAmountMovedX, lastAmountMovedY;

    // values used to keep track of player's current state
    protected PlayerState playerState;
    protected PlayerState previousPlayerState;
    protected Direction facingDirection;
    protected Direction lastMovementDirection;
    protected int coinCount = 0;
    

    // define keys
    protected KeyLocker keyLocker = new KeyLocker();
    protected Key MOVE_LEFT_KEY = Key.A;
    protected Key MOVE_RIGHT_KEY = Key.D;
    protected Key MOVE_UP_KEY = Key.W;
    protected Key MOVE_DOWN_KEY = Key.S;
    protected Key PICK_UP_KEY = Key.E;
    protected Key INTERACT_KEY = Key.E;
    protected Key INVENTORY = Key.I;

    protected boolean isLocked = false;

    public Player(SpriteSheet spriteSheet, float x, float y, String startingAnimationName) {
        super(spriteSheet, x, y, startingAnimationName);
        facingDirection = Direction.RIGHT;
        playerState = PlayerState.STANDING;
        previousPlayerState = playerState;
        this.affectedByTriggers = true;
        this.maxHealth = 100;
        this.health = maxHealth;
        this.critChance = 5;
        isDead = false;
        this.random = new Random();
        this.inventoryList = new Items[15];
        this.potions = new int[3];
        this.justCrit = false;
        this.critBucket = 0;
    }

    public void update() {
        if (!isLocked) {
            moveAmountX = 0;
            moveAmountY = 0;

            // if player is currently playing through level (has not won or lost)
            // update player's state and current actions, which includes things like determining how much it should move each frame and if its walking or jumping
            do {
                previousPlayerState = playerState;
                handlePlayerState();
            } while (previousPlayerState != playerState);

            // move player with respect to map collisions based on how much player needs to move this frame
            lastAmountMovedY = super.moveYHandleCollision(moveAmountY);
            lastAmountMovedX = super.moveXHandleCollision(moveAmountX);
        }

        handlePlayerAnimation();

        updateLockedKeys();

        // update player's animation
        super.update();
    }
    public boolean isInventoryKeyPressed() {
        return Keyboard.isKeyDown(INVENTORY);
    }

    // based on player's current state, call appropriate player state handling method
    protected void handlePlayerState() {
        switch (playerState) {
            case STANDING:
                playerStanding();
                break;
            case WALKING:
                playerWalking();
                break;
        }
    }
   

        
    


    // player STANDING state logic
    protected void playerStanding() {
        if (!keyLocker.isKeyLocked(INTERACT_KEY) && Keyboard.isKeyDown(INTERACT_KEY)) {
            keyLocker.lockKey(INTERACT_KEY);
            map.entityInteract(this);
        }

        // if a walk key is pressed, player enters WALKING state
        if (Keyboard.isKeyDown(MOVE_LEFT_KEY) || Keyboard.isKeyDown(MOVE_RIGHT_KEY) || Keyboard.isKeyDown(MOVE_UP_KEY) || Keyboard.isKeyDown(MOVE_DOWN_KEY)) {
            playerState = PlayerState.WALKING;
        }

        
    }


    // player WALKING state logic
    protected void playerWalking() {
        if (!keyLocker.isKeyLocked(INTERACT_KEY) && Keyboard.isKeyDown(INTERACT_KEY)) {
            keyLocker.lockKey(INTERACT_KEY);
            map.entityInteract(this);
        }

        // if walk left key is pressed, move player to the left
        if (Keyboard.isKeyDown(MOVE_LEFT_KEY)) {
            moveAmountX -= walkSpeed;
            facingDirection = Direction.LEFT;
            currentWalkingXDirection = Direction.LEFT;
            lastWalkingXDirection = Direction.LEFT;
        }
        
        // if walk right key is pressed, move player to the right
        else if (Keyboard.isKeyDown(MOVE_RIGHT_KEY)) {
            moveAmountX += walkSpeed;
            facingDirection = Direction.RIGHT;
            currentWalkingXDirection = Direction.RIGHT;
            lastWalkingXDirection = Direction.RIGHT;
        }
        else {
            currentWalkingXDirection = Direction.NONE;
        }

        if (Keyboard.isKeyDown(MOVE_UP_KEY)) {
            moveAmountY -= walkSpeed;
            currentWalkingYDirection = Direction.UP;
            lastWalkingYDirection = Direction.UP;
        }
        else if (Keyboard.isKeyDown(MOVE_DOWN_KEY)) {
            moveAmountY += walkSpeed;
            currentWalkingYDirection = Direction.DOWN;
            lastWalkingYDirection = Direction.DOWN;
        }
        else {
            currentWalkingYDirection = Direction.NONE;
        }

        if ((currentWalkingXDirection == Direction.RIGHT || currentWalkingXDirection == Direction.LEFT) && currentWalkingYDirection == Direction.NONE) {
            lastWalkingYDirection = Direction.NONE;
        }

        if ((currentWalkingYDirection == Direction.UP || currentWalkingYDirection == Direction.DOWN) && currentWalkingXDirection == Direction.NONE) {
            lastWalkingXDirection = Direction.NONE;
        }

        if (Keyboard.isKeyUp(MOVE_LEFT_KEY) && Keyboard.isKeyUp(MOVE_RIGHT_KEY) && Keyboard.isKeyUp(MOVE_UP_KEY) && Keyboard.isKeyUp(MOVE_DOWN_KEY)) {
            playerState = PlayerState.STANDING;
        }
    }
    public void initializeInventory() {
        inventoryList = new Items[15]; 
    }
    public Items[] getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(Items[] inventoryList) {
        this.inventoryList = inventoryList;
    }

    public boolean addToInventory(Items item){
        for (int i = 0; i < inventoryList.length; i++) {
            if (inventoryList[i] == null) { // Check if the slot is null and not
                inventoryList[i] = item; 
                System.out.println("Item picked up and placed at index: " + i);
                return true;
            }

        }
        System.out.println("Inventory is full!");
        return false;
    }
   

    protected void updateLockedKeys() {
        if (Keyboard.isKeyUp(INTERACT_KEY) && !isLocked) {
            keyLocker.unlockKey(INTERACT_KEY);
        }
    
        if (Keyboard.isKeyUp(INVENTORY)) {
            keyLocker.unlockKey(INVENTORY); 
        }
    }

    // anything extra the player should do based on interactions can be handled here
    protected void handlePlayerAnimation() {
        if (playerState == PlayerState.STANDING) {
            // sets animation to a STAND animation based on which way player is facing
            this.currentAnimationName = facingDirection == Direction.RIGHT ? "STAND_RIGHT" : "STAND_LEFT";
        }
        else if (playerState == PlayerState.WALKING) {
            // sets animation to a WALK animation based on which way player is facing
            this.currentAnimationName = facingDirection == Direction.RIGHT ? "WALK_RIGHT" : "WALK_LEFT";
        }
    }

    @Override
    public void onEndCollisionCheckX(boolean hasCollided, Direction direction, GameObject entityCollidedWith) { }

    @Override
    public void onEndCollisionCheckY(boolean hasCollided, Direction direction, GameObject entityCollidedWith) { }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    // returns player's coin count
    public int getCoinCount(){
        return this.coinCount;
    }

    // changes player's coin count
    public void setCoinCount(int coinCount){
        this.coinCount = coinCount;
    }

    public void inventory(){
        
    }

    public Rectangle getInteractionRange() {
        return new Rectangle(
                getBounds().getX1() - interactionRange,
                getBounds().getY1() - interactionRange,
                getBounds().getWidth() + (interactionRange * 2),
                getBounds().getHeight() + (interactionRange * 2));
    }

    public Key getInteractKey() { return INTERACT_KEY; }
    public Direction getCurrentWalkingXDirection() { return currentWalkingXDirection; }
    public Direction getCurrentWalkingYDirection() { return currentWalkingYDirection; }
    public Direction getLastWalkingXDirection() { return lastWalkingXDirection; }
    public Direction getLastWalkingYDirection() { return lastWalkingYDirection; }

    
    public void lock() {
        isLocked = true;
        playerState = PlayerState.STANDING;
        this.currentAnimationName = facingDirection == Direction.RIGHT ? "STAND_RIGHT" : "STAND_LEFT";
    }

    public void unlock() {
        isLocked = false;
        playerState = PlayerState.STANDING;
        this.currentAnimationName = facingDirection == Direction.RIGHT ? "STAND_RIGHT" : "STAND_LEFT";
    }

    // used by other files or scripts to force player to stand
    public void stand(Direction direction) {
        playerState = PlayerState.STANDING;
        facingDirection = direction;
        if (direction == Direction.RIGHT) {
            this.currentAnimationName = "STAND_RIGHT";
        }
        else if (direction == Direction.LEFT) {
            this.currentAnimationName = "STAND_LEFT";
        }
    }

    // used by other files or scripts to force player to walk
    public void walk(Direction direction, float speed) {
        playerState = PlayerState.WALKING;
        facingDirection = direction;
        if (direction == Direction.RIGHT) {
            this.currentAnimationName = "WALK_RIGHT";
        }
        else if (direction == Direction.LEFT) {
            this.currentAnimationName = "WALK_LEFT";
        }
        if (direction == Direction.UP) {
            moveY(-speed);
        }
        else if (direction == Direction.DOWN) {
            moveY(speed);
        }
        else if (direction == Direction.LEFT) {
            moveX(-speed);
        }
        else if (direction == Direction.RIGHT) {
            moveX(speed);
        }
    }

    //Make the player take damage
    public void takeDamage(int damage){
        if(hasDefenseBuff){
            damage *= 0.9;
        }
        this.health -= damage;
        if(damage >= health){
            isDead = true;
            health = 0;
        }
        this.hasDefenseBuff = false;
    }

    public int attack(){
        int cc = random.nextInt(101);
        justCrit = false;
        critBucket += 10;
        if(cc <= critChance + ((critBucket / 50) * 2)){
            justCrit = true;
            return 20;
        }else{
            return 10;
        }
    }

    public boolean lastAttackWasCrit(){
        if(justCrit){
            return true;
        }else{
            return false;
        }
    }
    
    public void heal(int healValue){
        this.health += healValue;
        if(health >= 100){
            health = 100;
        }
        if(this.isDead){
            this.isDead = false;
        }
    }

    public void setHealth(int newHealth){
        this.health = newHealth;
    }

    public int getHealth(){
        return this.health;
    }

    public int getMaxHealth(){
        return this.maxHealth;
    }

    public boolean isDead(){
        return isDead;
    }


    // health potion
    public void addHealthPot(){
        // increments number of health potions
        this.potions[HEALTH_POT]++;
    }

    public void useHealthPot(){
        // could be any amount
        if(this.potions[HEALTH_POT] >= 0){
            // heals an amount and decrements the count
            heal(15);
            this.potions[HEALTH_POT]--;
        }
        
    }

    public int healthPotCount(){
        // returns health potion count
        return this.potions[HEALTH_POT];
    }


    // damage potion
    public void addDamagePot(){
        // increments number of damage potions
        this.potions[DAMAGE_POT]++;
    }

    public void useDamagePot(){
        if(this.potions[DAMAGE_POT] >= 0){
            // unsure on this implementation for now, at least until battle screen is fleshed out
            this.hasDamageBuff = true;
            this.potions[DAMAGE_POT]--;
        }
    }

    public int damagePotCount(){
        // returns damage potion count
        return this.potions[DAMAGE_POT];
    }


    // defense potion
    public void addDefensePot(){
        // increments number of defense potions
        this.potions[DEFENSE_POT]++;
    }

    public void useDefensePot(){
        if(this.potions[DEFENSE_POT] >= 0){
            // next damage taken will be decreased and then the boolean is unset after that damage goes through
            this.hasDefenseBuff = true;
            this.potions[DEFENSE_POT]--;
        }
    }

    public int defensePotCount(){
        // returns defense potion count 
        return this.potions[DEFENSE_POT];
    }

    public void setMaxHealth(int health){
        this.health = health;
        this.maxHealth = health;
    }

    public void setCritChance(int cc){
        this.critChance = cc;
    }

    public boolean hasAttackBuff(){
        if(this.hasDamageBuff){
            return true;
        }else{
            return false;
        }
    }

    public boolean hasDefenseBuff(){
        if(this.hasDefenseBuff){
            return true;
        }else{
            return false;
        }
    }

    public void removeBuffs(){
        this.hasDamageBuff = false;
        this.hasDefenseBuff = false;
    }

    public void emptyCritBucket(){
        this.critBucket = 0;
    }

    // Uncomment this to have game draw player's bounds to make it easier to visualize
    /*
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        drawBounds(graphicsHandler, new Color(255, 0, 0, 100));
    }
    */
}
