package id.sch.smktelkom_mlg.project.xirpl407172737.helpmecook2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user_ on 11/26/2016.
 */

public class MyHolder extends RecyclerView.ViewHolder {

    TextView nameTxt;
    TextView bahan;
    TextView cara;
    ImageView img;

    public MyHolder(View itemView) {
        super(itemView);

        nameTxt = (TextView) itemView.findViewById(R.id.nameTxt);
        bahan = (TextView) itemView.findViewById(R.id.Bahan);
        cara = (TextView) itemView.findViewById(R.id.CaraMembuat);
        img = (ImageView) itemView.findViewById(R.id.resepImage);
    }
}
