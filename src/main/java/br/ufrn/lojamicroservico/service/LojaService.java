package br.ufrn.lojamicroservico.service;

import br.ufrn.lojamicroservico.domain.Loja;
import br.ufrn.lojamicroservico.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LojaService {
    private final LojaRepository lojaRepository;

    @Autowired
    public LojaService(LojaRepository lojaRepository){
        this.lojaRepository = lojaRepository;
    }

    public List<Loja> findAllLojas() {
        return lojaRepository.findAll();
    }

    public Loja findLojaById(Long lojaId) {
        Optional<Loja> lojaOptional = lojaRepository.findById(lojaId);
        return lojaOptional.orElse(null);
    }

    public String updateLoja(Long lojaId, Loja updatedLoja) {
        Optional<Loja> lojaOptional = lojaRepository.findById(lojaId);
        if (lojaOptional.isPresent()) {
            Loja existingLoja = lojaOptional.get();
            existingLoja.setName(updatedLoja.getName());
            existingLoja.setEndereco(updatedLoja.getEndereco());
            lojaRepository.save(existingLoja);
            return "Loja updated successfully";
        } else {
            return "Loja with ID " + lojaId + " not found";
        }
    }


    public String deleteLoja(Long lojaId) {
        Optional<Loja> LojaOptional = lojaRepository.findById(lojaId);
        if (LojaOptional.isPresent()) {
            lojaRepository.deleteById(lojaId);
            return "Loja with ID " + lojaId + " deleted successfully";
        } else {
            return "Loja with ID " + lojaId + " not found";
        }
    }

    public List<Loja> findLojasByName(String name) {
        return lojaRepository.findByName(name);
    }

    public String saveLojaDatabase(Loja loja){
        lojaRepository.save(loja);
        return "Loja stored with id " + loja.getId();
    }
}
