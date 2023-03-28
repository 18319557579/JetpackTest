package com.hsf.viewpager.normal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hsf.viewpager.R;

import java.util.List;

public class VpAdapter extends RecyclerView.Adapter<VpAdapter.VpViewHolder>{

    private List<ViewPagerModel> viewPagerModels;

    public VpAdapter(List<ViewPagerModel> viewPagerModels) {
        this.viewPagerModels = viewPagerModels;
    }

    @NonNull
    @Override
    public VpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_pager_item, parent, false);
        return new VpViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VpViewHolder holder, int position) {
        ViewPagerModel viewPagerModel = viewPagerModels.get(position);
        holder.mTextView.setText(viewPagerModel.getName());
        holder.mImage.setImageResource(viewPagerModel.getImage());
    }

    @Override
    public int getItemCount() {
        return viewPagerModels.size();
    }

    static class VpViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ImageView mImage;

        public VpViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.vp_item_text);
            mImage = itemView.findViewById(R.id.vp_item_image);
        }
    }
}
