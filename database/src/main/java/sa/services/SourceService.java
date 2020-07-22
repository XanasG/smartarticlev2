package sa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sa.entities.Source;
import sa.jpa.SourceRepository;

import java.util.List;

@Service
public class SourceService {

    @Autowired
    private SourceRepository sourceRepository;

    public List<Source> getAllSources() {
        return sourceRepository.findAll();
    }

    public Source getSource(String id) {
        return sourceRepository.getOne(id);
    }

    public void addSource(Source source) {
        sourceRepository.save(source);
    }

    public void removeSource(String id) {
        sourceRepository.deleteById(id);
    }
}

