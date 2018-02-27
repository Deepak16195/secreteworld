package com.credosys.solutions.secrete.world.Adapters.NormalScroll;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.credosys.solutions.secrete.world.Pojos.App.OrdersSellers;
import com.credosys.solutions.secrete.world.R;

import java.util.List;

/**
 * Created by credosys on 27/2/18.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderHolder>{
    Context context;
    List<OrdersSellers> list;

    public OrderAdapter(Context context, List<OrdersSellers> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public OrderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_order,parent, false);
        final OrderHolder mViewHolder=new OrderHolder(v);
//        v.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.onItemClick(v, mViewHolder.getAdapterPosition());
//            }
//        });

        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(OrderHolder holder, int position) {
        collapse(holder.llOrdersRow);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private void expand(LinearLayout mLinearLayout) {
        //set Visible
//        mLinearLayout.setVisibility(View.VISIBLE);

        final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        mLinearLayout.measure(widthSpec, heightSpec);

        ValueAnimator mAnimator = slideAnimator(140, mLinearLayout.getMeasuredHeight(),mLinearLayout);
        mAnimator.start();
    }
    private ValueAnimator slideAnimator(int start, int end, final LinearLayout mLinearLayout) {

        ValueAnimator animator = ValueAnimator.ofInt(start, end);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //Update Height
                final LinearLayout ll=mLinearLayout;
                int value = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = ll.getLayoutParams();
                layoutParams.height = value;
                ll.setLayoutParams(layoutParams);

            }
        });
        return animator;
    }
    private void collapse(final LinearLayout mLinearLayout) {
        int finalHeight = mLinearLayout.getHeight();

        ValueAnimator mAnimator = slideAnimator(finalHeight, 120,mLinearLayout);
        mAnimator.start();
    }

    class OrderHolder extends RecyclerView.ViewHolder{
        LinearLayout llSingleorder,llOrdersRow;
        ImageView imgExpand;
        TextView order;
        public OrderHolder(View itemView) {
            super(itemView);
            llOrdersRow=itemView.findViewById(R.id.ll_orders_row);
            llSingleorder=itemView.findViewById(R.id.ll_singleorder);
            imgExpand=itemView.findViewById(R.id.img_expand);
            order=itemView.findViewById(R.id.title_order);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(list.get(getAdapterPosition()).isMin()) {
                        expand(llOrdersRow);
                        imgExpand.setImageResource(R.drawable.ic_close_btn);
                        list.get(getAdapterPosition()).setMin(false);
                    }
                    else{
                        collapse(llOrdersRow);
                        imgExpand.setImageResource(R.drawable.ic_expand_btn);
                        list.get(getAdapterPosition()).setMin(true);
                    }
                }
            });
        }
    }
}
