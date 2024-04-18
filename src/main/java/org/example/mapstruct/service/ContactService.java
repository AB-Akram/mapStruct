package org.example.mapstruct.service;

import org.example.mapstruct.dto.ContactDTO;
import org.example.mapstruct.entity.Contact;
import org.example.mapstruct.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public Contact saveContact(ContactDTO contactDTO) {
        Contact contact = Contact.builder()
                .firstName(contactDTO.getFirstName())
                .email(contactDTO.getEmail())
                .phoneNo(contactDTO.getPhone())
                .lastName(contactDTO.getLastName())
                .build();
        return contactRepository.save(contact);
    }

    public ContactDTO getContactById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.map(value -> ContactDTO.builder()
                .id(id)
                .firstName(value.getFirstName())
                .lastName(value.getLastName())
                .email(value.getEmail())
                .phone(value.getPhoneNo())
                .build()).orElse(null);
    }

    public List<ContactDTO> getContactList() {
        return contactRepository.findAll().stream().map(contact -> {
            return ContactDTO.builder()
                    .id(contact.getId())
                    .firstName(contact.getFirstName())
                    .lastName(contact.getLastName())
                    .email(contact.getEmail())
                    .phone(contact.getPhoneNo())
                    .build();
        }).toList();
    }
}
