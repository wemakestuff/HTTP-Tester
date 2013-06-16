package com.wemakestuff.httptester.services;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import com.wemakestuff.httptester.core.Constants;
import com.wemakestuff.httptester.util.Ln;
import com.wemakestuff.httptester.util.SafeAsyncTask;

import javax.inject.Inject;


/**
 * Class used for sending and receiving a test via HTTP.
 */
public class TestService {

    protected Context context;

    @Inject
    public TestService(Context context) {
        this.context = context;
    }

    public void sendRequest(final Runnable onSuccess) {

        new RequestTask(context, onSuccess).execute();
    }

    private static class RequestTask extends SafeAsyncTask<Boolean> {

        private final Context context;
        private Runnable onSuccess;

        protected RequestTask(Context context, Runnable onSuccess) {
            this.context = context;
            this.onSuccess = onSuccess;
        }

        @Override
        public Boolean call() throws Exception {

            final Account[] accounts = AccountManager.get(context).getAccountsByType(Constants.Auth.BOOTSTRAP_ACCOUNT_TYPE);
            if(accounts.length > 0) {
                AccountManagerFuture<Boolean> removeAccountFuture = AccountManager.get(context).removeAccount
                        (accounts[0], null, null);
                if(removeAccountFuture.getResult() == true) {
                    return true;
                } else {
                    return false;
                }
            }

            return false;
        }

        @Override
        protected void onSuccess(Boolean requestSuccessful) throws Exception {
            super.onSuccess(requestSuccessful);

            Ln.d("Request succeeded: %s", requestSuccessful);
            onSuccess.run();

        }

        @Override
        protected void onException(Exception e) throws RuntimeException {
            super.onException(e);
            Ln.e(e.getCause(), "Request failed.");
        }
    }
}
