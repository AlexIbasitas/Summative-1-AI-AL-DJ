package com.company.summative_one.Controllers;

import com.company.summative_one.Models.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class WordController {
    private List<Definition> definitionList;

    private static int idCounter = 1;

    public WordController() {
        definitionList = new ArrayList<>();

        definitionList.add(new Definition("baud", "unit of data transmission speed of one signal event per second", idCounter++));
        definitionList.add(new Definition("whippet", "a small tank", idCounter++));
        definitionList.add(new Definition("nasutiform", "shaped like a nose",  idCounter++));
        definitionList.add(new Definition("waits", "musicians employed to play on ceremonial occasions", idCounter++));
        definitionList.add(new Definition("voluted", "in spiral form",  idCounter++));
        definitionList.add(new Definition("isogonal", "having equal angles", idCounter++));
        definitionList.add(new Definition("delf", "drain; ditch; excavation", idCounter++));
        definitionList.add(new Definition("headsail", "sail set forward of the foremast of a ship",  idCounter++));
        definitionList.add(new Definition("visiogenic", "suitable for transmission by television", idCounter++));
        definitionList.add(new Definition("tonometer", "instrument for measuring intraocular pressure",  idCounter++));
        definitionList.add(new Definition("virid", "green", idCounter++));
        definitionList.add(new Definition("bivious", "offering a choice; splitting between two directions",  idCounter++));
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition getARandomWord() {

        Random rand = new Random();
        Definition randomDefinition = definitionList.get(rand.nextInt(definitionList.size()));
        return randomDefinition;

    }

}
