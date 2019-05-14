# orc-extractor-clojure
Extract wave, midi and other data from orc-files (Voyetra Digital Orchestrator). This is a re-implementation of the unfinished Phyton-project [orc-extractor](https://github.com/Brygghuset/orc-extractor).

## File Description
All ORC files have the same format as RMI, but with some differences:
* ORC files don't use DLS sample banks.
* There is only one WAV track with all digital audio samples.
* Sample playback is controlled by Sequencer-Specific events in the MIDI sequence and by "voyl" chunk in the WAV track.

### RIFF Tree Structure
~~~
File Root
│
├─ RIFF:RMID     - RIFF MIDI header
│  └─ data       - MIDI data chunk
│
└─ RIFF:WAVE     - RIFF Wave header
   ├─ fmt        - Wave format chunk
   ├─ voyl       - Voyetra special chunk
   └─ data       - Waveform data chunk
~~~

## MIDI
* All MIDI files begin with "MThd" which is the start of the MIDI header. There may also be sub-headers in the MIDI file. Inside each header there will be a "MTrk" which signifies the beginning of a track. Type-0 MIDI files only have 1 track, but type-1 files may contain multiple tracks.
* All properly formatted MIDI files should end with same three bytes, 0xFF 0x2F 0x00.
* MIDI can have a minimum tempo of 16 BPM and a maximum of 500 BPM.

## Resources
* http://www.vgmpf.com/Wiki/index.php?title=ORC
* http://www.vgmpf.com/Wiki/index.php?title=RMI
* http://www.vgmpf.com/Wiki/index.php?title=MIDI
* http://www.vgmpf.com/Wiki/index.php?title=Digital_Orchestrator_Pro
* RIFF explained - http://www.tactilemedia.com/info/MCI_Control_Info.html
* http://soundfile.sapp.org/doc/WaveFormat/
* http://www.music.mcgill.ca/~ich/classes/mumt306/StandardMIDIfileformat.html
