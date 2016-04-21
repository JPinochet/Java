<<<<<<< HEAD
/**
 * 
 */
package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.*;
/**
  *
  *
  * This is the contract specification for a musical pitch or note.
  * A pitch can be completely specified as one of the following:
  * 1. A number of cycles per second or
  * 2. The number of half steps above a commonly agreed upon pitch
  *    (concert pitch=440Hz = A = MIDI69) or
  * 3. The common music note name (C, D, E, F, G, A, B) with the
  *    the suffix indicating the octave number [-1,9] and an additional
  *    suffix prefix '#' for sharp notes and 'b' for flat notes or
  * 4. The MIDI absolute note number [0,127] where 60 is middle C.
  *
  * Higher pitches have higher frequencies. Two pitches are an octave apart
  * (12 semitones) if one frequency is twice the other. A semitone is
  * aproximately an increase in pitch of 1.06 times higher.
  */

public abstract class NoteADT implements Comparable<NoteADT>
{
	protected int midiNoteValue = -1;
	
	/**
	 * A semitone is aproximately an increase in pitch of 1.06 times higher.
	 */
	public static final double SEMI_TONE_INCREASE_IN_PITCH = Math.pow(2.0,1.0/12.0);
	/**
	 * The agreed upon pitch "modern concert pitch"
	 */
	public static final double HZ_CONCERT_PITCH = 440.0; //Hz
	public static final int    MIDI_CONCERT_PITCH = 69;
  
	/**
	 * The high and low limits on the range of midi numbers.
	 */
	public static final int    LOW_MIDI_ABSOLUTE_NUMBER = 0;
	public static final int    HIGH_MIDI_ABSOLUTE_NUMBER = 127;
	
	@SuppressWarnings("unused")
	private int 					midiValue;

  
	/**
	 * The constructors for a note accept a frequency as a double for Hz or
	 * a number of semitones as an int above or below the concert pitch (440Hz)
	 * or a music note as a String such as C#4 
	 * Imperfect frequencies are tuned to the nearest half pitch and if a frequency
	 * or semitones pushes the note midi value to greater than 127 and less than 0
	 * the note midi values are set at 127 or 0 respectively.
	 */
	public NoteADT(double frequency)
	{		
		int testMIDIValue = ((int) Math.round(12*(Math.log(frequency/HZ_CONCERT_PITCH)/Math.log(2)) + MIDI_CONCERT_PITCH));
		if(testMIDIValue <= 127 || testMIDIValue >= 0)
		{
			this.midiNoteValue = testMIDIValue;
		}
		if(this.midiNoteValue > 127)
		{
			this.midiNoteValue = 127;
		}
		if (this.midiNoteValue < 0)
		{
			this.midiNoteValue = 0;
		}
	}
	
	public NoteADT(int semitones)
	{
		int testMIDIValue = semitones + MIDI_CONCERT_PITCH;
		
		if(testMIDIValue <= 127 || testMIDIValue >= 0)
		{
			this.midiNoteValue = testMIDIValue;
		}
		if(this.midiNoteValue > 127)
		{
			this.midiNoteValue = 127;
		}
		if (this.midiNoteValue < 0)
		{
			this.midiNoteValue = 0;
		}
	}

