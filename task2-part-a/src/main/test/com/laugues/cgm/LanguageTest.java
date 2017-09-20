package com.laugues.cgm;

import com.cg.helix.persistence.exception.NoResultsException;
import com.laugues.cgm.language.Language;
import com.laugues.cgm.language.LanguageService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

/**
 * Created by SOLO on 20/09/2017.
 */
public class LanguageTest
{

    @Rule
    public ExpectedException exception = ExpectedException.none();

    LanguageService service;

    /**
     * Tests the 'getLanguageById' method.
     */
    public void getLanguageById_NotFound() {

        exception.expect(NoResultsException.class);
        exception.expectMessage("Can not found language with id [ita]");

        // Get
        service.getLanguageById("ita");
    }

    /**
     * Tests the 'getLanguageById' method with null id provided.
     */
    @Test
    public void getLanguageById_WithNullId() {

        //Expected to have an exception
        exception.expect(NoResultsException.class);
        exception.expectMessage("The language id [null] is not valid");

        service.getLanguageById(null);
    }

    /**
     * Tests the 'getLanguageById' method with empty id provided.
     */
    @Test
    public void getLanguageById_WithEmptyId() {

        //Expected to have an exception
        exception.expect(NoResultsException.class);
        exception.expectMessage("The language id [] is not valid");

        service.getLanguageById("");
    }

    /**
     * Tests the 'getLanguageById' method with id provided is invalid (should be ISO 639-2 Bibliographic Alpha 3 code).
     */
    @Test
    public void getLanguageById_WithBlankId() {

        //Expected to have an exception
        exception.expect(NoResultsException.class);
        exception.expectMessage("The language id [   ] is not valid");

        service.getLanguageById("   ");
    }

    /**
     * Tests the 'getLanguageById' method with id provided is invalid (should be ISO 639-2 Bibliographic Alpha 3 code).
     */
    @Test
    public void getLanguageById_WithInvalidISOCode() {

        //Expected to have an exception
        exception.expect(NoResultsException.class);
        exception.expectMessage("The language id [italian] must comply to ISO 639-2 Bibliographic Alpha 3 code");

        service.getLanguageById("italian");
    }

    /**
     * Tests the 'findLanguagesBySearchString' method.
     */
    @Test
    public void findLanguagesBySearchString_FromId() {
        // Get the language "gle" from the database
        List<Language> languages = service.findLanguagesBySearchString("gle");
        // Validate
        Assert.assertNotNull(languages);
        Assert.assertEquals("Size of languages found is NOT correct", languages.size(), 1);
        Assert.assertEquals("Id of the language found is NOT correct", languages.get(0).getId(), "Irish");
    }

    /**
     * Tests the 'findLanguagesBySearchString' method.
     */
    @Test
    public void findLanguagesBySearchString_FromName() {
        // Get the language "gle" from the database
        List<Language> languages = service.findLanguagesBySearchString("Irish");
        // Validate
        Assert.assertNotNull("Languages found should NOT be null", languages);
        // Validate
        Assert.assertNotNull(languages);
        Assert.assertEquals("Size of languages found is NOT correct", languages.size(), 1);
        Assert.assertEquals("Name of the language found is NOT correct", languages.get(0).getName(), "Irish");
    }

    /**
     * Tests the 'findLanguagesBySearchString' method with null id provided.
     */
    @Test
    public void findLanguagesBySearchString_WithNullSearchString() {

        //Expected to have an exception
        exception.expect(NoResultsException.class);
        exception.expectMessage("The search string [null] is not valid");

        service.findLanguagesBySearchString(null);
    }

    /**
     * Tests the 'findLanguagesBySearchString' method with empty id provided.
     */
    @Test
    public void findLanguagesBySearchString_WithEmptyId() {

        //Expected to have an exception
        exception.expect(NoResultsException.class);
        exception.expectMessage("The search string [] is not valid");

        service.findLanguagesBySearchString("");
    }

    /**
     * Tests the 'findLanguagesBySearchString' method with id provided is invalid (should be ISO 639-2 Bibliographic Alpha 3 code).
     */
    @Test
    public void findLanguagesBySearchString_WithBlankId() {

        //Expected to have an exception
        exception.expect(NoResultsException.class);
        exception.expectMessage("The search string [   ] is not valid");

        service.findLanguagesBySearchString("   ");
    }

    /**
     * Tests the 'findLanguagesBySearchString' method with id not found.
     */
    @Test
    public void findLanguagesBySearchString_WithSearchStringNotFound() {

        //Expected to have an exception
        exception.expect(NoResultsException.class);
        exception.expectMessage("Not result found for language with search string [www]");

        //Italian is not in datbase
        service.findLanguagesBySearchString("www");
    }
}