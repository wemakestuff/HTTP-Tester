package com.wemakestuff.httptester.ui;

import android.view.LayoutInflater;
import com.wemakestuff.httptester.R;
import com.wemakestuff.httptester.core.QueryParameter;

import java.util.List;

public class QueryParameterListAdapter extends AlternatingColorListAdapter<QueryParameter> {
    /**
     * @param inflater
     * @param items
     * @param selectable
     */
    public QueryParameterListAdapter(LayoutInflater inflater, List<QueryParameter> items,
                                     boolean selectable) {
        super(R.layout.list_item, inflater, items, selectable);
    }

    /**
     * @param inflater
     * @param items
     */
    public QueryParameterListAdapter(LayoutInflater inflater, List<QueryParameter> items) {
        super(R.layout.list_item, inflater, items);
    }

    @Override
    protected int[] getChildViewIds() {
        return new int[]{R.id.tv_name, R.id.tv_value};
    }

    @Override
    protected void update(int position, QueryParameter item) {
        super.update(position, item);

        setText(0, item.getName());
        setText(0, item.getValue());
    }
}
