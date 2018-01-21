package security.bercy.com.week5day4googlemap.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import security.bercy.com.week5day4googlemap.R;

/**
 * Created by Bercy on 1/20/18.
 */

public class TopFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_fragment,container,false);
        return view;
    }
}
