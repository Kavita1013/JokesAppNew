package kavita.myappcompany.recyclerviewjsonexample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
List<Joke> jokeList;
RecyclerView recyclerView;
RecyclerAdapter RecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
jokeList=new ArrayList<>();

recyclerView =(RecyclerView) findViewById(R.id.recyclerview);

RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter = new RecyclerAdapter(getApplicationContext(),jokeList);
        recyclerView.setAdapter(RecyclerAdapter);

        ApiInterface apiInterface=ApiClient.getClient().create(ApiInterface.class);

        Call<List<Joke>> call= apiInterface.getJokes();

        call.enqueue(new Callback<List<Joke>>() {
            @Override
            public void onResponse(Call<List<Joke>> call, Response<List<Joke>> response) {

jokeList=response.body();
                Log.d("MainActivity",jokeList.toString());

                RecyclerAdapter.setJokeList(jokeList);


            }

            @Override
            public void onFailure(Call<List<Joke>> call, Throwable t) {

                Log.d("MainActivity",t.toString());

            }
        });

    }
}