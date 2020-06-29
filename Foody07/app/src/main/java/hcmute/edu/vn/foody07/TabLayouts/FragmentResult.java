package hcmute.edu.vn.foody07.TabLayouts;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.foody07.Database;
import hcmute.edu.vn.foody07.QuanAn;
import hcmute.edu.vn.foody07.QuanAnListAdapter;
import hcmute.edu.vn.foody07.R;

public class FragmentResult extends Fragment {
    SQLiteDatabase database;
    final String DATABASE_NAME="foody.sqlite";

    private ListView listView;
    private ArrayList<QuanAn> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_close, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        QuanAnListAdapter adapter=new QuanAnListAdapter(getContext(),list);
        listView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        //QuanAnListAdapter adapter=new QuanAnListAdapter(getContext(),list);
        //đọc data
        //Intent intent=getIntent();
        int CodeNumber= getActivity().getIntent().getIntExtra("CodeNumber",-1);
        database=Database.initDatabase(getActivity(),DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT * FROM QUANAN WHERE CodeNumber=?",new String[]{CodeNumber+""});
        list.clear();
        for(int i=0;i<cursor.getCount();i++){
            cursor.moveToPosition(i);
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            String address=cursor.getString(2);
            byte[] img=cursor.getBlob(4);
            String type=cursor.getString(3);
            //thêm dữ lie5u vào list
            list.add(new QuanAn(id,name,address,img,type));
        }
        //adapter.notifyDataSetChanged(); //adapter vẽ lại giao diện
    }
}
