package com.credosys.solutions.secrete.world.Adapters.NormalScroll;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.credosys.solutions.secrete.world.Pojos.App.ProfileStuff;
import com.credosys.solutions.secrete.world.R;

import java.util.List;

/**
 * Created by win7 on 31-Jan-18.
 */

public class ProfileStuffAdapter extends RecyclerView.Adapter<ProfileStuffAdapter.ProfileStuffHolder> {
    private List<ProfileStuff> list;
    private CustomItemClickListener listener;
    public ProfileStuffAdapter(List<ProfileStuff> list, CustomItemClickListener listener) {
        this.list = list;
        this.listener=listener;
    }

    @Override
    public ProfileStuffHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_profile_stuff_card,parent, false);
        final ProfileStuffHolder mViewHolder=new ProfileStuffHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, mViewHolder.getAdapterPosition());
            }
        });
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(ProfileStuffHolder holder, int position) {
        holder.ivSingleProfileStuff.setImageResource(list.get(position).getImgPofileStuff());
        holder.txtSingleProfileStuff.setText(list.get(position).getStrProfileStuff());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ProfileStuffHolder extends RecyclerView.ViewHolder{
    ImageView ivSingleProfileStuff;
    TextView txtSingleProfileStuff;
        public ProfileStuffHolder(View itemView) {
            super(itemView);
            ivSingleProfileStuff=itemView.findViewById(R.id.iv_single_profile_stuff);
            txtSingleProfileStuff=itemView.findViewById(R.id.txt_single_profile_stuff);
        }
    }
}
