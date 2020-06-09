package com.gardeos.gardenos;

import org.junit.Assert;
import com.gardeos.gardenos.entity.Client;
import com.gardeos.gardenos.service.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class AdressServiceTest {

    @Test
    public void client_name_check_valid() {
        ClientService clientService = Mockito.mock(ClientService.class);
        Client client= new Client();
        client.setName("Bern");
        when(clientService.getClient(5L)).thenReturn(client);
        String testName = clientService.getClient(5L).getName();
        Assert.assertEquals("Bern", testName);
    }

}
