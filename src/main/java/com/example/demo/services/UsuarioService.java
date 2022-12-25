package com.example.demo.services;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioModel> obtenerUsuarios(){
        return (List<UsuarioModel>) usuarioRepository.findAll();
    }
    public UsuarioModel guardarUsuario(UsuarioModel usuarioModel){
        return usuarioRepository.save(usuarioModel);
    }

    public Optional<UsuarioModel> obtenerUsuarioPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public List<UsuarioModel> obtenerUsuarioPorPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

}
