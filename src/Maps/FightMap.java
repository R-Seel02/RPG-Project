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

    public FightMap(String enemySprite) {
        super("title_screen_map.txt", new CommonTileset());
        Point catLocation = getMapTile(19, 5).getLocation().subtractX(6).subtractY(7);
        Point enemyLocation = getMapTile(15, 5).getLocation().subtractX(6).subtractY(7);
        cat = new Sprite(ImageLoader.loadSubImage("Cat.png", Colors.MAGENTA, 0, 0, 24, 24));
        cat.setScale(3);
        cat.setImageEffect(ImageEffect.FLIP_HORIZONTAL);
        cat.setLocation(catLocation.x, catLocation.y);
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
        enemy.setImageEffect(ImageEffect.FLIP_VERTICAL);
    }

    public void rightSprites(){
        if(cat.getImageEffect() == ImageEffect.FLIP_VERTICAL){
            cat.setImageEffect(ImageEffect.FLIP_HORIZONTAL);
        }
        if(enemy.getImageEffect() == ImageEffect.FLIP_VERTICAL){
            enemy.setImageEffect(ImageEffect.NONE);
        }
    }
}
