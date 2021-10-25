package com.example.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application
{
    @Override
    public void onCreate() {

        super.onCreate();

        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("0vYR7nhF1sbcNDgahjZ1pdgT1Ivlu6p5BHc9P0wO")
                .clientKey("84iOcd4UV7cbOwLqZQlXznia0aF858RXhl2MSNYb")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }

}
