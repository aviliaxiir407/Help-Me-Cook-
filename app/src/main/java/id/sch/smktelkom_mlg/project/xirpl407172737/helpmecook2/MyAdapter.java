package id.sch.smktelkom_mlg.project.xirpl407172737.helpmecook2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by user_ on 11/26/2016.
 */

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Resep> resep;

    public MyAdapter(Context c, ArrayList<Resep> resep) {
        this.c = c;
        this.resep = resep;
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model, parent, false);
        MyHolder holder = new MyHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.nameTxt.setText(resep.get(position).getName());
        holder.bahan.setText(resep.get(position).getBahan());
        holder.cara.setText(resep.get(position).getCara());

        PicassoClient.downloadImage(c, resep.get(position).getUrlgambar(), holder.img);
    }

    @Override
    public int getItemCount() {
        return resep.size();
    }
}
