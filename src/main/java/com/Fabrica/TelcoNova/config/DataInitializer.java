package com.Fabrica.TelcoNova.config;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.Fabrica.TelcoNova.model.DeliveryMethodModel;
import com.Fabrica.TelcoNova.model.DeliveryStatusModel;
import com.Fabrica.TelcoNova.model.EventModel;
import com.Fabrica.TelcoNova.model.EventTypeModel;
import com.Fabrica.TelcoNova.model.RoleModel;
import com.Fabrica.TelcoNova.model.UserModel;
import com.Fabrica.TelcoNova.repository.DeliveryMethodRepository;
import com.Fabrica.TelcoNova.repository.DeliveryStatusRepository;
import com.Fabrica.TelcoNova.repository.EventRepository;
import com.Fabrica.TelcoNova.repository.EventTypeRepository;
import com.Fabrica.TelcoNova.repository.RoleRepository;
import com.Fabrica.TelcoNova.repository.UserRepository;

import jakarta.transaction.Transactional;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final EventTypeRepository eventTypeRepository;
    private final DeliveryMethodRepository deliveryMethodRepository;
    private final DeliveryStatusRepository deliveryStatusRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public DataInitializer(RoleRepository roleRepository,
                           EventTypeRepository eventTypeRepository,
                           DeliveryMethodRepository deliveryMethodRepository,
                           DeliveryStatusRepository deliveryStatusRepository,
                           UserRepository userRepository,
                           EventRepository eventRepository) {
        this.roleRepository = roleRepository;
        this.eventTypeRepository = eventTypeRepository;
        this.deliveryMethodRepository = deliveryMethodRepository;
        this.deliveryStatusRepository = deliveryStatusRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        Boolean Fl= false;
        if(Fl){

        initLookupTables();
        initTestData();}
    }

    private void initLookupTables() {

    if (roleRepository.count() == 0) {
        roleRepository.save(new RoleModel("admin"));
        roleRepository.save(new RoleModel("user"));
    }

    if (eventTypeRepository.count() == 0) {
        eventTypeRepository.save(new EventTypeModel("INFO", 3));
        eventTypeRepository.save(new EventTypeModel("WARNING", 2));
        eventTypeRepository.save(new EventTypeModel("ERROR", 1));
    }

    if (deliveryMethodRepository.count() == 0) {
        deliveryMethodRepository.save(new DeliveryMethodModel("EMAIL"));
        deliveryMethodRepository.save(new DeliveryMethodModel("SMS"));
        deliveryMethodRepository.save(new DeliveryMethodModel("PUSH"));
    }

    if (deliveryStatusRepository.count() == 0) {
        deliveryStatusRepository.save(new DeliveryStatusModel("PENDING"));
        deliveryStatusRepository.save(new DeliveryStatusModel("SENT"));
        deliveryStatusRepository.save(new DeliveryStatusModel("FAILED"));
    }
}


    private void initTestData() {
        if (userRepository.findByEmail("admin@telconova.com").isEmpty()) {
            UserModel admin = new UserModel();
            admin.setName("Admin User");
            admin.setEmail("admin@telconova.com");
            admin.setPhone("+1234567890");
            admin.setRole(roleRepository.findById(1L).orElseThrow());
            admin.setAddress("TelcoNova HQ");
            userRepository.save(admin);
        }

        if (eventRepository.count() == 0) {
            EventModel event = new EventModel();
            event.setEventType(eventTypeRepository.findById(1L).orElseThrow());
            event.setDescription("System initialized");
            event.setEventDate(LocalDateTime.now());
            eventRepository.save(event);
        }
    }
    
    
}
