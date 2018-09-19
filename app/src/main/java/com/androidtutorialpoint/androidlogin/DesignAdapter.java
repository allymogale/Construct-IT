package com.androidtutorialpoint.androidlogin;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class DesignAdapter extends RecyclerView.Adapter<DesignAdapter.CustomViewHolder> {
    private Context mContext;
    private List<Design> designs;

    public DesignAdapter(List<Design> designs, Context mContext) {
        this.mContext = mContext;
        this.designs = designs;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.design_card, parent, false);

        return new CustomViewHolder(itemView);
    }

    /**
     *  Populate the views with appropriate Text and Images
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final DesignAdapter.CustomViewHolder holder, int position) {
        Design design = designs.get(position);
        holder.name.setText(design.getName());
        holder.price.setText(design.getPrice());
        holder.image.setImageResource(design.getImageResource());
        holder.options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOptionsMenu(holder.options);
            }
        });
    }

    /**
     * Display options on click of options icon (3 dots)
     *
     * @param view
     */
    private void showOptionsMenu(View view) {
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_designs, popup.getMenu());
        popup.setOnMenuItemClickListener(new DesignItemClickListener());
        popup.show();
    }

    @Override
    public int getItemCount() {
        return designs.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView name, price;
        public ImageView image, options;

        /**
         * Constructor to initialize the Views
         *
         * @param itemView
         */
        public CustomViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.designName);
            price = (TextView) itemView.findViewById(R.id.designPrice);
            image = (ImageView) itemView.findViewById(R.id.deignImage);
            options = (ImageView) itemView.findViewById(R.id.moreoptions);
        }
    }

    private class DesignItemClickListener implements PopupMenu.OnMenuItemClickListener {
        /**
         * Display Toast message on click of the options in the options
         *
         * @param item
         * @return
         */
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.View_Summary:
                    Toast.makeText(mContext, "View Summary", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.View_Plan:
                    Toast.makeText(mContext, "View Plan", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    }
}
