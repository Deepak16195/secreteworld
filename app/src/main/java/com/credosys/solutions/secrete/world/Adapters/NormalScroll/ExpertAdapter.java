package com.credosys.solutions.secrete.world.Adapters.NormalScroll;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.credosys.solutions.secrete.world.Pojos.App.pojoExperts;
import com.credosys.solutions.secrete.world.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win7 on 13-Jan-18.
 */

public class ExpertAdapter extends RecyclerView.Adapter<ExpertAdapter.ExpertHolder> {
List<pojoExperts>experts;
    ImageView image;
    public ExpertAdapter(ArrayList<pojoExperts> experts) {
        this.experts = experts;
    }

    @Override
    public ExpertAdapter.ExpertHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_expert,null, false);
          image = v.findViewById(R.id.img_expert_user);
        return new ExpertHolder(v);
    }
    @Override
    public void onBindViewHolder(ExpertAdapter.ExpertHolder holder, int position) {

image.setImageResource(experts.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return experts.size();
    }

    class ExpertHolder extends RecyclerView.ViewHolder{

        public ExpertHolder(View itemView) {
            super(itemView);
        }
    }

}
