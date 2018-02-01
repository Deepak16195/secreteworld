package com.credosys.solutions.secrete.world.Adapters.NormalScroll;

import android.animation.ValueAnimator;
import android.content.Context;
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
 * Created by win7 on 16-Jan-18.
 */

public class OrderSellerAdapter extends RecyclerView.Adapter<OrderSellerAdapter.OrderHolder> {
//    private CustomItemClickListener listener;
Context context;
    List<OrdersSellers> list;
    String fragmentString;
    Boolean mini;
    public OrderSellerAdapter(Context context, List<OrdersSellers> list, String s) {
        this.context=context;
        this.list=list;
        fragmentString = s;
    }

    @Override
    public OrderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_order_seller_row,parent, false);
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
    public void onBindViewHolder(final OrderHolder holder, int position) {
        collapse(holder.cvOrder);
//        holder.imgExpand.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(list.get(position).isMin()) {
//                    expand(holder.llSingleorder);
//                    list.get(position).setMin(false);
//                }
//                else{
//                    collapse(holder.llSingleorder);
//                    list.get(position).setMin(true);
//                }
//
//            }
//        });
    }
    private void expand(CardView mLinearLayout) {
        //set Visible
//        mLinearLayout.setVisibility(View.VISIBLE);

        final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        mLinearLayout.measure(widthSpec, heightSpec);

        ValueAnimator mAnimator = slideAnimator(130, mLinearLayout.getMeasuredHeight(),mLinearLayout);
        mAnimator.start();
    }
    private ValueAnimator slideAnimator(int start, int end, final CardView mLinearLayout) {

        ValueAnimator animator = ValueAnimator.ofInt(start, end);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //Update Height
                final CardView ll=mLinearLayout;
                int value = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = ll.getLayoutParams();
                layoutParams.height = value;
                ll.setLayoutParams(layoutParams);

            }
        });
        return animator;
    }
    private void collapse(final CardView mLinearLayout) {
        int finalHeight = mLinearLayout.getHeight();

        ValueAnimator mAnimator = slideAnimator(finalHeight, 95,mLinearLayout);
        mAnimator.start();
    }
    @Override
    public int getItemCount() {
        return 6;
    }


    class OrderHolder extends RecyclerView.ViewHolder {
        LinearLayout llSingleorder;
        ImageView imgExpand;
        CardView cvOrder;
        TextView order;
        private OrderHolder(View itemView) {
            super(itemView);
            llSingleorder=itemView.findViewById(R.id.ll_singleorder);
            imgExpand=itemView.findViewById(R.id.img_expand);
            cvOrder=itemView.findViewById(R.id.cv_order);
            order=itemView.findViewById(R.id.title_order);


            if(fragmentString.equalsIgnoreCase("MY_ORDER")){
                order.setVisibility(View.VISIBLE);
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(list.get(getAdapterPosition()).isMin()) {
                        expand(cvOrder);
                       imgExpand.setImageResource(R.drawable.ic_close_btn);
                        list.get(getAdapterPosition()).setMin(false);
                    }
                    else{
                        collapse(cvOrder);
                        imgExpand.setImageResource(R.drawable.ic_expand_btn);
                        list.get(getAdapterPosition()).setMin(true);
                    }
                }
            });
        }
    }
}
