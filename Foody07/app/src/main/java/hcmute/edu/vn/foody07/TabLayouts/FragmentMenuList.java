package hcmute.edu.vn.foody07.TabLayouts;

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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.foody07.DanhMuc;
import hcmute.edu.vn.foody07.Database;
import hcmute.edu.vn.foody07.MonAn;
import hcmute.edu.vn.foody07.MonAnListAdapter;
import hcmute.edu.vn.foody07.QuanAn;
import hcmute.edu.vn.foody07.R;

public class FragmentMenuList extends Fragment {
    SQLiteDatabase database;
    final String DATABASE_NAME="foody.sqlite";

    private RecyclerView listView;
    private List<MonAn> list;

    public FragmentMenuList(){}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_list, container, false);
        listView = (RecyclerView) view.findViewById(R.id.listView_menu_list);
        MonAnListAdapter adapter=new MonAnListAdapter(getContext(),list);
        listView.setLayoutManager(new GridLayoutManager(getActivity(),1));
        listView.setAdapter(adapter);
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list=new ArrayList<>();
        //đọc data
        int IdShopFood= getActivity().getIntent().getIntExtra("IdShopFood",-1);
        database= Database.initDatabase(getActivity(),DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT NameDishes,Image,Price FROM DANHMUC,MONAN WHERE IdShopFood=? AND DANHMUC.IdMenu=MONAN.IdMenu",new String[]{IdShopFood+""});
        list.clear();
        for(int i=0;i<cursor.getCount();i++){
            cursor.moveToPosition(i);
            String name=cursor.getString(0);
            int prices=cursor.getInt(2);
            //thêm dữ lie5u vào list
            list.add(new MonAn(name,prices));
        }
    }


}
