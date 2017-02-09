package com.yemyatthu.restaurantbooker.data.repository.datasource;

import com.yemyatthu.restaurantbooker.data.cache.TownshipCache;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by Ye Myat Thu on 2/9/2017.
 */


@RunWith(MockitoJUnitRunner.class)
public class TownshipLocalDataStoreTest {
    public TownshipLocalDataStore townshipLocalDataStore;

    @Mock
    TownshipCache townshipCache;
    @Before
    public void setUp(){
        townshipLocalDataStore = new TownshipLocalDataStore(townshipCache);
    }
    @Test
    public void testGetTownshipFromCache(){
        townshipLocalDataStore.townships();
        Mockito.verify(townshipCache).get();
    }
}
