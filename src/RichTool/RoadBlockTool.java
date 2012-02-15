package RichTool;

import RichPlayer.RichPlayer;

public class RoadBlockTool extends RichDeferredTool {
    public String display() {
        return "#";
    }

    public int getPoints() {
        return 50;
    }

    public String getName() {
        return "路障";
    }

    public boolean isSameTool(RichTool tool) {
        return tool instanceof RoadBlockTool;
    }

    public void triggerTool(RichPlayer player) {
        player.setRemainStep(0);
    }
}
