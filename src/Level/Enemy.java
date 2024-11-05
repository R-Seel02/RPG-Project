package Level;

import java.util.Random;

public class Enemy {
    protected int currentHealth, maxHealth;
    protected int baseDamage, spread;
    protected String sprite;
    protected String name;
    protected boolean isDead;
    protected Random random;
    protected int randomSpread;
    protected int randomNum;
    
    public Enemy(String name, int maxHealth, int damage, int spread, String sprite){
        this.maxHealth = maxHealth;
        this.spread = spread;
        this.currentHealth = maxHealth;
        this.baseDamage = damage;
        this.sprite = sprite;
        this.name = name;
        this.isDead = false;
        this.randomNum = 0;
        this.randomSpread = 0;
        this.random = new Random();
    }

    public String getName(){
        return this.name;
    }

    public String getSprite(){
        return this.sprite;
    }

    public int getCurrentHealth(){
        return this.currentHealth;
    }

    public int getDamage(){
        return this.baseDamage;
    }

    public int getSpread(){
        return this.spread;
    }

    public int getMaxHealth(){
        return this.maxHealth;
    }

    public boolean isDead(){
        return this.isDead;
    }
    
    public void takeDamage(int damage){
        this.currentHealth -= damage;
        if(this.currentHealth <= 0){
            this.currentHealth = 0;
            this.isDead = true;
        }
    }

    public void heal(int health){
        this.currentHealth += health;
        if(this.currentHealth >= this.maxHealth){
            this.currentHealth = this.maxHealth;
        }
    }

    public int attack(){
        int damSpread = random.nextInt(spread + 1); //generates a random number between 0 (inclusive) and the health of the enemy (inclusive)
        int dam = 0; //initializes a counter for damage
        randomNum = random.nextInt(2); //generates a random number, 0 or 1
        if(randomNum == 0){ //if the number is 0, the damage spread is added
            dam = baseDamage + damSpread;
        }else{ //if the number is 1, the damage spread is subtracted
            dam = baseDamage - damSpread;
        }
        if(dam < 0){ //ensures the enemy doesn't deal negative damage, which would heal the player
            dam = 0;
        }
        return dam; //returns the damage
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || this.getClass() != o.getClass()){
            return false;
        }
        Enemy otherEnemy = (Enemy) o;
        if(!this.name.equals(otherEnemy.getName())){
            return false;
        }else if(this.maxHealth != otherEnemy.getMaxHealth()){
            return false;
        }else if(this.baseDamage != otherEnemy.getDamage()){
            return false;
        }else if(this.spread != otherEnemy.getSpread()){
            return false;
        }else if(!this.sprite.equals(otherEnemy.getSprite())){
            return false;
        }
        return true;
    }
}
