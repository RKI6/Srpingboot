package day_6_ce.ex_1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import day_6_ce.ex_1.model.Children;
import day_6_ce.ex_1.repository.ChildrenRepo;

@Service
public class ChildrenService {
    @Autowired
    private ChildrenRepo childrenRepo;
    public List<Children> getAllChilden()
    {
        return childrenRepo.findAll();
    }
    public boolean postChildren(Children children)
    {
        try {
            childrenRepo.save(children);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public List<Children> getPage(int offset , int pageSize)
    {
        return childrenRepo.findAll(PageRequest.of(offset, pageSize)).getContent();
    }
    public Page<Children> getSortedPage(int offset , int pageSize , String field)
    {
        return childrenRepo.findAll(PageRequest.of(offset, pageSize,Sort.by(field)));
    }
    // public List<Children> getSort( String field)
    // {
    //     return childrenRepo.findAll(Sort.by(Direction.ASC,field));
    // }
}
