package adapterpattern.mediaplayer;

public class Client {

	
	public static void main(String[] args) {
	      AudioPlayer mp3AudioPlayer = new AudioPlayer();
	      mp3AudioPlayer.play("50cent.mp3");
	      
	      AudioPlayer mp4AudioPlayer = new AudioPlayer(".mp4");
	      mp4AudioPlayer.play("50cent.mp4");
	      
	      AudioPlayer vlcAudioPlayer = new AudioPlayer(".vlc");
	      vlcAudioPlayer.play("50cent.vlc");
	      
	      // not play
	      vlcAudioPlayer.play("50cent.mp4");
	      
	      // not play
	      mp4AudioPlayer.play("50cent.vlc");
	      
	      // play because of it is a audio player
	      mp4AudioPlayer.play("50cent.mp3");
	      
	      // not play because of not active
	      mp3AudioPlayer.play("50cent.mp4");
	   }
}
