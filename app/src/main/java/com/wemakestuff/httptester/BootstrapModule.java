package com.wemakestuff.httptester;

import android.content.Context;
import com.wemakestuff.httptester.services.TestService;
import com.wemakestuff.httptester.ui.CarouselActivity;
import com.wemakestuff.httptester.ui.TestHistoryListFragment;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Dagger module for setting up provides statements.
 * Register all of your entry points below.
 */
@Module
(
        complete = false,

        injects = {
                BootstrapApplication.class,
                TestHistoryListFragment.class,
                CarouselActivity.class
        }

)
public class BootstrapModule  {

    @Provides
    @Singleton
    TestService provideTestService(final Context context) {
        return new TestService(context);
    }

}
