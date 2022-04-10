# ris-labs
## Лабораторная №1 - Java RMI
### Задание
_Клиент удаленно вызывает метод сервера, который может быть запущен на удаленном компьютере. На клиенте вводится строка.  Сервер возвращает эту строку, но с гласными, замененными символом  «*» клиенту, который выводит ее на экран._

### Результат работы
![Лабораторная №1 - Скриншот](https://user-images.githubusercontent.com/57208499/154984457-ccdee53c-0462-4752-bb0d-21203d1c147c.png)


## Лабораторная №2 - EJB Session Beans
### Задание
*Факультеты (название, кол-во чел, плата за семестр)*
- *Расчёт оплаты за введённый период, выбранный факультет*
- *Вывод 2ух факультетов с наименьшим кол-ов студентов*

### Результат работы
#### Основное меню:

![Лабораторная №2 - Скриншот №1](https://user-images.githubusercontent.com/57208499/158068132-dae019ce-9442-4b79-96ea-57aa8339d785.png)

#### Результат выполнения поиска двух факультетов с наименьшим кол-ов студентов:

![Лабораторная №2 - Скриншот №2](https://user-images.githubusercontent.com/57208499/158068140-764a7777-5ff3-47ff-a667-e0ffcbf8c73b.png)

#### Пример расчёта оплаты за обучение:

![Лабораторная №2 - Скриншот №3](https://user-images.githubusercontent.com/57208499/158068146-97080a8f-feee-4ef5-9520-4e5c8bfeb8a8.png)

#### Результат работы подсчёта стоимости обучения:

![Лабораторная №2 - Скриншот №4](https://user-images.githubusercontent.com/57208499/158068151-cc6c9ef8-70c3-4db6-b811-c59f30fdf8dc.png)

#### Записи в базе данных:

![Лабораторная №2 - Скриншот №5](https://user-images.githubusercontent.com/57208499/158068267-6a1ccaa1-7ba1-464e-b990-37a776fd9bd2.png)


## Лабораторная работа №3 - Управление персистенцией в Java EE 6.
### Задание
*Необходимо создать вышеописанное приложение. Внесите такие  изменения в файл сервлета CustomerDetails.java, чтобы кроме фамилии выводились код штата и кредитный лимит.*

### Результат работы
#### Основное меню:

![Лабораторная №3 - Скриншот №1](https://user-images.githubusercontent.com/57208499/158155442-c62bb374-5f93-4ddb-b902-e0c1de341805.png)

#### Результат успешного нахождения клиента:

![Лабораторная №3 - Скриншот №2](https://user-images.githubusercontent.com/57208499/158155519-66c60f9c-a156-4b00-8f85-d1df25831bda.png)

#### Результат неудачного поиска клиента:

![Лабораторная №3 - Скриншот №3](https://user-images.githubusercontent.com/57208499/158155671-7c335b2c-ce21-4a43-b716-5de8ce33e878.png)

![Лабораторная №3 - Скриншот №4](https://user-images.githubusercontent.com/57208499/158155691-959ad27c-c054-420f-a83a-3724da14c7b2.png)

#### Записи в базе данных

![Лабораторная №3 - Скриншот №5](https://user-images.githubusercontent.com/57208499/158156000-fd7fb53e-3b85-4db0-87fa-4fac0d4c5b8f.png)


## Лабораторная работа №4 - Java Message Service и Message-Driven Beans
### Задание
*Клиентское приложение отправляет несколько (не менее 10) сообщений в QUEUE или TOPIC (нечетный вариант – QUEUE, четный – TOPIC). MDB получает и обрабатывает сообщения следующим образом: Получатель производит поиск сообщения (искать в файле).*

### Результат работы
#### Файл (пример содержания)

![image](https://user-images.githubusercontent.com/57208499/162575067-328aa900-ab20-4ad8-9537-c76148a30d27.png)

#### Отправляемые данные

```java
private static final String[] words = { "orange", "sin", "Nec", "lorem", "battle", "refrigerator", "radiation", "adipiscing", "cruelty", "wall" };
```

#### Получатель

![image](https://user-images.githubusercontent.com/57208499/162575201-54bbecd5-c0f5-4235-96e1-f7fc1a637a14.png)


## Лабораторная работа №5 - Java Server Faces
### Задание

![image](https://user-images.githubusercontent.com/57208499/162612956-5b8483c0-0c9d-49b4-900a-ca0291e7b25b.png)

### Результат работы

![image](https://user-images.githubusercontent.com/57208499/162612965-a4d1833b-decd-44d5-b9fa-9344d582ae8e.png)

![image](https://user-images.githubusercontent.com/57208499/162612977-ee511b2f-9a0a-45ec-96f7-872c95361d7e.png)

![image](https://user-images.githubusercontent.com/57208499/162612984-51e01f4c-7f5d-44d2-8e3e-f217c5b9b311.png)

![image](https://user-images.githubusercontent.com/57208499/162612992-14f97db9-dc2f-4bce-8c61-1e17dd01141a.png)

![image](https://user-images.githubusercontent.com/57208499/162612996-31c6dcb3-36fd-4a30-9e77-0616a42ce6c8.png)
