package ScriptActions;

import Level.ScriptState;

public class AddCoin extends ScriptAction {
    protected String flagName;
    protected int coinAmount;

    public AddCoin(String flagName, int coinAmount ) {
        this.flagName = flagName;
        this.coinAmount = coinAmount;
    }


    @Override
    public ScriptState execute() {
        if (this.map.getFlagManager().getFlag(flagName)) {
            player.setCoinCount(player.getCoinCount() + coinAmount);
        }
        return ScriptState.COMPLETED;
    }


}
