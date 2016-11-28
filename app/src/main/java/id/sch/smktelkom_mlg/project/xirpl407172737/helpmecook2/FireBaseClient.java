package id.sch.smktelkom_mlg.project.xirpl407172737.helpmecook2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

/**
 * Created by user_ on 11/26/2016.
 */

public class FireBaseClient {

    Context c;
    String DB_URL;
    RecyclerView rv;
    Firebase fire;
    ArrayList<Resep> resep = new ArrayList<>();
    MyAdapter adapter;

    public FireBaseClient(Context c, String DB_URL, RecyclerView rv) {
        this.c = c;
        this.DB_URL = DB_URL;
        this.rv = rv;

        //INITIALIZE
        Firebase.setAndroidContext(c);

        //INISIANTLATE
        fire = new Firebase(DB_URL);
    }

    public void saveOnCline(String namaresep, String bahan,
                            String caramembuat, String urlgambar) {
        Resep m = new Resep();
        m.setName(namaresep);
        m.setBahan(bahan);
        m.setCara(caramembuat);
        m.setUrlgambar(urlgambar);

        fire.child("Resep").push().setValue(m);
    }

    //RETRIEVE
    public void refreshData() {
        fire.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    private void getUpdates(DataSnapshot dataSnapshot) {
        resep.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Resep m = new Resep();
            m.setName(ds.getValue(Resep.class).getName());
            m.setBahan(ds.getValue(Resep.class).getBahan());
            m.setCara(ds.getValue(Resep.class).getCara());
            m.setUrlgambar(ds.getValue(Resep.class).getUrlgambar());

            resep.add(m);
        }
        if (resep.size() > 0) {
            adapter = new MyAdapter(c, resep);
            rv.setAdapter(adapter);
        } else {
            Toast.makeText(c, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
}
