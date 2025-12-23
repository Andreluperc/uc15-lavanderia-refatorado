# Evidencia de versionamento (GitHub)

Para gerar a evidencia solicitada na entrega, execute os passos abaixo e gere os prints.

## 1) Adicionar o projeto de testes ao mesmo repositorio do PI

Sugestao de estrutura:
- uc15-lavanderia-refatorado/        (projeto principal - core)
- uc15-lavanderia-testes/            (este projeto)

## 2) Comandos (terminal) para versionar

Na raiz do repositorio:

```bash
git add uc15-lavanderia-testes
git commit -m "test: adicionar projeto de testes JUnit (CpfUtils)"
git push
```

## 3) Prints recomendados (cole no seu PDF/Word de evidencias)

- Print 1: pagina do GitHub mostrando a pasta `uc15-lavanderia-testes/`
- Print 2: historico de commits mostrando o commit acima
- Print 3: execucao do `mvn test` com BUILD SUCCESS (ou janela de Test no NetBeans)
