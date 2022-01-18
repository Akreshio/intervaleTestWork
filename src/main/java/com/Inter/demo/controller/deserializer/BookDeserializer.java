package com.Inter.demo.controller.deserializer;


import com.Inter.demo.model.books.Book;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class BookDeserializer extends JsonDeserializer<Book> {

    @Override
    public Book deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        return new Book(node.get("isbn").textValue(),
                node.get("name").textValue(),
                node.get("writer").textValue(),
                node.get("page").asInt(),
                node.get("price").asInt(),
                node.get("weight").asDouble()
                );
    }
}
