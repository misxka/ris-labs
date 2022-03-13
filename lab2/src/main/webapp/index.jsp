<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./style.css" type="text/css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Факультеты БГУИР</title>
    </head>
    <body>
        <div class="wrapper">
            <h1>Факультеты БГУИР</h1>

            <form action="departments" method="get">
                <input class="btn btn-outline-primary" type="submit" value="Получить 2 факультета с наименьшим количество студентов" />
            </form>

            <h3>Расчёт оплаты</h3>
            <form action="departments" method="post" class="row g-4">
                <div class="col-12">
                    <label for="form-select" class="form-label">Выберите факультет:</label>
                    <select id="form-select" class="form-select" name="department-id">
                        <option value="1" selected>Факультет компьютерного проектирования</option>
                        <option value="2">Факультет информационных технологий и управления</option>
                        <option value="3">Факультет радиотехники и электроники</option>
                        <option value="4">Факультет компьютерных систем и сетей</option>
                        <option value="5">Факультет инфокоммуникаций</option>
                        <option value="6">Инженерно-экономический факультет</option>
                    </select>
                </div>

                <div class="col-12">
                    <label for="semesters-input" class="form-label">Введите количество семестров:</label>
                    <input id="semesters-input" type="number" class="form-control" name="semesters-amount" placeholder="1" min="1" max="8" value="1">
                </div>

                <div class="col-12">
                    <button type="submit" class="btn btn-primary">Рассчитать</button>
                </div>
            </form>
        </div>
    </body>
</html>