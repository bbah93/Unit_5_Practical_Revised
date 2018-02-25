package nyc.c4q.unit_5_practical_revised.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.unit_5_practical_revised.R;
import nyc.c4q.unit_5_practical_revised.User_Details;
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDetailActivity = new Intent(holder.itemView.getContext(),User_Details.class);
                goToDetailActivity
                        .putExtra("Picture", randomUserList.get(position).getPicture().getLarge());
                goToDetailActivity.putExtra("Cell", randomUserList.get(position).getCell());
                goToDetailActivity.putExtra("DOB", randomUserList.get(position).getDob());
                goToDetailActivity.putExtra("Email", randomUserList.get(position).getEmail());
                goToDetailActivity.putExtra("City", randomUserList.get(position).getLocation().getCity());
                goToDetailActivity.putExtra("Post_Code",
                        String.valueOf(randomUserList.get(position).getLocation().getPostcode()));
                goToDetailActivity
                        .putExtra("State", randomUserList.get(position).getLocation().getState());
                goToDetailActivity
                        .putExtra("Street", randomUserList.get(position).getLocation().getStreet());
                holder.itemView.getContext().startActivity(goToDetailActivity);
            }


        });
    }

    @Override
    public int getItemCount() {
        return randomUserList.size();
    }
}
