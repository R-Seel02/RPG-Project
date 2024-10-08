package ScriptActions;

import Level.ScriptState;

public class AddCoin extends ScriptAction {
    protected String flagName;

    public AddCoin(String flagName) {
        this.flagName = flagName;
    }


    @Override
    public ScriptState execute() {
        if (this.map.getFlagManager().getFlag(flagName)) {
            player.setCoinCount(player.getCoinCount() + 1);
        }
        return ScriptState.COMPLETED;
    }


}
