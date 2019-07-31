// IMattAidlInterface.aidl
package com.matt.mattdemo;

// Declare any non-default types here with import statements
import com.matt.mattdemo.Student;

interface IMattAidlInterface {

    void put(in String param);
    String get();
    Student getStudent();
}