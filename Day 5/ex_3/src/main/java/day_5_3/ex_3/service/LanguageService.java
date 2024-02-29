package day_5_3.ex_3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day_5_3.ex_3.model.Language;
import day_5_3.ex_3.repository.LanguageRepository;

@Service
public class LanguageService {
    @Autowired
    private LanguageRepository languageRepository;
    public boolean saveProduct(Language language )
    {
        try{

         languageRepository.save(language);
            return true;
            
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public Language getLanguage(int id)
    {
        return languageRepository.findById(id).orElse(null);
    }
    public Optional<Language> getbyId(Integer productId)
    {
        return languageRepository.findById(productId);
    }
    public List<Language>getAllLanguage()
    {
        return languageRepository.findAll();
    }
    public boolean updateLanguage(int id ,Language productModel)
    {
        if(this.getLanguage(id) == null)
        {
            return false;
        }
                try{
                    // productRepository.setId(id);
                languageRepository.save(productModel);
            }
            catch(Exception e)
            {
                return false;
            }
    //    productRepository.save(productModel);
        return true;
    }
    public boolean deleteLanguage(int id)
    {
        if(this.getbyId(id) != null)
        {
            return false;
        }
                try{
                   
                languageRepository.deleteById(id);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
    }
}
