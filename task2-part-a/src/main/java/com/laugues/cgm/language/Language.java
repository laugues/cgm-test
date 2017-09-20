package com.laugues.cgm.language;

/**
 * Created by SOLO on 20/09/2017.
 */
public class Language
{
    private String id;
    private String name;

    /**
     * Get the language id
     *
     * @return the language id
     */
    public String getId() {
        return id;
    }

    /**
     * Set the language id
     *
     * @param id the language id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the name of language
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of language
     *
     * @param name the name of the language to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
