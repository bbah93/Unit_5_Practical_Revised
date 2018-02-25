package nyc.c4q.unit_5_practical_revised.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.unit_5_practical_revised.R;
import nyc.c4q.unit_5_practical_revised.models.Results;
import nyc.c4q.unit_5_practical_revised.views.RU_ViewHolder;

/**
 * Created by bobbybah on 2/24/18.
 */

public class RandomUser_Adapter extends RecyclerView.Adapter<RU_ViewHolder> {
    List<Results> randomUserList;
    Context context;

    public RandomUser_Adapter(List<Results> randomUserList){
        this.randomUserList = randomUserList;
    }

    @Override
    public RU_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);
        context = parent.getContext();
        return new RU_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RU_ViewHolder holder,final int position) {
        Results randomUsers = randomUserList.get(position);
        holder.onBind(randomUsers);

        //TODO: Make on click listener to new activity
    }

    @Override
    public int getItemCount() {
        return randomUserList.size();
    }
}
