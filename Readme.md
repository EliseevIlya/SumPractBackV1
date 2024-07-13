Для запуска требуется можно установить системные переменные:

| переменная | значение по умолчанию | описание                                                    |
| -------------------- | ---------------------------------------- | ------------------------------------------------------------------- |
| DATABASE_HOST        | localhost                                | хост бд                                                       |
| DATABASE_PORT        | 5432                                     | порт бд                                                       |
| DATABASE_NAME        | SummerPracticV2                          | имя бд                                                         |
| DATABASE_USER        | postgres                                 | пользователь бд                                       |
| DATABASE_PASSWORD    | postgres                                 | пароль от бд                                              |
| JWT_SECRET           | ...                                      | ключ для генерации и проверки токена |
| ADMIN_USER           | admin                                    | Имя первого админа                                  |
| ADMIN_PASSWORD       | admin                                    | Пароль первого админа                            |
| PROFILE              | dev                                      | dev отключает cors                                        |

Можно также установить в `application.properties`.

Если возникли проблемы с бд после обновления нужно обнулить некоторые таблицы в бд:

```sql
DROP TABLE IF EXISTS acc_rstr_list, accounts, bic_directory_entry, import_data, initial_ed, part_info, participant_info, rstr_list, swbics
```
