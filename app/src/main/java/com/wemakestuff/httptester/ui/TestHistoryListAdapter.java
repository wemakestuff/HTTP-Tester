package com.wemakestuff.httptester.ui;

import android.view.LayoutInflater;
import com.wemakestuff.httptester.R;
import com.wemakestuff.httptester.core.RequestHistory;

import java.util.List;

public class TestHistoryListAdapter extends AlternatingColorListAdapter<RequestHistory> {
    /**
     * @param inflater
     * @param items
     * @param selectable
     */
    public TestHistoryListAdapter(LayoutInflater inflater, List<RequestHistory> items,
                                  boolean selectable) {
        super(R.layout.list_item, inflater, items, selectable);
    }

    /**
     * @param inflater
     * @param items
     */
    public TestHistoryListAdapter(LayoutInflater inflater, List<RequestHistory> items) {
        super(R.layout.list_item, inflater, items);
    }

    @Override
    protected int[] getChildViewIds() {
        return new int[]{R.id.tv_name, R.id.tv_value};
    }

    @Override
    protected void update(int position, RequestHistory item) {
        super.update(position, item);

        setText(0, item.getUrl());
        setText(0, item.getLastUsedDate());
    }
}
