package com.anthonyestacado.mytasks.views.tasksview.fragments.usertaskeditor;

import com.anthonyestacado.mytasks.common.RepeatMode;

/**
 * Created by Anthony Kontsevoy on 06.03.2018.
 */

public interface EditUserTaskFragmentInterface {
    void fillInputFieldsWithData(String title, String description, String dueDate, int hasNotification, int repeatMode);
    void makeInputFieldsEmpty();
    void getUserInput();
}
