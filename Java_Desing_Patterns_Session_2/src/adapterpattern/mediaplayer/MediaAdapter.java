package adapterpattern.mediaplayer;

public class MediaAdapter implements MediaPlayer {

	   private AdvancedMediaPlayer amp;

	   public MediaAdapter(String extension) {
	      if (extension.equals(".mp4")) {
	         amp = new Mp4Player();
	      }
	      else if (extension.equals(".vlc")) {
	         amp = new VlcPlayer();
	      }
	      else {
	         System.err.println("invalid media format");
	      }
	   }

	   @Override
	   public void play(String music) throws NullPointerException {
	      amp.play(music);
	   }
	}