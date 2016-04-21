/**
 * 
 */
package noteGeneration;

import javax.sound.midi.*;

/**
 * @author 432873
 *
 */
public class Piano
{
	/**
	 * Method plays a note.
	 */
	public void playNote()
    {
		Synthesizer synthesizer = null;
		try
		{
			synthesizer = MidiSystem.getSynthesizer();
			synthesizer.open();
		}
		catch(MidiUnavailableException mue)
		{
			mue.printStackTrace();
		}
		
		Instrument [] instruments = synthesizer.getDefaultSoundbank().getInstruments();
		synthesizer.loadInstrument(instruments[30]);
		MidiChannel [] channels = synthesizer.getChannels();
		channels[1].noteOn(30, 127);
		
		try
		{
			Thread.sleep(1500);
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		channels[1].noteOff(30,127);
    }
	
	/**
	 * Method plays a note.
	 */
	public void playNote(int absoluteMIDIValue, int number)
    {
		Synthesizer synthesizer = null;
		try
		{
			synthesizer = MidiSystem.getSynthesizer();
			synthesizer.open();
		}
		catch(MidiUnavailableException mue)
		{
			mue.printStackTrace();
		}
		
		Instrument [] instruments = synthesizer.getDefaultSoundbank().getInstruments();
		synthesizer.loadInstrument(instruments[30]);
		MidiChannel [] channels = synthesizer.getChannels();
		channels[1].noteOn(number, absoluteMIDIValue);
		
		
		try
		{
			Thread.sleep(1500);
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		channels[1].noteOff(number,absoluteMIDIValue);
    }
	
	public static void main(String [] args)
	{
		Piano p = new Piano();
		p.playNote();
		System.exit(0);
    }
}