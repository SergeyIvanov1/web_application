<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Encryption</title>
</head>
<body>
<br>
<h1>Encryptor</h1>

<form action="/encrypt" method="post" enctype="multipart/form-data">
    <p>Upload file
        <input type="file" name="file" accept=".txt">
    <p><label for="key">Input key</label>
        <input type="text" name="key" id="key" required></p>
    <br>
    <p><input type="submit" name="button" value="Encrypt"></p>
</form>
<br><br>

</body>
</html>
