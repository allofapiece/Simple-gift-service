package com.epam.service.parser;

import java.util.HashMap;

public interface PropertyParserInterface {
    HashMap<String, String> parse(String filePath);
}
