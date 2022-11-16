# Portefoeljeopgave 4

## Opgavebeskrivelse

I denne opgave skal I deployere en event-dreven arkitektur.

I kommer endnu en gang til at tage udgangspunkt i reference implementeringen som i fik udleveret i forbindelse med delopgave 2, og skal endnu en gang anvende Hazelcast. Denne gang er det dog Topics i Hazelcast som i skal fokusere på:

https://hazelcast.org/imdg/?samplelang=Java+Client&sampleindex=7

I skal udvikle tre adskilte Java applikationer - en Client applikation, en Temperatur Sensor applikation og en CO2 Sensor applikation. Hver af disse skal fungere som Event Processors der anvender Hazelcast som event broker: Client applikation skal abonnere (addMessageListener(Topic)) på det Topic, som bliver publiceret (publish(…)) af Temperature Sensor- og CO2 Sensor applikationerne. Det vil altså sige, at Temperature Sensor- og CO2 Sensor applikationerne er ansvarlig for at publicere sensorværdier på dette topic. Det er op til jer at afgøre hvilket interval det skal ske med. Det er et krav, at Client applikationen fortsat gør brug af ISensor-interfacet.

BILLEDE