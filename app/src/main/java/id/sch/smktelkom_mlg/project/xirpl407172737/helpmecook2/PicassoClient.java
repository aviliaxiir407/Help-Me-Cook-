package id.sch.smktelkom_mlg.project.xirpl407172737.helpmecook2;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by user_ on 11/26/2016.
 */

public class PicassoClient {

    public static void downloadImage(Context c, String url, ImageView img) {
        if (url != null && url.length() > 0) {
            Picasso.with(c).load(url).placeholder(R.drawable.placeholder).into(img);

        } else
            Picasso.with(c).load(R.drawable.placeholder).into(img);
    }
}
