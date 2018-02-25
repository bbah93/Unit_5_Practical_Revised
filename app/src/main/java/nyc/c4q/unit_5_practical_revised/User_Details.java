package nyc.c4q.unit_5_practical_revised;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

public class User_Details extends AppCompatActivity {

    ImageView imageView;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_user_detail);

        imageView = findViewById(R.id.detail_person_image);
        listview = findViewById(R.id.details_list_view);

        grabUserDetails();
    }

    private void grabUserDetails(){
        Intent detailIntent = getIntent();
        String[] items = {detailIntent.getStringExtra("Cell"), detailIntent.getStringExtra("DOB"),
                detailIntent.getStringExtra("Email"), detailIntent.getStringExtra("City"),
                detailIntent.getStringExtra("Post_Code"), detailIntent.getStringExtra("State"),
                detailIntent.getStringExtra("Street")};
        Picasso.with(getApplicationContext()).load(detailIntent.getStringExtra("Picture"))
                .into(imageView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.user_details_item,
                R.id.detail_text, items);
        listview.setAdapter(adapter);
    }
}
