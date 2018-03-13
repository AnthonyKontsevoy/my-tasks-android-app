package com.anthonyestacado.mytasks.tasksview.fragments.taskslist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.anthonyestacado.mytasks.R;

import org.w3c.dom.Text;

/**
 * Created by Anthony Kontsevoy on 12.03.2018.
 */

class UserTaskCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView statusImage;
    TextView userTaskTitle;
    TextView userTaskDescription;
    TextView userTaskDueDate;
    TextView userTaskDueTime;

    public UserTaskCardViewHolder(View itemView) {
        super(itemView);

        statusImage = (ImageView) itemView.findViewById(R.id.imageViewStatus);
        userTaskTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
        userTaskDescription = (TextView) itemView.findViewById(R.id.textViewDescription);
        userTaskDueDate = (TextView) itemView.findViewById(R.id.textViewDueDate);
        userTaskDueTime = (TextView) itemView.findViewById(R.id.textViewDueTime);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
