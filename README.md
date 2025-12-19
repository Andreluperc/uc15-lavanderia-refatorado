# UC15 – Lavanderia (Refatorado para reuso no Web)

Este projeto é o **core** (domínio + persistência + serviços) do sistema de Lavanderia, refatorado para remover dependência de Swing e permitir reaproveitamento no PI Web.

## Executar testes
```bash
mvn test
```

## Executar o main (testes manuais)
```bash
mvn exec:java
```

## Persistência
- `lavanderia-test-PU` (H2 em memória) – usado por padrão nos testes
- `lavanderia-PU` (MySQL) – configure user/password no `persistence.xml`
