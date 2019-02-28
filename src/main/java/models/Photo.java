package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Photo {

    private long id;
    private boolean orientation; // T -> H; F -> V
    private Set<String> tags;

    public Photo(long id, boolean orientation, Set<String> tags) {
        this.id = id;
        this.orientation = orientation;
        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isOrientation() {
        return orientation;
    }

    public void setOrientation(boolean orientation) {
        this.orientation = orientation;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public boolean addTag(String tag) {
        return this.tags.add(tag);
    }

    @Override
    public String toString() {
        return Long.toString(id);
    }
    public int CountMinimumCommonFactor(Photo photo, ArrayList<Photo> inputCollection){

        ArrayList<Photo> photoCollection = inputCollection;
        //remove the photo from the collection - we dont want it to compare to itself;
        photoCollection.remove(photo);

        int minimumCommonTagCount = 0;
        for (Photo collectionPhoto : photoCollection) {
            if (minimumCommonTagCount < CountCommonTags(photo, collectionPhoto)){
                minimumCommonTagCount = CountCommonTags(photo, collectionPhoto);
            }
        }
        return minimumCommonTagCount;
    }

    private int CountCommonTags(Photo photo1, Photo photo2){

        int currentMaximumCommonTagCount = 0;

        for (String tag1: photo1.getTags()) {
            int matches = 0;
            for (String tag2 : photo2.getTags()){
                if (tag1 == tag2){
                    matches += 1;
                }
            }
            if (currentMaximumCommonTagCount < matches) {
                currentMaximumCommonTagCount = matches;
            }
        }
        return currentMaximumCommonTagCount;
    }

    @Override
    public Photo clone() {
        return new Photo(this.id, this.orientation, new HashSet<>(this.tags));
    }
}
