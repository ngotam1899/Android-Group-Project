package hcmute.edu.vn.foody07;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

import java.util.List;

public class MonAnListAdapter extends RecyclerView.Adapter<MonAnListAdapter.MyViewHolder> {

    Context context;
    List<MonAn> list;

    public MonAnListAdapter(Context context, List<MonAn> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(context).inflate(R.layout.mon_an_list,parent,false);
        MyViewHolder holder=new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtName_2.setText((list.get(position).getNameDishes()));
        holder.txtAddress_2.setText((list.get(position).getPrice()+""));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtName_2,txtAddress_2;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName_2=(TextView)itemView.findViewById(R.id.txtFName);
            txtAddress_2=(TextView)itemView.findViewById(R.id.txtFPrice);
        }
    }
}
