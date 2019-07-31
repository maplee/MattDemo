package com.matt.mattdemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author:Created by jiaguofeng on 2019/7/21.
 * Email:jiaguofeng@inno72.com
 */
public class Student implements Parcelable {

    private String id;
    private String name;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
    }

    public Student() {
    }

    protected Student(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}

