package day_5_3.ex_3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import day_5_3.ex_3.model.Language;
import day_5_3.ex_3.service.LanguageService;

@RestController
public class LanguageController {
    @Autowired
    private LanguageService languageService;
     @PostMapping("/prod")
    public ResponseEntity<Language>postProduct(@RequestBody Language language)
    {
        if(languageService.saveProduct(language) == true)
        {
            return new ResponseEntity<>(language,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/language/{languageId}")
    public ResponseEntity<Language>getLanguage(@PathVariable("languageId") Integer languageId)
    {
       Language language = languageService.getLanguage(languageId);
       if (language == null)
       return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
       return new ResponseEntity<>(language,HttpStatus.FOUND);
    }
    @GetMapping("/language")
    public ResponseEntity<List>getLanguages()
    {
        List<Language>list = languageService.getAllLanguage();
        if(list.isEmpty())
        {
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
            // return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @PutMapping("/language/{languageId}")
    public ResponseEntity<Language> putMethodName(@PathVariable int id, @RequestBody Language productModel) {
        if (languageService.updateLanguage(id , productModel) == true){

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/language/{languageId}")
    public ResponseEntity<Language> deleteProduct(@PathVariable Integer id)
    {
        if(languageService.deleteLanguage(id) == true)
        return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
