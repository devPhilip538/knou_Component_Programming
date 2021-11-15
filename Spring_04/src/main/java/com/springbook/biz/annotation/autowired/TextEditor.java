package com.springbook.biz.annotation.autowired;

import com.springbook.biz.HomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
    private static final Logger logger = LoggerFactory.getLogger(TextEditor.class);

    @Autowired
    private SpellChecker spellChecker;

    public TextEditor () {
        logger.info("TextEditor 객체 생성");
    }

    public void textSpellChecker () {
        this.spellChecker.checkSpeclling();
    }
}
