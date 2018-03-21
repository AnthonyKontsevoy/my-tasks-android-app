package com.anthonyestacado.mytasks.tasksview.fragments.taskslist;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anthonyestacado.mytasks.R;
import com.anthonyestacado.mytasks.model.MyUtils;
import com.anthonyestacado.mytasks.model.User;
import com.anthonyestacado.mytasks.model.UserTask;
import com.anthonyestacado.mytasks.tasksview.fragments.usertaskdetails.UserTaskDetailsFragment;

import java.util.List;

import static com.anthonyestacado.mytasks.model.SQLiteDBHelper.context;

/**
 * Created by Anthony Kontsevoy on 12.03.2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<UserTaskCardViewHolder> {

    //Needed to inflate the layout
    private Context context;

    //Fragment which uses this adapter
    private TasksListFragment fragment;

    //Stores th list of all user tasks
    private List<UserTask> userTasksList;

    public RecyclerViewAdapter(Context context, TasksListFragment fragment, List<UserTask> userTasksList) {
        this.context = context;
        this.fragment = fragment;
        this.userTasksList = userTasksList;
    }

    @Override
    public UserTaskCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_task_card, null);
        return new UserTaskCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserTaskCardViewHolder holder, int position) {
        //Getting the product of the specified position
        UserTask userTask = userTasksList.get(position);

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

    public void loadUserTasksDetailsFragment(int userTaskID) {
        fragment.loadUserTasksDetailsFragment(userTaskID);
    }

    @Override
    public int getItemCount() {
        return userTasksList.size();
    }


}
