<?php


//Class DbConnect
class DbConnect
{
// Variable to store database link
private $con;

//class constructor
function_construct(){

}

//this method will connect to the database
function connect()
{
	//Including the constants.php file to get the database constants
	//includes the file only once, returns boolean value. Dirname - returns current directory.
	// . here is concatcenation operator
	include_once dirname(__FILE__).'/Constants.php';


	//Connecting to mysql database, "this" works like this in java. "(this.con)"
	//mysqli arguments are in constants.php 
	$this->con = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);

	//Checking if any error occured while connecting
	if(mysqli_connect_errno()){
		echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}

	//finally returning the connection link
	return $this->con;

}

}