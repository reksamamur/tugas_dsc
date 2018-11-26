package com.ta.bukalapakcopy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class RvSpecialAdapter extends RecyclerView.Adapter<RvSpecialAdapter.RvSpesialViewHolder> {

    private Context mContext;
    private ArrayList<Special> specialArrayList;

    public RvSpecialAdapter(Context mContext, ArrayList<Special> specialArrayList) {
        this.mContext = mContext;
        this.specialArrayList = specialArrayList;
    }

    @NonNull
    @Override
    public RvSpesialViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflater = LayoutInflater.from(mContext)
                .inflate(R.layout.rv_spesial, viewGroup, false);
        return new RvSpesialViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull RvSpesialViewHolder rvSpesialViewHolder, int i) {
        Special nCurrent = specialArrayList.get(i);
        rvSpesialViewHolder.imgSlide.setImageResource(nCurrent.getImg());
    }

    @Override
    public int getItemCount() {
        return specialArrayList.size();
    }

    class RvSpesialViewHolder extends RecyclerView.ViewHolder {

        ImageView imgSlide;

        RvSpesialViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSlide = itemView.findViewById(R.id.img_spesial);
        }
    }
}
