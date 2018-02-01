package com.credosys.solutions.secrete.world.Adapters.NormalScroll;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.credosys.solutions.secrete.world.Pojos.App.HomeContents;
import com.credosys.solutions.secrete.world.R;

import java.util.List;

/**
 * Created by win7 on 10-Jan-18.
 */

public class ContentsAdapter extends RecyclerView.Adapter<ContentsAdapter.MyViewHolder>{
    List<HomeContents> list;
    public ContentsAdapter(List<HomeContents> list){
        this.list=list;
    }
    @Override
    public ContentsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_contents_card,parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtTitle.setText(list.get(position).getTitle());
        holder.txtDetail.setText(list.get(position).getSubtitle());
//        holder.txtName.setText(list.get(position).getName());
        holder.txtLable.setText(list.get(position).getLable());
        holder.txtLable.setBackgroundResource(list.get(position).getColor());
        holder.imgSingleThumbnail.setBackgroundResource(list.get(position).getImg());
//        holder.imgSingleThumbnail.setImageDrawable(list.get(position).getImg());

//        holder.imgSingleThumbnail.setColorFilter();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle,txtDetail,txtName,txtLable;
        ImageView imgSingleThumbnail;
        MyViewHolder(View view){
            super(view);
            txtTitle=view.findViewById(R.id.txt_title_card);
            txtDetail=view.findViewById(R.id.txt_detail);
            txtName=view.findViewById(R.id.txt_user_name);
            txtLable=view.findViewById(R.id.txt_lable);
            imgSingleThumbnail=view.findViewById(R.id.img_single_thumbnail);
        }
    }
}