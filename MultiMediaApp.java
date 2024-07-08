//Structural Design Pattern -> Adapter Design Pattern, Composite Design Pattern, Decorator Design pattern

/*
 * Problem statement:
 * We are developing a multimedia streaming application that supports various types of media,
 * including images, videos, audio tracks
 * The application needs to handle the different media formats, provide efficient storage and 
 * enable seamless playback for users.
 * To achieve this, we'll implement multiple structual design patterns to organize and manage
 * hte multimedia elements effectively.
 */

import java.util.ArrayList;
import java.util.List;

interface Media{
    void play();
}
class Video implements Media{
    private String fileName;
    public Video(String fileName){
        this.fileName=fileName;
    }
    @Override
    public void play(){
        System.out.println("Video is playing "+this.fileName);
    }
}
class Audio implements Media{
    private String fileName;
    public Audio(String fileName){
        this.fileName=fileName;
    }
    @Override
    public void play(){
        System.out.println("Audio is playing "+this.fileName);
    }
}
class Image{
    private String fileName;
    public Image(String fileName){
        this.fileName=fileName;
    }
    public void display(){
        System.out.println("Displaying Image: "+this.fileName);
    }
}
//Adapter Design Pattern
class Adapter implements Media{
    private Image image;
    public Adapter(Image image){
        this.image=image;
    }
    @Override
    public void play(){
        this.image.display();
    }
}
//Decortor Design Pattern
abstract class MediaDecorator implements Media{
    private Media decoratorMedia;
    public MediaDecorator(Media decoratorMedia){
        this.decoratorMedia=decoratorMedia;
    }
    @Override
    public void play(){
        this.decoratorMedia.play();
    }
}
class HighQualityMediaDecorator extends MediaDecorator{
    public HighQualityMediaDecorator(Media decoratorMedia){
        super(decoratorMedia);
    }
    public void play(){
        super.play();
        System.out.println("Enhahncing the playback quality");
    }
}
//Composite Design Pattern
class MediaCollection implements Media{
    private List<Media> mediaList=new ArrayList<>();
    public MediaCollection(List<Media> mediaList){
        this.mediaList=mediaList;
    }
    @Override
    public void play(){
        for(Media media:mediaList){
            media.play();
        }
    }
    public void addMedia(Media media){
        mediaList.add(media);
    }
}
public class MultiMediaApp {
    public static void main(String[] args) {
        Media video=new Video("movie.mp4");
        Media audio=new Audio("song.mp3");
        Image img=new Image("picture.jpg");
        Media image=new Adapter(img);

        Media highQualityAudio=new HighQualityMediaDecorator(audio);

        MediaCollection allMedia=new MediaCollection(new ArrayList<>());

        allMedia.addMedia(video);
        allMedia.addMedia(highQualityAudio);
        allMedia.addMedia(image);

        allMedia.play();
    }
}
