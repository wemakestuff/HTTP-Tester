package com.wemakestuff.httptester.ui;

import android.os.Bundle;
import android.widget.*;
import butterknife.InjectView;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.wemakestuff.httptester.R;
import com.wemakestuff.httptester.core.Constants;
import com.wemakestuff.httptester.core.HeaderParameter;
import com.wemakestuff.httptester.core.QueryParameter;
import com.wemakestuff.httptester.core.Request;
import com.wemakestuff.httptester.view.FlowLayout;

import java.util.ArrayList;
import java.util.List;

public class RequestActivity extends BootstrapActivity {

    protected Request requestItem;
    @InjectView(R.id.tv_protocol_label)
    protected TextView protocolLabel;
    @InjectView(R.id.sp_url_protocol)
    protected Spinner protocol;
    @InjectView(R.id.tv_request_method_label)
    protected TextView requestMethodLabel;
    @InjectView(R.id.sp_request_method)
    protected Spinner requestMethod;
    @InjectView(R.id.tv_url_label)
    protected TextView urlLabel;
    @InjectView(R.id.et_url)
    protected EditText url;
    @InjectView(R.id.tv_query_parameters_label)
    protected TextView queryParametersLabel;
    @InjectView(R.id.ib_add_query_parameters)
    protected ImageButton addQueryParameters;
    @InjectView(R.id.ib_clear_query_parameters)
    protected ImageButton clearQueryParameters;
    @InjectView(R.id.fl_query_parameters)
    protected FlowLayout queryParametersList;
    @InjectView(R.id.tv_no_query_parameters)
    protected TextView noQueryParameters;
    @InjectView(R.id.ib_add_headers)
    protected ImageButton addHeaders;
    @InjectView(R.id.ib_clear_headers)
    protected ImageButton clearHeaders;
    @InjectView(R.id.fl_headers)
    protected FlowLayout headersList;
    @InjectView(R.id.tv_no_headers)
    protected TextView noHeaders;
    @InjectView(R.id.tv_payload_label)
    protected TextView payloadLabel;
    @InjectView(R.id.et_payload)
    protected EditText payload;
    @InjectView(R.id.tv_response)
    protected TextView response;
    @InjectView(R.id.tv_response_body)
    protected TextView responseBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.request);

        if (getIntent() != null && getIntent().getExtras() != null) {
            requestItem = (Request) getIntent().getExtras().getSerializable(Constants.REQUEST);
            setTitle(getResources().getString(R.string.view_request));
        } else {
            setTitle(getResources().getString(R.string.create_request));
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        List<QueryParameter> queryParams = new ArrayList<QueryParameter>();
        queryParams.add(new QueryParameter("city", "orlando"));
        queryParams.add(new QueryParameter("state", "florida"));

        List<HeaderParameter> headerParams = new ArrayList<HeaderParameter>();
        headerParams.add(new HeaderParameter("Accept", "application/json"));
        headerParams.add(new HeaderParameter("Authorization", "SDASD!112312asdfar23"));

        QueryParameterListAdapter queryParamsAdapter = new QueryParameterListAdapter(getLayoutInflater(), queryParams);
        for (int i = 0; i < queryParamsAdapter.getCount(); i++) {
            queryParametersList.addView(queryParamsAdapter.getView(i, null, queryParametersList));
        }

        HeaderParameterListAdapter headerParamsAdapter = new HeaderParameterListAdapter(getLayoutInflater(), headerParams);
        for (int i = 0; i < headerParamsAdapter.getCount(); i++) {
            headersList.addView(headerParamsAdapter.getView(i, null, headersList));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.request, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_save:
                return true;
            case R.id.menu_history:
                return true;
            case R.id.menu_clear:
                return true;
            case R.id.menu_settings:
                return true;
            case R.id.menu_go:
                return true;
            case R.id.menu_stop:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
}
