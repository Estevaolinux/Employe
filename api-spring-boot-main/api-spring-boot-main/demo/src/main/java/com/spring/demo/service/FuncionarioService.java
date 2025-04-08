package com.spring.demo.service;

import com.spring.demo.dto.FuncionarioRecordDto;
import com.spring.demo.model.FuncionarioModel;
import com.spring.demo.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    // Corrigido o tipo de retorno para FuncionarioModel
    public FuncionarioModel salvar(FuncionarioRecordDto dto) {
        FuncionarioModel funcionario = new FuncionarioModel();
        funcionario.setNome(dto.nome());
        funcionario.setEmail(dto.email());
        funcionario.setSenha(passwordEncoder.encode(dto.senha()));
        funcionario.setAtivo(dto.ativo());
        return repository.save(funcionario);
    }

    // Corrigido o tipo de retorno para List<FuncionarioModel>
    public List<FuncionarioModel> listar() {
        return repository.findAll();
    }
}
