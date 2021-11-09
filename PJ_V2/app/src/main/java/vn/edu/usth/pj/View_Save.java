package vn.edu.usth.pj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class View_Save extends RecyclerView.Adapter<View_Save.ViewHolder> {
    private List<Save_Page> Save_pageArraylist;
    private Context context;

    public View_Save(List<Save_Page> Save_pageArraylist, Context context) {
        this.Save_pageArraylist = Save_pageArraylist;
        this.context = context;
    }
    @NonNull
    @Override
    public View_Save.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        android.view.View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_layout, parent, false);
        return new View_Save.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Save_Page save_page = Save_pageArraylist.get(position);

        holder.save_title.setText(save_page.getTitle());
        holder.save_desc.setText(save_page.getDesc());


    }


    @Override
    public int getItemCount() {
        return Save_pageArraylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView save_title, save_desc;
        public ViewHolder(android.view.View itemView) {
            super(itemView);
            save_title = itemView.findViewById(R.id.save_title);
            save_desc = itemView.findViewById(R.id.save_desc);

        }
    }

    public void getSave(List<Save_Page> list){
        this.Save_pageArraylist = list;
        notifyDataSetChanged();
    }
}
