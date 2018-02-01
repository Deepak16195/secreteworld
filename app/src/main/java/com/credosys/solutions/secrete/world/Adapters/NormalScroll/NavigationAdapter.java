package com.credosys.solutions.secrete.world.Adapters.NormalScroll;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.credosys.solutions.secrete.world.Pojos.App.Naviagion;
import com.credosys.solutions.secrete.world.R;

import java.util.List;

/**
 * Created by win7 on 01-Feb-18.
 */

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.NavigationHolder>{
    List<Naviagion> list;

    public NavigationAdapter(List<Naviagion> list) {
        this.list = list;
    }

    @Override
    public NavigationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_navigation, parent, false);
        return new NavigationHolder(v);
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
