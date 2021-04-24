package kavita.myappcompany.recyclerviewjsonexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("random_ten")
    Call<List<Joke>> getJokes();
}
