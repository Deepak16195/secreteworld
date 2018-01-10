package com.credosys.solutions.secrete.world.Adapters.NormalScroll;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by win7 on 10-Jan-18.
 */

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ImageHolder>{
    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ImageHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ImageHolder  extends RecyclerView.ViewHolder{

        public ImageHolder(View itemView) {
            super(itemView);
        }
    }
}
