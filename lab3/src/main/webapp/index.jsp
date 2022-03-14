<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="./style.css" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Customer Details</title>
</head>
<body>
<div class="wrapper">
    <h1>Search Customer Information</h1>

    <form action="customer-details" method="get" class="row g-3">
        <div class="row mb-3">
            <label for="customer-id" class="col-sm-3 col-form-label">Customer number:</label>
            <div class="col-sm-4">
                <input id="customer-id" type="number" class="form-control" name="customer-id" placeholder="1" value="1">
            </div>
            <div class="col-sm-4">
                <button type="submit" class="btn btn-primary">Select</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>