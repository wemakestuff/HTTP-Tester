package com.wemakestuff.httptester;

import android.accounts.AccountManager;
import android.content.Context;

import com.wemakestuff.httptester.authenticator.BootstrapAuthenticatorActivity;
import com.wemakestuff.httptester.authenticator.LogoutService;
import com.wemakestuff.httptester.core.CheckIn;
import com.wemakestuff.httptester.core.TimerService;
import com.wemakestuff.httptester.ui.BootstrapTimerActivity;
import com.wemakestuff.httptester.ui.CarouselActivity;
import com.wemakestuff.httptester.ui.CheckInsListFragment;
import com.wemakestuff.httptester.ui.ItemListFragment;
import com.wemakestuff.httptester.ui.NewsActivity;
import com.wemakestuff.httptester.ui.NewsListFragment;
import com.wemakestuff.httptester.ui.UserActivity;
import com.wemakestuff.httptester.ui.UserListFragment;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for setting up provides statements.
 * Register all of your entry points below.
 */
@Module
(
        complete = false,

        injects = {
                BootstrapApplication.class,
                BootstrapAuthenticatorActivity.class,
                CarouselActivity.class,
                BootstrapTimerActivity.class,
                CheckInsListFragment.class,
                NewsActivity.class,
                NewsListFragment.class,
                UserActivity.class,
                UserListFragment.class,
                TimerService.class
        }

)
public class BootstrapModule  {

    @Singleton
    @Provides
    Bus provideOttoBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    LogoutService provideLogoutService(final Context context, final AccountManager accountManager) {
        return new LogoutService(context, accountManager);
    }

}
