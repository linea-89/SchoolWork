# Portefoeljeopgave 3

## Opgavebeskrivelse

I denne opgave skal i udvikle og deployere en Microservice-baseret løsning.

Opgaven kan tænkes som en udvidelse af delopgave 2, hvor i udviklede tre applikationer: En client og en server for hver af de to sensorer.

Det samme skal I gøre denne gang, men variansen er, at clienten ikke længere må kende til adressen for nogen af sensor serverne ved compile time.

I stedet skal I anvende HazelCasts distribuerede Map struktur ([MultiMap](https://docs.hazelcast.org/docs/5.1/javadoc/com/hazelcast/multimap/MultiMap.html)). Her skal hver server registrere sig med en identifier og data der beskriver deres placering ved run-time. Clienten skal læse placeringen for hver sensor-server (sensor service) fra samme Map, og anvende dette til at forbinde til de to sensor services. Princippet er illustreret i Figure 4.

BILLEDE

Til jeres hjælp har i på ItsLearning givet et eksempel der viser brugen af HazelCasts distribuerede Map struktur i Java. Dette eksempel viser hvordan man skriver til mappet og læser fra mappet i samme applikation. I skal naturligvis skrive og læse fra henholdsvis jeres Sensor services og jeres client.

Det er et krav at Client-delen stadig gør brug af ISensor interfacet.

I Figure 5 vises et deployment diagram af fire nodes hvorpå de tre applikationer, samt en Hazelcast Member afvikles. Hazelcast Member fungerer som kommunikationsled mellem UI og Sensor applikationerne.

BILLEDE

Det er tilladt at de tre applikationer og Hazelcast afvikles på jeres pc eller laptop, således at deployment diagrammet ser ud som vist i Figure 6.

BILLEDE