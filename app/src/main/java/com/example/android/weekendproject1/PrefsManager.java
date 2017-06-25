package com.example.android.weekendproject1;

import android.graphics.Bitmap;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v4.widget.DrawerLayout;

/**
 * Created by Android on 6/23/2017.
 */

public class PrefsManager {

    private static final String SECRET_MESSAGE_KEY = "Secret Message is";
    private static final String LOG_IN_NAME_KEY="Name is";
    private static final String LOG_IN_PASSWORD_KEY = "Password is";
    private static String PASSWORD ="";
    private static String LOG_IN_NAME="";
    private static final int MAX_PHOTOS = 32;
    private static Bitmap[] photos = new Bitmap[MAX_PHOTOS];
    private static int images =0;

    private static String LoggedInName ="";
    private static String LoggedInPassword ="";
    private static final String GET_IMAGE_KEY ="The Image is";

//    public static Image Get(){
//
//    }

    public static Bitmap GetPic(int i){
        return photos[i];
    }
    public static int GetPicAmount(){
        return images;
    }
    public static int GetMaxPics(){
        return MAX_PHOTOS;
    }

    public static  void SetPicAmount(int i){
        images += i;
    }
    public  static void SetPhoto(Bitmap p, int i){
        photos[i] = p;
    }

    public static String GetLogedInName(){
        return (LoggedInName);
    }
    public static String GetName(){
        return LOG_IN_NAME;
    }
    public static String GetLogedInPassword(){
        return (LoggedInName);
    }
    public static String GetPassword(){
        return PASSWORD;
    }

    public static void SetLogedInName(String s) {
        LoggedInName = s;
    }
    public static void SetLogedInPassword(String s) {
        LoggedInPassword = s;
    }
    public static void SetName(String s){
        LOG_IN_NAME = s;
    }
    public static void SetPassword(String s){
        PASSWORD = s;

    }
}
