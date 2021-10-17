package vn.edu.usth.pj;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class View_Page extends RecyclerView.Adapter<View_Page.ViewHolder> implements Filterable {
    private List<Articles> articlesArrayList;
    private List<Articles> articlesArrayList_search;
    private Context context;

    public View_Page(List<Articles> articlesArrayList, Context context) {
        this.articlesArrayList = articlesArrayList;
        this.articlesArrayList_search = articlesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public View_Page.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        android.view.View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_layout, parent, false);
        return new View_Page.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull View_Page.ViewHolder holder, int position) {
        Articles articles = articlesArrayList.get(position);

        holder.subV.setText(articles.getDescription());
        holder.titleV.setText(articles.getTitle());
        holder.imageV.setImageResource(articles.image());
        holder.itemView.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent i = new Intent(context, Page.class);
                i.putExtra("title", articles.getTitle());
                i.putExtra("desc", articles.getDescription());
                i.putExtra("image", articles.image());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleV, subV;
        private ImageView imageV;
        public ViewHolder(@NonNull android.view.View itemView) {
            super(itemView);
            titleV = itemView.findViewById(R.id.text);
            subV = itemView.findViewById(R.id.sub);
            imageV = itemView.findViewById((R.id.view));
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter(){

            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String search = charSequence.toString();
                if (search.isEmpty()){
                    articlesArrayList = articlesArrayList_search;
                }
                else{
                    List<Articles> list = new ArrayList<>();
                    for (Articles i: articlesArrayList_search){
                        if (i.getTitle().toLowerCase().contains(search.toLowerCase())){
                            list.add(i);
                        }
                    }
                    articlesArrayList = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = articlesArrayList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                articlesArrayList = (List<Articles>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
