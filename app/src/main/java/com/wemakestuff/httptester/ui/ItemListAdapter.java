package com.wemakestuff.httptester.ui;

import android.view.LayoutInflater;
import com.wemakestuff.httptester.R;
import com.wemakestuff.httptester.core.Item;

import java.util.List;

public class ItemListAdapter extends AlternatingColorListAdapter<Item> {
    /**
     * @param inflater
     * @param items
     * @param selectable
     */
    public ItemListAdapter(LayoutInflater inflater, List<Item> items,
                           boolean selectable) {
        super(R.layout.list_item, inflater, items, selectable);
    }

    /**
     * @param inflater
     * @param items
     */
    public ItemListAdapter(LayoutInflater inflater, List<Item> items) {
        super(R.layout.list_item, inflater, items);
    }

    @Override
    protected int[] getChildViewIds() {
        return new int[]{R.id.tv_name, R.id.tv_value};
    }

    @Override
    protected void update(int position, Item item) {
        super.update(position, item);

        setText(0, item.getName());
        setText(1, item.getValue());
    }
}
