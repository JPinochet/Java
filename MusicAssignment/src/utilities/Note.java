package utilities;

import java.util.regex.*;

import exceptions.InvalidNoteStringException;

@SuppressWarnings("unused")
public class Note extends NoteADT
{	
	/**
	 * This constructor builds a Note with a given frequency, which then converts it into the proper MIDI value...I think.
	 * 
	 * @param frequency in hertz of desired musical note.
	 */
	public Note(double frequency)
	{
		super(frequency);
	}

	/**
	 * This constructor builds a Note given a semiTone, which is then converted into a frequency,followed into a MIDI value.
	 * Again this is all speculation, the math I found to convert musical pitches and octaves could be terriby wrong.
	 *  
	 * @param semitones of desired musical note.
	 */
	public Note(int semitones)
	{
		super(semitones);
	}

	/**
	 * Constructor takes in a note, breaks it apart and returns the appropriate 
	 * 
	 * @param strNote the actual musical note to play
	 * @throws InvalidNoteStringException
	 */
	public Note(String strNote) throws InvalidNoteStringException
	{
		super(strNote);
		
		
	}

	@Override
	/**
	 * Compares the MIDI value of the note to a note being passed in. 
	 * 
	 * @return 0 if the are equal, a number if they are not the same. Negative number means this Note has a greater MIDI value than the 
	 * one passed in. Positive number means this Note has a lesser MIDI value than the one passed in.
	 */
	public int compareTo(NoteADT obj)
	{
		return this.midiNoteValue - obj.midiNoteValue;
	}

	@Override
	/**
	 * Checks if the current Note and the Note object passed in can form an octave. To do this it retrieves the frequencies of both notes
	 * and compares if one is double or half the other.
	 * 
	 * @return true if they can, false otherwise
	 */
	public boolean formOctave(NoteADT note) throws IllegalArgumentException
	{
		if((this.getFrequencyInHz()/2 == note.getFrequencyInHz()) && (this.getFrequencyInHz()*2 == note.getFrequencyInHz()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	/**
	 * Getter for of the frequency. To do this simply reverse math the MIDI value to acquire the frequency.
	 * Always assuming of course the math to get the MIDI value was correct.
	 * 
	 * @return frequency in Hz
	 */
	public double getFrequencyInHz()
	{
		double reverseMIDI = HZ_CONCERT_PITCH*Math.pow(SEMI_TONE_INCREASE_IN_PITCH, ((double)this.midiNoteValue -(double)MIDI_CONCERT_PITCH));
		return reverseMIDI;
	}

	@Override
	/**
	 * Getter for of the HalfSteps. To do this simply reverse math the MIDI value to acquire the frequency.
	 * Always assuming of course the math to get the MIDI value was correct. 
	 */
	public int getHalfSteps()
	{
		int reverseMIDI = this.midiNoteValue - MIDI_CONCERT_PITCH;
		return reverseMIDI;
	}

	@Override
	/**
	 * Getter for the MIDI value, woo no calculations.
	 */
	public int getMIDIAbsoluteNumber()
	{
		return this.midiNoteValue;
	}

	@Override
	/**
	 * This method modifies a note by a number of Half Steps. 
	 */
	public void modifyNoteBySemitones(int numberOfSemitones)
	{
		this.midiNoteValue = this.midiNoteValue + numberOfSemitones;
		
		if(this.midiNoteValue > 127)
		{
			this.midiNoteValue = 127;
		}
		if (this.midiNoteValue < 0)
		{
			this.midiNoteValue = 0;
		}
	}
}
