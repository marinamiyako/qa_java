# Predator tests

## Как вызвать генерацию Jacoco

Сначала генерируем билд для тестов

```bash
mvn clean test
mvn verify
```

Затем вызываем в maven окне команду jacoco:report

```bash
mvn jacoco:report
```