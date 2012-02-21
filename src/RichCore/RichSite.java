package RichCore;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

public abstract class RichSite {
    protected final BufferedReader _inputReader;
    protected final PrintStream _outputWriter;

    private RichDeferredTool _tool;
    private final ArrayList<RichPlayer> _players;

    protected RichSite(BufferedReader reader, PrintStream writer) {
        _players = new ArrayList<RichPlayer>();
        _tool = null;
        _inputReader = reader;
        _outputWriter = writer;
    }

    public void acceptPlayer(RichPlayer player) {
        if (!player.isPunished()) {
            addPlayer(player);
            doAcceptPlayer(player);
        }
    }

    protected abstract void doAcceptPlayer(RichPlayer player);

    protected abstract String doDisplay();

    public String display() {
        if (hasDeferredToolInstalled()) return _tool.display();
        if (hasPlayerStand()) return getLastPlayer().display();
        return doDisplay();
    }

    private RichPlayer getLastPlayer() {
        return _players.get(_players.size() - 1);
    }

    public boolean installDeferredTool(RichDeferredTool tool) {
        if (hasDeferredToolInstalled()) return false;
        if (hasPlayerStand()) return false;
        _tool = tool;
        return true;
    }

    public boolean hasPlayerStand() {
        for (RichPlayer player : _players) {
            if (!player.isPunished()) {
                return true;
            }
        }
        return false;
    }

    public void removeDeferredTool() {
        _tool = null;
    }

    public void acceptPassenger(RichPlayer player) {
        if (hasDeferredToolInstalled()) {
            _tool.triggerTool(player);
            removeDeferredTool();
        }
    }

    public boolean hasDeferredToolInstalled() {
        return _tool != null;
    }

    public void addPlayer(RichPlayer player) {
        _players.add(player);
    }

    public void removePlayer(RichPlayer player) {
        _players.remove(player);
    }


}
