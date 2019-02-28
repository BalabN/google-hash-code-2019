package models;

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
}
