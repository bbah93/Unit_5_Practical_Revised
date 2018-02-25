package nyc.c4q.unit_5_practical_revised.network;

import nyc.c4q.unit_5_practical_revised.models.RandomPeople;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by bobbybah on 2/21/18.
 */

public interface RandomAPICaller {
    @GET("api/?nat=us&inc=name,location,cell,email,dob,picture&results=20")
    Call<RandomPeople> getRandomPeople();
}
