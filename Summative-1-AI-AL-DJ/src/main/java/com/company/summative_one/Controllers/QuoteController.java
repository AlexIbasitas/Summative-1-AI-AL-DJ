package com.company.summative_one.Controllers;

import com.company.summative_one.Models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

@RestController
public class QuoteController {
    private List<Quote> quotes;
    private int id = 1;

    public QuoteController() {
        quotes = new ArrayList<>();
        quotes.add(new Quote(id++, "Rock Lee", "A dropout will beat a genius through hard work."));
        quotes.add(new Quote(id++, "Naruto Uzumaki", "Hard work is worthless for those that don’t believe in themselves."));
        quotes.add(new Quote(id++, "Sakura Haruno", "A smile is the easiest way out of a difficult situation."));
        quotes.add(new Quote(id++, "Sasuke Uchiha", "Having too many bonds causes one to lose focus, weakening their strongest wish, their greatest desire."));
        quotes.add(new Quote(id++, "Itachi Uchiha", "People’s lives don’t end when they die, it ends when they lose faith."));
        quotes.add(new Quote(id++, "Ging Freecss", "You should enjoy the little detours to the fullest. Because that’s where you’ll find the things more important than what you want."));
        quotes.add(new Quote(id++, "Hisoka Morow", "Love and hate are two sides of the same coin."));
        quotes.add(new Quote(id++, "Kurapika Kurta", "I do not fear death. I fear only that my rage will fade over time."));
        quotes.add(new Quote(id++, "Mikasa Ackerman", "The world is cruel but also very beautiful."));
        quotes.add(new Quote(id++, "Armin Arlert", "When people are faced with a situation they don’t understand, it’s easy for fear to take hold."));
        quotes.add(new Quote(id++, "Eren Jaeger", "Nothing can suppress a human's curiosity."));
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getRandomQuote() {
        int quoteIndex = (int)(Math.random()*quotes.size());
        return quotes.get(quoteIndex);
    }
}
