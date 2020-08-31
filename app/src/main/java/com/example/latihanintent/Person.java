package com.example.latihanintent;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    public String Name;
    public int age;
    public String Email;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String city;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Name);
        dest.writeInt(this.age);
        dest.writeString(this.Email);
        dest.writeString(this.city);
    }

    public Person() {
    }

    protected Person(Parcel in) {
        this.Name = in.readString();
        this.age = in.readInt();
        this.Email = in.readString();
        this.city = in.readString();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