	public NoteADT(String strNote) throws InvalidNoteStringException
	{
		Pattern note = Pattern.compile("^[A-Ga-g]");
		Matcher matchNote = note.matcher(strNote);
		
		if(matchNote.find())
		{
			strNote = strNote.substring(matchNote.end());
			char found = strNote.toUpperCase().charAt(0);
			
			switch (found)
			{
				case 'A': this.midiNoteValue = 9; break;
				case 'B': this.midiNoteValue = 11; break;
				case 'C': this.midiNoteValue = 0; break;
				case 'D': this.midiNoteValue = 2; break;
				case 'E': this.midiNoteValue = 4; break;
				case 'F': this.midiNoteValue = 5; break;
				case 'G': this.midiNoteValue = 7; break;
			}
			
			Pattern modifier = Pattern.compile("[#b]");
			Matcher matchModifier = modifier.matcher(strNote);
			if(matchModifier.find())
			{
				found = strNote.toLowerCase().charAt(0);
				
				switch (found)
				{
					case 'b' : this.midiNoteValue= this.midiNoteValue - 1; break; 
					case '#' : this.midiNoteValue= this.midiNoteValue - 1; break; 
				}
				
				Pattern octave = Pattern.compile("[-1]?[0-9]$");
				Matcher matchOctave = octave.matcher(strNote);
				if(matchOctave.find())
				{
					String foundOctave = matchOctave.group();
					int foundOctave2 = Integer.parseInt(foundOctave);
					
					for(int i = 0; i <= foundOctave2; i++)
					{
						this.midiNoteValue = this.midiNoteValue + 12;
					}
				}
			}
		}
		else
		{
			throw new InvalidNoteStringException("Invalid note");
		}
		if(this.midiNoteValue > 127)
		{
			this.midiNoteValue = 127;
		}
		if (this.midiNoteValue < 0)
		{
			this.midiNoteValue = 0;
		}
	}

	/**
	 * Returns the frequency of this note in cycles per second- Hertz (Hz)
	 * 
	 * Preconditions: A valid internal reference number exists for a note
	 * and the numbers range from 0 (C-1) to 127 (G9).
	 * 
	 * Postconditions: The internal reference number is successfully converted
	 * to a frequency in hertz and returned to the calling function.
	 * 
	 * @return double The frequency in Hz.
	 */
	public abstract double getFrequencyInHz();

	/**
	 * Returns the frequency of this note in semitones (half steps) above or below
	 * the concert pitch (440Hz).
	 * 
	 * Preconditions: A valid internal reference number exists for a note
	 * and the numbers range from 0 (C-1) to 127 (G9).
	 * 
	 * Postconditions: The internal reference number is successfully converted
	 * to number of half steps or semitones above or below concert pitch (69)
	 * and returned to the calling function.
	 * 
	 * @return int The frequency in Semitones or half steps
	 */
	public abstract int getHalfSteps();

	/**
	 * Returns the frequency of this note as a MIDI absolute Number.
	 * 
	 * Preconditions: A valid internal reference number exists for a note
	 * and the numbers range from 0 (C-1) to 127 (G9).
	 * 
	 * Postconditions: The internal reference number is successfully returned
	 * as the MIDI absolute Number to the calling function.
	 *   
	 * @return int The frequency MIDI absolute Number
	 */
	public abstract int getMIDIAbsoluteNumber();

	/**
	 * Method compares if this note is 12 semitones above or 
	 * 12 semitones below the other note, then the notes form an octave.
	 *  
	 * Preconditions: A valid internal reference number exists and the note
	 * passed into the method is a valid Note.
	 * 
	 * Postconditions: An octave is formed if the note passed in is exactly
	 * 12 semitones above or below the internal reference MIDI absolute number.
	 * If the difference is + or - 12 semitones then a boolean true is returned
	 * otherwise a boolean false is returned.
	 * 
	 * @param note The note that can form an Octave
	 * @return boolean true if they do form an octave
	 */
	public abstract boolean formOctave(NoteADT note) throws IllegalArgumentException;

	/**
	 * Raise or lower the pitch by any number of semitones.
	 * 
	 * Preconditions: A valid internal reference number exists for a note
	 * and the numbers range from 0 (C-1) to 127 (G9).
	 * 
	 * Postconditions: The internal reference MIDI absolute number is
	 * increased or decreased by the amount of the semitones passed into
	 * the method. If the internal note is raised above 127 set midi value
	 * to 127 and if the internal note is lowered below 0 set midi value 0.
	 * 
	 * @param semitone Change int used to calculate the new note
	 *
	 * @throws IllegalArgumentException if the internal note is raised above 
	 * 127 or if the internal note is lowered below 0 throw an IllegalArgumentException.
	 */
    public abstract void modifyNoteBySemitones(int numberOfSemitones);

