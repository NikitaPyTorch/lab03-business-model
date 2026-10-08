# Результаты проверки

Проверка выполнена 8 октября 2026 года на JDK 25.0.4 (JetBrains Runtime, встроенный в IntelliJ IDEA), Maven 3.9.16 и JUnit Jupiter 5.11.4.

## Автоматические тесты

Запущен полный Maven lifecycle `test` с исходным `pom.xml` и предоставленными тестами.

| Набор | Выполнено | Ошибки проверок | Исключения тестового запуска | Пропущено |
| --- | ---: | ---: | ---: | ---: |
| CustomerTest | 17 | 0 | 0 | 0 |
| ProductTest | 14 | 0 | 0 | 0 |
| OrderItemTest | 5 | 0 | 0 | 0 |
| PaymentTest | 10 | 0 | 0 | 0 |
| OrderTest | 23 | 0 | 0 | 0 |
| StructureTest | 7 | 0 | 0 | 0 |
| **Всего** | **76** | **0** | **0** | **0** |

```text
Tests run: 76, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

Файлы `src/test/java`, `pom.xml` и оба enum не отличаются от учебного коммита `e16b44d`. В основном коде не осталось заглушек и TODO. Дополнительная проверка кода подтвердила сохранение публичных сигнатур.

## Ручной сценарий

Фактически запущен `by.bseu.pp.lab03.Application`. Вывод:

```text
Order total: 2490.0
Order status: PAID
```

Это сумма двух ноутбуков по 1200 и трёх мышей по 30. Платёж создан на `order.total()`, отмечен успешным и принят заказом.

## Повторение проверки

В IntelliJ IDEA выберите JDK 25, загрузите Maven-проект и запустите весь пакет тестов `by.bseu.pp.lab03.model`. При установленном Maven из каталога проекта достаточно выполнить `mvn test`.

## Проверка в IntelliJ IDEA

8 октября 2026 года проект открыт как Maven-проект в IntelliJ IDEA 2026.2.3 с Microsoft OpenJDK 25.0.4.1 (`ms-25`). Обе сохранённые конфигурации фактически запущены в окне IDE:

- `Application`: `Order total: 2490.0`, `Order status: PAID`, `Process finished with exit code 0`.
- `All model tests`: `76 tests passed`, `76 tests total`, `Process finished with exit code 0`.

Подробная инструкция для повторного запуска: [INTELLIJ_RU.md](INTELLIJ_RU.md).
