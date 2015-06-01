package com.agroambles.olavera.flatsmanagement.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.agroambles.olavera.flatsmanagement.R;
import com.agroambles.olavera.flatsmanagement.model.entities.Building;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author Olavera
 */
public class BuildingListAdapter extends RecyclerView.Adapter<BuildingListAdapter.BuildingHolder> {

    private final BuildingListAdapterCallbacks mCallbacks;
    private final List<Building> mBuildingList = new ArrayList<>();

    public BuildingListAdapter(BuildingListAdapterCallbacks callbacks){
        super();
        this.mCallbacks = callbacks;
    }

    @Override
    public BuildingHolder onCreateViewHolder(ViewGroup parentViewGroup, int i) {
        View rowView = LayoutInflater.from(parentViewGroup.getContext())
                .inflate(R.layout.item_building_list, parentViewGroup, false);

        return new BuildingHolder (rowView, mCallbacks);
    }

    @Override
    public void onBindViewHolder(BuildingHolder viewHolder, final int position) {
        final Building rowData = mBuildingList.get(position);
        viewHolder.idTextView.setText(rowData.getId() + "");
        viewHolder.nameTextView.setText(rowData.getName());
        viewHolder.itemView.setTag(rowData);
    }

    @Override
    public int getItemCount() {
        return mBuildingList.size();
    }

    @Override
    public long getItemId(int position) {
        return mBuildingList.get(position).getId();
    }

    public void removeData (int position) {
        mBuildingList.remove(position);
        notifyItemRemoved(position);
    }

    public void addItem(int positionToAdd, Building building) {
        mBuildingList.add(positionToAdd, building);
        notifyItemInserted(positionToAdd);
    }

    public void appendList(List<Building> buildingList) {
        int positionStart = mBuildingList.size();
        mBuildingList.addAll(buildingList);
        notifyItemRangeInserted(positionStart, buildingList.size());
    }

    public static class BuildingHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @InjectView(R.id.tv_id)
        public TextView idTextView;
        @InjectView(R.id.tv_name)
        public TextView nameTextView;

        private BuildingListAdapterCallbacks mCallbacks;

        public BuildingHolder(View itemView, BuildingListAdapterCallbacks callbacks) {
            super(itemView);
            ButterKnife.inject(this, itemView);

            this.mCallbacks = callbacks;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mCallbacks.OnItemClick(getPosition());
        }
    }

    public interface BuildingListAdapterCallbacks {

        void OnItemClick(int position);
    }

}