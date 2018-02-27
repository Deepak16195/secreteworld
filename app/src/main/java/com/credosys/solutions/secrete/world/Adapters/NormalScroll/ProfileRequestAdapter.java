package com.credosys.solutions.secrete.world.Adapters.NormalScroll;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.credosys.solutions.secrete.world.Pojos.App.Request;
import com.credosys.solutions.secrete.world.R;

import java.util.List;

/**
 * Created by win7 on 12-Jan-18.
 */

public class ProfileRequestAdapter extends RecyclerView.Adapter<ProfileRequestAdapter.MyViewHolder> {
List<Request> list;

    public ProfileRequestAdapter(List<Request> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_profile_request_card,parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    holder.img.setImageResource(list.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txtTitle,txtNote;
        public MyViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_left);
            txtTitle=itemView.findViewById(R.id.txt_profile_request_title);
        }
    }
}
