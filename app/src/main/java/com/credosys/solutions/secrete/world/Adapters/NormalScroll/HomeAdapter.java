package com.credosys.solutions.secrete.world.Adapters.NormalScroll;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.credosys.solutions.secrete.world.Pojos.App.HomeContentsPlaces;
import com.credosys.solutions.secrete.world.R;

import java.util.List;

/**
 * Created by win7 on 23-Dec-17.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{
    List<HomeContentsPlaces> list;
    private CustomItemClickListener listener;
    public HomeAdapter(List<HomeContentsPlaces> list,CustomItemClickListener listener){
        this.list=list;
        this.listener=listener;
    }
    @Override
    public HomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_home_card,parent, false);
        final MyViewHolder mViewHolder=new MyViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, mViewHolder.getAdapterPosition());
            }
        });
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(HomeAdapter.MyViewHolder holder, int position) {
        holder.txtTitle.setText(list.get(position).getTitle());
        holder.txtDetail.setText(list.get(position).getSubtitle());
        holder.txtName.setText(list.get(position).getName());
        holder.imgSingleThumbnail.setImageResource(list.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle,txtDetail,txtName;
        ImageView imgSingleThumbnail;
        MyViewHolder(View view){
            super(view);
            txtTitle=view.findViewById(R.id.txt_title_card);
            txtDetail=view.findViewById(R.id.txt_address);
            txtName=view.findViewById(R.id.txt_user_name);
            imgSingleThumbnail= view.findViewById(R.id.img_single_thumbnail);
        }
    }
}
