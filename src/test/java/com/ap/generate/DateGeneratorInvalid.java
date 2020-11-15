/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.generate;

/**
 *
 * @author Marco
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import static com.pholser.junit.quickcheck.internal.Reflection.*;


/**
 * Produces values of type {@link Date}.
 */
public class DateGeneratorInvalid extends Generator<Date> {
    private Date min = new Date(-2181822377000L);
    private Date max = new Date(1605089623000L);

    public DateGeneratorInvalid() {
        super(Date.class);
    }

    /**
     * <p>Tells this generator to produce values within a specified
     * {@linkplain InRange#min() minimum} and/or {@linkplain InRange#max()
     * maximum}, inclusive, with uniform distribution, down to the
     * millisecond.</p>
     *
     * <p>If an endpoint of the range is not specified, the generator will use
     * dates with milliseconds-since-the-epoch values of either
     * {@link Integer#MIN_VALUE} or {@link Long#MAX_VALUE} as appropriate.</p>
     *
     * <p>{@link InRange#format()} describes
     * {@linkplain SimpleDateFormat#parse(String) how the generator is to
     * interpret the range's endpoints}.</p>
     *
     * @param range annotation that gives the range's constraints
     */
    public void configure(InRange range) {
        SimpleDateFormat formatter = new SimpleDateFormat(range.format());
        formatter.setLenient(false);

        try {
            if (!defaultValueOf(InRange.class, "min").equals(range.min()))
                min = (Date) formatter.parse(range.min());
            if (!defaultValueOf(InRange.class, "max").equals(range.max()))
                max = (Date) formatter.parse(range.max());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
        
        
        if (min.getTime() > max.getTime())
            throw new IllegalArgumentException(String.format("bad range, %s > %s", range.min(), range.max()));
    }

    @Override public Date generate(SourceOfRandomness random, GenerationStatus status) {
        //return new Date(random.nextLong(-218182487, 1605054925));
        Date dt;
        long ms;

        // Get a new random instance, seeded from the clock
        // Get an Epoch value roughly between 1940 and 2020
        // -2208988800000L = January 1, 1900
        // Add up to 70 years to it (using modulus on the next long)
        ms = 1605089623000L + (Math.abs(random.nextLong()) % (100L * 365 * 24 * 60 * 60 * 1000));

        // Construct a date
        dt = new Date(ms);
        return dt;
    }
}