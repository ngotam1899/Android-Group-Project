package hcmute.edu.vn.ngotam.sqliteimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ThingAdapter  extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Food> foodsList;

    public ThingAdapter(Context context, int layout, List<Food> foodsList) {
        this.context = context;
        this.layout = layout;
        this.foodsList = foodsList;
    }

    @Override
    public int getCount() {
        return foodsList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView txtTen, txtDiaChi, txtKhoangCach,txtLoaiHinh;
        ImageView imageView;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout, null);
            holder.txtTen=(TextView) view.findViewById(R.id.txtName_2);
            holder.txtDiaChi=(TextView) view.findViewById(R.id.txtAddress_2);
            holder.txtKhoangCach=(TextView) view.findViewById(R.id.txtDistance_2);
            holder.txtLoaiHinh=(TextView) view.findViewById(R.id.txtType_2);
            holder.imageView=(ImageView) view.findViewById(R.id.imgCustom_2);
            view.setTag(holder);
        }
        else {
            holder=(ViewHolder) view.getTag();
        }
        /*
        Food food=foodsList.get(i);
        holder.txtTen.setText(food.getTen());
        holder.txtDiaChi.setText(food.getDiaChi());
        holder.txtKhoangCach.setText(food.getKhoangCach());
        holder.txtLoaiHinh.setText(food.getLoaiHinh());

        //chuyển byte[] sang chuổi bitmap
        byte[] hinhAnh=food.getHinh();
        Bitmap bitmap= BitmapFactory.decodeByteArray(hinhAnh,0,hinhAnh.length);
        holder.imageView.setImageBitmap(bitmap);
        */
        return view;
    }
}
