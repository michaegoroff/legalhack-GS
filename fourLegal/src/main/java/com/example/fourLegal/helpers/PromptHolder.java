package com.example.fourLegal.helpers;

import org.springframework.stereotype.Component;

import com.example.fourLegal.contract.DoctypeEnum;

@Component
public class PromptHolder {

    //holds openai prompt for document analysis
    public String getDocumentAnalysis(String prompt) {
        return "Przeanalizuj:  \\n" + //
                        " „Notatka“: \\n" + //
                        "  \\n" + //
                        " Polecenie: Wybierz pasujący do „Notatka“ „Wzór“ \\n" + //
                        prompt + //
                        " \"Wzór\": pozew \\n" + //
                        "  Pismo zostało napisane przez ....... w dniu ....... \\n" + //
                        "  Nazwa pisma ....... \\n" + //
                        "  Adres powoda ....... \\n" + //
                        "  Adres pełnomocnika powoda ....... \\n" + //
                        "  Adres pozwanego ....... \\n" + //
                        "  Adres pełnomocnika pozwanego ....... \\n" + //
                        "  Żądania powoda \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  (Maks 1000 punktów) \\n" + //
                        "   \\n" + //
                        " Wnioski dowodowe powoda \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  (Maks 1000 punktów) \\n" + //
                        "   \\n" + //
                        " Dowody/Załączniki wskazane w pozwie przez powoda \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        "  (Maks 1000 punktów) \\n" + //
                        "   \\n" + //
                        "   \\n" + //
                        " \"Wzór\": odpowiedź na pozew \\n" + //
                        "  Pismo zostało napisane przez ....... w dniu ....... \\n" + //
                        "  Nazwa pisma ....... \\n" + //
                        "  Adres powoda ....... \\n" + //
                        "  Adres pełnomocnika powoda ....... \\n" + //
                        "  Adres pozwanego ....... \\n" + //
                        "  Adres pełnomocnika pozwanego ....... \\n" + //
                        "  Żądania pozwanego: \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  (Maks 1000 punktów) \\n" + //
                        "   \\n" + //
                        " Wnioski dowodowe pozwanego: \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  (Maks 1000 punktów) \\n" + //
                        "   \\n" + //
                        "   \\n" + //
                        " Dowody/Załączniki wskazane w odpowiedzi na pozew przez pozwanego: \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  (Maks 1000 punktów) \\n" + //
                        "   \\n" + //
                        "   \\n" + //
                        " Wnioski dowodowe pozwanego: \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  ....... \\n" + //
                        "  (Maks 1000 punktów) \\n" + //
                        "   \\n" + //
                        "   \\n" + //
                        " \"Wzór\": postanowienie \\n" + //
                        "  Wydał sąd: ........ w dniu: ....... \\n" + //
                        "  Postanawia: ....... \\n" + //
                        "   \\n" + //
                        "  \"Wzór\": opinia biegłego \\n" + //
                        "  Sporządził biegły: ....... \\n" + //
                        " Zleceniodawca: ....... \\n" + //
                        " Biegły stwierdził: ....... \\n" + //
                        " \"Wzór\": protokół \\n" + //
                        " Rozprawa/Posiedzenie z dnia ....... \\n" + //
                        " Stawili się: \\n" + //
                        " .......  \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " (Maks 1000 punktów) \\n" + //
                        " Stanowisko powoda ....... \\n" + //
                        " Stanowisko pozwanego ....... \\n" + //
                        " Postanowienia sądu ....... \\n" + //
                        " Zeznania powoda w punktach: \\n" + //
                        " .......  \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " (Maks 1000 punktów) \\n" + //
                        " Zeznania pozwanego w punktach: \\n" + //
                        " .......  \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " (Maks 1000 punktów) \\n" + //
                        " Zeznania świadków w punktach: \\n" + //
                        " .......  \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " (Maks 1000 punktów) \\n" + //
                        " Dalsze wnioski dowodowe ....... \\n" + //
                        " Dalsze postanowienia sądu: ....... \\n" + //
                        " \"Wzór\": uzasadnienie \\n" + //
                        " Powód wniósł (w punktach): \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " (Maks 1000 punktów) \\n" + //
                        "   \\n" + //
                        " Pozwany wniósł (w punktach): \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " (Maks 1000 punktów) \\n" + //
                        "   \\n" + //
                        " Sąd ustalił stan faktyczny (w punktach): \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " (Maks 1000 punktów) \\n" + //
                        "   \\n" + //
                        " Sąd zważył/orzekł:  \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " (Maks 1000 punktów) \\n" + //
                        " Uzasadnienie prawne: \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " ....... \\n" + //
                        " (Maks 1000 punktów) \\n" + //
                        " Zasady: Odpowiadając wolno ci wypełniać tylko elementy w których jest więcej  \\n" + //
                        " niż dwie kropki przykład: ....... \\n" + //
                        " Polecenie: Wypełnij informacjami z 'notatka' każde wykropkowanie w wybranym  \\n" + //
                        " 'wzór' Jeśli nie znasz odpowiedzi we 'wzór' pozostaw kropki. \\n" + //
                        " ";
    }



