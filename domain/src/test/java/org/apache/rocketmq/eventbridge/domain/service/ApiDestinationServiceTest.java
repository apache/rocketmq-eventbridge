package org.apache.rocketmq.eventbridge.domain.service;

import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.ApiDestinationService;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.EventApiDestination;
import org.apache.rocketmq.eventbridge.domain.repository.ApiDestinationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class ApiDestinationServiceTest {

    @InjectMocks
    private ApiDestinationService apiDestinationService;
    @Mock
    private ApiDestinationRepository apiDestinationRepository;

    @Before
    public void testBefore() {
        ReflectionTestUtils.setField(apiDestinationService, "apiDestinationLimit", "10");
        Mockito.when(apiDestinationRepository.createApiDestination(any())).thenReturn(Boolean.TRUE);
        Mockito.when(apiDestinationRepository.deleteApiDestination(any(), any())).thenReturn(Boolean.TRUE);
        Mockito.when(apiDestinationRepository.updateApiDestination(any())).thenReturn(Boolean.TRUE);
        EventApiDestination eventApiDestination = new EventApiDestination();
        eventApiDestination.setName(UUID.randomUUID().toString());
        Mockito.when(apiDestinationRepository.getApiDestinationCount(any(), any())).thenReturn(8);
        Mockito.when(apiDestinationRepository.listApiDestinations(any(), any(), any(), anyInt())).thenReturn(new ArrayList<>());
    }

    @Test
    public void testCreateApiDestination() {
        Mockito.when(apiDestinationRepository.getApiDestination(any(), any())).thenReturn(null);
        EventApiDestination eventApiDestination = new EventApiDestination();
        eventApiDestination.setName(UUID.randomUUID().toString());
        eventApiDestination.setAccountId(UUID.randomUUID().toString());
        final String apiDestination = apiDestinationService.createApiDestination(eventApiDestination);
        Assert.assertNotNull(apiDestination);
    }

    @Test
    public void testUpdateApiDestination() {
        Mockito.when(apiDestinationRepository.getApiDestination(any(), any())).thenReturn(new EventApiDestination());
        EventApiDestination eventApiDestination = new EventApiDestination();
        eventApiDestination.setName(UUID.randomUUID().toString());
        eventApiDestination.setAccountId(UUID.randomUUID().toString());
        final Boolean aBoolean = apiDestinationService.updateApiDestination(eventApiDestination);
        Assert.assertTrue(aBoolean);
    }

    @Test
    public void testGetApiDestination() {
        Mockito.when(apiDestinationRepository.getApiDestination(any(), any())).thenReturn(new EventApiDestination());
        final EventApiDestination apiDestination = apiDestinationService.getApiDestination(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        Assert.assertNotNull(apiDestination);
    }

    @Test
    public void testDeleteApiDestination() {
        Mockito.when(apiDestinationRepository.getApiDestination(any(), any())).thenReturn(new EventApiDestination());
        final Boolean aBoolean = apiDestinationService.deleteApiDestination(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        Assert.assertTrue(aBoolean);
    }

    @Test
    public void testListApiDestinations() {
        final PaginationResult<List<EventApiDestination>> listPaginationResult = apiDestinationService.listApiDestinations(UUID.randomUUID().toString(), UUID.randomUUID().toString(), "0", 10);
        Assert.assertNotNull(listPaginationResult.getData());
    }
}
