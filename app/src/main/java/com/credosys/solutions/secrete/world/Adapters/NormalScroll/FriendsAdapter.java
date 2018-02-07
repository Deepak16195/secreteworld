package com.credosys.solutions.secrete.world.Adapters.NormalScroll;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.Pojos.App.pojoFriends;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win7 on 10-Jan-18.
 */

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ImageHolder> {

    List<pojoFriends> pojoFriends;
    ImageView imageView;
    public FriendsAdapter(ArrayList<pojoFriends> friend) {
        pojoFriends = friend;
    }

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_friend_card, parent, false);
        imageView = v.findViewById(R.id.img_friend_face);

        return new FriendsAdapter.ImageHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageHolder holder, int position) {
        imageView.setImageResource(pojoFriends.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return pojoFriends.size();
    }

    class ImageHolder extends RecyclerView.ViewHolder {

        public ImageHolder(View itemView) {
            super(itemView);

        }
    }
}
