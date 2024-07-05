package com.joss.contactlistapi.service;

import com.joss.contactlistapi.dto.ContactDTO;
import com.joss.contactlistapi.entity.Contact;
import com.joss.contactlistapi.exception.ResourceNotFoundException;
import com.joss.contactlistapi.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ContactService {


    private final ContactRepository contactRepository;

    public Iterable<Contact> findAll(){
        return contactRepository.findAll();
    }

    public Contact findById(Integer id){
        return contactRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Contact create(ContactDTO contactDTO){
        Contact contact = new Contact();
        contact.setName(contactDTO.getName());
        contact.setEmail(contactDTO.getEmail());
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);

    }

    public Contact update( Integer id,ContactDTO contactDTO){
        Contact contactFromDb = findById(id);

        contactFromDb.setName(contactDTO.getName());
        contactFromDb.setEmail(contactDTO.getEmail());

        return contactRepository.save(contactFromDb);

    }

    public void delete( Integer id){
        Contact contactFromDb =contactRepository
                .findById(id)
                .orElse(null);

        contactRepository.delete(contactFromDb);

    }
}

