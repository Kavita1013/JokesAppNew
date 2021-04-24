package kavita.myappcompany.recyclerviewjsonexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyviewHolder> {
    private Context context;
    private List<Joke> jokeList;

    public RecyclerAdapter(Context context, List<Joke> jokeList) {
        this.context = context;
        this.jokeList = jokeList;
    }

    public void setJokeList(List<Joke> jokeList) {
        this.jokeList = jokeList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerAdapter.MyviewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_layout,parent,false);
return new MyviewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyviewHolder holder, int position) {


holder.textViewJokeid1.setText(jokeList.get(position).getId());
        holder.textViewJokeType.setText(jokeList.get(position).getType());
        holder.textViewJokeId.setText(jokeList.get(position).getSetup());
holder.textViewJokePunchline.setText(jokeList.get(position).getPunchline());
    }

    @Override
    public int getItemCount() {
        return jokeList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        TextView textViewJokeId;
       TextView textViewJokeType;
       TextView textViewJokeid1;
        TextView textViewJokePunchline;
        public MyviewHolder(View itemView) {
            super(itemView);
            textViewJokeid1=(TextView) itemView.findViewById(R.id.textViewJokeid1);
            textViewJokeType=(TextView) itemView.findViewById(R.id.textViewJokeType);
            textViewJokeId=(TextView) itemView.findViewById(R.id.textViewJokeId);


            textViewJokePunchline=(TextView) itemView.findViewById(R.id.textViewJokePunchline);
        }
    }
}
