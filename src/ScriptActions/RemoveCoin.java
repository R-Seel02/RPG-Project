package ScriptActions;

import Level.ScriptState;

public class RemoveCoin extends ScriptAction{

    protected int answer;

    public RemoveCoin(int answer) {
        this.answer = answer;
    }


    @Override
    public ScriptState execute() {
        if (this.answer == 0) {
            if(player.getCoinCount() < 1){
                
            }
            player.setCoinCount(player.getCoinCount() - 1);
        }
        return ScriptState.COMPLETED;
    }

}
