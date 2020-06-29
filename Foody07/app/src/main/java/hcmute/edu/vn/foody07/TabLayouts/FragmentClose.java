package hcmute.edu.vn.foody07.TabLayouts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import hcmute.edu.vn.foody07.R;

public class FragmentClose extends Fragment {
    public FragmentClose(){}
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_close, container, false);
        //listView = (ListView) view.findViewById(R.id.listView);
        return view;
    }

}
