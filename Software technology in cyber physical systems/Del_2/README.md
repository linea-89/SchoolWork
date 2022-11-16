# Portefoeljeopgave 2

## Opgavebeskrivelse

Denne opgave tager afsæt i porteføljeopgave del 1.

I får udleveret en referenceimplementering (et løsningsforslag) til opgave 1.

Jeres første opgave er at beskrive forskelle mellem jeres løsning og den udleverede løsning. Kommenter kort på konsekvenserne ved jeres valg i forhold til de valg der er foretaget i referenceimplementeringen.

Herefter skal I skal anvende client/server distributions mønsteret og distribuere referenceimplementeringen. I må gerne ændre i kildekoden i den udstrækning der er nødvendigt, men funktionalitet og programflow skal være uændret i den udstrækning det er muligt.

I skal lave to typer af komponenter. Det ene type af komponent,”Application”-komponent, indeholder de logiske lag ”presentation” og ”domain”. Det andet type af komponent, ”Sensor”-komponent, indeholder det logiske lag ”sensor”, men da vi har to sensorer bør i brække disse to ud i separate instanser af komponenten. Det vil sige, i skal ende op med i alt 3 komponenter. Det er forsøgt afbilledet i Figure 2. Bemærk: Der vil blive introduceret en ny form for klasser i jeres komponenter. De har ansvaret for kommunikation, og de bør naturligvis placeres hensigtsmæssigt i jeres softwarearkitektur for de enkelte komponenter. Hvad ”hensigtsmæssigt” vil sige er op til jer at afgøre.

BILLEDE

I skal sørge for, at jeres system stadig er fungerende. Det vil sige, at I skal implementere en form for netværkskommunikation mellem jeres Sensor-komponenter og jeres Application-komponent.
Der findes flere muligheder for at implementere netværkskommunikationen i ovenstående. Herunder er forslag til metoder og introduktion til disse metoder. Det er op til jer selv, hvilken metode i vælger, men I skal – naturligvis – dokumentere jeres valg (blot hvilken tilgang i valgte – i behøver ikke begrunde yderligere). Eneste krav er, at I skal anvende ”request/reply” pattern i jeres protokol.

* [UTF baseret Socket programmering](https://www.geeksforgeeks.org/socket-programming-in-java/)
* [Object transfer over Socket](http://www.coderpanda.com/java-socket-programming-transferring-of-java-objects-through-sockets/) 
* [JSON transfer over Socket](https://www.programmersought.com/article/9404373623/)

I figuren herunder vises systemet i et deployment diagram hvor netværkskommunikationen mellem Application og Sensor komponenterne er illustreret. Hver sensor komponent skal kunne forespørges de særskilte værdier for hhv. sensornavn og sensorværdi. Desuden er det et krav, at hver sensor implementeres som selvstændige serverprogrammer. Client og hver sensor skal udarbejdes i selvstændige projekter dvs. i alt tre projekter.

BILLEDE DEPLOYMENT

