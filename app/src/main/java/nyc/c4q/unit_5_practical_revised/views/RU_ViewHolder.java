package nyc.c4q.unit_5_practical_revised.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.unit_5_practical_revised.R;
import nyc.c4q.unit_5_practical_revised.models.Results;


/**
 * Created by bobbybah on 2/24/18.
 */

//results.getPicture().getLarge().isEmpty()

public class RU_ViewHolder extends RecyclerView.ViewHolder {

    ImageView userImage;
    TextView userName;


    public RU_ViewHolder(View itemView) {
        super(itemView);

        userImage = itemView.findViewById(R.id.person_picture);
        userName = itemView.findViewById(R.id.person_name);
    }

    public void onBind(Results results){
        String full_Name = results.getName().getFirst() + " " + results.getName().getLast();

        userName.setText(full_Name);
        String imgUrl = results.getPicture().getLarge();
        if (imgUrl != null){
            Picasso.with(userImage.getContext())
                    .load(imgUrl)
                    .into(userImage);
        }
    }

}
