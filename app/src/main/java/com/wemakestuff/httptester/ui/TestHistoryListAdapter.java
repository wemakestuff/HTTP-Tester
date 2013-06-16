package com.wemakestuff.httptester.ui;

import android.view.LayoutInflater;
import com.wemakestuff.httptester.R;
import com.wemakestuff.httptester.core.TestHistory;

import java.util.List;

public class TestHistoryListAdapter extends AlternatingColorListAdapter<TestHistory> {
    /**
     * @param inflater
     * @param items
     * @param selectable
     */
    public TestHistoryListAdapter(LayoutInflater inflater, List<TestHistory> items,
                                  boolean selectable) {
        super(R.layout.test_history_list_item, inflater, items, selectable);
    }

    /**
     * @param inflater
     * @param items
     */
    public TestHistoryListAdapter(LayoutInflater inflater, List<TestHistory> items) {
        super(R.layout.test_history_list_item, inflater, items);
    }

    @Override
    protected int[] getChildViewIds() {
        return new int[] { R.id.tv_title, R.id.tv_summary,
                R.id.tv_date };
    }

    @Override
    protected void update(int position, TestHistory item) {
        super.update(position, item);

        setText(0, item.getTitle());
        setText(1, item.getContent());
        //setNumber(R.id.tv_date, item.getCreatedAt());
    }
}
