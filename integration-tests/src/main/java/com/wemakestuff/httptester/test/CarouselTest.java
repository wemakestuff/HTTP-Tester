

package com.wemakestuff.httptester.test;

import android.test.ActivityInstrumentationTestCase2;


/**
 * Request displaying of carousel.
 */
public class CarouselTest extends ActivityInstrumentationTestCase2<CarouselActivity> {

    /**
     * Create request for {@link CarouselActivity}
     */
    public CarouselTest() {
        super(CarouselActivity.class);
    }

    /**
     * Verify activity exists
     */
    public void testActivityExists() {
        assertNotNull(getActivity());
    }
}
