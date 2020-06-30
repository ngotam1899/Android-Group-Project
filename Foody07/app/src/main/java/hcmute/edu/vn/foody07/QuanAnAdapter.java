package hcmute.edu.vn.foody07;

import android.app.Activity;
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

import java.util.ArrayList;
import java.util.List;

public class QuanAnAdapter extends RecyclerView.Adapter<QuanAnAdapter.MyViewHolder> {
    //dùng kiểu Activity để chuyển giao diên
    Context context;
    List<QuanAn> list;

    public QuanAnAdapter(Activity context, List<QuanAn> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(context);
        view = mInflater.inflate(R.layout.quan_an_item, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtName_2.setText((list.get(position).getNameShopFood()));
        holder.txtAddress_2.setText((list.get(position).getDiaChi()));
        Bitmap bitmap= BitmapFactory.decodeByteArray(list.get(position).Image,0,list.get(position).Image.length);
        holder.imageView.setImageBitmap(bitmap);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtName_2,txtAddress_2,txtDistance;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName_2=(TextView)itemView.findViewById(R.id.txtName_2);
            txtAddress_2=(TextView)itemView.findViewById(R.id.txtAddress_2);
            imageView=(ImageView)itemView.findViewById(R.id.imgCustom_2);
            txtDistance=(TextView) itemView.findViewById(R.id.txtDistance);

        }
    }
}
