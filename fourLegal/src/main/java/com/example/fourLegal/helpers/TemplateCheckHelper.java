package com.example.fourLegal.helpers;
import com.example.fourLegal.contract.DoctypeEnum;
import com.example.fourLegal.contract.ChatResponseDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class TemplateCheckHelper{

    // Determines the type of the document based on the OpenAI response.
    public DoctypeEnum determineDocumentType(ChatResponseDto dto){
        //gets openai response
         String response = dto.getOpenAiResponse();
         //searches for pattern
         Pattern pattern = Pattern.compile("\"Wzór\":.+\n",Pattern.CASE_INSENSITIVE);
         Matcher matcher = pattern.matcher(response);
         //if found, return the type
         if(matcher.find()){
            String matching = matcher.group(0);
            String type = matching.substring(7,matching.length() - 1).trim();
            switch (type) {
                case "pozew":
                    return DoctypeEnum.POZEW;   
                case "odpowiedź na pozew":
                    return DoctypeEnum.ODP_POZEW;
                case "opinia biegłego":
                    return DoctypeEnum.OP_BIEGLEGO;
                default:
                    break;
            }
         }
         //else, return no type
         return DoctypeEnum.NOTYPE;

    }
}