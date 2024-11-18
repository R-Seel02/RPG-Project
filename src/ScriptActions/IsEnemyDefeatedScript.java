package ScriptActions;

import java.util.ArrayList;

import Level.Enemy;
import Level.NPC;
import Level.Script;
import Level.ScriptState;

public class IsEnemyDefeatedScript extends ScriptAction{
    protected Enemy enemy;
    protected NPC npc;
    protected String flagName;

    public IsEnemyDefeatedScript(Enemy enemy, String flagName){
        this.enemy = enemy;
        this.flagName = flagName;
    }

    public ScriptState execute() {
        // System.out.println(this.map.getFlagManager().isFlagSet(flagName));
        // System.out.println(enemy.getCurrentHealth());
        if(enemy.isDead()){
            this.map.getFlagManager().setFlag(flagName);
            // System.out.println(this.map.getFlagManager().isFlagSet(flagName));
        }
        return ScriptState.COMPLETED;
    }
}