    // Returns the prompt for generating a JSON summary of the document based on the type of the document.
    public String getJsonPrompt(String responsePrompt, DoctypeEnum type) {
        return 
        responsePrompt + //
        "\n" + //
        "{ \n" + //
        getDocumentPattern(type) + //
        "\n } \n" + //
        "Polecenie: Uzupełnij \"json\" danymi z \"wzór\"";
    }

    //holds document patterns for different types of documents
    private String getDocumentPattern(DoctypeEnum type) {
        switch(type) {
            case POZEW:
                return "\"pozew\": [ \n     { \n       \"data\": \"\", \n       \"autor\": \"\", \n       \"nazwa\": \"Pozew\", \n       \"adres_powoda\": \"\", \n       \"adres_pelnomocnika_powoda\": \"\", \n       \"adres_pozwanego\": \"\", \n       \"adres_pelnomocnika_pozwanego\": \"\", \n       \"zadania_powoda\": [ \n         \"\", \n         \"\", \n         \"\", \n       ], \n       \"wnioski_dowodowe_powoda\": [ \n         \"\", \n         \"\", \n         \"\" \n       ], \n       \"dowody\": [ \n         \"\", \n         \"\", \n         \"\", \n         \"\", \n         \"\", \n         \"\", \n       ] \n     }, \n    ]";
            case ODP_POZEW:
                return "\"odpowiedź na pozew\": [  \n     { \n       \"data\": \"\", \n       \"autor\": \"\", \n       \"nazwa\": \"\", \n       \"adres_powoda\": \"\", \n       \"adres_pelnomocnika_powoda\": \"\", \n       \"adres_pozwanego\": \"\", \n       \"adres_pelnomocnika_pozwanego\": \"\", \n       \"zadania_pozwanego\": [ \n         \"\", \n         \"\", \n         \"\", \n         \"\", \n         \"\", \n       ], \n       \"wnioski_dowodowe_pozwanego\": [ \n         \"\", \n         \"\", \n         \"\", \n         \"\" \n       ], \n       \"dowody\": [ \n         \"\", \n         \"\", \n         \"\", \n         \"\" \n       ] \n     }, \n     { \n       \"typ\": \"postanowienie\", \n       \"data\": \"\", \n       \"autor\": \"\", \n       \"postanowienie\": [ \n         \"\", \n         \"\", \n         \"\", \n         \"\", \n         \"\" \n       ] \n     },]";
            case OP_BIEGLEGO:
                return "\"opinia biegłego\": [     \n     { \n       \"autor\": \"\", \n       \"zleceniodawca\": \"\", \n       \"opinia\": \"\" \n  \n      } \n  \n   ]";
            default:
                return "";
        }
    }
}
