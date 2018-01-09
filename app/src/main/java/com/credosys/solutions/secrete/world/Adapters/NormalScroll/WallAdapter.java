package com.credosys.solutions.secrete.world.Adapters.NormalScroll;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.R;

/**
 * Created by win7 on 09-Jan-18.
 */

public class WallAdapter  extends RecyclerView.Adapter<WallAdapter.WallHolder>{

    @Override
    public WallHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_wall, parent, false);
        return new WallAdapter.WallHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WallHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class WallHolder extends RecyclerView.ViewHolder{

        public WallHolder(View itemView) {
            super(itemView);
        }
    }
}
