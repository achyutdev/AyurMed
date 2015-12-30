package app.com.example.dev.weather;

import java.io.Serializable;

/**
 * Created by 984872 on 12/26/2015.
 */
public class SingleCategoryDesc implements Serializable {
    long itemId;
    String title;
    String desc;
    String numStars;
    String numCustReviews;
    String imgId;

    public SingleCategoryDesc() {}

    public SingleCategoryDesc(String title, String desc, String numStars, String numCustReviews, String imgId) {
        this.title = title;
        this.desc = desc;
        this.numStars = numStars;
        this.numCustReviews = numCustReviews;
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNumStars() {
        return numStars;
    }

    public void setNumStars(String numStars) {
        this.numStars = numStars;
    }

    public String getNumCustReviews() {
        return numCustReviews;
    }

    public void setNumCustReviews(String numCustReviews) {
        this.numCustReviews = numCustReviews;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getItemId() {
        return itemId;
    }

    @Override
    public String toString() {
        return "SingleCategoryDesc{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", numStars='" + numStars + '\'' +
                ", numCustReviews='" + numCustReviews + '\'' +
                ", imgId='" + imgId + '\'' +
                '}';
    }
}
