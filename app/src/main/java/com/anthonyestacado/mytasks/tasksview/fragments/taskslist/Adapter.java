package com.anthonyestacado.mytasks.tasksview.fragments.taskslist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anthonyestacado.mytasks.R;
import com.anthonyestacado.mytasks.model.MyUtils;
import com.anthonyestacado.mytasks.model.User;
import com.anthonyestacado.mytasks.model.UserTask;

import java.util.List;

/**
 * Created by Anthony Kontsevoy on 23.03.2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    protected List<UserTask> userTaskList;
    protected Context context;

    public Adapter(Context context, List<UserTask> userTaskList) {
        this.context = context;
        this.userTaskList = userTaskList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_task_card, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserTask userTask = userTaskList.get(position);

        //Binding the data with the ViewHolder views
        holder.userTaskTitle.setText(userTask.getTitle());
        holder.userTaskDescription.setText(userTask.getDescription());

        //Splitting the due date to show it on the card the way we want it
        String date = MyUtils.selectOnlyDateFromString(userTask.getDueDate());
        String time = MyUtils.selectOnlyTimeFromString(userTask.getDueDate());
        holder.userTaskDueDate.setText(date);
        holder.userTaskDueTime.setText(time);

        switch (userTask.getStatus()) {
            //Sets the "In progress" image
            case 0: {
                holder.statusImage.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_tasks_in_progress));
                break;
            }

            //Sets the "Done" image
            case 1: {
                holder.statusImage.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_done_tasks));
                break;
            }

            default: {
                holder.statusImage.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_all_tasks));
            }
        }
    }

    @Override
    public int getItemCount() {
        return userTaskList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView statusImage;
        public TextView userTaskTitle;
        public TextView userTaskDescription;
        public TextView userTaskDueDate;
        public TextView userTaskDueTime;

        public ViewHolder(View itemView) {
            super(itemView);

            statusImage = (ImageView) itemView.findViewById(R.id.imageViewStatus);
            userTaskTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            userTaskDescription = (TextView) itemView.findViewById(R.id.textViewDescription);
            userTaskDueDate = (TextView) itemView.findViewById(R.id.textViewDueDate);
            userTaskDueTime = (TextView) itemView.findViewById(R.id.textViewDueTime);
        }
    }
}
