package com.wemakestuff.httptester.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.ListView;
import com.github.kevinsawicki.wishlist.SingleTypeAdapter;
import com.wemakestuff.httptester.BootstrapApplication;
import com.wemakestuff.httptester.R;
import com.wemakestuff.httptester.core.TestHistory;
import com.wemakestuff.httptester.services.TestService;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

public class TestHistoryListFragment extends ItemListFragment<TestHistory> {

    @Inject
    protected TestService testService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BootstrapApplication.getInstance().inject(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setEmptyText(R.string.no_test_history);


    }

    @Override
    protected void configureList(Activity activity, ListView listView) {
        super.configureList(activity, listView);

        listView.setFastScrollEnabled(true);
        listView.setDividerHeight(0);

        getListAdapter()
                .addHeader(activity.getLayoutInflater()
                        .inflate(R.layout.test_history_list_item_labels, null));
    }

    @Override
    TestService getTestService() {
        return testService;
    }

    @Override
    public void onDestroyView() {
        setListAdapter(null);

        super.onDestroyView();
    }

    @Override
    public Loader<List<TestHistory>> onCreateLoader(int id, Bundle args) {
        final List<TestHistory> initialItems = items;
        return new ThrowableLoader<List<TestHistory>>(getActivity(), items) {

            @Override
            public List<TestHistory> loadData() throws Exception {
                if (getActivity() != null) {
                    //return serviceProvider.getService(getActivity()).getNews();
                    return Collections.emptyList();
                } else {
                    return Collections.emptyList();
                }
            }
        };
    }

    @Override
    protected SingleTypeAdapter<TestHistory> createAdapter(List<TestHistory> items) {
        return new TestHistoryListAdapter(getActivity().getLayoutInflater(), items);
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        TestHistory news = ((TestHistory) l.getItemAtPosition(position));

        //startActivity(new Intent(getActivity(), NewsActivity.class).putExtra(NEWS_ITEM, news));
    }

    @Override
    protected int getErrorMessage(Exception exception) {
        return R.string.error_loading_test_history;
    }
}
