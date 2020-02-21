package sequencer;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class MusicTest1 {

    public void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("Success");
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("Failed");
        }
    }

    public void nana() throws IllegalStateException {
        if (1 < 2) {
            throw new IllegalStateException("nanana");
        }
    }

    public static void main(String[] args) {
        MusicTest1 mt = new MusicTest1();
        mt.play();
    }

}
