package com.credosys.solutions.secrete.world.Adapters.NormalScroll;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.R;

/**
 * Created by credosys on 6/3/18.
 */

public class MapAdapter extends RecyclerView.Adapter<MapAdapter.MapHolder>{

    @NonNull
    @Override
    public MapHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_map,parent,false);
        return new MapHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MapHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class MapHolder extends RecyclerView.ViewHolder{

        private MapHolder(View itemView) {
            super(itemView);
        }
    }
}
