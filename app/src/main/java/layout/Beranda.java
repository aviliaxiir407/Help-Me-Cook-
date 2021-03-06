package layout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.sch.smktelkom_mlg.project.xirpl407172737.helpmecook2.MainActivity;
import id.sch.smktelkom_mlg.project.xirpl407172737.helpmecook2.R;
import id.sch.smktelkom_mlg.project.xirpl407172737.helpmecook2.Tambah_resep;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {link Beranda.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {link Beranda#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Beranda extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_beranda, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Beranda");

    }

}
