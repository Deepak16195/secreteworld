package com.credosys.solutions.secrete.world.Adapters.NormalScroll;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.R;

/**
 * Created by win7 on 13-Jan-18.
 */

public class ExpertAdapter extends RecyclerView.Adapter<ExpertAdapter.ExpertHolder> {

    @Override
    public ExpertAdapter.ExpertHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_expert,null, false);
        return new ExpertHolder(v);
    }
    @Override
    public void onBindViewHolder(ExpertAdapter.ExpertHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ExpertHolder extends RecyclerView.ViewHolder{

        public ExpertHolder(View itemView) {
            super(itemView);
        }
    }

}
