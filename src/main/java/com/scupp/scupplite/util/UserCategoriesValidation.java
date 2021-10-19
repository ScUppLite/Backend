package com.scupp.scupplite.util;

import com.scupp.scupplite.entities.User;
import com.scupp.scupplite.services.exceptions.UserNumberOfCategoriesException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserCategoriesValidation {


    public static Logger logger = LoggerFactory.getLogger(UserCategoriesValidation.class);

  public static void validation(User dto){
        if(dto.getCategories().size() == 0){
            logger.error("Nenhum categoria foi passada");
            throw  new UserNumberOfCategoriesException("Number of categories must be equals or higher than 1");
        }
        logger.info("Categoria colocada no usuario com Sucesso !");
    }

}
