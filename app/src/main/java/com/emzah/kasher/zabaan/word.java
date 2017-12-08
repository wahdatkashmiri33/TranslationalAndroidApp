package com.emzah.kasher.zabaan;

/**
 * Created by WAHDAT KASHMIRI on 31-10-2017.
 */

public class word {
    private String mdefaultTranslation;

    private String mkashurTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED=-1;

    private int mAudioResourceId;
    public word(String defaultTranlation,String kashurTranslation, int AudioResourceId){
        mdefaultTranslation=defaultTranlation;
        mkashurTranslation=kashurTranslation;
        mAudioResourceId=AudioResourceId;

    }

    public word(String defaultTranlation,String kashurTranslation,int ImageResourceId, int AudioResourceId){
        mdefaultTranslation=defaultTranlation;
        mkashurTranslation=kashurTranslation;
        mImageResourceId=ImageResourceId;
        mAudioResourceId=AudioResourceId;
    }

    public String getMdefaultTranslation() {
        return mdefaultTranslation;
    }

    public String getMkashurTranslation() {
        return mkashurTranslation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }



    public boolean hasImage(){
        //check whether listitem has image or not
return mImageResourceId !=NO_IMAGE_PROVIDED;

    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }
}
