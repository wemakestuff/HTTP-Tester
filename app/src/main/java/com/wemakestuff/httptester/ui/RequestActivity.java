package com.wemakestuff.httptester.ui;

import android.os.Bundle;
import android.widget.*;
import butterknife.InjectView;
import com.wemakestuff.httptester.R;
import com.wemakestuff.httptester.core.Constants;
import com.wemakestuff.httptester.core.Request;

public class RequestActivity extends BootstrapActivity {

    protected Request requestItem;
    @InjectView(R.id.sp_url_protocol)
    protected Spinner protocol;
    @InjectView(R.id.et_url)
    protected EditText url;
    @InjectView(R.id.sp_request_method)
    protected Spinner requestMethod;
    @InjectView(R.id.ib_add_query_parameters)
    protected ImageButton addQueryParameters;
    @InjectView(R.id.ib_clear_query_parameters)
    protected ImageButton clearQueryParameters;
    @InjectView(R.id.lv_query_parameters)
    protected ListView queryParametersListView;
    @InjectView(R.id.ib_add_headers)
    protected ImageButton addHeaders;
    @InjectView(R.id.ib_clear_headers)
    protected ImageButton clearHeaders;
    @InjectView(R.id.lv_headers)
    protected ListView headersListView;
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
    }

}
