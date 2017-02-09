package com.yemyatthu.restaurantbooker.domain.interactor;

import com.yemyatthu.restaurantbooker.domain.repository.TownshipRepository;

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
public class GetTownshipListTest {
    private GetTownshipList getTownshipList;
    @Mock private TownshipRepository townshipRepository;
    @Before
    public void setUp(){
        getTownshipList = new GetTownshipList(townshipRepository);
    }

    @Test
    public void testGetTownshipList(){
        getTownshipList.buildUseCaseObservable(null);
        Mockito.verify(townshipRepository).townships();
        Mockito.verifyNoMoreInteractions(townshipRepository);
    }
}
