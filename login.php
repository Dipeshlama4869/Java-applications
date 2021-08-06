<?php 
	//making connection with database
	$connect = new mysqli("localhost","root","","php");


	if($connect -> connection_error){
		die("connection failed: " . $connect->connection_error);
	}



 ?>

<?php 

	//inserting registered name, username, password in database
	if (isset($_POST['register'])) {
		$user = $_POST['user'];
		$pass = $_POST['pass'];
		$name = $_POST['name'];

		$mysql = "INSERT INTO info (username,password,name) values ('$user','$pass','$name')";

		$connect->query($mysql);
	}


 ?>


<?php
	
		$mysql1 = "SELECT username,password,name FROM info";
		$res = $connect->query($mysql1);
		if (isset($_POST['login'])) {
		if($res->num_rows > 0){

			while($row = $res->fetch_assoc()){
				if($_POST['username'] == $row["username"] && $_POST['password'] == $row["password"]){
					$username = $row["username"];
					$password = $row["password"];
					$name1 = $row["name"];
				}
			}
		}

	}
	$connect->close();


session_start();
if (isset($_SESSION['name'])) {
	header('Location: index.php');
}

if(isset($_POST['login'])){
	if ($_POST['username'] == $username && $_POST['password'] == $password) {
		$_SESSION['name'] = $name1;
		header('Location: index.php');
	}

	else{
		echo "<script> alert('Username or password incorrect') </script>";
	}
}
?>

	
<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
	<h1>REGISTER</h1>
	<form method="post" action="login.php">
		<label>Name: </label>
		<input type="text" name="name">
		<br>
		<label>Username: </label>
		<input type="text" name="user">
		<br>
		<label>Password: </label>
		<input type="text" name="pass">
		<br>
		<input type="submit" name="register">

	</form>

	<h1>LOGIN</h1>
	<form method="post" action="login.php">
		<label>Username: </label>
		<input type="text" name="username">
		<br>
		<label>Password: </label>
		<input type="text" name="password"> 
		<br>
		<input type="submit" name="login">
	</form>
</body>
</html>


