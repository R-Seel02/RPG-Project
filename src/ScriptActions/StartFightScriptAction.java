package ScriptActions;

import Level.ScriptState;

public class StartFightScriptAction extends ScriptAction {
    protected String spriteName;
    //protected Enemy enemy;

    public StartFightScriptAction(String spriteName) {
        this.spriteName = spriteName;
    }

    @Override
    public ScriptState execute() {
        this.map.setEnemySprite(spriteName);
        return ScriptState.COMPLETED;
    }
}
