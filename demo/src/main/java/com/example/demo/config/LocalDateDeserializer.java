package com.example.demo.config;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateDeserializer extends StdDeserializer<LocalDate>{
    

    /**
	 * 
	 */
	private static final long serialVersionUID = -8006582152818663987L;

	protected LocalDateDeserializer() {
        super(LocalDate.class);
    }

    public LocalDate deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String as = parser.readValueAs(String.class);
        return nonNull(as) ? parse(as, ofPattern("dd/MM/yyyy")) : null;
    }
}
