package com.example.userinteraction.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Pair implements Parcelable {

    private int first;
    private int second;

    public Pair() {

    }

    protected Pair(Parcel in) {
        first = in.readInt();
        second = in.readInt();
    }

    public static final Creator<Pair> CREATOR = new Creator<Pair>() {
        @Override
        public Pair createFromParcel(Parcel in) {
            return new Pair(in);
        }

        @Override
        public Pair[] newArray(int size) {
            return new Pair[size];
        }
    };

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(first);
        dest.writeInt(second);
    }
}
