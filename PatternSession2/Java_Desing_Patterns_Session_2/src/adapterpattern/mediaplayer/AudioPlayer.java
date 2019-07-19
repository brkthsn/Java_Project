package adapterpattern.mediaplayer;

public class AudioPlayer implements MediaPlayer {

	   MediaAdapter adapter;


	   public AudioPlayer() {
	   }

	   public AudioPlayer(String extension) {
	      adapter = new MediaAdapter(extension);
	   }

	   @Override
	   public void play(String music) {
	      if (MediaFormatDedector.verifyMediaFormat(".mp3", music)) {
	         System.out.println(music + " is running as mp3 format");
	      }

	      else {
	         try {
	            adapter.play(music);
	         }
	         catch (NullPointerException npe) {
	            System.err.println("The adapter is not active");
	         }
	      }

	   }
	}