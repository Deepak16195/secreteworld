package com.credosys.solutions.secrete.world.Adapters.NormalScroll;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.credosys.solutions.secrete.world.Pojos.App.SearchCategory;
import com.credosys.solutions.secrete.world.R;

import java.util.List;

/**
 * Created by win7 on 05-Jan-18.
 */

public class SearchByCategoryAdapter extends RecyclerView.Adapter<SearchByCategoryAdapter.MyViewHolder> {
    private Context context;
    private List<SearchCategory> list;
    CustomItemClickListener listener;
    public SearchByCategoryAdapter(Context context, List<SearchCategory> list,CustomItemClickListener listener) {
        this.context=context;
        this.list=list;
        this.listener=listener;
    }


    @Override
    public SearchByCategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_search_category,parent, false);
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
    public void onBindViewHolder(SearchByCategoryAdapter.MyViewHolder holder, int position) {
        holder.imgPlaces.setBackgroundResource(list.get(position).getImgPlaces());
        holder.txtPlaces.setText(list.get(position).getPlaceNames());
        holder.chkSearchCategory.setChecked(list.get(position).isChecked());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPlaces;
        TextView txtPlaces;
        CheckBox chkSearchCategory;
        private MyViewHolder(View itemView) {
            super(itemView);
            txtPlaces=itemView.findViewById(R.id.txt_place);
            imgPlaces=itemView.findViewById(R.id.img_single_search_category);
            chkSearchCategory=itemView.findViewById(R.id.chk_search_category);
        }
    }
}
