package music_player;

public class MusicPlayer {
    public static void main(String[] args){
        SongList playlist = new SongList();

        // Create some sample songs
        Song song1 = new Song("S001", "Davido", "Unavailable", 3.2);
        Song song2 = new Song("S002", "Burna Boy", "Last Last", 2.9);
        Song song3 = new Song("S003", "Wizkid", "Essence", 3.5);
        Song song4 = new Song("S004", "Sarkodie", "Non-Living Thing", 3.0);
        Song song5 = new Song("S005", "Stonebwoy", "Into the Future", 3.1);

        // Add songs to the playlist
        playlist.add_first(song1);  // Front: S001
        playlist.add_last(song2);   // End: S002
        playlist.add_first(song3);  // New Front: S003
        playlist.add_last(song4);   // New End: S004

        // Display list forward
        playlist.displayForward();

        // Add song5 after S002
        System.out.println("\nAdding after S002:");
        playlist.add_after("S002", song5);
        playlist.displayForward();

        // Find a song
        System.out.println("\nFinding S003:");
        Song foundSong = playlist.find("S003");
        System.out.println("Found: " + foundSong);

        // Remove a song
        System.out.println("\nRemoving S001:");
        Song removed = playlist.remove("S001");
        System.out.println("Removed: " + removed);

        // Display list forward and backward
        System.out.println("\nUpdated Playlist (Forward):");
        playlist.displayForward();

        System.out.println("\nUpdated Playlist (Backward):");
        playlist.displayBackward();
    }
}
