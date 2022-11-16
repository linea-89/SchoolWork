# Portefoeljeopgave 1

## Opgavebeskrivelse

I har givet et library (i form af en jar) med følgende klasser:

* CO2Sensor – En objekt-orienteret repræsentation af en CO2 sensor.
* TemperatureSensor – En objekt-orienteret repræsentation af en temperatur sensor.

CO2Sensor og TemperatureSensor indeholder begge en metode ”stop()” som anvendes til at stoppe sensorerne fra at generere værdier. Det er ikke nødvendigt at anvende denne metode for at løse opgaven. Den er der kun for at illustrere en komplet implementering.

Herudover får i følgende udleveret:

* ISensor – Et interface der beskriver det interface, som vi ønsker at alle sensorer i systemer skal overholde.
* Test – En klasse, der viser instantiering og en anvendelse af sensorerne. I forventes ikke at bruge denne klasse til at udarbejde jeres løsning i. Den er kun med for at illustrere anvendelsen af klasserne CO2Sensor og TemperatureSensor – altså som en hjælp.

Jeres opgave er at udvikle en konsol applikation, der er i stand til at udskrive de til enhver tid gældende værdier for disse 2 sensorer.

Jeres program skal opfylde følgende:

1. I skal udvikle et Command-Line Interface hvor der kan vælges hvilken sensor man ønsker at have den seneste værdi udskrevet fra.
2. I skal følge det lagdelte pattern,således at sensor-lag, domænelag og user interface lag er adskilt. Se nedenstående figur.

![pakkediagramOpgave1](https://user-images.githubusercontent.com/71763923/202202987-27fbf91c-c85a-4df5-b7da-7f72c4682cc4.PNG)

3. I skal implementere 2 Adapter-klasser som implementerer ISensor-interfacet og eksponerer værdierne fra hhv. CO2Sensor og TemperatureSensor. Det skal i gøre, uden at ændre i implementeringen af klasserne CO2Sensor og TemperatureSensor. Dette simulerer situationen, hvor i er afhængig af en implementering, nogle andre har lavet. Jeres Adapter-klasser skal i placere i Sensor-laget. Det betyder også at i gerne må (og bør) ændre pakken på ISensor-interfacet. I kan finde hjælp til anvendelsen af sensorerne i Test klassen.
4. Domain-laget skal indeholde klasse(r) der kan håndtere kald fra bruger-interfacet, kalder metoder på instanser af jeres Adapter-klasser for at returnere den nuværende værdi for sensorerne, når der bliver bedt om det fra brugerinterfacet.

Der må i forbindelse med denne opgave IKKE ændres i koden i hverken library eller interface (ud over pakkenavnet)!

For at kunne anvende den udleverede jar skal i inkludere en reference til den i jeres projekt. Vi anbefaler at i bruger maven til dette formål.