    /**
     * The compareTo method will be implemented by the Comparable interface
     * it will adhere to the Comparable interface contract referenced in
     * the Java API - java.lang.*; and will have the following signature.
     * public int comparteTo(Object obj);.
     */
    public abstract int compareTo(NoteADT obj);


=======
/**
 * 
 */
package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.*;
/**
  *
  *
  * This is the contract specification for a musical pitch or note.
  * A pitch can be completely specified as one of the following:
  * 1. A number of cycles per second or
  * 2. The number of half steps above a commonly agreed upon pitch
  *    (concert pitch=440Hz = A = MIDI69) or
  * 3. The common music note name (C, D, E, F, G, A, B) with the
  *    the suffix indicating the octave number [-1,9] and an additional
  *    suffix prefix '#' for sharp notes and 'b' for flat notes or
  * 4. The MIDI absolute note number [0,127] where 60 is middle C.
  *
  * Higher pitches have higher frequencies. Two pitches are an octave apart
  * (12 semitones) if one frequency is twice the other. A semitone is
  * aproximately an increase in pitch of 1.06 times higher.
  */

public abstract class NoteADT implements Comparable<NoteADT>
{
	protected int midiNoteValue = -1;
	
	/**
	 * A semitone is aproximately an increase in pitch of 1.06 times higher.
	 */
	public static final double SEMI_TONE_INCREASE_IN_PITCH = Math.pow(2.0,1.0/12.0);
	/**
	 * The agreed upon pitch "modern concert pitch"
	 */
	public static final double HZ_CONCERT_PITCH = 440.0; //Hz
	public static final int    MIDI_CONCERT_PITCH = 69;
  
	/**
	 * The high and low limits on the range of midi numbers.
	 */
	public static final int    LOW_MIDI_ABSOLUTE_NUMBER = 0;
	public static final int    HIGH_MIDI_ABSOLUTE_NUMBER = 127;
	
	@SuppressWarnings("unused")
	private int 					midiValue;

  
	/**
	 * The constructors for a note accept a frequency as a double for Hz or
	 * a number of semitones as an int above or below the concert pitch (440Hz)
	 * or a music note as a String such as C#4 
	 * Imperfect frequencies are tuned to the nearest half pitch and if a frequency
	 * or semitones pushes the note midi value to greater than 127 and less than 0
	 * the note midi values are set at 127 or 0 respectively.
	 */
	public NoteADT(double frequency)
	{		
		int testMIDIValue = ((int) Math.round(12*(Math.log(frequency/HZ_CONCERT_PITCH)/Math.log(2)) + MIDI_CONCERT_PITCH));
		if(testMIDIValue <= 127 || testMIDIValue >= 0)
		{
			this.midiNoteValue = testMIDIValue;
		}
		if(this.midiNoteValue > 127)
		{
			this.midiNoteValue = 127;
		}
		if (this.midiNoteValue < 0)
		{
			this.midiNoteValue = 0;
		}
	}
	
	public NoteADT(int semitones)
	{
		int testMIDIValue = semitones + MIDI_CONCERT_PITCH;
		
		if(testMIDIValue <= 127 || testMIDIValue >= 0)
		{
			this.midiNoteValue = testMIDIValue;
		}
		if(this.midiNoteValue > 127)
		{
			this.midiNoteValue = 127;
		}
		if (this.midiNoteValue < 0)
		{
			this.midiNoteValue = 0;
		}
	}

	public NoteADT(String strNote) throws InvalidNoteStringException
	{
		Pattern note = Pattern.compile("^[A-Ga-g]");
		Matcher matchNote = note.matcher(strNote);
		
		if(matchNote.find())
		{
			strNote = strNote.substring(matchNote.end());
			char found = strNote.toUpperCase().charAt(0);
			
			switch (found)
			{
				case 'A': this.midiNoteValue = 9; break;
				case 'B': this.midiNoteValue = 11; break;
				case 'C': this.midiNoteValue = 0; break;
				case 'D': this.midiNoteValue = 2; break;
				case 'E': this.midiNoteValue = 4; break;
				case 'F': this.midiNoteValue = 5; break;
				case 'G': this.midiNoteValue = 7; break;
			}
			
			Pattern modifier = Pattern.compile("[#b]");
			Matcher matchModifier = modifier.matcher(strNote);
			if(matchModifier.find())
			{
				found = strNote.toLowerCase().charAt(0);
				
				switch (found)
				{
					case 'b' : this.midiNoteValue= this.midiNoteValue - 1; break; 
					case '#' : this.midiNoteValue= this.midiNoteValue - 1; break; 
				}
				
				Pattern octave = Pattern.compile("[-1]?[0-9]$");
				Matcher matchOctave = octave.matcher(strNote);
				if(matchOctave.find())
				{
					String foundOctave = matchOctave.group();
					int foundOctave2 = Integer.parseInt(foundOctave);
					
					for(int i = 0; i <= foundOctave2; i++)
					{
						this.midiNoteValue = this.midiNoteValue + 12;
					}
				}
			}
		}
		else
		{
			throw new InvalidNoteStringException("Invalid note");
		}
		if(this.midiNoteValue > 127)
		{
			this.midiNoteValue = 127;
		}
		if (this.midiNoteValue < 0)
		{
			this.midiNoteValue = 0;
		}
	}

