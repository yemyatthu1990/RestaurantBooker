package com.yemyatthu.restaurantbooker.data.repository.datasource;

import com.yemyatthu.restaurantbooker.data.cache.TownshipCache;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by Ye Myat Thu on 2/9/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class TownshipCloudDataStoreTest {
    private TownshipCloudDataStore townshipCloudDataStore;

    @Mock
    TownshipCache townshipCache;

    @Before
    public void setUp(){
        townshipCloudDataStore = new TownshipCloudDataStore(townshipCache);
    }

    @Test
    public void testGetTownshipListFromAPI(){
        townshipCloudDataStore.townships();
}
}
