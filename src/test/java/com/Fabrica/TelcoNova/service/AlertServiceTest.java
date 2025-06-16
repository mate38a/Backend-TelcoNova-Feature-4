package com.Fabrica.TelcoNova.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Fabrica.TelcoNova.dto.CreateAlertInput;
import com.Fabrica.TelcoNova.dto.UpdateAlertInput;
import com.Fabrica.TelcoNova.model.AlertModel;
import com.Fabrica.TelcoNova.model.DeliveryMethodModel;
import com.Fabrica.TelcoNova.model.EventModel;
import com.Fabrica.TelcoNova.repository.AlertRepository;
import com.Fabrica.TelcoNova.repository.DeliveryMethodRepository;
import com.Fabrica.TelcoNova.repository.EventRepository;

@ExtendWith(MockitoExtension.class)
class AlertServiceTest {

    @Mock private AlertRepository alertRepo;
    @Mock private EventRepository eventRepo;
    @Mock private DeliveryMethodRepository dmRepo;

    @InjectMocks
    private AlertService service;

    @Test
    void createAlert_success() {
        CreateAlertInput in = new CreateAlertInput();
        in.setEventId(1L);
        in.setDeliveryMethodId(2L);
        in.setMessageTemplate("¡Alerta!");

        EventModel ev = new EventModel(); ev.setId(1L);
        DeliveryMethodModel dm = new DeliveryMethodModel(); dm.setId(2L);

        when(eventRepo.findById(1L)).thenReturn(Optional.of(ev));
        when(dmRepo.findById(2L)).thenReturn(Optional.of(dm));
        when(alertRepo.save(any(AlertModel.class))).thenAnswer(i -> i.getArgument(0));

        AlertModel result = service.createAlert(in);

        assertNotNull(result.getCreatedAt());
        assertEquals("¡Alerta!", result.getMessageTemplate());
        assertSame(ev, result.getEvent());
        assertSame(dm, result.getDeliveryMethod());
        verify(alertRepo).save(result);
    }

    @Test
    void createAlert_eventNotFound_throws() {
        when(eventRepo.findById(1L)).thenReturn(Optional.empty());

        CreateAlertInput in = new CreateAlertInput();
        in.setEventId(1L);
        in.setDeliveryMethodId(2L);

        assertThrows(RuntimeException.class, () -> service.createAlert(in));
    }

    @Test
    void createAlert_deliveryMethodNotFound_throws() {
        EventModel ev = new EventModel(); ev.setId(1L);
        when(eventRepo.findById(1L)).thenReturn(Optional.of(ev));
        when(dmRepo.findById(2L)).thenReturn(Optional.empty());

        CreateAlertInput in = new CreateAlertInput();
        in.setEventId(1L);
        in.setDeliveryMethodId(2L);

        assertThrows(RuntimeException.class, () -> service.createAlert(in));
    }

    @Test
    void updateAlert_success() {
        AlertModel existing = new AlertModel();
        existing.setId(5L);
        existing.setMessageTemplate("Antiguo");
        existing.setActive(false);

        when(alertRepo.findById(5L)).thenReturn(Optional.of(existing));
        when(alertRepo.save(existing)).thenReturn(existing);

        UpdateAlertInput in = new UpdateAlertInput();
        in.setMessageTemplate("Nuevo");
        in.setActive(true);

        boolean ok = service.updateAlert(5L, in);

        assertTrue(ok);
        assertEquals("Nuevo", existing.getMessageTemplate());
        assertTrue(existing.isActive());
        verify(alertRepo).save(existing);
    }

    @Test
    void updateAlert_notFound_throws() {
        // 1) Arranca el escenario
        UpdateAlertInput in = new UpdateAlertInput();
        when(alertRepo.findById(99L)).thenReturn(Optional.empty());
    
        // 2) Dentro del lambda solo SERVICE.updateAlert(...)
        RuntimeException ex = assertThrows(RuntimeException.class,
            () -> service.updateAlert(99L, in));
    
        // (opcional) 3) puedes comprobar también el mensaje
        assertEquals("Alerta no encontrada", ex.getMessage());
    }
    

    @Test
    void deleteAlert_success() {
        AlertModel existing = new AlertModel(); existing.setId(7L);
        when(alertRepo.findById(7L)).thenReturn(Optional.of(existing));

        boolean ok = service.deleteAlert(7L);

        assertTrue(ok);
        verify(alertRepo).delete(existing);
    }

    @Test
    void deleteAlert_notFound_throws() {
        when(alertRepo.findById(8L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> service.deleteAlert(8L));
    }

    @Test
    void getAlerts_returnsAll() {
        List<AlertModel> list = List.of(new AlertModel(), new AlertModel());
        when(alertRepo.findAll()).thenReturn(list);

        List<AlertModel> result = service.getAlerts();

        assertEquals(2, result.size());
        assertSame(list, result);
    }

    @Test
    void getAlertById_success() {
        AlertModel existing = new AlertModel(); existing.setId(10L);
        when(alertRepo.findById(10L)).thenReturn(Optional.of(existing));

        AlertModel result = service.getAlertById(10L);

        assertSame(existing, result);
    }

    @Test
    void getAlertById_notFound_throws() {
        when(alertRepo.findById(11L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> service.getAlertById(11L));
    }
}
