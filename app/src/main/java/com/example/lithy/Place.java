package com.example.lithy;

import android.os.Parcel;
import android.os.Parcelable;

public class Place implements Parcelable {
    private String name;
    private String place;
    private String description;
    private String gps;
    private String web;
    private String img;

    public Place() {
    }

    public Place(String name, String place, String description, String gps, String web, String img) {
        this.name = name;
        this.place = place;
        this.description = description;
        this.gps = gps;
        this.web = web;
        this.img = img;
    }

    protected Place(Parcel in) {
        name = in.readString();
        place = in.readString();
        description = in.readString();
        gps = in.readString();
        web = in.readString();
        img = in.readString();
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(place);
        parcel.writeString(description);
        parcel.writeString(gps);
        parcel.writeString(web);
        parcel.writeString(img);
    }
}
