package Maps;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.ImageEffect;
import GameObject.Sprite;
import Level.Map;
import Tilesets.CommonTileset;
import Utils.Colors;
import Utils.Point;

// Represents the map that is used as a background for the main menu and credits menu screen
public class FightMap extends Map {

    private Sprite cat;
    private Sprite enemy;
    private String enemySprite;

    public FightMap() {
        super("fight_map.txt", new CommonTileset());
        Point catLocation = getMapTile(7, 7).getLocation().subtractX(0).subtractY(7);
        Point enemyLocation = getMapTile(21, 7).getLocation().subtractX(15).subtractY(7);
        cat = new Sprite(ImageLoader.loadSubImage("Assassin.png", Colors.MAGENTA, 0, 0, 24, 24));
        cat.setScale(3);
        cat.setLocation(catLocation.x, catLocation.y);

        this.enemySprite = "error.png";
        enemy = new Sprite(ImageLoader.loadSubImage(enemySprite, Colors.MAGENTA, 0, 0, 24, 24));
        enemy.setScale(3);
        enemy.setLocation(enemyLocation.x, enemyLocation.y);
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        cat.draw(graphicsHandler);
        enemy.draw(graphicsHandler);
    }

    public void flipPlayer(){
        cat.setImageEffect(ImageEffect.FLIP_VERTICAL);
    }

    public void flipEnemy(){
        enemy.setImageEffect(ImageEffect.FLIP_H_AND_V);
    }

    public void rightSprites(){
        if(cat.getImageEffect() == ImageEffect.FLIP_VERTICAL){
            cat.setImageEffect(ImageEffect.NONE);
        }
        if(enemy.getImageEffect() == ImageEffect.FLIP_H_AND_V){
            enemy.setImageEffect(ImageEffect.FLIP_HORIZONTAL);
        }
    }

    public void setEnemySprite(String sprite){
        this.enemySprite = sprite;
        enemy = new Sprite(ImageLoader.loadSubImage(enemySprite, Colors.MAGENTA, 0, 0, 24, 24));
        Point enemyLocation = getMapTile(21, 7).getLocation().subtractX(6).subtractY(7);
        enemy.setScale(3);
        enemy.setLocation(enemyLocation.x, enemyLocation.y);
        enemy.setImageEffect(ImageEffect.FLIP_HORIZONTAL);
    }

    public String getEnemySprite(){
        return this.enemySprite;
    }
}
