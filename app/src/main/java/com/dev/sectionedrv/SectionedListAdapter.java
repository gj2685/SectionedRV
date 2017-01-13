package com.dev.sectionedrv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SectionedListAdapter extends SimpleSectionedListAdapter<RecyclerView.ViewHolder> {

    private List<SectionedData> mDataSection;

    public SectionedListAdapter(List<SectionedData> dataSection) {
        mDataSection = dataSection;
    }

    @Override
    public int getHeaderCount() {
        return mDataSection.size();
    }

    @Override
    public int getItemCount(int section) {
        return mDataSection.get(section).getModelList().size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, boolean isHeader) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (isHeader)
            return new HeaderViewHolder(inflater.inflate(R.layout.header_row_layout, parent, false));
        return new ItemViewHolder(inflater.inflate(R.layout.item_row_layout, parent, false));
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder viewHolder, int headerIndex) {
        HeaderViewHolder holder = (HeaderViewHolder) viewHolder;
        holder.bind(headerIndex);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int headerIndex, int position) {
        ItemViewHolder holder = (ItemViewHolder) viewHolder;
        holder.bind(headerIndex, position);
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView tvHeader;

        HeaderViewHolder(View itemView) {
            super(itemView);
            tvHeader = (TextView) itemView.findViewById(R.id.tv_header);
        }

        void bind(int position) {
            String header = mDataSection.get(position).getHeaderName();
            tvHeader.setText(header);
        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView ivUser;
        TextView tvName;
        TextView tvAge;

        ItemViewHolder(View itemView) {
            super(itemView);
            ivUser = (ImageView) itemView.findViewById(R.id.iv_user);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvAge = (TextView) itemView.findViewById(R.id.tv_age);
        }

        void bind(int headerIndex, int position) {
            List<Model> modelList = mDataSection.get(headerIndex).getModelList();
            Model model = modelList.get(position);
            String imgUrl = model.getImgUrl();
            String name = model.getName();
            int age = model.getAge();

            ivUser.setImageResource(R.drawable.no_image);
            tvName.setText(name);
            tvAge.setText(String.valueOf(age));
        }
    }
}
