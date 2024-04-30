package com.example.fourLegal;

import com.example.fourLegal.contract.ChatResponseDto;
import com.example.fourLegal.contract.PromptDto;
import com.example.fourLegal.helpers.PromptHolder;
import com.example.fourLegal.helpers.TemplateCheckHelper;
import com.example.fourLegal.services.DocumentAIService;
import com.example.fourLegal.services.OpenAIService;
import com.example.fourLegal.services.StorageService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FourLegalApplicationTests {

	@Test
	void contextLoads() {
	}

	// @Test
	// public void testPrompt(){

	// 	PromptHolder promptHolder = new PromptHolder();
	// 	TemplateCheckHelper templateCheckHelper = new TemplateCheckHelper();
	// 	OpenAIService openAIService = new OpenAIService();

	// 	var promptText ="Sygn. akt I C 90/22 \\n" + //
	// 			" Uzasadnienie \\n" + //
	// 			" Powód Adam Nowak wniósł o zasądzenie od pozwanego Polskiego Towarzystwa \\n" + //
	// 			" Ubezpieczeń S.A. w Warszawie kwoty 8 000 zł wraz z ustawowymi odsetkami za  \\n" + //
	// 			" opóźnienie \\n" + //
	// 			" oraz kosztami procesu. Dochodzone niniejszym pozwem żądanie obejmowało  \\n" + //
	// 			" kwoty: \\n" + //
	// 			" - 6 000 zł \\n" + //
	// 			" ... \\n" + //
	// 			" stanowiącą różnicę pomiędzy kosztem naprawy pojazdu marki Audi A4 \\n" + //
	// 			" o nr rej. WR1111A, z zastosowaniem oryginalnych części w wysokości 8 500 zł, a  \\n" + //
	// 			" kwotą \\n" + //
	// 			" wypłaconego przez pozwanego odszkodowania w wysokości 2 500 zł, \\n" + //
	// 			" - 1 750 zł - poniesionych kosztów najmu pojazdu zastępczego, \\n" + //
	// 			" - 250 zł - poniesionych kosztów sporządzenia prywatnej ekspertyzy  \\n" + //
	// 			" rzeczoznawczej. \\n" + //
	// 			" Pozwany w odpowiedzi na pozew wniósł o oddalenie powództwa oraz o  \\n" + //
	// 			" zasądzenie \\n" + //
	// 			" kosztów procesu. Zarzucił, że wypłacone dotychczas odszkodowanie w wysokości  \\n" + //
	// 			" 2 500 zł \\n" + //
	// 			" brutto jest wystarczające do przywrócenia pojazdu do stanu sprzed szkody, a  \\n" + //
	// 			" wyliczenie \\n" + //
	// 			" powoda jest zawyżone, z uwagi na niezasadne zastosowanie oryginalnych części  \\n" + //
	// 			" zamiennych. \\n" + //
	// 			" Pozwany wskazał, że dla ustalenia wysokości szkody nie może być bez znaczenia \\n" + //
	// 			" okoliczność, że poszkodowany naprawił pojazd i to on winien udowodnić, że  \\n" + //
	// 			" koszty \\n" + //
	// 			" rzeczywiście poniesione były wyższe, niż kwota, jaką pozwany wypłacił tytułem  \\n" + //
	// 			" jej \\n" + //
	// 			" naprawienia. Jednocześnie pozwany zakwestionował celowość wynajęcia przez  \\n" + //
	// 			" powoda auta \\n" + //
	// 			" zastępczego, a także czas oraz stawkę dobową czynszu najmu. W jego ocenie,  \\n" + //
	// 			" również \\n" + //
	// 			" wydatek obejmujący koszty prywatnej ekspertyzy był niecelowy i nie pozostawał \\n" + //
	// 			" w adekwatnym związku przyczynowym ze szkodą. Strona pozwana nie uznała  \\n" + //
	// 			" także \\n" + //
	// 			" roszczenia odsetkowego, podnosząc, że odsetki od odszkodowania są należne od  \\n" + //
	// 			" daty \\n" + //
	// 			" wydania wyroku, a nie od daty wcześniejszej. \\n" + //
	// 			" Sąd Rejonowy ustalił następujący stan faktyczny: \\n" + //
	// 			" W dniu 8 lipca 2021 r. doszło do zdarzenia drogowego, w wyniku którego \\n" + //
	// 			" uszkodzeniu uległ samochód osobowy marki Audi A4 o nr rej. WR1111A, będący  \\n" + //
	// 			" własnością \\n" + //
	// 			" Adama Nowaka. Pojazd sprawcy kolizji był objęty ubezpieczeniem OC w  \\n" + //
	// 			" pozwanym \\n" + //
	// 			" towarzystwie ubezpieczeń. \\n" + //
	// 			" Okoliczności bezsporne oraz dowody: notatka policyjna z dnia 8 lipca 2021 r.,  \\n" + //
	// 			" kopia dowodu \\n" + //
	// 			" rejestracyjnego pojazdu marki Audi A4 o nr rej. WR1111A. \\n" + //
	// 			" Pozwany w dniu 9 lipca 2021 r. przyjął zgłoszenie szkody i zarejestrował ją pod \\n" + //
	// 			" numerem 123456789. Po dokonaniu oględzin uszkodzonego pojazdu uznał swoją \\n" + //
	// 			" odpowiedzialność gwarancyjną za skutki kolizji z dnia 8 lipca 2021 r. i wypłacił \\n" + //
	// 			" EGZAMIN RADCOWSKI – PRAWO CYWILNE \\n" + //
	// 			" 27/32 \\n" + //
	// 			" K24 \\n" + //
	// 			" odszkodowanie w kwocie 2 500 zł brutto za stwierdzoną w pojeździe szkodę  \\n" + //
	// 			" częściową. \\n" + //
	// 			" W swojej kalkulacji zastosował ceny części oryginalnych grupy „Q” oraz  \\n" + //
	// 			" zamiennych \\n" + //
	// 			" alternatywnych grupy „P/PJ”, a także przyjął stawkę za roboczogodzinę prac  \\n" + //
	// 			" mechaniczno- \\n" + //
	// 			" blacharskich i lakierniczych w wysokości 50 zł netto za godzinę. \\n" + //
	// 			" Okoliczności bezsporne oraz dowody: protokół zgłoszenia szkody z dnia 9 lipca  \\n" + //
	// 			" 2021 r., \\n" + //
	// 			" protokół szkody w pojeździe z dnia 12 lipca 2021 r., kalkulacja naprawy nr  \\n" + //
	// 			" 122/C/10001, \\n" + //
	// 			" decyzja pozwanego z dnia 20 lipca 2021 r. \\n" + //
	// 			" Z takim stanowiskiem nie zgodził się powód, który zlecił niezależnemu  \\n" + //
	// 			" rzeczoznawcy \\n" + //
	// 			" samochodowemu obliczenie rzeczywistych kosztów naprawy uszkodzonego  \\n" + //
	// 			" pojazdu. \\n" + //
	// 			" Ze sporządzonej przez Autoklasa sp. z o.o. kalkulacji naprawy z dnia 23 lipca  \\n" + //
	// 			" 2021 r. wynika, \\n" + //
	// 			" że koszt naprawy pojazdu - przy uwzględnieniu oryginalnych części zamiennych  \\n" + //
	// 			" grupy „O” \\n" + //
	// 			" i stawki 100 zł netto za godzinę prac blacharsko-lakierniczych - wynosi 8 500 zł.  \\n" + //
	// 			" Powód \\n" + //
	// 			" poniósł koszt wykonania ww. kalkulacji w wysokości 250 zł. \\n" + //
	// 			" Dowody: kosztorys Autoklasa sp. z o.o. z dnia 23 lipca 2021 r., faktura VAT nr FV  \\n" + //
	// 			" 22/2021 \\n" + //
	// 			" z dnia 23 lipca 2021 r., zeznania powoda. \\n" + //
	// 			" Na czas naprawy pojazdu powód najął auto zastępcze marki AUDI A4 o nr rej. \\n" + //
	// 			" WR3333C, które użytkował przez 7 dób w okresie od 2 do 9 sierpnia 2021 r.  \\n" + //
	// 			" Poniósł z tego \\n" + //
	// 			" tytułu wydatek w wysokości 1 750 zł, na podstawie faktury VAT nr 123456, którą  \\n" + //
	// 			" opłacił \\n" + //
	// 			" gotówką. \\n" + //
	// 			" Dowody: umowa najmu pojazdu zastępczego z dnia 2 sierpnia 2021 r., protokół  \\n" + //
	// 			" odbioru \\n" + //
	// 			" pojazdu zastępczego z dnia 2 sierpnia 2021 r., \\n" + //
	// 			" sierpnia 2021 r., faktura VAT nr 123456 z dnia 10 sierpnia \\n" + //
	// 			" 2021 r., zeznania powoda. \\n" + //
	// 			" www. \\n" + //
	// 			" Pismem z dnia 13 sierpnia 2021 r., odebranym przez pozwanego w dniu 17  \\n" + //
	// 			" sierpnia \\n" + //
	// 			" 2021 r., powód wezwał pozwanego do zapłaty dalszego odszkodowania za koszty  \\n" + //
	// 			" naprawy \\n" + //
	// 			" pojazdu w wysokości 6 000 zł, a także kwot: 1 750 zł poniesionej za najem  \\n" + //
	// 			" pojazdu \\n" + //
	// 			" zastępczego i 250 zł tytułem kosztów prywatnej kalkulacji. Pozwany odmówił  \\n" + //
	// 			" uznania \\n" + //
	// 			" roszczeń powoda. \\n" + //
	// 			" Dowody: odwołanie z dnia 13 sierpnia 2021 r. wraz ze zwrotnym potwierdzeniem  \\n" + //
	// 			" jego \\n" + //
	// 			" odbioru przez pozwanego w dniu 17 sierpnia 2021 r., decyzja pozwanego z dnia  \\n" + //
	// 			" 20 sierpnia \\n" + //
	// 			" 2021 r. \\n" + //
	// 			" Powód kupił pojazd marki Audi A4 o nr rej. WR1111A na rynku wtórnym, w lutym \\n" + //
	// 			" 2020 r. Samochód został wyprodukowany w 2016 r. i po raz pierwszy  \\n" + //
	// 			" zarejestrowany \\n" + //
	// 			" w Polsce w dniu 3 lutego 2020 r. Przebieg pojazdu odczytany na dzień zdarzenia  \\n" + //
	// 			" wynosił \\n" + //
	// 			" 70 000 km. Auto nie było na gwarancji i brak jest danych, jakiego rodzaju części  \\n" + //
	// 			" były w nim \\n" + //
	// 			" 28/32 \\n" + //
	// 			" EGZAMIN RADCOWSKI – PRAWO CYWILNE \\n" + //
	// 			" k25 \\n" + //
	// 			" zamontowane przed kolizją. Pojazd po zdarzeniu z dnia 8 lipca 2021 r. był jezdny i \\n" + //
	// 			" można \\n" + //
	// 			" nim było się poruszać po drogach publicznych. Adam Nowak naprawił pojazd \\n" + //
	// 			" w warsztacie nieautoryzowanym i poniósł z tego tytułu koszt w wysokości 4 000  \\n" + //
	// 			" zł. Do \\n" + //
	// 			" naprawy użyto części oryginalnych i zamienników o porównywalnej jakości.  \\n" + //
	// 			" Naprawa \\n" + //
	// 			" przywróciła pojazd do stanu sprzed zdarzenia. \\n" + //
	// 			" Dowody: kopia dowodu rejestracyjnego pojazdu marki Audi A4 o nr rej. WR1111A, \\n" + //
	// 			" opinia \\n" + //
	// 			" biegłego sądowego Jakuba Wolnego z dnia 12 września 2022 r., zeznania powoda. \\n" + //
	// 			" Warsztaty naprawcze z terenu Radomia w III kwartale 2021 r. stosowały stawki za \\n" + //
	// 			" prace mechaniczne w przedziale 100-110 zł netto za godzinę, a za prace  \\n" + //
	// 			" lakiernicze 100 zł \\n" + //
	// 			" netto za godzinę. Przewidywany koszt naprawy z zastosowaniem oryginalnych  \\n" + //
	// 			" części \\n" + //
	// 			" zamiennych sygnowanych logiem producenta pojazdu kategorii „,O\" wynosił 8  \\n" + //
	// 			" 500 zł brutto. \\n" + //
	// 			" Tak skalkulowana naprawa pojazdu jest zgodna z zaleceniami producenta pojazdu \\n" + //
	// 			" i zapewnia \\n" + //
	// 			" pełne przywrócenie do stanu sprzed szkody, przy założeniu, że uszkodzeniu  \\n" + //
	// 			" uległy części \\n" + //
	// 			" oryginalne. \\n" + //
	// 			" Przewidywany koszt naprawy pojazdu marki Audi A4 o nr rej. WR1111A, \\n" + //
	// 			" z zastosowaniem części w klasie jakości „Q” i części zamiennych „P/PJ” o  \\n" + //
	// 			" porównywalnej \\n" + //
	// 			" jakości, przy zastosowaniu stawki 100 zł netto za godzinę prac blacharsko- \\n" + //
	// 			" mechanicznych, \\n" + //
	// 			" wynosi 4 000 zł brutto. Taki sposób naprawy przywróci techniczną sprawność  \\n" + //
	// 			" pojazdu do \\n" + //
	// 			" stanu sprzed zdarzenia. \\n" + //
	// 			" Dowód: opinia biegłego sądowego Jakuba Wolnego z dnia 12 września 2022 r. \\n" + //
	// 			" Uzasadniony okres najmu pojazdu zastępczego wynosił 5 dni roboczych, a średnia \\n" + //
	// 			" stawka rynkowa najmu pojazdu odpowiadającego klasie uszkodzonemu pojazdowi \\n" + //
	// 			" w III \\n" + //
	// 			" kwartale 2021 r. na terenie miasta Radomia wynosiła 250 zł brutto. \\n" + //
	// 			" Dowód: opinia biegłego sądowego Jakuba Wolnego z dnia 12 września 2022 r. \\n" + //
	// 			" Powód wstawił samochód do warsztatu w poniedziałek rano 2 sierpnia 2021 r., \\n" + //
	// 			" Samochód został naprawiony i w piątek 6 sierpnia 2021 r. od południa właściciel  \\n" + //
	// 			" warsztatu \\n" + //
	// 			" dzwonił do powoda, mówiąc, że samochód jest gotowy do odbioru. Powód jednak  \\n" + //
	// 			" nie odebrał \\n" + //
	// 			" samochodu w piątek, mimo takiej możliwości, odebrał samochód w poniedziałek  \\n" + //
	// 			" 9 sierpnia \\n" + //
	// 			" 2021 r. \\n" + //
	// 			" Dowód: zeznania powoda. \\n" + //
	// 			" Powód pracuje i mieszka w centrum Radomia. Nie jest właścicielem innego  \\n" + //
	// 			" pojazdu, \\n" + //
	// 			" nie prowadzi działalności gospodarczej, nie ma możliwości odliczenia podatku VAT \\n" + //
	// 			" od \\n" + //
	// 			" kosztów naprawy. Żona powoda jest właścicielką samochodu marki Kia, z którego  \\n" + //
	// 			" powód \\n" + //
	// 			" mógł korzystać. Przed zdarzeniem powód wykorzystywał pojazd marki Audi A4 do \\n" + //
	// 			" dojazdów \\n" + //
	// 			" EGZAMIN RADCOWSKI – PRAWO CYWILNE \\n" + //
	// 			" 29/32 \\n" + //
	// 			" 126 \\n" + //
	// 			" do pracy, na zakupy, załatwiania sprawy codziennych, odwożenia dzieci do szkoły. \\n" + //
	// 			" Czasami \\n" + //
	// 			" zdarzało mu się jeździć do pracy z kolegą, samochodem kolegi. \\n" + //
	// 			" Dowód: zeznania powoda. \\n" + //
	// 			" Sąd dokonał powyższych ustaleń faktycznych na podstawie okoliczności  \\n" + //
	// 			" bezspornych, \\n" + //
	// 			" powołanych wyżej dokumentów, a także w oparciu o pisemną opinię biegłego  \\n" + //
	// 			" sądowego Jana \\n" + //
	// 			" Wolnego. \\n" + //
	// 			" Sąd uwzględnił wyżej wymienione dowody z dokumentów, których zarówno \\n" + //
	// 			" autentyczność, jak i prawdziwość w zakresie twierdzeń w nich zawartych, nie  \\n" + //
	// 			" budziła \\n" + //
	// 			" wątpliwości Sądu, zatem brak było podstaw do odmowy dania im wiary. \\n" + //
	// 			" Sąd w całości dał wiarę opinii biegłego sądowego, która nie była kwestionowana \\n" + //
	// 			" przez strony. Biegły w sposób logiczny i spójny udzielił odpowiedzi na zawarte w  \\n" + //
	// 			" tezie \\n" + //
	// 			" dowodowej pytania, które poparł szczegółowymi wyliczeniami w oparciu o dane  \\n" + //
	// 			" zawarte \\n" + //
	// 			" w aktach sprawy, w tym akta szkodowe, a także posiadaną wiedzę specjalną. \\n" + //
	// 			" Sąd oparł się także na zeznaniach powoda, które w przeważającej mierze uznał \\n" + //
	// 			" za wiarygodne. Sąd nie dał jednak wiary powodowi, że części zamontowane w  \\n" + //
	// 			" pojeździe \\n" + //
	// 			" marki Audi A4 o nr rej. WR1111A przed kolizją z dnia 8 lipca 2021 r. były  \\n" + //
	// 			" oryginalne, \\n" + //
	// 			" a samochód bezwypadkowy, gdyż nie poparł tych twierdzeń żadnymi dowodami,  \\n" + //
	// 			" a ponadto \\n" + //
	// 			" jest osobą bezpośrednio zainteresowaną wynikiem postępowania. \\n" + //
	// 			" Sąd Rejonowy zważył co następuje: \\n" + //
	// 			" Powództwo zasługiwało na uwzględnienie jedynie w części. \\n" + //
	// 			" Bezsporne w niniejszej sprawie było to, że pozwany ponosił odpowiedzialność \\n" + //
	// 			" gwarancyjną za skutki zdarzenia z dnia 8 lipca 2021 r. Okolicznościami spornymi  \\n" + //
	// 			" były \\n" + //
	// 			" natomiast wartość kosztów naprawy uszkodzonego pojazdu, a w szczególności,  \\n" + //
	// 			" czy naprawy \\n" + //
	// 			" należało dokonywać przy użyciu oryginalnych części zamiennych, oraz stawka za \\n" + //
	// 			" roboczogodzinę prac blacharsko-lakierniczych. Strony pozostawały także w  \\n" + //
	// 			" sporze co do \\n" + //
	// 			" zasadności i wysokości poniesionych kosztów prywatnej ekspertyzy oraz najmu  \\n" + //
	// 			" pojazdu \\n" + //
	// 			" zastępczego. \\n" + //
	// 			" Mając na uwadze zakreślony wyżej zakres sporu, wskazać należy, że zasada \\n" + //
	// 			" odpowiedzialności pozwanego z tytułu przedmiotowej szkody uregulowana jest w  \\n" + //
	// 			" art. 822 § 1 \\n" + //
	// 			" k.c., zgodnie z którym przez umowę ubezpieczenia odpowiedzialności cywilnej \\n" + //
	// 			" ubezpieczyciel zobowiązuje się do zapłacenia określonego w umowie  \\n" + //
	// 			" odszkodowania za \\n" + //
	// 			" szkody wyrządzone osobom trzecim, wobec których odpowiedzialność za szkodę  \\n" + //
	// 			" ponosi \\n" + //
	// 			" 30/32 \\n" + //
	// 			" EGZAMIN RADCOWSKI – PRAWO CYWILNE \\n" + //
	// 			" K27 \\n" + //
	// 			" ubezpieczający albo ubezpieczony. Powód mógł dochodzić odszkodowania od  \\n" + //
	// 			" pozwanego \\n" + //
	// 			" z uwagi na treść art. 822 § 4 k.c. \\n" + //
	// 			" Z kolei podstawowe znaczenie dla ustalenia wysokości szkody, a tym samym  \\n" + //
	// 			" zakresu \\n" + //
	// 			" odpowiedzialności odszkodowawczej pozwanego, będzie miał art. 361 § 2 k.c.,  \\n" + //
	// 			" ustanawiający \\n" + //
	// 			" zasadę pełnej kompensacji szkody oraz art. 363 § 1 k.c., zgodnie z którym  \\n" + //
	// 			" naprawienie \\n" + //
	// 			" szkody powinno nastąpić, według wyboru poszkodowanego, bądź przez  \\n" + //
	// 			" przywrócenie stanu \\n" + //
	// 			" poprzedniego, bądź przez zapłatę odpowiedniej sumy pieniężnej. \\n" + //
	// 			" Zgodnie z art. 316 § 1 k.p.c. sąd bierze pod uwagę stan istniejący w dacie  \\n" + //
	// 			" zamknięcia \\n" + //
	// 			" rozprawy. Istotne jest zatem ustalenie, czy poszkodowany naprawił szkodę, czy  \\n" + //
	// 			" nie, a jeśli \\n" + //
	// 			" tak, to czy doszło do przywrócenia jego stanu majątkowego do stanu sprzed  \\n" + //
	// 			" szkody. \\n" + //
	// 			" Biegły sądowy wskazał, że naprawa pojazdu oryginalnymi częściami  \\n" + //
	// 			" sygnowanymi \\n" + //
	// 			" logiem producenta pojazdu kategorii „O” jest zgodna z zaleceniami producenta  \\n" + //
	// 			" pojazdu \\n" + //
	// 			" i zapewnia pełne przywrócenie do stanu sprzed szkody, przy założeniu, że  \\n" + //
	// 			" uszkodzeniu uległy \\n" + //
	// 			" części oryginalne. Powód nie udowodnił jednak, że w dacie zdarzenia w pojeździe \\n" + //
	// 			" zamontowane były części oryginalne, a ponadto, że naprawa przy użyciu części  \\n" + //
	// 			" oryginalnych \\n" + //
	// 			" nie spowoduje wzrostu wartości pojazdu. Tym samym zastosowanie części  \\n" + //
	// 			" oryginalnych \\n" + //
	// 			" skutkowałoby bezpodstawnym wzbogaceniem powoda. \\n" + //
	// 			" Dla wyliczenia należnego powodowi odszkodowania Sąd przyjął wariant naprawy \\n" + //
	// 			" z zastosowaniem części o jakości „Q” i „P/PJ”, z tą różnicą, że stawka za prace  \\n" + //
	// 			" blacharsko- \\n" + //
	// 			" lakiernicze winna wynosić 100 zł netto za godzinę, gdyż zgodnie z opinią biegłego \\n" + //
	// 			" sądowego \\n" + //
	// 			" stawka 50 zł netto za godzinę nie spełnia kryteriów rynkowych. Dodatkowo, za \\n" + //
	// 			" zastosowaniem części jakości „Q” i „P/PJ” przemawia okoliczność, że w dacie  \\n" + //
	// 			" zdarzenia \\n" + //
	// 			" pojazd miał już 5 lat, nie był na gwarancji i miał przebieg 70 000 km. Jak zeznał  \\n" + //
	// 			" powód, \\n" + //
	// 			" pojazd został sprowadzony z zagranicy, a więc należy przyjąć, że był pojazdem \\n" + //
	// 			" powypadkowym, stąd niezasadne byłoby naprawienie go przy użyciu nowych,  \\n" + //
	// 			" oryginalnych \\n" + //
	// 			" części. \\n" + //
	// 			" Nie bez znaczenia dla sprawy pozostaje okoliczność, że po zdarzeniu z dnia 8  \\n" + //
	// 			" lipca \\n" + //
	// 			" 2021 r. powód naprawił pojazd i poniósł z tego tytułu koszt 4 000 zł, co pokrywa  \\n" + //
	// 			" się \\n" + //
	// 			" z wyliczeniami biegłego sądowego. Dodatkowo powód zeznał, że pojazd po  \\n" + //
	// 			" naprawie był \\n" + //
	// 			" sprawny technicznie, a stan był taki, jak przed wypadkiem. Tym samym, skoro  \\n" + //
	// 			" zgodnie \\n" + //
	// 			" z opinią biegłego i samego powoda, taka kwota pozwoliła na przywrócenie  \\n" + //
	// 			" pojazdu do stanu \\n" + //
	// 			" sprzed szkody, Sąd zasądził różnicę pomiędzy kwotą wypłaconą przez  \\n" + //
	// 			" pozwanego, \\n" + //
	// 			" a obliczoną przez biegłego, tj. 1 500 zł (4 000 zł - 2 500 zł). \\n" + //
	// 			" EGZAMIN RADCOWSKI – PRAWO CYWILNE \\n" + //
	// 			" 31/32 \\n";

	// 	var prompt = new PromptDto();
	// 	prompt.setContent(promptHolder.getDocumentAnalysis(promptText));
	// 	prompt.setRole("assistant");
		
	// 	var response = openAiService.sendPrompt(List.of(prompt));
	// }

//	@Test
//	public void checkType() {
//		var response = testPrompt();
//		TemplateCheckHelper templateCheckHelper = new TemplateCheckHelper();
//		templateCheckHelper.checkTemplate(response);
//	}

}
