package com.credosys.solutions.secrete.world.Adapters.NormalScroll;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.credosys.solutions.secrete.world.Pojos.App.Navigation;
import com.credosys.solutions.secrete.world.R;

import java.util.List;

/**
 * Created by win7 on 01-Feb-18.
 */

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.NavigationHolder>{
    List<Navigation> list;
    private CustomItemClickListener listener;
    public NavigationAdapter(List<Navigation> list, CustomItemClickListener listener) {
        this.list = list;
        this.listener=listener;
    }

    @Override
    public NavigationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_navigation, parent, false);
        final NavigationHolder mViewHolder=new NavigationHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, mViewHolder.getAdapterPosition());
            }
        });
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(NavigationHolder holder, int position) {
        holder.txtNavigation.setText(list.get(position).getStrNav());
        holder.imgNavigation.setBackgroundResource(list.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NavigationHolder extends RecyclerView.ViewHolder{
        TextView txtNavigation;
        ImageView imgNavigation;
        public NavigationHolder(View itemView) {
            super(itemView);
            txtNavigation=itemView.findViewById(R.id.txt_navigation);
            imgNavigation=itemView.findViewById(R.id.img_navigation);
        }
    }
}
