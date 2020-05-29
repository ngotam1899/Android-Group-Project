package hcmute.edu.vn.ngotam.sqliteimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodApdater extends RecyclerView.Adapter<FoodApdater.MyViewHolder> {
    private Context context;
    private List<Food> list;

    public FoodApdater(Context context, List<Food> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(context);
        view = mInflater.inflate(R.layout.dong_do_vat_2, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtName_2.setText((list.get(position).getTen()));
        holder.txtAddress_2.setText((list.get(position).getDiaChi()));
        holder.txtDistance_2.setText((list.get(position).getKhoangCach()));
        holder.txtType_2.setText((list.get(position).getLoaiHinh()));
        //chuyển byte[] sang chuổi bitmap
        //byte[] hinhAnh=list.get(position).getHinh();
        //Bitmap bitmap= BitmapFactory.decodeByteArray(hinhAnh,0,hinhAnh.length);
        //holder.imageView.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtName_2,txtAddress_2,txtDistance_2,txtType_2;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName_2=(TextView)itemView.findViewById(R.id.txtName_2);
            txtAddress_2=(TextView)itemView.findViewById(R.id.txtAddress_2);
            txtDistance_2=(TextView)itemView.findViewById(R.id.txtDistance_2);
            txtType_2=(TextView)itemView.findViewById(R.id.txtType_2);
            imageView=(ImageView)itemView.findViewById(R.id.imgCustom_2);
        }
    }
}
