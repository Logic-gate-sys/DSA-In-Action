package music_player;

public class Song {
    private String id;
    private String artist;
    private String title;
    private double duration;
    public Song(String id,String artist,String title,double duration){
        this.id=id;
        this.title=title;
        this.artist=artist;
        this.duration=duration;
    }

    // getter
    public String getartist(){
        return artist;
    }
    public String getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public double getDuration(){
        return duration;
    }
    // to String
    @Override 
    public String toString(){
        return id+" Title: "+title+" Artist: "+artist+"\n Duration " +duration +" mins";
    }
}
