package ScriptActions;

import Level.ScriptState;
import Level.Enemy;

public class StartFightScriptAction extends ScriptAction {
    //protected String spriteName; DEPRECATED -- use enemy instead
    protected Enemy enemy;

    public StartFightScriptAction(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public ScriptState execute() {
        this.map.setCurrentEnemy(enemy);
        return ScriptState.COMPLETED;
    }
}
