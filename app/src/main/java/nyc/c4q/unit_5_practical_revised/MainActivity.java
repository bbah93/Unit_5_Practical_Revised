package nyc.c4q.unit_5_practical_revised;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.unit_5_practical_revised.controller.RandomUser_Adapter;
import nyc.c4q.unit_5_practical_revised.models.RandomPeople;
import nyc.c4q.unit_5_practical_revised.models.Results;
import nyc.c4q.unit_5_practical_revised.network.RandomAPICaller;
import nyc.c4q.unit_5_practical_revised.network.Retrofit_Client;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    RandomAPICaller userAPISerivce;
    RecyclerView recyclerView;
    RandomUser_Adapter randomUser_adapter;
    List<Results> randomPeopleList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.random_people_rv);

        if(getApplication().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
        }
        randomUser_adapter = new RandomUser_Adapter(randomPeopleList);
        recyclerView.setAdapter(randomUser_adapter);

        API_Caller();
    }

    public void API_Caller(){
        userAPISerivce = Retrofit_Client.getRetrofit("https://randomuser.me/")
                .create(RandomAPICaller.class);

        userAPISerivce.getRandomPeople().enqueue(new Callback<RandomPeople>() {
            @Override
            public void onResponse(Call<RandomPeople> call, Response<RandomPeople> response) {
                randomPeopleList = response.body().getResults();
                recyclerView.setAdapter(new RandomUser_Adapter(randomPeopleList));
                Log.d(TAG, "onResponse: " + randomPeopleList);
            }

            @Override
            public void onFailure(Call<RandomPeople> call, Throwable t) {
                Log.d(TAG, "ON_FAILURE " + t.getMessage());
            }
        });

    }
}
