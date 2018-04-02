package com.anthonyestacado.mytasks.common;

/**
 * Created by Anthony Kontsevoy on 29.03.2018.
 */
public enum TaskStatuses {
    IN_PROGRESS(0),
    DONE(1),
    ALL(2);

    private int status;

    TaskStatuses(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
