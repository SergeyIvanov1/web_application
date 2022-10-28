<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Encryption</title>
</head>
<body>
<br>
<h1>Decryption with key</h1>

<form action="/decryption_with_key" method="post" enctype="multipart/form-data">
    <p>Upload file
        <input type="file" name="file" accept=".txt"></p>
    <p><label for="key">Input key</label>
        <input type="text" name="key" id="key" required></p>
    <br>
    <p><input type="submit" name="button" value="Decryption with key"></p>
</form>
<br><br>

</body>
</html>