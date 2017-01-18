package com.dev.sectionedrv;


import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.ViewGroup;

public abstract class SimpleSectionedListAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private SparseIntArray mHeaderMap;

    public SimpleSectionedListAdapter() {
        mHeaderMap = new SparseIntArray();
    }

    public abstract int getHeaderCount();

    public abstract int getItemCount(int section);

    public abstract VH onCreateViewHolder(ViewGroup parent, boolean isHeader);

    public abstract void onBindHeaderViewHolder(VH holder, int headerIndex);

    public abstract void onBindViewHolder(VH holder, int headerIndex, int position);

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateViewHolder(parent, viewType == TYPE_HEADER);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        if (isHeader(position)) {
            onBindHeaderViewHolder(holder, mHeaderMap.get(position));
        } else {
            int hIndex = getHeaderIndex(position);
            int relativePos = position - mHeaderMap.keyAt(hIndex) - 1;
            onBindViewHolder(holder, hIndex, relativePos);
        }
    }

    private int getHeaderIndex(int position) {
        int headerKey = 0;
        for (int i = 0; i < mHeaderMap.size(); i++) {
            int key = mHeaderMap.keyAt(i);
            if (position < key)
                break;
            headerKey = key;
        }
        return mHeaderMap.get(headerKey);
    }

    @Override
    public int getItemCount() {
        int count = 0;
        for (int i = 0; i < getHeaderCount(); i++) {
            mHeaderMap.put(count, i);
            count += getItemCount(i) + 1;
        }
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position))
            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    private boolean isHeader(int position) {
        return mHeaderMap.get(position, -1) != -1;
    }
}
