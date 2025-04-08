package com.spring.demo.controller;

import com.spring.demo.dto.FuncionarioRecordDto;
import com.spring.demo.model.FuncionarioModel;
import com.spring.demo.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;

    @PostMapping
    public ResponseEntity<FuncionarioModel> criar(@RequestBody @Valid FuncionarioRecordDto dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioModel>> listar() {
        return ResponseEntity.ok(service.listar());
    }
}
