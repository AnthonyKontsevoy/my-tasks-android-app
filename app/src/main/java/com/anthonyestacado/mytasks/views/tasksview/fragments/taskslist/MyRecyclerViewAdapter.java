package com.anthonyestacado.mytasks.views.tasksview.fragments.taskslist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anthonyestacado.mytasks.R;
import com.anthonyestacado.mytasks.common.MyUtils;
import com.anthonyestacado.mytasks.model.UserTask;

import java.util.List;

/**
 * Created by Anthony Kontsevoy on 12.03.2018.
 */


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(UserTask userTask);
    }

    private final List<UserTask> userTaskList;
    private final OnItemClickListener listener;
    public static Context context;

    public MyRecyclerViewAdapter(Context context, List<UserTask> items, OnItemClickListener listener) {
        this.context = context;
        this.userTaskList = items;
        this.listener = listener;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_task_card, parent, false);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_task_card, null);
        return new ViewHolder(view);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(userTaskList.get(position), listener);
    }

    @Override public int getItemCount() {
        return userTaskList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

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

        public void bind(final UserTask userTask, final OnItemClickListener listener) {
            userTaskTitle.setText(userTask.getTitle());
            userTaskDescription.setText(userTask.getDescription());

            //Splitting the due date to show it on the card the way we want it
            String date = MyUtils.selectOnlyDateFromString(userTask.getDueDate());
            String time = MyUtils.selectOnlyTimeFromString(userTask.getDueDate());
            userTaskDueDate.setText(date);
            userTaskDueTime.setText(time);

            switch (userTask.getStatus()) {
                //Sets the "In progress" image
                case 0: {
                    statusImage.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_tasks_in_progress));
                    break;
                }

                //Sets the "Done" image
                case 1: {
                    statusImage.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_done_tasks));
                    break;
                }

                default: {
                    statusImage.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_all_tasks));
                }
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(userTask);
                }
            });
        }
    }
}
