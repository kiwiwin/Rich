package RichMap;

import RichPlayer.RichPlayer;

import java.io.BufferedReader;
import java.io.PrintStream;

public class RichMagicSite extends RichSite {
    public RichMagicSite(BufferedReader reader, PrintStream writer) {
        super(reader, writer);
    }

    public void doAcceptPlayer(RichPlayer richPlayer) {
    }

    public String display() {
        return "M";
    }
}
