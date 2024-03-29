package com.credosys.solutions.secrete.world.Adapters.NormalScroll;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.credosys.solutions.secrete.world.Pojos.App.ExploreGooglePlaces;
import com.credosys.solutions.secrete.world.R;

import java.util.List;

/**
 * Created by win7 on 30-Dec-17.
 */

public class GoogleHorizontalAdapter extends RecyclerView.Adapter<GoogleHorizontalAdapter.TextHolder> {
    private List<ExploreGooglePlaces>  list;
    public GoogleHorizontalAdapter(List<ExploreGooglePlaces> list)  {
        this.list=list;
    }

    @Override
    public TextHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_google_place_card, parent, false);
        return new TextHolder(itemView);

}
    @Override
    public void onBindViewHolder(TextHolder holder, int position) {
        ExploreGooglePlaces exploreGooglePlaces=list.get(position);
        if(list.get(position).getCount()==0)
            holder.txtGoogleFamous.setText(exploreGooglePlaces.getPlaces());
        else
            holder.txtGoogleFamous.setText(exploreGooglePlaces.getPlaces()+"("+exploreGooglePlaces.getCount()+")");

        holder.llTextBackground.setBackgroundResource(exploreGooglePlaces.getColor());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TextHolder extends RecyclerView.ViewHolder{
        TextView txtGoogleFamous;
        LinearLayout llTextBackground;
        private TextHolder(View itemView) {
            super(itemView);
            txtGoogleFamous=itemView.findViewById(R.id.card_google_places);
            llTextBackground=itemView.findViewById(R.id.ll_textbackground);
        }
    }
}
