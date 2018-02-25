package nyc.c4q.unit_5_practical_revised.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bobbybah on 2/24/18.
 */

public class Retrofit_Client {
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit(String baseURL){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
