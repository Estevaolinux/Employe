package com.spring.demo.controller;

import com.spring.demo.dto.ClientRecordDto;
import com.spring.demo.model.ClientModel;
import com.spring.demo.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping

public class ServiceController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    public ResponseEntity<ClientModel> addClient(@RequestBody @Valid ClientRecordDto clientRecordDto) {
        var clientModel = new ClientModel();
        BeanUtils.copyProperties(clientRecordDto, clientModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientRepository.save(clientModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneClient(@PathVariable(value = "id") int id) {
        Optional<ClientModel> client0 = clientRepository.findAllById(id);
        if (client0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serviço não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(client0.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable(value = "id") int id,
                                               @RequestBody @Valid ClientRecordDto clientRecordDto) {
        Optional<ClientModel> client0 = clientRepository.findById(id);
        if (client0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serviço não Encontrado");
        }
        var clientModel = client0.get();
        BeanUtils.copyProperties(clientRecordDto, clientModel);
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.save(clientModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable(value = "id") int id) {
        Optional<ClientModel> cliente0 = clientRepository.findById(id);
        if (cliente0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serviço não Encontrado");
        }
        clientRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Serviço excluído com sucesso");
    }

}