	/**
	 * Returns the frequency of this note in cycles per second- Hertz (Hz)
	 * 
	 * Preconditions: A valid internal reference number exists for a note
	 * and the numbers range from 0 (C-1) to 127 (G9).
	 * 
	 * Postconditions: The internal reference number is successfully converted
	 * to a frequency in hertz and returned to the calling function.
	 * 
	 * @return double The frequency in Hz.
	 */
	public abstract double getFrequencyInHz();

	/**
	 * Returns the frequency of this note in semitones (half steps) above or below
	 * the concert pitch (440Hz).
	 * 
	 * Preconditions: A valid internal reference number exists for a note
	 * and the numbers range from 0 (C-1) to 127 (G9).
	 * 
	 * Postconditions: The internal reference number is successfully converted
	 * to number of half steps or semitones above or below concert pitch (69)
	 * and returned to the calling function.
	 * 
	 * @return int The frequency in Semitones or half steps
	 */
	public abstract int getHalfSteps();

	/**
	 * Returns the frequency of this note as a MIDI absolute Number.
	 * 
	 * Preconditions: A valid internal reference number exists for a note
	 * and the numbers range from 0 (C-1) to 127 (G9).
	 * 
	 * Postconditions: The internal reference number is successfully returned
	 * as the MIDI absolute Number to the calling function.
	 *   
	 * @return int The frequency MIDI absolute Number
	 */
	public abstract int getMIDIAbsoluteNumber();

	/**
	 * Method compares if this note is 12 semitones above or 
	 * 12 semitones below the other note, then the notes form an octave.
	 *  
	 * Preconditions: A valid internal reference number exists and the note
	 * passed into the method is a valid Note.
	 * 
	 * Postconditions: An octave is formed if the note passed in is exactly
	 * 12 semitones above or below the internal reference MIDI absolute number.
	 * If the difference is + or - 12 semitones then a boolean true is returned
	 * otherwise a boolean false is returned.
	 * 
	 * @param note The note that can form an Octave
	 * @return boolean true if they do form an octave
	 */
	public abstract boolean formOctave(NoteADT note) throws IllegalArgumentException;

	/**
	 * Raise or lower the pitch by any number of semitones.
	 * 
	 * Preconditions: A valid internal reference number exists for a note
	 * and the numbers range from 0 (C-1) to 127 (G9).
	 * 
	 * Postconditions: The internal reference MIDI absolute number is
	 * increased or decreased by the amount of the semitones passed into
	 * the method. If the internal note is raised above 127 set midi value
	 * to 127 and if the internal note is lowered below 0 set midi value 0.
	 * 
	 * @param semitone Change int used to calculate the new note
	 *
	 * @throws IllegalArgumentException if the internal note is raised above 
	 * 127 or if the internal note is lowered below 0 throw an IllegalArgumentException.
	 */
    public abstract void modifyNoteBySemitones(int numberOfSemitones);

    /**
     * The compareTo method will be implemented by the Comparable interface
     * it will adhere to the Comparable interface contract referenced in
     * the Java API - java.lang.*; and will have the following signature.
     * public int comparteTo(Object obj);.
     */
    public abstract int compareTo(NoteADT obj);


>>>>>>> origin/master
}