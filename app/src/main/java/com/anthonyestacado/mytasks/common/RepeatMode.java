package com.anthonyestacado.mytasks.common;

/**
 * Created by Anthony Kontsevoy on 28.03.2018.
 */
public enum RepeatMode {

    DAILY("every day"),
    WEEKLY("every week"),
    MONTHLY("every month"),
    EVERY_YEAR("evert year"),
    NEVER("never");

    private String repeatMode;

    RepeatMode (String repeatMode){
        this.repeatMode = repeatMode;
    }

    public String getRepeatMode(){
        return repeatMode;
    }
}
