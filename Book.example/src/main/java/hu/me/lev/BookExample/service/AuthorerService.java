package hu.me.lev.BookExample.service;

import hu.me.lev.BookExample.persist.AuthorerEntity;
import hu.me.lev.BookExample.persist.AuthorerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorerService {

    private AuthorerRepository authorerRepository;
    @Autowired
    public AuthorerService(AuthorerRepository authorerRepository){
        this.authorerRepository = authorerRepository;
    }

    public void addAuthorer(AuthorerEntity authorerEntity){
        authorerRepository.save(authorerEntity);
    }
    public List<AuthorerEntity> getAuthorers(){
        return (List<AuthorerEntity>) authorerRepository.findAll();
    }
    public AuthorerEntity getAuthorer(Long id) {
        AuthorerEntity authorerEntity = authorerRepository.findById(id).get();
        System.out.println(authorerEntity);
        return authorerEntity;
    }
}
