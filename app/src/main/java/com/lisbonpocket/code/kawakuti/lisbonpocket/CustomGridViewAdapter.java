package com.lisbonpocket.code.kawakuti.lisbonpocket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Russelius on 07/01/16.
 */
public class CustomGridViewAdapter extends BaseAdapter {
    private Context context;
    private final String[] stringValues;
    private final int [] resourceImagesIds;


    public CustomGridViewAdapter(Context context, int [] resourcesImg , String[] stringValues) {
        this.context = context;
        this.stringValues = stringValues;
        this.resourceImagesIds = resourcesImg;
    }

    @Override
    public int getCount() {
        return resourceImagesIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (row == null) {

            row = inflater.inflate(R.layout.service_grid, parent, false);
            holder = new RecordHolder();
            holder.txtTitle = (TextView) row.findViewById(R.id.item_text);
            holder.imageItem = (ImageView) row.findViewById(R.id.item_image);

            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }
        holder.txtTitle.setText(stringValues[position]);
        holder.imageItem.setImageResource(resourceImagesIds[position]);
            holder.imageItem.setScaleType(ImageView.ScaleType.CENTER_CROP);
            holder.imageItem.setPadding(8, 8, 8, 8);
        return row;
    }


    static class RecordHolder {
        TextView txtTitle;
        ImageView imageItem;
    }


}
